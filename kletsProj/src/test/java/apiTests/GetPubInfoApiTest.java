package apiTests;


import org.apache.log4j.Logger;
import org.junit.Test;
import privateBankApi.dto.responseDto.ApiHelperPrivateBank;

public class GetPubInfoApiTest {
    Logger logger = Logger.getLogger(getClass());
    ApiHelperPrivateBank apiHelperPrivateBank = new ApiHelperPrivateBank();

    @Test
    public void getPubInfoTest() {
        logger.info("Get pub info test started");
        apiHelperPrivateBank.getAllInfo().getClass();
        logger.info("Get pub info test finished");

    }


}
