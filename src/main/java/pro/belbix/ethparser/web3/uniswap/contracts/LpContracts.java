package pro.belbix.ethparser.web3.uniswap.contracts;

import static pro.belbix.ethparser.web3.ContractConstants.D18;
import static pro.belbix.ethparser.web3.ContractConstants.D6;
import static pro.belbix.ethparser.web3.ContractConstants.D8;
import static pro.belbix.ethparser.web3.erc20.Tokens.BAC_NAME;
import static pro.belbix.ethparser.web3.erc20.Tokens.BAC_TOKEN;
import static pro.belbix.ethparser.web3.erc20.Tokens.BADGER_NAME;
import static pro.belbix.ethparser.web3.erc20.Tokens.BADGER_TOKEN;
import static pro.belbix.ethparser.web3.erc20.Tokens.BAS_NAME;
import static pro.belbix.ethparser.web3.erc20.Tokens.BAS_TOKEN;
import static pro.belbix.ethparser.web3.erc20.Tokens.DAI_NAME;
import static pro.belbix.ethparser.web3.erc20.Tokens.DPI_NAME;
import static pro.belbix.ethparser.web3.erc20.Tokens.FARM_NAME;
import static pro.belbix.ethparser.web3.erc20.Tokens.FARM_TOKEN;
import static pro.belbix.ethparser.web3.erc20.Tokens.GRAIN_NAME;
import static pro.belbix.ethparser.web3.erc20.Tokens.GRAIN_TOKEN;
import static pro.belbix.ethparser.web3.erc20.Tokens.IDX_NAME;
import static pro.belbix.ethparser.web3.erc20.Tokens.MIC_NAME;
import static pro.belbix.ethparser.web3.erc20.Tokens.MIC_TOKEN;
import static pro.belbix.ethparser.web3.erc20.Tokens.MIS_NAME;
import static pro.belbix.ethparser.web3.erc20.Tokens.MIS_TOKEN;
import static pro.belbix.ethparser.web3.erc20.Tokens.TBTC_NAME;
import static pro.belbix.ethparser.web3.erc20.Tokens.USDC_NAME;
import static pro.belbix.ethparser.web3.erc20.Tokens.USDT_NAME;
import static pro.belbix.ethparser.web3.erc20.Tokens.WBTC_NAME;
import static pro.belbix.ethparser.web3.erc20.Tokens.WETH_NAME;
import static pro.belbix.ethparser.web3.erc20.Tokens.WETH_TOKEN;
import static pro.belbix.ethparser.web3.erc20.Tokens.findNameForContract;
import static pro.belbix.ethparser.web3.erc20.Tokens.simplifyName;
import static pro.belbix.ethparser.web3.harvest.contracts.Vaults.IDX_ETH_DPI;
import static pro.belbix.ethparser.web3.harvest.contracts.Vaults.ONEINCH_ETH_DAI;
import static pro.belbix.ethparser.web3.harvest.contracts.Vaults.ONEINCH_ETH_USDC;
import static pro.belbix.ethparser.web3.harvest.contracts.Vaults.ONEINCH_ETH_USDT;
import static pro.belbix.ethparser.web3.harvest.contracts.Vaults.ONEINCH_ETH_WBTC;
import static pro.belbix.ethparser.web3.harvest.contracts.Vaults.SUSHI_ETH_DAI;
import static pro.belbix.ethparser.web3.harvest.contracts.Vaults.SUSHI_ETH_USDC;
import static pro.belbix.ethparser.web3.harvest.contracts.Vaults.SUSHI_ETH_USDT;
import static pro.belbix.ethparser.web3.harvest.contracts.Vaults.SUSHI_ETH_WBTC;
import static pro.belbix.ethparser.web3.harvest.contracts.Vaults.SUSHI_MIC_USDT;
import static pro.belbix.ethparser.web3.harvest.contracts.Vaults.SUSHI_MIS_USDT;
import static pro.belbix.ethparser.web3.harvest.contracts.Vaults.SUSHI_WBTC_TBTC;
import static pro.belbix.ethparser.web3.harvest.contracts.Vaults.UNI_BAC_DAI;
import static pro.belbix.ethparser.web3.harvest.contracts.Vaults.UNI_DAI_BAS;
import static pro.belbix.ethparser.web3.harvest.contracts.Vaults.UNI_ETH_DAI;
import static pro.belbix.ethparser.web3.harvest.contracts.Vaults.UNI_ETH_DAI_V0;
import static pro.belbix.ethparser.web3.harvest.contracts.Vaults.UNI_ETH_USDC;
import static pro.belbix.ethparser.web3.harvest.contracts.Vaults.UNI_ETH_USDC_V0;
import static pro.belbix.ethparser.web3.harvest.contracts.Vaults.UNI_ETH_USDT;
import static pro.belbix.ethparser.web3.harvest.contracts.Vaults.UNI_ETH_USDT_V0;
import static pro.belbix.ethparser.web3.harvest.contracts.Vaults.UNI_ETH_WBTC;
import static pro.belbix.ethparser.web3.harvest.contracts.Vaults.UNI_ETH_WBTC_V0;

