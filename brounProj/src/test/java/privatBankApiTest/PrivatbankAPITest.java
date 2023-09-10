package privatBankApiTest;

import org.apache.log4j.Logger;
import org.assertj.core.api.SoftAssertions;
import org.hamcrest.Matchers;
import org.junit.Test;
import privatBankApi.PrimaryDto;
import privatBankApi.PrivatbankEndpoints;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class PrivatbankAPITest {
    final String DATE = "22.03.2022";
    Logger logger = Logger.getLogger(getClass());

    @Test

    public void getExchangeRateTest() {
        PrimaryDto primaryDto = given()
                .contentType("application/json")
                .queryParam("date", DATE)
                .log().all()
                .when()
                .get(PrivatbankEndpoints.EXCHANGE_RATES)
                .then()
                .statusCode(200)
                .log().all()
                .assertThat()
                .statusCode(Matchers.either(Matchers.is(200)).or(Matchers.is(201))) // Перевірте, чи статус-код рівний 200 або 201
                .body("date", equalTo(DATE))
                .body("bank", equalTo("PB"))
                .body("baseCurrency", equalTo(980))
                .body("baseCurrencyLit", equalTo("UAH"))
                .extract().body().as(PrimaryDto.class);

        List<String> listOfCurrency = List.of("AUD", "AZN", "BYN", "CAD", "CHF", "CNY", "CZK", "DKK", "EUR", "GBP",
                "GEL", "HUF", "ILS", "JPY", "KZT", "MDL", "NOK", "PLN", "SEK", "SGD", "TMT", "TRY", "UAH", "USD", "UZS");

        if (primaryDto.getExchangeRate().length != listOfCurrency.size()) {
            throw new AssertionError("Number of currency is not matched");

        } else {
            logger.info("Number of currency is matched");


            SoftAssertions softAssertions = new SoftAssertions();
            for (int i = 0; i < primaryDto.getExchangeRate().length; i++) {
                softAssertions.assertThat(primaryDto.getExchangeRate()[i].getBaseCurrency())
                        .as("Base currency is not matched in post " + i)
                        .isEqualTo("UAH");

                softAssertions.assertThat(primaryDto.getExchangeRate()[i].getCurrency())
                        .as("Currency is not matched in post " + i)
                        .isEqualTo(listOfCurrency.get(i));

                softAssertions.assertThat(primaryDto.getExchangeRate()[i].getSaleRateNB())
                        .as("Sale rateNB is not positive")
                        .isGreaterThan(0);

                softAssertions.assertThat(primaryDto.getExchangeRate()[i].getPurchaseRateNB())
                        .as("Purchase rateNB is not positive")
                        .isGreaterThan(0);

                if (primaryDto.getExchangeRate()[i].getSaleRate() != null)
                    softAssertions.assertThat(primaryDto.getExchangeRate()[i].getSaleRate())
                            .as("Sale rate is not positive")
                            .isGreaterThan(0);

                if (primaryDto.getExchangeRate()[i].getPurchaseRate() != null)
                    softAssertions.assertThat(primaryDto.getExchangeRate()[i].getPurchaseRate())
                            .as("Purchase rate is not positive")
                            .isGreaterThan(0);
            }
            softAssertions.assertAll();

        }
    }


}
