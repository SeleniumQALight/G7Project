package privatBankApiTest;

import io.restassured.http.ContentType;
import org.apache.log4j.Logger;
import org.assertj.core.api.SoftAssertions;
import org.junit.Assert;
import org.junit.Test;
import privatBankApi.PrivatBankEndpoints;
import privatBankApi.getDto.responseDto.ExchangeRateDtoPrivatBank;
import privatBankApi.getDto.responseDto.GetDtoPrivatBank;

import static io.restassured.RestAssured.given;

public class ApiTestPrivatBank {
    final String DATE_NOW = "03.09.2023";
    final String BASE_CURRENCY = "UAH";

    Logger logger = Logger.getLogger(getClass());

    @Test
    public void getCurrencyPrivatBank(){
        GetDtoPrivatBank responseAsGtoPrivatBank = given()
                .contentType(ContentType.JSON)
                .log().all()
                .when()
                .get(PrivatBankEndpoints.EXCHANGE_RATE, DATE_NOW)
                .then()
                .statusCode(200)
                .log().all()
                .assertThat()
                .extract().body().as(GetDtoPrivatBank.class)
                ;
        logger.info(responseAsGtoPrivatBank.toString());
        logger.info(responseAsGtoPrivatBank.getExchangeRate());
        logger.info(responseAsGtoPrivatBank.getExchangeRate().length);

        Assert.assertEquals("The date does not match the selected date", DATE_NOW, responseAsGtoPrivatBank.getDate());

        for (int i = 0; i < responseAsGtoPrivatBank.getExchangeRate().length; i++) {
            Assert.assertEquals("baseCurrency corresponds to UAH", BASE_CURRENCY, responseAsGtoPrivatBank.getExchangeRate()[i].getBaseCurrency());
        }

        GetDtoPrivatBank [] expectedGetDtoPrivatBank = {
                new GetDtoPrivatBank(DATE_NOW, "PB", 980, "UAH", new ExchangeRateDtoPrivatBank []("UAH"))
        };

        Assert.assertEquals("Value of BANK", expectedGetDtoPrivatBank, responseAsGtoPrivatBank);

        SoftAssertions softAssertions = new SoftAssertions();

        for (int i = 0; i < responseAsGtoPrivatBank.getExchangeRate().length; i++) {
            softAssertions.assertThat(responseAsGtoPrivatBank.getExchangeRate()[i].getBaseCurrency())
                    .isEqualToIgnoringGivenFields(expectedGetDtoPrivatBank.getExchangeRate()[i], "currency", "saleRateNB", "purchaseRateNB", "saleRate", "purchaseRate");
        }


        softAssertions.assertAll();

    }
}