import java.lang.reflect.Field;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.web3j.tuples.generated.Tuple2;

public class LpContracts {

    public static final String UNI_LP_ETH_DAI = "0xA478c2975Ab1Ea89e8196811F51A7B7Ade33eB11".toLowerCase();
    public static final String UNI_LP_ETH_USDC = "0xB4e16d0168e52d35CaCD2c6185b44281Ec28C9Dc".toLowerCase();
    public static final String UNI_LP_ETH_USDT = "0x0d4a11d5EEaaC28EC3F61d100daF4d40471f1852".toLowerCase();
    public static final String UNI_LP_ETH_WBTC = "0xBb2b8038a1640196FbE3e38816F3e67Cba72D940".toLowerCase();
    public static final String SUSHI_LP_WBTC_TBTC = "0x2Dbc7dD86C6cd87b525BD54Ea73EBeeBbc307F68".toLowerCase();
    public static final String UNI_LP_USDC_ETH = "0xB4e16d0168e52d35CaCD2c6185b44281Ec28C9Dc".toLowerCase();
    public static final String UNI_LP_USDC_WBTC = "0x004375dff511095cc5a197a54140a24efef3a416".toLowerCase();
    public static final String UNI_LP_USDC_FARM = "0x514906fc121c7878424a5c928cad1852cc545892".toLowerCase();
    public static final String UNI_LP_WETH_FARM = "0x56feaccb7f750b997b36a68625c7c596f0b41a58".toLowerCase();
    public static final String UNI_LP_IDX_ETH = "0x3452a7f30a712e415a0674c0341d44ee9d9786f9".toLowerCase();
    public static final String UNI_LP_USDC_IDX = "0xc372089019614e5791b08b5036f298d002a8cbef".toLowerCase();
    public static final String UNI_LP_ETH_DPI = "0x4d5ef58aac27d99935e5b6b4a6778ff292059991".toLowerCase();
    public static final String UNI_LP_WBTC_BADGER = "0xcd7989894bc033581532d2cd88da5db0a4b12859".toLowerCase();
    public static final String SUSHI_LP_ETH_DAI = "0xc3d03e4f041fd4cd388c549ee2a29a9e5075882f".toLowerCase();
    public static final String SUSHI_LP_ETH_USDC = "0x397ff1542f962076d0bfe58ea045ffa2d347aca0".toLowerCase();
    public static final String SUSHI_LP_ETH_USDT = "0x06da0fd433c1a5d7a4faa01111c044910a184553".toLowerCase();
    public static final String SUSHI_LP_ETH_WBTC = "0xceff51756c56ceffca006cd410b03ffc46dd3a58".toLowerCase();
    public static final String UNI_LP_GRAIN_FARM = "0xb9fa44b0911f6d777faab2fa9d8ef103f25ddf49".toLowerCase();
    public static final String UNI_LP_BAC_DAI = "0xd4405f0704621dbe9d4dea60e128e0c3b26bddbd".toLowerCase();
    public static final String UNI_LP_DAI_BAS = "0x0379da7a5895d13037b6937b109fa8607a659adf".toLowerCase();
    public static final String SUSHI_LP_MIC_USDT = "0xC9cB53B48A2f3A9e75982685644c1870F1405CCb".toLowerCase();
    public static final String SUSHI_LP_MIS_USDT = "0x066F3A3B7C8Fa077c71B9184d862ed0A4D5cF3e0".toLowerCase();
    public static final String ONEINCH_LP_ETH_DAI = "0x7566126f2fD0f2Dddae01Bb8A6EA49b760383D5A".toLowerCase();
    public static final String ONEINCH_LP_ETH_USDC = "0xb4dB55a20E0624eDD82A0Cf356e3488B4669BD27".toLowerCase();
    public static final String ONEINCH_LP_ETH_USDT = "0xbBa17b81aB4193455Be10741512d0E71520F43cB".toLowerCase();
    public static final String ONEINCH_LP_ETH_WBTC = "0x6a11F3E5a01D129e566d783A7b6E8862bFD66CcA".toLowerCase();

