package pro.belbix.ethparser.web3.prices;

import static pro.belbix.ethparser.service.AbiProviderService.ETH_NETWORK;
import static pro.belbix.ethparser.web3.abi.FunctionsNames.GET_PRICE;
import static pro.belbix.ethparser.web3.contracts.ContractConstants.ORACLE;
import static pro.belbix.ethparser.web3.contracts.ContractConstants.D18;
import static pro.belbix.ethparser.web3.contracts.ContractConstants.ORACLE_START_BLOCK;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import pro.belbix.ethparser.properties.AppProperties;
import pro.belbix.ethparser.web3.abi.FunctionsUtils;

@Service
@Log4j2
public class PriceOracle {

    private final FunctionsUtils functionsUtils;
    private final AppProperties appProperties;

    public PriceOracle(FunctionsUtils functionsUtils,
                         AppProperties appProperties) {
        this.functionsUtils = functionsUtils;
        this.appProperties = appProperties;

    }

    public double getPriceForCoinOnChain(String tokenAdr, Long block) {
        if (appProperties.isOnlyApi()) {
            return 0.0;
        }
        if (block <= ORACLE_START_BLOCK){
            throw new IllegalStateException("Oracle price smart contract was deploy on block " + ORACLE_START_BLOCK); 
        }

        double price = functionsUtils.callIntByName(GET_PRICE, tokenAdr, ORACLE, block, ETH_NETWORK)
        .orElseThrow(() -> new IllegalStateException("Can't fetch price for " + tokenAdr)).doubleValue();
        
        return price / D18;
    }

    public boolean isAvailable(String coinName, long block) {
        return block > ORACLE_START_BLOCK
            && !coinName.equals("USDC");
    }
}
