package apiTests;

import api.HwEndPoints;
import api.dto.responseDto.hwDto.ExchangeRateDto;
import api.dto.responseDto.hwDto.HwDtoPB;
import io.restassured.http.ContentType;
import org.apache.log4j.Logger;
import org.assertj.core.api.SoftAssertions;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class PbApiTest {
    Logger logger = Logger.getLogger(getClass());

    @Test
    public void validateExchangeRates() {
        String date = "22.03.2022";

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
        assertEquals("UAH", response.getBaseCurrencyLit());
        assertEquals("22.03.2022", response.getDate());
        assertEquals(980, response.getBaseCurrency().intValue());


        for (int i = 0; i < response.getExchangeRate().length; i++) {
            assertEquals("UAH", response.getExchangeRate()[i].getBaseCurrency());
        }

        ExchangeRateDto[] expectedResult = {
                new ExchangeRateDto("UAH", "AUD"),
                new ExchangeRateDto("UAH", "AZN"),
                new ExchangeRateDto("UAH", "BYN"),
                new ExchangeRateDto("UAH", "CAD"),
                new ExchangeRateDto("UAH", "CHF"),
                new ExchangeRateDto("UAH", "CNY"),
                new ExchangeRateDto("UAH", "CZK"),
                new ExchangeRateDto("UAH", "DKK"),
                new ExchangeRateDto("UAH", "EUR"),
                new ExchangeRateDto("UAH", "GBP"),
                new ExchangeRateDto("UAH", "GEL"),
                new ExchangeRateDto("UAH", "HUF"),
                new ExchangeRateDto("UAH", "ILS"),
                new ExchangeRateDto("UAH", "JPY"),
                new ExchangeRateDto("UAH", "KZT"),
                new ExchangeRateDto("UAH", "MDL"),
                new ExchangeRateDto("UAH", "NOK"),
                new ExchangeRateDto("UAH", "PLN"),
                new ExchangeRateDto("UAH", "SEK"),
                new ExchangeRateDto("UAH", "SGD"),
                new ExchangeRateDto("UAH", "TMT"),
                new ExchangeRateDto("UAH", "TRY"),
                new ExchangeRateDto("UAH", "UAH"),
                new ExchangeRateDto("UAH", "USD"),
                new ExchangeRateDto("UAH", "UZS")};

        SoftAssertions softAssertions = new SoftAssertions();

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

        ExchangeRateDto[] exchangeRates = response.getExchangeRate();

        for (int i = 0; i < exchangeRates.length; i++) {
            ExchangeRateDto exchangeRate = exchangeRates[i];
            if (exchangeRate.getSaleRate() != null) {
                assertTrue(exchangeRate.getSaleRate() > 0);
            }
            if (exchangeRate.getPurchaseRate() != null) {
                assertTrue(exchangeRate.getPurchaseRate() > 0);
            }
            if (exchangeRate.getSaleRateNB() != null) {
                assertTrue(exchangeRate.getSaleRateNB() > 0);
            }
            if (exchangeRate.getPurchaseRateNB() != null) {
                assertTrue(exchangeRate.getPurchaseRateNB() > 0);
            }
        }
    }
}