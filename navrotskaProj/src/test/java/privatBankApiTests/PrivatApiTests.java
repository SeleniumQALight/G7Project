package privatBankApiTests;

import api.EndPoints;
import io.restassured.http.ContentType;
import org.apache.log4j.Logger;
import org.assertj.core.api.SoftAssertions;
import org.junit.Assert;
import org.junit.Test;
import privatBankApi.PrivatEndPoints;
import privatBankApi.dto.responseDto.ExchangeAllRatesDto;
import privatBankApi.dto.responseDto.ExchangeRateDto;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.CoreMatchers.*;


public class PrivatApiTests {
    final String BASE_CURRENCY = "UAH";
    final String DATE = "22.03.2022";
    Logger logger = Logger.getLogger(getClass());


    @Test
    public void getExchangeRateTest() {
        ExchangeAllRatesDto responseAsDto = given()
                .contentType(ContentType.JSON)//додали хедер аплікейшина
                .log().all()//виводимо в колсоль весь запит
                .when()// дія
                .queryParam("date", DATE)
                .get(PrivatEndPoints.GET_EXCHANGE_RATE)
                .then()
                .statusCode(200)
                .log().all()
                .assertThat()
                .body("date", equalTo(DATE))
                .body("baseCurrencyLit", equalTo(BASE_CURRENCY))
                .body("baseCurrency", equalTo(980))
                .body("bank", equalTo("PB"))
                .body("exchangeRate.baseCurrency", everyItem(equalTo(BASE_CURRENCY)))
                .body("exchangeRate.currency", hasItem(equalTo("USD")))
                .extract().body().as(ExchangeAllRatesDto.class);
        logger.info(responseAsDto.toString());
        logger.info(responseAsDto.getBank());
        logger.info(responseAsDto.getBaseCurrency());
        logger.info(responseAsDto.getExchangeRate()[23].getCurrency());



        for (int i = 0; i < responseAsDto.getExchangeRate().length; i++) {
            Assert.assertEquals("BaseCurrency is not matched with Exchange Rate list" + i
                    , BASE_CURRENCY, responseAsDto.getExchangeRate()[i].getBaseCurrency());
        }

        ExchangeRateDto[] expectedExchangeRateDto = {
                        new ExchangeRateDto(BASE_CURRENCY, "AUD"),
                        new ExchangeRateDto(BASE_CURRENCY, "AZN"),
                        new ExchangeRateDto(BASE_CURRENCY, "BYN"),
                        new ExchangeRateDto(BASE_CURRENCY, "CAD"),
                        new ExchangeRateDto(BASE_CURRENCY, "CHF"),
                        new ExchangeRateDto(BASE_CURRENCY, "CNY"),
                        new ExchangeRateDto(BASE_CURRENCY, "CZK"),
                        new ExchangeRateDto(BASE_CURRENCY, "DKK"),
                        new ExchangeRateDto(BASE_CURRENCY, "EUR"),
                        new ExchangeRateDto(BASE_CURRENCY, "GBP"),
                        new ExchangeRateDto(BASE_CURRENCY, "GEL"),
                        new ExchangeRateDto(BASE_CURRENCY, "HUF"),
                        new ExchangeRateDto(BASE_CURRENCY, "ILS"),
                        new ExchangeRateDto(BASE_CURRENCY, "JPY"),
                        new ExchangeRateDto(BASE_CURRENCY, "KZT"),
                        new ExchangeRateDto(BASE_CURRENCY, "MDL"),
                        new ExchangeRateDto(BASE_CURRENCY, "NOK"),
                        new ExchangeRateDto(BASE_CURRENCY, "PLN"),
                        new ExchangeRateDto(BASE_CURRENCY, "SEK"),
                        new ExchangeRateDto(BASE_CURRENCY, "SGD"),
                        new ExchangeRateDto(BASE_CURRENCY, "TMT"),
                        new ExchangeRateDto(BASE_CURRENCY, "TRY"),
                        new ExchangeRateDto(BASE_CURRENCY, "UAH"),
                        new ExchangeRateDto(BASE_CURRENCY, "USD"),
                        new ExchangeRateDto(BASE_CURRENCY, "UZS")
                };


        Assert.assertEquals("Number of currencies",expectedExchangeRateDto.length,responseAsDto.getExchangeRate().length);
        SoftAssertions softAssertions = new SoftAssertions();

        for (int i = 0; i < expectedExchangeRateDto.length; i++) {
            softAssertions.assertThat(responseAsDto.getExchangeRate()[i])
                    .isEqualToIgnoringGivenFields(expectedExchangeRateDto[i],"saleRateNB", "purchaseRateNB", "saleRate", "purchaseRate");
        }
        softAssertions.assertAll();

    }
    @Test
    public void getAllRatesByDateSchema() {
        given()
                .contentType(ContentType.JSON)//додали хедер аплікейшина
                .log().all()//виводимо в колсоль весь запит
                .when()// дія
                .queryParam("date", DATE)
                .get(PrivatEndPoints.GET_EXCHANGE_RATE)
                .then()
                .statusCode(200)
                .log().all()
                .assertThat()
                .body(matchesJsonSchemaInClasspath("data-container.json"));
    }



}