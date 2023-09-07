package apiTests;

import api.HwEndPoints;
import api.dto.responseDto.hwDto.ExchangeRateDto;
import api.dto.responseDto.hwDto.HwDtoPB;
import io.restassured.http.ContentType;
import org.apache.log4j.Logger;
import org.assertj.core.api.SoftAssertions;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;


public class PbApiTest {
    Logger logger = Logger.getLogger(getClass());

    @Test
    public void validateExchangeRates() {
        String date = "22.03.2022";
        final String BASE_CURRENCY = "UAH";

        HwDtoPB response = given()
                .contentType(ContentType.JSON)
                .queryParam("date", date)
                .when()
                .get(HwEndPoints.PB_EXCHANGE_RATES)
                .then()
                .statusCode(200)
                .log().all()
                .assertThat()
                .extract().as(HwDtoPB.class);
        logger.info(response.toString());
        logger.info(response.getExchangeRate().length);

        assertEquals("PB", response.getBank());
        assertEquals(BASE_CURRENCY, response.getBaseCurrencyLit());
        assertEquals(date, response.getDate());
        assertEquals(980, response.getBaseCurrency().intValue());




        for (int i = 0; i < response.getExchangeRate().length; i++) {
            assertEquals(BASE_CURRENCY, response.getExchangeRate()[i].getBaseCurrency());
        }

        ExchangeRateDto[] expectedResult = {
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
                new ExchangeRateDto(BASE_CURRENCY, "UZS")};

        SoftAssertions softAssertions = new SoftAssertions();

        Assert.assertEquals("Number of BASE_CURRENCY", expectedResult.length, response.getExchangeRate().length);
        logger.info("Number of BASE_CURRENCY: " + expectedResult.length + " " + response.getExchangeRate().length);

        for (int i = 0; i < expectedResult.length; i++) {
            softAssertions.assertThat(response.getExchangeRate()[i]).isEqualToIgnoringGivenFields(expectedResult[i], "saleRateNB", "purchaseRateNB", "saleRate", "purchaseRate");
        }
        softAssertions.assertAll();

    }

    @Test
    public void validateCurrencyExchangeRates() {
        String date = "22.03.2022";

        HwDtoPB response = given()
                .contentType(ContentType.JSON)
                .queryParam("date", date)
                .when()
                .get(HwEndPoints.PB_EXCHANGE_RATES)
                .then()
                .statusCode(200)
                .extract().as(HwDtoPB.class);

        SoftAssertions softAssertions = new SoftAssertions();

        for (int i = 0; i < response.getExchangeRate().length; i++) {
            ExchangeRateDto exchangeRate = response.getExchangeRate()[i];

            softAssertions.assertThat(exchangeRate.getSaleRateNB())
                    .as("Sale Rate NB for Currency: " + exchangeRate.getCurrency())
                    .isGreaterThan(0);

            softAssertions.assertThat(exchangeRate.getPurchaseRateNB())
                    .as("Purchase Rate NB for Currency: " + exchangeRate.getCurrency())
                    .isGreaterThan(0);

            if (exchangeRate.getSaleRate() != null) {
                softAssertions.assertThat(exchangeRate.getSaleRate())
                        .as("Sale Rate for Currency: " + exchangeRate.getCurrency())
                        .isGreaterThan(0);
            }

            if (exchangeRate.getPurchaseRate() != null) {
                softAssertions.assertThat(exchangeRate.getPurchaseRate())
                        .as("Purchase Rate for Currency: " + exchangeRate.getCurrency())
                        .isGreaterThan(0);
            }
        }

        softAssertions.assertAll();
    }
}