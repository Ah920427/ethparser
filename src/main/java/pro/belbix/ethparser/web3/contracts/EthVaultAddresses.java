package pro.belbix.ethparser.web3.contracts;

import static pro.belbix.ethparser.web3.contracts.Contract.createContracts;

import java.util.List;
import lombok.extern.log4j.Log4j2;

@Log4j2
class EthVaultAddresses {

  private EthVaultAddresses() {
  }
  
  static final List<Contract> VAULTS = createContracts(
      new Contract(10770117, "YCRV_V0", "0xF2B223Eb3d2B382Ead8D85f3c1b7eF87c1D35f3A"),
      new Contract(10861886, "WETH_V0", "0x8e298734681adbfC41ee5d17FF8B0d6d803e7098"),
      new Contract(10770105, "USDC_V0", "0xc3F7ffb5d5869B3ade9448D094d81B0521e8326f"),
      new Contract(10770108, "USDT_V0", "0xc7EE21406BB581e741FBb8B21f213188433D9f2F"),
      new Contract(10770103, "DAI_V0", "0xe85C8581e60D7Cd32Bbfd86303d2A4FA6a951Dac"),
      new Contract(10802976, "WBTC_V0", "0xc07EB91961662D275E2D285BdC21885A4Db136B0"),
      new Contract(10802986, "RENBTC_V0", "0xfBe122D0ba3c75e1F7C80bd27613c9f35B81FEeC"),
      new Contract(10815917, "CRVRENWBTC_V0", "0x192E9d29D43db385063799BC239E772c3b6888F3"),
      new Contract(10883048, "UNI_ETH_DAI_V0", "0x1a9F22b4C385f78650E7874d64e442839Dc32327"),
      new Contract(10883030, "UNI_ETH_USDC_V0", "0x63671425ef4D25Ec2b12C7d05DE855C143f16e3B"),
      new Contract(10883026, "UNI_ETH_USDT_V0", "0xB19EbFB37A936cCe783142955D39Ca70Aa29D43c"),
      new Contract(10883054, "UNI_ETH_WBTC_V0", "0xb1FeB6ab4EF7d0f41363Da33868e85EB0f3A57EE"),
      new Contract(11041674, "UNI_ETH_DAI", "0x307E2752e8b8a9C29005001Be66B1c012CA9CDB7"),
      new Contract(11041667, "UNI_ETH_USDC", "0xA79a083FDD87F73c2f983c5551EC974685D6bb36"),
      new Contract(11011433, "UNI_ETH_USDT", "0x7DDc3ffF0612E75Ea5ddC0d6Bd4e268f70362Cff"),
      new Contract(11041683, "UNI_ETH_WBTC", "0x01112a60f427205dcA6E229425306923c3Cc2073"),
      new Contract(11086824, "WETH", "0xFE09e53A81Fe2808bc493ea64319109B5bAa573e"),
      new Contract(11086842, "USDC", "0xf0358e8c3CD5Fa238a29301d0bEa3D63A17bEdBE"),
      new Contract(11086849, "USDT", "0x053c80eA73Dc6941F518a68E2FC52Ac45BDE7c9C"),
      new Contract(11086832, "DAI", "0xab7FA2B2985BCcfC13c6D86b1D5A17486ab1e04C"),
      new Contract(11068089, "WBTC", "0x5d9d25c7C457dD82fc8668FFC6B9746b674d4EcB"),
      new Contract(11086855, "RENBTC", "0xC391d1b08c1403313B0c28D47202DFDA015633C4"),
      new Contract(11086865, "CRVRENWBTC", "0x9aA8F427A17d6B0d91B6262989EdC7D45d6aEdf8"),
      new Contract(11036219, "SUSHI_WBTC_TBTC", "0xF553E1f826f42716cDFe02bde5ee76b2a52fc7EB"),
      new Contract(11152258, "YCRV", "0x0FE4283e0216F94f5f9750a7a11AC54D3c9C38F3"),
      new Contract(11159005, "3CRV", "0x71B9eC42bB3CB40F017D8AD8011BE8e384a95fa5"),
      new Contract(10997721, "TUSD", "0x7674622c63Bee7F46E86a4A5A18976693D54441b"),
      new Contract(11230944, "CRV_TBTC", "0x640704D106E79e105FDA424f05467F005418F1B5"),
      new Contract(10957909, "PS", "0x25550Cccbd68533Fa04bFD3e3AC4D09f9e00Fc50"),
      new Contract(10797544, "PS_V0", "0x59258F4e15A5fC74A7284055A8094F58108dbD4f"),
      new Contract(11257781, "CRV_CMPND", "0x998cEb152A42a3EaC1f555B1E911642BeBf00faD"),
      new Contract(11257802, "CRV_BUSD", "0x4b1cBD6F6D8676AcE5E412C78B7a59b4A1bbb68a"),
      new Contract(11257784, "CRV_USDN", "0x683E683fBE6Cf9b635539712c999f3B3EdCB8664"),
      new Contract(11269733, "SUSHI_ETH_DAI", "0x203E97aa6eB65A1A02d9E80083414058303f241E"),
      new Contract(11269722, "SUSHI_ETH_USDC", "0x01bd09A1124960d9bE04b638b142Df9DF942b04a"),
      new Contract(11269716, "SUSHI_ETH_USDT", "0x64035b583c8c694627A199243E863Bb33be60745"),
      new Contract(11269739, "SUSHI_ETH_WBTC", "0x5C0A3F55AAC52AA320Ff5F280E77517cbAF85524"),
      new Contract(11374134, "IDX_ETH_DPI", "0x2a32dcbb121d48c106f6d94cf2b4714c0b4dfe48"),
      new Contract(11380823, "CRV_HUSD", "0x29780C39164Ebbd62e9DDDE50c151810070140f2"),
      new Contract(11380817, "CRV_HBTC", "0xCC775989e76ab386E9253df5B0c0b473E22102E2"),
      new Contract(11608433, "UNI_BAC_DAI", "0x6Bccd7E983E438a56Ba2844883A664Da87E4C43b"),
      new Contract(11608445, "UNI_DAI_BAS", "0xf8b7235fcfd5a75cfdcc0d7bc813817f3dd17858"),
      new Contract(11608456, "SUSHI_MIC_USDT", "0x6F14165c6D529eA3Bfe1814d0998449e9c8D157D"),
      new Contract(11608466, "SUSHI_MIS_USDT", "0x145f39B3c6e6a885AA6A8fadE4ca69d64bab69c8"),
      new Contract(11639716, "CRV_OBTC", "0x966A70A4d3719A6De6a94236532A0167d5246c72"),
      new Contract(11647784, "ONEINCH_ETH_DAI", "0x8e53031462e930827a8d482e7d80603b1f86e32d"),
      new Contract(11647839, "ONEINCH_ETH_USDC", "0xd162395c21357b126c5afed6921bc8b13e48d690"),
      new Contract(11647866, "ONEINCH_ETH_USDT", "0x4bf633a09bd593f6fb047db3b4c25ef5b9c5b99e"),
      new Contract(11647897, "ONEINCH_ETH_WBTC", "0x859222dd0b249d0ea960f5102dab79b294d6874a"),
      new Contract(11660618, "DAI_BSG", "0x639d4f3F41daA5f4B94d63C2A5f3e18139ba9E54"),
      new Contract(11660626, "DAI_BSGS", "0x633C4861A4E9522353EDa0bb652878B079fb75Fd"),
      new Contract(11655592, "BAC", "0x371E78676cd8547ef969f89D2ee8fA689C50F86B"),
      new Contract(11655609, "ESD", "0x45a9e027DdD8486faD6fca647Bb132AD03303EC2"),
      new Contract(11655624, "DSD", "0x8Bf3c1c7B1961764Ecb19b4FC4491150ceB1ABB1"),
      new Contract(11674631, "CRV_EURS", "0x6eb941BD065b8a5bd699C5405A928c1f561e2e5a"),
      new Contract(11680899, "CRV_UST", "0x84A1DfAdd698886A614fD70407936816183C0A02"),
      new Contract(11681744, "MAAPL_UST", "0x11804D69AcaC6Ae9466798325fA7DE023f63Ab53"),
      new Contract(11681033, "MAMZN_UST", "0x8334A61012A779169725FcC43ADcff1F581350B7"),
      new Contract(11681049, "MGOOGL_UST", "0x07DBe6aA35EF70DaD124f4e2b748fFA6C9E1963a"),
      new Contract(11681065, "MTSLA_UST", "0xC800982d906671637E23E031e907d2e3487291Bc"),
      new Contract(11686113, "CRV_STETH", "0xc27bfE32E0a934a12681C1b35acf0DBA0e7460Ba"),
      new Contract(11745394, "CRV_GUSD", "0xB8671E33fcFC7FEA2F7a3Ea4a117F065ec4b009E"),
      new Contract(11830928, "CRV_AAVE", "0xc3EF8C4043D7cf1D15B6bb4cd307C844E0BA9d42"),
      new Contract(11777480, "SUSHI_SUSHI_ETH", "0x5aDe382F38A09A1F8759D06fFE2067992ab5c78e"),
      new Contract(11775913, "iPS", "0x1571eD0bed4D987fe2b498DdBaE7DFA19519F651"),
      new Contract(11905238, "ONEINCH_ETH_ONEINCH", "0xFCA949E34ecd9dE519542CF02054DE707Cf361cE"),
      new Contract(11924821, "UNI_WBTC_KLON", "0xB4E3fC276532f27Bd0F738928Ce083A3b064ba61"),
      new Contract(11924877, "UNI_WBTC_KBTC", "0x5cd9Db40639013A08d797A839C9BECD6EC5DCD4D"),
      new Contract(11953907, "MNFLX_UST", "0x99C2564C9D4767C13E13F38aB073D4758af396Ae"),
      new Contract(11953999, "MTWTR_UST", "0xb37c79f954E3e1A4ACCC14A5CCa3E46F226038b7"),
      new Contract(11954053, "SUSHI_ETH_UST", "0x4D4D85c6a1ffE6Bb7a1BEf51c9E2282893feE521"),
      new Contract(11954288, "CRV_LINK", "0x24C562E24A4B5D905f16F2391E07213efCFd216E"),
      new Contract(11954195, "SUSHI_HODL", "0x274AA8B58E8C57C4e347C8768ed853Eb6D375b48"),
      new Contract(11998979, "ETH_DAI_HODL", "0x29EC64560ab14d3166222Bf07c3F29c4916E0027"),
      new Contract(11998977, "ETH_USDC_HODL", "0x5774260CcD87F4FfFc4456260857207fc8BCb89A"),
      new Contract(11998971, "ETH_USDT_HODL", "0x4D4B6f8EFb685b774234Fd427201b3a9bF36ffc8"),
      new Contract(11998984, "ETH_WBTC_HODL", "0xB677bcA369f2523F62862F88d83471D892dD55B9"),
      new Contract(12044241, "MUSE_ETH", "0xc45d471c77ff31C39474d68a5080Fe1FfACDBC04"),
      new Contract(12044243, "DUDES20_ETH", "0x1E5f4e7127ea3981551D2Bf97dCc8f17a4ECEbEf"),
      new Contract(12044246, "MASK20_ETH", "0xF2a671645D0DF54d2f03E9ad7916c8F7368D1C29"),
      new Contract(12044248, "ROPE20_ETH", "0xAF9486E3DA0cE8d125aF9b256b3ecd104a3031B9"),
      new Contract(12135514, "MCAT20_ETH", "0x0cA19915439C12B16C0A8C119eC05fA801365a15"),
      new Contract(12226541, "MEME20_ETH", "0x227A46266329767cEa8883BFC81d21f1Ea0EdbB3"),
      new Contract(12226232, "GPUNK20_ETH", "0xe6e0B4294eF6a518bB702402e9842Df2a2Abf1B1"),
      new Contract(12226571, "MVI_ETH", "0x5EA74C6AbF0e523fdecFE218CCb3d2fDe2339613"),
      new Contract(12226909, "KXUSD_DAI", "0x26193024f481aA987FC5230E107F1651b3e01741"),
      new Contract(12063558, "ONEINCH_ONEINCH_WBTC", "0xDdB4669f39c03A6edA92ffB5B78A9C1a74615F1b"),
      new Contract(12063513, "ONEINCH_ONEINCH_USDC", "0xF174DDDD9DBFfeaeA5D908a77d695a77e53025b3"),
      new Contract(12016868, "CRV_USDP", "0x02d77f6925f4ef89EE2C35eB3dD5793f5695356f")
  );
}
