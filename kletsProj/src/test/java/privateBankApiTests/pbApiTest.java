package privateBankApiTests;


import io.restassured.http.ContentType;
import org.apache.log4j.Logger;
import org.assertj.core.api.SoftAssertions;
import org.junit.Assert;
import org.junit.Test;
import privateBankApi.PrivateBankEndPoints;
import privateBankApi.dto.responseDto.CurrencyDto;
import privateBankApi.dto.responseDto.ExchangeRateDto;

import static io.restassured.RestAssured.given;

public class pbApiTest {

    Logger logger = Logger.getLogger(getClass());

    final String DATE = "22.03.2022";
    final String BASE_CURRENCY = "UAH";

    @Test
    public void getCurrencyExchangeRateTest() {
        CurrencyDto currencyResponseAsDto = given()
                .contentType(ContentType.JSON)
                .queryParam("date", DATE)
                .log().all()
                .when()
                .get(PrivateBankEndPoints.CURRENCY_EXCHANGE)
                .then()
                .statusCode(200)
                .log().all()
                .assertThat()
                .extract().body().as(CurrencyDto.class);
        logger.info(currencyResponseAsDto.toString());
        logger.info(currencyResponseAsDto.getExchangeRate().length);

        Assert.assertEquals("Date is not matched in the exchange rate ", DATE,
                currencyResponseAsDto.getDate());
        Assert.assertEquals("Bank is not matched in the exchange rate ", "PB",
                currencyResponseAsDto.getBank());
        Assert.assertEquals("Base currency is not matched in the exchange rate ", 980,
                currencyResponseAsDto.getBaseCurrency());
        Assert.assertEquals("Base currency lit is not matched in the exchange rate ", BASE_CURRENCY,
                currencyResponseAsDto.getBaseCurrencyLit());

        for (int i = 0; i < currencyResponseAsDto.getExchangeRate().length; i++) {
            Assert.assertEquals("Base currency is not matched in the exchange rate " + i, BASE_CURRENCY,
                    currencyResponseAsDto.getExchangeRate()[i].getBaseCurrency());
        }

        ExchangeRateDto[] expectedExchangeRates = {
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

        Assert.assertEquals("Exchange rates are not matched", expectedExchangeRates.length,
                currencyResponseAsDto.getExchangeRate().length);

        SoftAssertions softAssertions = new SoftAssertions();

        for (int i = 0; i < expectedExchangeRates.length; i++) {
            softAssertions.assertThat(currencyResponseAsDto.getExchangeRate()[i])
                    .isEqualToIgnoringGivenFields(expectedExchangeRates[i],
                            "saleRateNB", "purchaseRateNB", "saleRate", "purchaseRate");

            softAssertions.assertAll();
        }
    }
}