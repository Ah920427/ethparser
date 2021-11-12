package pro.belbix.ethparser.web3.bancor;

import static pro.belbix.ethparser.service.AbiProviderService.ETH_NETWORK;
import static pro.belbix.ethparser.web3.abi.FunctionsNames.RATE_BY_PATH;
import static pro.belbix.ethparser.web3.contracts.ContractConstants.BANCOR_CONVERSION_ADDRESS;
import static pro.belbix.ethparser.web3.contracts.ContractConstants.BANCOR_USDC_CONVERT_PATH;
import static pro.belbix.ethparser.web3.contracts.ContractConstants.D6;
import static pro.belbix.ethparser.web3.contracts.ContractConstants.L18;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.web3j.protocol.core.methods.response.Log;
import pro.belbix.ethparser.dto.v0.BancorDTO;
import pro.belbix.ethparser.model.tx.BancorPriceTx;
import pro.belbix.ethparser.properties.AppProperties;
import pro.belbix.ethparser.properties.NetworkProperties;
import pro.belbix.ethparser.repositories.v0.BancorRepository;
import pro.belbix.ethparser.web3.ParserInfo;
import pro.belbix.ethparser.web3.Web3Parser;
import pro.belbix.ethparser.web3.Web3Subscriber;
import pro.belbix.ethparser.web3.abi.FunctionsUtils;
import pro.belbix.ethparser.web3.contracts.ContractUtils;
import pro.belbix.ethparser.web3.contracts.db.ErrorDbService;

@Service
@Log4j2
public class BancorPriceParser extends Web3Parser<BancorDTO, Log> {

  private final Web3Subscriber web3Subscriber;
  private final NetworkProperties networkProperties;
  private final BancorLogDecoder bancorLogDecoder;
  private final BancorRepository bancorRepository;
  private final FunctionsUtils functionsUtils;

  protected BancorPriceParser(ParserInfo parserInfo,
      AppProperties appProperties,
      ErrorDbService errorDbService, Web3Subscriber web3Subscriber,
      NetworkProperties networkProperties,
      BancorLogDecoder bancorLogDecoder,
      BancorRepository bancorRepository,
      FunctionsUtils functionsUtils) {
    super(parserInfo, appProperties, errorDbService);
    this.web3Subscriber = web3Subscriber;
    this.networkProperties = networkProperties;
    this.bancorLogDecoder = bancorLogDecoder;
    this.bancorRepository = bancorRepository;
    this.functionsUtils = functionsUtils;
  }

  private boolean isValidLog(Log ethLog, String network) {
    if (ethLog == null || ethLog.getTopics() == null || ethLog.getTopics().isEmpty()) {
      return false;
    }
    return ContractUtils
        .isParsableBancorTransaction(ethLog.getAddress(), ethLog.getBlockNumber().intValue(),
            network);
  }

  @Override
  public BancorDTO parse(Log ethLog, String network) {

    if (!isValidLog(ethLog, network)) {
      return null;
    }

    BancorPriceTx tx = bancorLogDecoder.decode(ethLog);
    if (tx == null) {
      return null;
    }
    BancorDTO bancorDTO =  createDto(tx);
    double priceFarm =  bancorDTO.getAmountBnt() * bancorDTO.getPriceBnt() / bancorDTO.getAmountFarm();
    bancorDTO.setPriceFarm(priceFarm);
    return bancorDTO;
  }

  private BancorDTO createDto(BancorPriceTx tx) {
    BancorDTO bancorDTO = new BancorDTO();
    bancorDTO.setId(tx.getHash());
    bancorDTO.setLogId(tx.getLogId());
    bancorDTO.setBlock(tx.getBlock());
    bancorDTO.setAmountBnt(parseAmount(tx.getAmountBnt()));
    bancorDTO.setAmountFarm(parseAmount(tx.getAmountFarm()));
    bancorDTO.setPriceBnt(findBntPriceOnBlock(tx.getBlock()));
    bancorDTO.setFarmAsSource(tx.getFarmAsSource());
    return bancorDTO;
  }

  public double parseAmount(BigInteger amount) {
    return new BigDecimal(amount)
        .divide(new BigDecimal(L18), 99, RoundingMode.HALF_UP)
        .doubleValue();
  }

  private double findBntPriceOnBlock(long block){
    BigInteger amountIn = BigInteger.valueOf(L18);
    long price1 = functionsUtils.callIntByNameWithAddressesArrayAndBigIntegerArg(
        RATE_BY_PATH, BANCOR_USDC_CONVERT_PATH, amountIn,
        BANCOR_CONVERSION_ADDRESS, block,
        ETH_NETWORK).orElse(BigInteger.ZERO).longValue();
    return price1/D6;
  }

  @Override
  protected boolean save(BancorDTO dto) {
    if (!appProperties.isOverrideDuplicates() && bancorRepository.existsById(dto.getId())) {
      log.warn("Duplicate tx " + dto.getId());
      return false;
    }
    bancorRepository.saveAndFlush(dto);
    return true;
  }

  @Override
  protected void subscribeToInput() {
    web3Subscriber.subscribeOnLogs(input, this.getClass().getSimpleName());
  }

  @Override
  protected boolean isActiveForNetwork(String network) {
    return networkProperties.get(network).isParseBancorLog();
  }

}
