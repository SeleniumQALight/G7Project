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
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

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
                ExchangeRateDtoPrivatBank.builder().baseCurrency(BASE_CURRENCY).currency("AUD")
                        .build(),
                ExchangeRateDtoPrivatBank.builder().baseCurrency(BASE_CURRENCY).currency("AZN")
                        .build(),
                ExchangeRateDtoPrivatBank.builder().baseCurrency(BASE_CURRENCY).currency("BYN")
                        .build(),
                ExchangeRateDtoPrivatBank.builder().baseCurrency(BASE_CURRENCY).currency("CAD")
                        .build(),
                ExchangeRateDtoPrivatBank.builder().baseCurrency(BASE_CURRENCY).currency("CHF")
                        .build(),
                ExchangeRateDtoPrivatBank.builder().baseCurrency(BASE_CURRENCY).currency("CNY")
                        .build(),
                ExchangeRateDtoPrivatBank.builder().baseCurrency(BASE_CURRENCY).currency("CZK")
                        .build(),
                ExchangeRateDtoPrivatBank.builder().baseCurrency(BASE_CURRENCY).currency("DKK")
                        .build(),
                ExchangeRateDtoPrivatBank.builder().baseCurrency(BASE_CURRENCY).currency("EUR")
                        .build(),
                ExchangeRateDtoPrivatBank.builder().baseCurrency(BASE_CURRENCY).currency("GBP")
                        .build(),
                ExchangeRateDtoPrivatBank.builder().baseCurrency(BASE_CURRENCY).currency("GEL")
                        .build(),
                ExchangeRateDtoPrivatBank.builder().baseCurrency(BASE_CURRENCY).currency("HUF")
                        .build(),
                ExchangeRateDtoPrivatBank.builder().baseCurrency(BASE_CURRENCY).currency("ILS")
                        .build(),
                ExchangeRateDtoPrivatBank.builder().baseCurrency(BASE_CURRENCY).currency("JPY")
                        .build(),
                ExchangeRateDtoPrivatBank.builder().baseCurrency(BASE_CURRENCY).currency("KZT")
                        .build(),
                ExchangeRateDtoPrivatBank.builder().baseCurrency(BASE_CURRENCY).currency("MDL")
                        .build(),
                ExchangeRateDtoPrivatBank.builder().baseCurrency(BASE_CURRENCY).currency("NOK")
                        .build(),
                ExchangeRateDtoPrivatBank.builder().baseCurrency(BASE_CURRENCY).currency("PLN")
                        .build(),
                ExchangeRateDtoPrivatBank.builder().baseCurrency(BASE_CURRENCY).currency("SEK")
                        .build(),
                ExchangeRateDtoPrivatBank.builder().baseCurrency(BASE_CURRENCY).currency("SGD")
                        .build(),
                ExchangeRateDtoPrivatBank.builder().baseCurrency(BASE_CURRENCY).currency("TMT")
                        .build(),
                ExchangeRateDtoPrivatBank.builder().baseCurrency(BASE_CURRENCY).currency("TRY")
                        .build(),
                ExchangeRateDtoPrivatBank.builder().baseCurrency(BASE_CURRENCY).currency("UAH")
                        .build(),
                ExchangeRateDtoPrivatBank.builder().baseCurrency(BASE_CURRENCY).currency("USD")
                        .build(),
                ExchangeRateDtoPrivatBank.builder().baseCurrency(BASE_CURRENCY).currency("UZS")
                        .build(),
                ExchangeRateDtoPrivatBank.builder().baseCurrency(BASE_CURRENCY).currency("XAU")
                        .build()


