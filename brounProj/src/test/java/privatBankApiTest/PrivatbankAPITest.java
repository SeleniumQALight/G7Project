package privatBankApiTest;

import api.EndPoints;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import privatBankApi.PrimaryDto;
import privatBankApi.PrivatbankEndpoints;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class PrivatbankAPITest {
    final String DATE = "22.03.2022";
    Logger logger = Logger.getLogger(getClass());
    @Test

    public void getExchangeRateTest() {
        PrimaryDto primaryDto = given()
                .contentType("application/json")
                .queryParam("date", DATE)
                .log().all()
                .when()
                .get(PrivatbankEndpoints.EXCHANGE_RATES)
                .then()
                .statusCode(200)
                .log().all()
                .assertThat()
                .body("date", equalTo(DATE))
                .body("bank", equalTo("PB"))
                .body("baseCurrency", equalTo(980))
                .body("baseCurrencyLit", equalTo("UAH"))
                .extract().body().as(PrimaryDto.class);

        for (int i = 0; i < primaryDto.getExchangeRate().length; i++) {

            Assert.assertEquals("Base currency is not matched in post " + i,
                    "UAH",
                    primaryDto.getExchangeRate()[i].getBaseCurrency());
            
        }
        

    }

}
