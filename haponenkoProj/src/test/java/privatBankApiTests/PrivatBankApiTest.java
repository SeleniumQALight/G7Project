package privatBankApiTests;

import io.restassured.http.ContentType;
import org.apache.log4j.Logger;
import org.assertj.core.api.SoftAssertions;
import org.junit.Assert;
import org.junit.Test;
import privatBankApi.PrivatBankEndPoints;
import privatBankApi.dto.pbResponseDto.CurrencyDto;
import privatBankApi.dto.pbResponseDto.ExchangeRateDto;


import static io.restassured.RestAssured.given;

public class PrivatBankApiTest {
    Logger logger = Logger.getLogger(getClass());
    final String DATE = "22.03.2022";
    final String BASE_CURRENCY = "UAH";

    @Test
    public void getCurrencyRateTest() {
        CurrencyDto currencyResponseAsDto = given()
                .contentType(ContentType.JSON)
                .queryParam("date", DATE)
                .log().all()
                .when()
                .get(PrivatBankEndPoints.CURRENCY_RATES)
                .then()
                .statusCode(200)
                .log().all()
                .assertThat()
                .extract().body().as(CurrencyDto.class);
        logger.info(currencyResponseAsDto.toString());
        logger.info(currencyResponseAsDto.getExchangeRate().length);

        Assert.assertEquals("Date is not expected", DATE, currencyResponseAsDto.getDate());
        Assert.assertEquals("Bank is not expected", "PB", currencyResponseAsDto.getBank());
        Assert.assertEquals("Base currency is not expected", 980, currencyResponseAsDto.getBaseCurrency());
        Assert.assertEquals("Base currency lit is not expected", "UAH", currencyResponseAsDto.getBaseCurrencyLit());

        for (int i = 0; i < currencyResponseAsDto.getExchangeRate().length; i++) {
            Assert.assertEquals("Base_Currency is not expected in #" + i,
                    BASE_CURRENCY,
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

        CurrencyDto expectedCurrencyDto = new CurrencyDto(DATE, "PB", 980, "UAH", expectedExchangeRates);
//       питання: чому якщо перенести рядок 75 перед рядком 47, то expectedExchangeRates з 75 рядка починає світитись червоним?

        SoftAssertions softAssertions = new SoftAssertions();

        for (int i = 0; i < expectedExchangeRates.length; i++) {
            softAssertions.assertThat(currencyResponseAsDto.getExchangeRate()[i])
                    .isEqualToIgnoringGivenFields(expectedCurrencyDto.getExchangeRate()[i], "saleRateNB", "purchaseRateNB", "saleRate", "purchaseRate");
        }

        softAssertions.assertAll();
    }
}