    public static final Map<String, String> harvestStrategyToLp = new LinkedHashMap<>();
    public static final Map<String, String> lpNameToHash = new LinkedHashMap<>();
    public static final Map<String, Double> lpHashToDividers = new LinkedHashMap<>();
    public static final Map<String, String> lpHashToName = new LinkedHashMap<>();
    public static final Map<String, Tuple2<String, String>> lpHashToCoinNames = new LinkedHashMap<>();
    public final static Map<String, Tuple2<Double, Double>> lpPairsDividers = new LinkedHashMap<>();
    public static final Map<String, String> keyCoinForLp = new LinkedHashMap<>();
    public static final Set<String> parsable = new HashSet<>();
    public static final Set<String> oneInch = new HashSet<>();

    static {
        try {
            initMaps();
        } catch (Exception e) {
            e.printStackTrace();
        }

        harvestStrategyToLp.put(UNI_ETH_DAI, UNI_LP_ETH_DAI);
        harvestStrategyToLp.put(UNI_ETH_USDC, UNI_LP_ETH_USDC);
        harvestStrategyToLp.put(UNI_ETH_USDT, UNI_LP_ETH_USDT);
        harvestStrategyToLp.put(UNI_ETH_WBTC, UNI_LP_ETH_WBTC);
        harvestStrategyToLp.put(SUSHI_WBTC_TBTC, SUSHI_LP_WBTC_TBTC);
        harvestStrategyToLp.put(UNI_ETH_DAI_V0, UNI_LP_ETH_DAI);
        harvestStrategyToLp.put(UNI_ETH_USDC_V0, UNI_LP_ETH_USDC);
        harvestStrategyToLp.put(UNI_ETH_USDT_V0, UNI_LP_ETH_USDT);
        harvestStrategyToLp.put(UNI_ETH_WBTC_V0, UNI_LP_ETH_WBTC);
        harvestStrategyToLp.put(SUSHI_ETH_DAI, SUSHI_LP_ETH_DAI);
        harvestStrategyToLp.put(SUSHI_ETH_USDC, SUSHI_LP_ETH_USDC);
        harvestStrategyToLp.put(SUSHI_ETH_USDT, SUSHI_LP_ETH_USDT);
        harvestStrategyToLp.put(SUSHI_ETH_WBTC, SUSHI_LP_ETH_WBTC);
        harvestStrategyToLp.put(IDX_ETH_DPI, UNI_LP_ETH_DPI);
        harvestStrategyToLp.put(UNI_BAC_DAI, UNI_LP_BAC_DAI);
        harvestStrategyToLp.put(UNI_DAI_BAS, UNI_LP_DAI_BAS);
        harvestStrategyToLp.put(SUSHI_MIC_USDT, SUSHI_LP_MIC_USDT);
        harvestStrategyToLp.put(SUSHI_MIS_USDT, SUSHI_LP_MIS_USDT);
        harvestStrategyToLp.put(ONEINCH_ETH_DAI, ONEINCH_LP_ETH_DAI);
        harvestStrategyToLp.put(ONEINCH_ETH_USDC, ONEINCH_LP_ETH_USDC);
        harvestStrategyToLp.put(ONEINCH_ETH_USDT, ONEINCH_LP_ETH_USDT);
        harvestStrategyToLp.put(ONEINCH_ETH_WBTC, ONEINCH_LP_ETH_WBTC);

        lpHashToDividers.put(UNI_LP_ETH_DAI, D18);
        lpHashToDividers.put(UNI_LP_ETH_USDC, D18);
        lpHashToDividers.put(UNI_LP_ETH_USDT, D18);
        lpHashToDividers.put(UNI_LP_ETH_WBTC, D18);
        lpHashToDividers.put(SUSHI_LP_WBTC_TBTC, D18);
        lpHashToDividers.put(SUSHI_LP_ETH_DAI, D18);
        lpHashToDividers.put(SUSHI_LP_ETH_USDC, D18);
        lpHashToDividers.put(SUSHI_LP_ETH_USDT, D18);
        lpHashToDividers.put(SUSHI_LP_ETH_WBTC, D18);
        lpHashToDividers.put(UNI_LP_IDX_ETH, D18);
        lpHashToDividers.put(UNI_LP_USDC_IDX, D18);
        lpHashToDividers.put(UNI_LP_ETH_DPI, D18);
        lpHashToDividers.put(UNI_LP_USDC_FARM, D18);
        lpHashToDividers.put(UNI_LP_WBTC_BADGER, D18);
        lpHashToDividers.put(UNI_LP_GRAIN_FARM, D18);
        lpHashToDividers.put(UNI_LP_WETH_FARM, D18);
        lpHashToDividers.put(UNI_LP_BAC_DAI, D18);
        lpHashToDividers.put(UNI_LP_DAI_BAS, D18);
        lpHashToDividers.put(SUSHI_LP_MIC_USDT, D18);
        lpHashToDividers.put(SUSHI_LP_MIS_USDT, D18);
        lpHashToDividers.put(ONEINCH_LP_ETH_DAI, D18);
        lpHashToDividers.put(ONEINCH_LP_ETH_USDC, D18);
        lpHashToDividers.put(ONEINCH_LP_ETH_USDT, D18);
        lpHashToDividers.put(ONEINCH_LP_ETH_WBTC, D18);

        lpHashToCoinNames.put(UNI_LP_ETH_DAI, new Tuple2<>(DAI_NAME, WETH_NAME));
        lpHashToCoinNames.put(UNI_LP_ETH_USDC, new Tuple2<>(USDC_NAME, WETH_NAME));
        lpHashToCoinNames.put(UNI_LP_ETH_USDT, new Tuple2<>(WETH_NAME, USDT_NAME));
        lpHashToCoinNames.put(UNI_LP_ETH_WBTC, new Tuple2<>(WBTC_NAME, WETH_NAME));
        lpHashToCoinNames.put(SUSHI_LP_WBTC_TBTC, new Tuple2<>(WBTC_NAME, TBTC_NAME));
        lpHashToCoinNames.put(SUSHI_LP_ETH_DAI, new Tuple2<>(DAI_NAME, WETH_NAME));
        lpHashToCoinNames.put(SUSHI_LP_ETH_USDC, new Tuple2<>(USDC_NAME, WETH_NAME));
        lpHashToCoinNames.put(SUSHI_LP_ETH_USDT, new Tuple2<>(WETH_NAME, USDT_NAME));
        lpHashToCoinNames.put(SUSHI_LP_ETH_WBTC, new Tuple2<>(WBTC_NAME, WETH_NAME));
        lpHashToCoinNames.put(UNI_LP_IDX_ETH, new Tuple2<>(IDX_NAME, WETH_NAME));
        lpHashToCoinNames.put(UNI_LP_USDC_IDX, new Tuple2<>(IDX_NAME, USDC_NAME));
        lpHashToCoinNames.put(UNI_LP_ETH_DPI, new Tuple2<>(DPI_NAME, WETH_NAME));
        lpHashToCoinNames.put(UNI_LP_WBTC_BADGER, new Tuple2<>(WBTC_NAME, BADGER_NAME));
        lpHashToCoinNames.put(UNI_LP_WETH_FARM, new Tuple2<>(FARM_NAME, WETH_NAME));
        lpHashToCoinNames.put(UNI_LP_USDC_FARM, new Tuple2<>(FARM_NAME, USDC_NAME));
        lpHashToCoinNames.put(UNI_LP_GRAIN_FARM, new Tuple2<>(GRAIN_NAME, FARM_NAME));
        lpHashToCoinNames.put(UNI_LP_BAC_DAI, new Tuple2<>(BAC_NAME, DAI_NAME));
        lpHashToCoinNames.put(UNI_LP_DAI_BAS, new Tuple2<>(DAI_NAME, BAS_NAME));
        lpHashToCoinNames.put(SUSHI_LP_MIC_USDT, new Tuple2<>(MIC_NAME, USDT_NAME));
        lpHashToCoinNames.put(SUSHI_LP_MIS_USDT, new Tuple2<>(MIS_NAME, USDT_NAME));
        lpHashToCoinNames.put(UNI_LP_USDC_WBTC, new Tuple2<>(MIS_NAME, USDT_NAME));
        lpHashToCoinNames.put(ONEINCH_LP_ETH_DAI, new Tuple2<>(WETH_NAME, DAI_NAME));
        lpHashToCoinNames.put(ONEINCH_LP_ETH_USDC, new Tuple2<>(WETH_NAME, USDC_NAME));
        lpHashToCoinNames.put(ONEINCH_LP_ETH_USDT, new Tuple2<>(WETH_NAME, USDT_NAME));
        lpHashToCoinNames.put(ONEINCH_LP_ETH_WBTC, new Tuple2<>(WETH_NAME, WBTC_NAME));

        lpPairsDividers.put(UNI_LP_ETH_DAI, new Tuple2<>(D18, D18));
        lpPairsDividers.put(UNI_LP_ETH_USDC, new Tuple2<>(D6, D18));
        lpPairsDividers.put(UNI_LP_ETH_USDT, new Tuple2<>(D18, D6));
        lpPairsDividers.put(UNI_LP_ETH_WBTC, new Tuple2<>(D8, D18));
        lpPairsDividers.put(SUSHI_LP_WBTC_TBTC, new Tuple2<>(D8, D18));
        lpPairsDividers.put(UNI_LP_USDC_ETH, new Tuple2<>(D6, D18));
        lpPairsDividers.put(UNI_LP_USDC_WBTC, new Tuple2<>(D8, D6));
        lpPairsDividers.put(UNI_LP_USDC_FARM, new Tuple2<>(D18, D6));
        lpPairsDividers.put(SUSHI_LP_ETH_DAI, new Tuple2<>(D18, D18));
        lpPairsDividers.put(SUSHI_LP_ETH_USDC, new Tuple2<>(D6, D18));
        lpPairsDividers.put(SUSHI_LP_ETH_USDT, new Tuple2<>(D18, D6));
        lpPairsDividers.put(SUSHI_LP_ETH_WBTC, new Tuple2<>(D8, D18));
        lpPairsDividers.put(UNI_LP_IDX_ETH, new Tuple2<>(D18, D18));
        lpPairsDividers.put(UNI_LP_USDC_IDX, new Tuple2<>(D18, D6));
        lpPairsDividers.put(UNI_LP_ETH_DPI, new Tuple2<>(D18, D18));
        lpPairsDividers.put(UNI_LP_WBTC_BADGER, new Tuple2<>(D8, D18));
        lpPairsDividers.put(UNI_LP_WETH_FARM, new Tuple2<>(D18, D18));
        lpPairsDividers.put(UNI_LP_GRAIN_FARM, new Tuple2<>(D18, D18));
        lpPairsDividers.put(UNI_LP_BAC_DAI, new Tuple2<>(D18, D18));
        lpPairsDividers.put(UNI_LP_DAI_BAS, new Tuple2<>(D18, D18));
        lpPairsDividers.put(SUSHI_LP_MIC_USDT, new Tuple2<>(D18, D6));
        lpPairsDividers.put(SUSHI_LP_MIS_USDT, new Tuple2<>(D18, D6));
        lpPairsDividers.put(ONEINCH_LP_ETH_DAI, new Tuple2<>(D18, D18));
        lpPairsDividers.put(ONEINCH_LP_ETH_USDC, new Tuple2<>(D18, D6));
        lpPairsDividers.put(ONEINCH_LP_ETH_USDT, new Tuple2<>(D18, D6));
        lpPairsDividers.put(ONEINCH_LP_ETH_WBTC, new Tuple2<>(D8, D18));

        keyCoinForLp.put(UNI_LP_USDC_FARM, FARM_TOKEN);
        keyCoinForLp.put(UNI_LP_WETH_FARM, FARM_TOKEN);
        keyCoinForLp.put(UNI_LP_WBTC_BADGER, BADGER_TOKEN);
        keyCoinForLp.put(UNI_LP_USDC_ETH, WETH_TOKEN);
        keyCoinForLp.put(UNI_LP_GRAIN_FARM, GRAIN_TOKEN);
        keyCoinForLp.put(UNI_LP_BAC_DAI, BAC_TOKEN);
        keyCoinForLp.put(UNI_LP_DAI_BAS, BAS_TOKEN);
        keyCoinForLp.put(SUSHI_LP_MIC_USDT, MIC_TOKEN);
        keyCoinForLp.put(SUSHI_LP_MIS_USDT, MIS_TOKEN);

        parsable.add(UNI_LP_USDC_FARM);
        parsable.add(UNI_LP_WETH_FARM);
        parsable.add(UNI_LP_WBTC_BADGER);
        parsable.add(UNI_LP_GRAIN_FARM);

        oneInch.add(ONEINCH_LP_ETH_DAI);
        oneInch.add(ONEINCH_LP_ETH_USDC);
        oneInch.add(ONEINCH_LP_ETH_USDT);
        oneInch.add(ONEINCH_LP_ETH_WBTC);
    }

