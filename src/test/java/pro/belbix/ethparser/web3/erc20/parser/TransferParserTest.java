package pro.belbix.ethparser.web3.erc20.parser;

import static java.util.Collections.singletonList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertAll;
import static pro.belbix.ethparser.web3.erc20.Tokens.FARM_TOKEN;

import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.web3j.protocol.core.methods.response.EthLog.LogResult;
import org.web3j.protocol.core.methods.response.Log;
import pro.belbix.ethparser.Application;
import pro.belbix.ethparser.dto.TransferDTO;
import pro.belbix.ethparser.web3.PriceProvider;
import pro.belbix.ethparser.web3.Web3Service;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@ActiveProfiles("test")
public class TransferParserTest {

    @Autowired
    private Web3Service web3Service;
    @Autowired
    private PriceProvider priceProvider;
    @Autowired
    private TransferParser transferParser;

    @Before
    public void setUp() {
        priceProvider.setUpdateTimeout(0);
    }

    @Test
    public void testParseFARM_exit1() {
        TransferDTO dto = parserTest(FARM_TOKEN,
            11337723,
            0,
            "FARM",
            "0x8f5adc58b32d4e5ca02eac0e293d35855999436c",
            "0x25550cccbd68533fa04bfd3e3ac4d09f9e00fc50",
            "180981,24181470",
            "REWARD",
            "exit"
        );
        assertNotNull(dto);
    }

    @Test
    public void testParseFARM_exit2() {
        TransferDTO dto = parserTest(FARM_TOKEN,
            11337723,
            1,
            "FARM",
            "0x8f5adc58b32d4e5ca02eac0e293d35855999436c",
            "0x25550cccbd68533fa04bfd3e3ac4d09f9e00fc50",
            "2,07976153",
            "REWARD",
            "exit"
        );
        assertNotNull(dto);
    }

    @Test
    public void testParseFARM_exit3() {
        TransferDTO dto = parserTest(FARM_TOKEN,
            11337723,
            2,
            "FARM",
            "0x25550cccbd68533fa04bfd3e3ac4d09f9e00fc50",
            "0x27c7e3758983f00085c5bbc91ecf0c91baae7146",
            "1,06503922",
            "COMMON",
            "exit"
        );
        assertNotNull(dto);
    }

    @Test
    public void testParseFARM_exit4() {
        TransferDTO dto = parserTest(FARM_TOKEN,
            11337723,
            5,
            "FARM",
            "0x25550cccbd68533fa04bfd3e3ac4d09f9e00fc50",
            "0x8f5adc58b32d4e5ca02eac0e293d35855999436c",
            "180982,25653701",
            "NOTIFY",
            "exit"
        );
        assertNotNull(dto);
    }

    @Test
    public void testParseFARM_stake1() {
        TransferDTO dto = parserTest(FARM_TOKEN,
            11337691,
            0,
            "FARM",
            "0x8f5adc58b32d4e5ca02eac0e293d35855999436c",
            "0x25550cccbd68533fa04bfd3e3ac4d09f9e00fc50",
            "180905,75962281",
            "REWARD",
            "stake"
        );
        assertNotNull(dto);
    }

    @Test
    public void testParseFARM_stake2() {
        TransferDTO dto = parserTest(FARM_TOKEN,
            11337691,
            1,
            "FARM",
            "0x8f5adc58b32d4e5ca02eac0e293d35855999436c",
            "0x25550cccbd68533fa04bfd3e3ac4d09f9e00fc50",
            "10,56597522",
            "REWARD",
            "stake"
        );
        assertNotNull(dto);
    }

    @Test
    public void testParseFARM_stake3() {
        TransferDTO dto = parserTest(FARM_TOKEN,
            11337691,
            6,
            "FARM",
            "0x25550cccbd68533fa04bfd3e3ac4d09f9e00fc50",
            "0x8f5adc58b32d4e5ca02eac0e293d35855999436c",
            "180981,24181470",
            "NOTIFY",
            "stake"
        );
        assertNotNull(dto);
    }

    @Test
    public void testParseFARM_balancer() {
        TransferDTO dto = parserTest(FARM_TOKEN,
            10777054,
            1,
            "FARM",
            "0x3e66b66fd1d0b02fda6c811da9e0547970db2f21",
            "0xefd0199657b444856e3259ed8e3c39ee43cf51dc",
            "101,21369473",
            "COMMON",
            "0xe2b39746"
        );
        assertNotNull(dto);
    }

    @Test
    public void testParseFARM_swap() {
        TransferDTO dto = parserTest(FARM_TOKEN,
            11055960,
            0,
            "FARM",
            "0x8d98f2bcaf61811a2cc813a4db65286b5db785f6",
            "0x11111254369792b2ca5d084ab5eea397ca8fa48b",
            "1,58631881",
            "COMMON",
            "swap"
        );
        assertNotNull(dto);
    }

    @Test
    public void testParseFARM_addLiquidity() {
        TransferDTO dto = parserTest(FARM_TOKEN,
            11362801,
            1,
            "FARM",
            "0xc3aee7f07034e846243c60acbe8cf5b8a71e4584",
            "0x514906fc121c7878424a5c928cad1852cc545892",
            "9,64157915",
            "LP_ADD",
            "addLiquidity"
        );
        assertNotNull(dto);
    }

    @Test
    public void testParseFARM_transfer() {
        parserTest(FARM_TOKEN,
            11571359,
            0,
            "FARM",
            "0xa910f92acdaf488fa6ef02174fb86208ad7722ba",
            "0x7a77784d32fef468c2a46cdf4ef2e15ef2cb2226",
            "4,25506623",
            "COMMON",
            "transfer"
        );
    }

    private TransferDTO parserTest(
        String contractHash,
        int onBlock,
        int logId,
        String name,
        String owner,
        String recipient,
        String value,
        String type,
        String methodName
    ) {
        List<LogResult> logResults = web3Service.fetchContractLogs(singletonList(contractHash), onBlock, onBlock);
        assertTrue("Log smaller then necessary", logId < logResults.size());
        TransferDTO dto = transferParser.parseLog((Log) logResults.get(logId).get());
        assertDto(dto, name, owner, recipient, value, type, methodName);
        return dto;
    }

    private void assertDto(TransferDTO dto, String name, String owner,
                           String recipient, String value, String type, String methodName) {
        assertNotNull("Dto is null", dto);
        assertAll(
            () -> assertEquals("name", name, dto.getName()),
            () -> assertEquals("owner", owner, dto.getOwner()),
            () -> assertEquals("recipient", recipient, dto.getRecipient()),
            () -> assertEquals("value", value, String.format("%.8f", dto.getValue())),
            () -> assertEquals("type", type, dto.getType()),
            () -> assertEquals("methodName", methodName, dto.getMethodName())
        );
    }

}
