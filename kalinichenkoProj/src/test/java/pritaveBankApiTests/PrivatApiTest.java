package pritaveBankApiTests;

import io.restassured.http.ContentType;
import org.apache.log4j.Logger;
import org.assertj.core.api.SoftAssertions;
import org.junit.Assert;
import org.junit.Test;
import privatbankApi.EndPoints;
import privatbankApi.responsDto.ArchiveCursPrivatDto;
import privatbankApi.responsDto.ExchangeRateDto;

import static io.restassured.RestAssured.given;


public class PrivatApiTest {
    Logger logger = Logger.getLogger(getClass());
    final String DATE = "22.03.2022";
    final String BASE_CURRENCY = "UAH";

    @Test
    public void PrivatApiTest() {
        ArchiveCursPrivatDto responsAsDto = given()
                .contentType(ContentType.JSON)
                .log().all()
                .when()
                .given().queryParam("date", DATE)
                .get(EndPoints.BASE_URL)
                .then()
                .log().all()
                .extract().body().as(ArchiveCursPrivatDto.class);
        logger.info(responsAsDto.toString());
        SoftAssertions softAssertions = new SoftAssertions();
        Assert.assertEquals("Date is not expected", DATE, responsAsDto.getDate());
        Assert.assertEquals("Bank is not expected", "PB", responsAsDto.getBank());
        Assert.assertEquals("Base currencyLit is not expected", BASE_CURRENCY, responsAsDto.getBaseCurrencyLit());
        for (int i = 0; i < expectedExchangeRatesList.length; i++) {
            softAssertions.assertThat(responsAsDto.getExchangeRate()[i])
                    .isEqualToIgnoringGivenFields(expectedExchangeRatesList[i], "saleRateNB", "purchaseRateNB", "saleRate", "purchaseRate");
        }

        softAssertions.assertAll();
    }

    ExchangeRateDto[] expectedExchangeRatesList = {
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

    ArchiveCursPrivatDto expectArchiveCurs =
            new ArchiveCursPrivatDto("22.03.2022", "PB", 980, BASE_CURRENCY, expectedExchangeRatesList);

    @Test
    public void PrivatApiTestAdditionalCheck() {
        ArchiveCursPrivatDto responsAsDto = given()
                .contentType(ContentType.JSON)
                .log().all()
                .when()
                .given().queryParam("date", DATE)
                .get(EndPoints.BASE_URL)
                .then()
                .log().all()
                .extract().body().as(ArchiveCursPrivatDto.class);
        SoftAssertions softAssertions = new SoftAssertions();
        for (int i = 0; i < responsAsDto.getExchangeRate().length; i++) {

            if (responsAsDto.getExchangeRate()[i].getSaleRateNB() != null) {
                softAssertions.assertThat(responsAsDto.getExchangeRate()[i].getSaleRateNB()).isGreaterThan(0);
                logger.info("The saleRateNB is " + responsAsDto.getExchangeRate()[i].getSaleRateNB());
            } else {
                logger.info("The saleRateNB is null");
            }

            if (responsAsDto.getExchangeRate()[i].getPurchaseRateNB() != null) {
                softAssertions.assertThat(responsAsDto.getExchangeRate()[i].getPurchaseRateNB()).isGreaterThan(0);
                logger.info("The purchaseRateNB is " + responsAsDto.getExchangeRate()[i].getPurchaseRateNB());
            } else {
                logger.info("The purchaseRateNB is null");
            }

            if (responsAsDto.getExchangeRate()[i].getSaleRate() != null) {
                softAssertions.assertThat(responsAsDto.getExchangeRate()[i].getSaleRate()).isGreaterThan(0);
                logger.info("The saleRate is " + responsAsDto.getExchangeRate()[i].getSaleRate());
            } else {
                logger.info("The saleRate is null");
            }

            if (responsAsDto.getExchangeRate()[i].getPurchaseRate() != null) {
                softAssertions.assertThat(responsAsDto.getExchangeRate()[i].getPurchaseRate()).isGreaterThan(0);
                logger.info("The purchaseRate is " + responsAsDto.getExchangeRate()[i].getPurchaseRate());
            } else {
                logger.info("The purchaseRate is null");
            }
            logger.info("The iteration is " + i);
        }
        softAssertions.assertAll();
    }
}