package pro.belbix.ethparser.web3.harvest.vault;

import static java.util.Collections.singletonList;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static pro.belbix.ethparser.TestUtils.assertModel;
import static pro.belbix.ethparser.service.AbiProviderService.BSC_NETWORK;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.web3j.protocol.core.methods.response.EthLog.LogResult;
import org.web3j.protocol.core.methods.response.Log;
import pro.belbix.ethparser.Application;
import pro.belbix.ethparser.dto.v0.HarvestDTO;
import pro.belbix.ethparser.web3.Web3Functions;
import pro.belbix.ethparser.web3.contracts.ContractLoader;
import pro.belbix.ethparser.web3.harvest.HarvestOwnerBalanceCalculator;
import pro.belbix.ethparser.web3.harvest.db.HarvestDBService;
import pro.belbix.ethparser.web3.harvest.parser.HarvestVaultParserV2;
import pro.belbix.ethparser.web3.prices.PriceProvider;

@SpringBootTest(classes = Application.class)
@ContextConfiguration
public class HarvestVaultParserBscTest {

  private static final int LOG_ID = 0;

  @Autowired
  private HarvestVaultParserV2 harvestVaultParser;
  @Autowired
  private Web3Functions web3Functions;
  @Autowired
  private PriceProvider priceProvider;
  @Autowired
  private HarvestOwnerBalanceCalculator harvestOwnerBalanceCalculator;
  @Autowired
  private HarvestDBService harvestDBService;
  @Autowired
  private ContractLoader contractLoader;

  @BeforeEach
  public void setUp() throws Exception {
    contractLoader.load(BSC_NETWORK);
  }

  @Test
  void test_ONEINCH_RENBTC() throws Exception {
    HarvestDTO harvestDTO = loadHarvestDto(
        "0xbF2989575dE9850F0A4b534740A88F5D2b460A4f", 6231363);
    assertNotNull(harvestDTO);
    assertModel(HarvestDTO.builder()
        .hash("0xec16afa25cbbfa92ae54373a53c3d1513fc15c88fd417bb1a711150114d7389c")
        .block(6231363L)
        .blockDate(1617409416L)
        .confirmed(1)
        .methodName("Deposit")
        .owner("0x1eb1b1bea69839835bd71e428c3cae0116c0d8bf")
        .vault("ONEINCH_RENBTC")
        .amount(1535.5432734372898)
        .usdAmount(7240L)
        .lastTvl(1535.5432734372898)
        .lastUsdTvl(7240.0)
        .ownerBalance(1535.5432734372898)
        .ownerBalanceUsd(3619.6440326107777)
        .sharePrice(1.)
        .lpStat(null)
        .ownerCount(1)
        .migrated(false)
        .underlyingPrice(null)
        .profit(null)
        .profitUsd(null)
        .totalAmount(null)
        .build(), harvestDTO);
  }

  @Test
  void test_ONEINCH_BNB() throws Exception {
    HarvestDTO harvestDTO = loadHarvestDto(
        "0x9090BCcD472b9D11DE302572167DED6632e185AB", 6400546);
    assertNotNull(harvestDTO);
    assertModel(HarvestDTO.builder()
        .hash("0x7f32e4faab8187908eebbae504c44374854a9d9f6f8303180f6fcab977bcc888")
        .block(6400546L)
        .blockDate(1617928698L)
        .confirmed(1)
        .methodName("Deposit")
        .owner("0xa12f7352ee48481f5c5896d47d74eff6a7a267e7")
        .vault("ONEINCH_BNB")
        .amount(142.55437636286547)
        .usdAmount(1990L)
        .lastTvl(76006.17496369126)
        .lastUsdTvl(1056488.0)
        .ownerBalance(143.18501961766782)
        .ownerBalanceUsd(1990.275158037569)
        .sharePrice(1.0044238785991184)
        .lpStat(null)
        .ownerCount(1)
        .migrated(false)
        .underlyingPrice(null)
        .profit(null)
        .profitUsd(null)
        .totalAmount(null)
        .build(), harvestDTO);
  }

  @Test
  void test_VENUS_XVS() throws Exception {
    HarvestDTO harvestDTO = loadHarvestDto(
        "0xCf5F83F8FE0AB0f9E9C1db07E6606dD598b2bbf5", 6343242);
    assertNotNull(harvestDTO);
    assertModel(HarvestDTO.builder()
        .hash("0x8a3ed912f608f2d8dfafc0406082d52df2b79fc3ae57febc0bdfc98b75d833c8")
        .block(6343242L)
        .blockDate(1617750554L)
        .confirmed(1)
        .methodName("Deposit")
        .owner("0x67e82669107250b8562e5bc7df4e347abf1fb66f")
        .amount(389.8465842113253)
        .vault("VENUS_XVS")
        .lastUsdTvl(90119.0)
        .sharePrice(1.0014240802660224)
        .usdAmount(22531L)
        .lpStat(null)
        .ownerBalance(390.4017570386769)
        .ownerBalanceUsd(22531.514889208454)
        .migrated(false)
        .underlyingPrice(null)
        .ownerCount(1)
        .lastTvl(1561.4865941715939)
        .profit(null)
        .profitUsd(null)
        .totalAmount(null)
        .build(), harvestDTO);
  }

  @Test
  void test_PC_BUSD_BNB() throws Exception {
    HarvestDTO harvestDTO = loadHarvestDto(
        "0xf7a3a95d0f7e8a5eeae483cdd7b76af287283d34", 6101208);
    assertNotNull(harvestDTO);
    assertModel(HarvestDTO.builder()
        .hash("0x2beda2c174968f2f7170d1a1722d29f0a15d29104cb1ff3ae8a63247a9656af2")
        .block(6101208L)
        .blockDate(1617016126L)
        .confirmed(1)
        .methodName("Deposit")
        .owner("0x7f4ac7a8b18d7dc76c5962aa1aacf968eac3ac67")
        .amount(0.2662041892498321)
        .vault("PC_BUSD_BNB")
        .lastUsdTvl(10.)
        .sharePrice(1.)
        .usdAmount(10L)
        .lpStat(
            "{\"coin1\":\"WBNB\",\"coin2\":\"BUSD\",\"amount1\":0.01830295070448038,\"amount2\":4.999430824411079,\"price1\":273.1488985099692,\"price2\":1.0}")
        .ownerBalance(0.2662041892498321)
        .ownerBalanceUsd(9.99886164882216)
        .migrated(false)
        .underlyingPrice(null)
        .ownerCount(0)
        .lastTvl(0.2662041892498321)
        .profit(null)
        .profitUsd(null)
        .totalAmount(null)
        .build(), harvestDTO);
  }

  private HarvestDTO loadHarvestDto(String vaultAddress, int block) {
    @SuppressWarnings("rawtypes")
    List<LogResult> logResults = web3Functions
        .fetchContractLogs(singletonList(vaultAddress), block, block, BSC_NETWORK);
    assertTrue(LOG_ID < logResults.size(),
        "Log smaller then necessary");
    HarvestDTO harvestDTO = harvestVaultParser.parseVaultLog(
        (Log) logResults.get(LOG_ID).get(), BSC_NETWORK);
    harvestVaultParser.enrichDto(harvestDTO, BSC_NETWORK);
    harvestOwnerBalanceCalculator.fillBalance(harvestDTO, BSC_NETWORK);
    harvestDBService.saveHarvestDTO(harvestDTO);
    return harvestDTO;
  }

}
