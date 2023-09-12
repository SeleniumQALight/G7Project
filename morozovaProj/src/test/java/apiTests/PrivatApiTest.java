/**
 * ДЗ№1 опис АПІ https://api.privatbank.ua/#p24/exchangeArchive
 * 1. Відправити GET https://api.privatbank.ua/p24api/exchange_rates?date=22.03.2022,
 * і провалідувати поля date, bank,baseCurrency,baseCurrencyLit і в полі exchangeRate
 * назву валют в полях baseCurrency та currency , заігноривши поля в яких вказані курси валют
 * (saleRateNB, purchaseRateNB, saleRate, purchaseRate )
 * ==
 * "date": "22.03.2022",
 * "bank": "PB",
 * "baseCurrency": 980,
 * "baseCurrencyLit": "UAH",
 * "exchangeRate": [
 * {
 * "baseCurrency": "UAH",
 * "currency": "AUD",
 * "saleRateNB": 21.2610000,
 * "purchaseRateNB": 21.2610000
 * }
 * ==
 */

package apiTests;

import api.EndPoints;
import api.dto.responseDto.ExchangeRateCurrencyDto;
import api.dto.responseDto.PrivatHW;

import io.restassured.http.ContentType;
import org.apache.log4j.Logger;
import org.assertj.core.api.SoftAssertions;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class PrivatApiTest {
    String date = "22.03.2022";
    final String BASE_CURRENCY = "UAH";
    Logger logger = Logger.getLogger(getClass());

    @Test
    public void getAllCurrencyPrivat() {
        PrivatHW responseAsDto = given()
                .contentType(ContentType.JSON)
                .queryParam("date", date)
                .when()
                .get(EndPoints.PRIVAT_URL)
                .then()
                .statusCode(200)
                .log().all()
                .assertThat()
                .extract().as(PrivatHW.class);
        logger.info(responseAsDto.toString());
        logger.info("Number of currencies = " + responseAsDto.getExchangeRate().length);

        ExchangeRateCurrencyDto[] expectedExchangeRates = {
                new ExchangeRateCurrencyDto(BASE_CURRENCY, "AUD"),
                new ExchangeRateCurrencyDto(BASE_CURRENCY, "AZN"),
                new ExchangeRateCurrencyDto(BASE_CURRENCY, "BYN"),
                new ExchangeRateCurrencyDto(BASE_CURRENCY, "CAD"),
                new ExchangeRateCurrencyDto(BASE_CURRENCY, "CHF"),
                new ExchangeRateCurrencyDto(BASE_CURRENCY, "CNY"),
                new ExchangeRateCurrencyDto(BASE_CURRENCY, "CZK"),
                new ExchangeRateCurrencyDto(BASE_CURRENCY, "DKK"),
                new ExchangeRateCurrencyDto(BASE_CURRENCY, "EUR"),
                new ExchangeRateCurrencyDto(BASE_CURRENCY, "GBP"),
                new ExchangeRateCurrencyDto(BASE_CURRENCY, "GEL"),
                new ExchangeRateCurrencyDto(BASE_CURRENCY, "HUF"),
                new ExchangeRateCurrencyDto(BASE_CURRENCY, "ILS"),
                new ExchangeRateCurrencyDto(BASE_CURRENCY, "JPY"),
                new ExchangeRateCurrencyDto(BASE_CURRENCY, "KZT"),
                new ExchangeRateCurrencyDto(BASE_CURRENCY, "MDL"),
                new ExchangeRateCurrencyDto(BASE_CURRENCY, "NOK"),
                new ExchangeRateCurrencyDto(BASE_CURRENCY, "PLN"),
                new ExchangeRateCurrencyDto(BASE_CURRENCY, "SEK"),
                new ExchangeRateCurrencyDto(BASE_CURRENCY, "SGD"),
                new ExchangeRateCurrencyDto(BASE_CURRENCY, "TMT"),
                new ExchangeRateCurrencyDto(BASE_CURRENCY, "TRY"),
                new ExchangeRateCurrencyDto(BASE_CURRENCY, "UAH"),
                new ExchangeRateCurrencyDto(BASE_CURRENCY, "USD"),
                new ExchangeRateCurrencyDto(BASE_CURRENCY, "UZS")
        };
        //перевірка кількості елементів
        Assert.assertEquals("Number of posts ", expectedExchangeRates.length, responseAsDto.getExchangeRate().length);

        Assert.assertEquals("Date is not expected", date, responseAsDto.getDate());
        Assert.assertEquals("Bank is not expected", "PB", responseAsDto.getBank());
        Assert.assertEquals("BaseCurrency is not expected", 980, responseAsDto.getBaseCurrency());
        Assert.assertEquals("BaseCurrencyLit is not expected", "UAH", responseAsDto.getBaseCurrencyLit());

        for (int i = 0; i < responseAsDto.getExchangeRate().length; i++) {
            Assert.assertEquals("BaseCurrency is not expected in " + i,
                    BASE_CURRENCY,
                    responseAsDto.getExchangeRate()[i].getBaseCurrency());
        }

        PrivatHW expectedCurrencyDto = new PrivatHW(date, "PB", 980, "UAH", expectedExchangeRates);

        SoftAssertions softAssertions = new SoftAssertions();

        for (int i = 0; i < expectedExchangeRates.length; i++) {
            softAssertions.assertThat(responseAsDto.getExchangeRate()[i])
                    .isEqualToIgnoringGivenFields(expectedCurrencyDto.getExchangeRate()[i], "saleRateNB", "purchaseRateNB", "saleRate", "purchaseRate");
        }
        softAssertions.assertAll();
    }
}
