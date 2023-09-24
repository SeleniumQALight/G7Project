package privatBankApiTests;

import api.EndPoints;
import io.restassured.http.ContentType;
import org.assertj.core.api.SoftAssertions;
import org.junit.Assert;
import org.junit.Test;
import privatBankApi.PrivatBankEndpoints;
import privatBankApi.dto.ExchangeRateDto;
import privatBankApi.dto.PrivatDto;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static privatBankApi.PrivatBankEndpoints.*;

public class PrivatBankApiTest {
    final String BASE_CURRENCY = "UAH";
    final String DATE = "22.03.2022";

    @Test
    public void getCurrencyRateTest() {
        PrivatDto privatDto = given()
                .contentType(ContentType.JSON)
                .queryParam("date", DATE)
                .log().all()
                .get(EXCHANGE_RATE_URL)
                .then()
                .statusCode(200)
                .log().all()
                .assertThat()
                .extract().body().as(PrivatDto.class);

        Assert.assertEquals("Number of currency is not expected", 25, privatDto.getExchangeRate().length);

        Assert.assertEquals("Date is not expected", DATE, privatDto.getDate());
        Assert.assertEquals("Bank is not expected", "PB", privatDto.getBank());
        Assert.assertEquals("BaseCurrency is not expected", 980, privatDto.getBaseCurrency());
        Assert.assertEquals("BaseAlphabeticCurrencyCode is not expected", BASE_CURRENCY, privatDto.getBaseCurrencyLit());

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

    @Test
    public void getExchangeRateFromSchema(){
        given()
                .contentType(ContentType.JSON)
                .queryParam("date", DATE)
                .log().all()
                .when()
                .get(EXCHANGE_RATE_URL)
                .then()
                .statusCode(200)
                .log().all()
                .assertThat().body(matchesJsonSchemaInClasspath("privatJsonSchema.json"));
    }
}

