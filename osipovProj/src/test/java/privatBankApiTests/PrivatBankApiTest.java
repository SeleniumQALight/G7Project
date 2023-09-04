package privatBankApiTests;

import io.restassured.http.ContentType;
import org.assertj.core.api.SoftAssertions;
import org.junit.Assert;
import org.junit.Test;
import privatBankApi.dto.ExchangeRateDto;
import privatBankApi.dto.PrivatDto;

import static io.restassured.RestAssured.given;
import static privatBankApi.PrivatBankEndpoints.*;

public class PrivatBankApiTest {
    final String BASE_CURRENCY = "UAH";

    @Test
    public void getCurrencyRateTest() {
        PrivatDto privatDto = given()
                .contentType(ContentType.JSON)
                .log().all()
                .get(EXCHANGE_RATE_URL)
                .then()
                .statusCode(200)
                .log().all()
                .assertThat()
                .extract().body().as(PrivatDto.class);

        Assert.assertEquals("", privatDto.getDate(), "22.03.2022");
        Assert.assertEquals("", privatDto.getBank(), "PB");
        Assert.assertEquals("", privatDto.getBaseCurrency(), 980);
        Assert.assertEquals("", privatDto.getBaseCurrencyLit(), "UAH");

        ExchangeRateDto[] expectedCurrency = { //25
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

        SoftAssertions softAssertions = new SoftAssertions();
        for (int i = 0; i < expectedCurrency.length; i++) {
            softAssertions.assertThat(privatDto.getExchangeRate()[i])
                    .isEqualToIgnoringGivenFields(expectedCurrency[i], "saleRateNB", "purchaseRateNB", "saleRate", "purchaseRate");

        }
        softAssertions.assertAll();
    }
}

