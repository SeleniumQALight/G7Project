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
    final String DATE_NOW = "05.09.2023";
    final String BASE_CURRENCY = "UAH";

    Logger logger = Logger.getLogger(getClass());

    @Test
    public void getCurrencyPrivatBank(){
        GetDtoPrivatBank responseAsGtoPrivatBank = given()
                .contentType(ContentType.JSON)
                .queryParam("date", DATE_NOW)
                .log().all()
                .when()
                .get(PrivatBankEndpoints.EXCHANGE_RATE)
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

        ExchangeRateDtoPrivatBank [] exchangeRateDtoPrivatBanks = {
                new ExchangeRateDtoPrivatBank (BASE_CURRENCY,"AUD"),
                new ExchangeRateDtoPrivatBank (BASE_CURRENCY,"AZN"),
                new ExchangeRateDtoPrivatBank (BASE_CURRENCY,"BYN"),
                new ExchangeRateDtoPrivatBank (BASE_CURRENCY,"CAD"),
                new ExchangeRateDtoPrivatBank (BASE_CURRENCY,"CHF"),
                new ExchangeRateDtoPrivatBank (BASE_CURRENCY,"CNY"),
                new ExchangeRateDtoPrivatBank (BASE_CURRENCY,"CZK"),
                new ExchangeRateDtoPrivatBank (BASE_CURRENCY,"DKK"),
                new ExchangeRateDtoPrivatBank (BASE_CURRENCY,"EUR"),
                new ExchangeRateDtoPrivatBank (BASE_CURRENCY,"GBP"),
                new ExchangeRateDtoPrivatBank (BASE_CURRENCY,"GEL"),
                new ExchangeRateDtoPrivatBank (BASE_CURRENCY,"HUF"),
                new ExchangeRateDtoPrivatBank (BASE_CURRENCY,"ILS"),
                new ExchangeRateDtoPrivatBank (BASE_CURRENCY,"JPY"),
                new ExchangeRateDtoPrivatBank (BASE_CURRENCY,"KZT"),
                new ExchangeRateDtoPrivatBank (BASE_CURRENCY,"MDL"),
                new ExchangeRateDtoPrivatBank (BASE_CURRENCY,"NOK"),
                new ExchangeRateDtoPrivatBank (BASE_CURRENCY,"PLN"),
                new ExchangeRateDtoPrivatBank (BASE_CURRENCY,"SEK"),
                new ExchangeRateDtoPrivatBank (BASE_CURRENCY,"SGD"),
                new ExchangeRateDtoPrivatBank (BASE_CURRENCY,"TMT"),
                new ExchangeRateDtoPrivatBank (BASE_CURRENCY,"TRY"),
                new ExchangeRateDtoPrivatBank (BASE_CURRENCY,"UAH"),
                new ExchangeRateDtoPrivatBank (BASE_CURRENCY,"USD"),
                new ExchangeRateDtoPrivatBank (BASE_CURRENCY,"UZS"),
                new ExchangeRateDtoPrivatBank (BASE_CURRENCY,"XAU")

        };

        GetDtoPrivatBank expectedGetDtoPrivatBank =
                new GetDtoPrivatBank(DATE_NOW, "PB", 980, "UAH", exchangeRateDtoPrivatBanks)
        ;

        Assert.assertEquals("Value of BANK", expectedGetDtoPrivatBank.getExchangeRate().length, responseAsGtoPrivatBank.getExchangeRate().length);

        SoftAssertions softAssertions = new SoftAssertions();

        for (int i = 0; i < responseAsGtoPrivatBank.getExchangeRate().length; i++) {
            softAssertions.assertThat(responseAsGtoPrivatBank.getExchangeRate()[i])
                    .usingRecursiveComparison()
                    .ignoringFields("saleRateNB", "purchaseRateNB", "saleRate", "purchaseRate")
                    .isEqualTo(expectedGetDtoPrivatBank.getExchangeRate()[i]);
        }




        softAssertions.assertAll();

    }
}
