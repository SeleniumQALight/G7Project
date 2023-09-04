package privatBankApiTest;

import io.restassured.http.ContentType;
import org.apache.log4j.Logger;
import org.junit.Test;
import privatBankApi.PrivatBankEndpoints;
import privatBankApi.getDto.responseDto.GetDto;

import static io.restassured.RestAssured.given;

public class ApiTestPrivatBank {
    final String DATE_NOW = "03.09.2023";

    Logger logger = Logger.getLogger(getClass());

    @Test
    public void getCurrencyPrivatBank(){
        GetDto responseAsGto = given()
                .contentType(ContentType.JSON)
                .log().all()
                .when()
                .get(PrivatBankEndpoints.EXCHANGE_RATE, DATE_NOW)
                .then()
                .statusCode(200)
                .log().all()
                .assertThat()
                .extract().body().as(GetDto.class)
                ;
        logger.info(responseAsGto.toString());
        logger.info(responseAsGto.getExchangeRate());
    }
}