//                new ExchangeRateDtoPrivatBank (BASE_CURRENCY,"AUD"), --
//                new ExchangeRateDtoPrivatBank (BASE_CURRENCY,"AZN"), --
//                new ExchangeRateDtoPrivatBank (BASE_CURRENCY,"BYN"), --
//                new ExchangeRateDtoPrivatBank (BASE_CURRENCY,"CAD"), --
//                new ExchangeRateDtoPrivatBank (BASE_CURRENCY,"CHF"), --
//                new ExchangeRateDtoPrivatBank (BASE_CURRENCY,"CNY"), --
//                new ExchangeRateDtoPrivatBank (BASE_CURRENCY,"CZK"), --
//                new ExchangeRateDtoPrivatBank (BASE_CURRENCY,"DKK"), --
//                new ExchangeRateDtoPrivatBank (BASE_CURRENCY,"EUR"), --
//                new ExchangeRateDtoPrivatBank (BASE_CURRENCY,"GBP"), --
//                new ExchangeRateDtoPrivatBank (BASE_CURRENCY,"GEL"), --
//                new ExchangeRateDtoPrivatBank (BASE_CURRENCY,"HUF"), --
//                new ExchangeRateDtoPrivatBank (BASE_CURRENCY,"ILS"), --
//                new ExchangeRateDtoPrivatBank (BASE_CURRENCY,"JPY"), --
//                new ExchangeRateDtoPrivatBank (BASE_CURRENCY,"KZT"), --
//                new ExchangeRateDtoPrivatBank (BASE_CURRENCY,"MDL"), --
//                new ExchangeRateDtoPrivatBank (BASE_CURRENCY,"NOK"), --
//                new ExchangeRateDtoPrivatBank (BASE_CURRENCY,"PLN"), --
//                new ExchangeRateDtoPrivatBank (BASE_CURRENCY,"SEK"), --
//                new ExchangeRateDtoPrivatBank (BASE_CURRENCY,"SGD"), --
//                new ExchangeRateDtoPrivatBank (BASE_CURRENCY,"TMT"), --
//                new ExchangeRateDtoPrivatBank (BASE_CURRENCY,"TRY"), --
//                new ExchangeRateDtoPrivatBank (BASE_CURRENCY,"UAH"), --
//                new ExchangeRateDtoPrivatBank (BASE_CURRENCY,"USD"), --
//                new ExchangeRateDtoPrivatBank (BASE_CURRENCY,"UZS"), --
//                new ExchangeRateDtoPrivatBank (BASE_CURRENCY,"XAU")  --

        };

        GetDtoPrivatBank expectedGetDtoPrivatBank =
//                new GetDtoPrivatBank(DATE_NOW, "PB", 980, "UAH", exchangeRateDtoPrivatBanks)
                GetDtoPrivatBank.builder().date(DATE_NOW).bank("PB").baseCurrency(980).baseCurrencyLit("UAH").exchangeRate(exchangeRateDtoPrivatBanks)
                        .build()
        ;

        Assert.assertEquals("Value of BANK", expectedGetDtoPrivatBank.getExchangeRate().length, responseAsGtoPrivatBank.getExchangeRate().length);

        SoftAssertions softAssertions = new SoftAssertions();

//        for (int i = 0; i < responseAsGtoPrivatBank.getExchangeRate().length; i++) {
//            softAssertions.assertThat(responseAsGtoPrivatBank.getExchangeRate()[i])
//                    .usingRecursiveComparison()
//                    .ignoringFields("saleRateNB", "purchaseRateNB", "saleRate", "purchaseRate")
//                    .isEqualTo(expectedGetDtoPrivatBank.getExchangeRate()[i]);
            softAssertions.assertThat(responseAsGtoPrivatBank)
                    .usingRecursiveComparison()
                    .ignoringFields("exchangeRate.saleRateNB", "exchangeRate.purchaseRateNB", "exchangeRate.saleRate", "exchangeRate.purchaseRate")
                    .isEqualTo(expectedGetDtoPrivatBank);
//        }




        softAssertions.assertAll();

    }

    @Test
    public void getAllCurrencyPrivatBankSchema(){
        String matchesJsonSchemaInClasspath;
        given()
                .contentType(ContentType.JSON)
                .queryParam("date", DATE_NOW)
                .log().all()
                .when()
                .get(PrivatBankEndpoints.EXCHANGE_RATE)
                .then()
                .statusCode(200)
                .log().all()
                .assertThat().body(matchesJsonSchemaInClasspath("responseApiPrivatBank.json"));
    }
}