    public static String findVaultHashByLpHash(String lpHash) {
        for (Entry<String, String> entry : harvestStrategyToLp.entrySet()) {
            if (entry.getValue().equalsIgnoreCase(lpHash)) {
                return entry.getKey();
            }
        }
        return null;
    }

    public static String findNameForLpHash(String lpHash) {
        String lpName = lpHashToName.get(lpHash);
        if (lpName == null) {
            throw new IllegalStateException("Not found LP name for " + lpHash);
        }
        return lpName;
    }

    public static String findLpForCoins(String coin1, String coin2) {
        coin1 = simplifyName(coin1);
        coin2 = simplifyName(coin2);
        for (Entry<String, Tuple2<String, String>> entry : lpHashToCoinNames.entrySet()) {
            Tuple2<String, String> coinNames = entry.getValue();
            if (
                (coinNames.component1().equalsIgnoreCase(coin1)
                    || coinNames.component2().equalsIgnoreCase(coin1))
                    && (
                    coinNames.component1().equalsIgnoreCase(coin2)
                        || coinNames.component2().equalsIgnoreCase(coin2)
                )
            ) {
                return entry.getKey();
            }
        }
        throw new IllegalStateException("Not found LP for " + coin1 + " " + coin2);
    }

    public static double amountToDouble(BigInteger amount, String lpAddress, String coinAddress) {
        Tuple2<String, String> names = lpHashToCoinNames.get(lpAddress);
        if (names == null) {
            throw new IllegalStateException("Not found names for " + lpAddress);
        }
        String coinName = findNameForContract(coinAddress);
        Tuple2<Double, Double> dividers = lpPairsDividers.get(lpAddress);
        if (dividers == null) {
            throw new IllegalStateException("Not found dividers for " + lpAddress);
        }
        Double divider;
        if (names.component1().equals(coinName)) {
            divider = dividers.component1();
        } else if (names.component2().equals(coinName)) {
            divider = dividers.component2();
        } else {
            throw new IllegalStateException(String.format("Coin %s not compare with LP %s", coinName, lpAddress));
        }

        return amount.doubleValue() / divider;
    }

    //dangerous, but useful
    private static void initMaps() throws IllegalAccessException, NoSuchFieldException {
        for (Field field : LpContracts.class.getDeclaredFields()) {
            if (!(field.get(null) instanceof String)) {
                continue;
            }
            String lpName = field.getName();
            String lpHash = (String) field.get(null);
            lpHashToName.put(lpHash, lpName);
            lpNameToHash.put(lpName, lpHash);
        }
    }

}
