package privatBankApiTest;

import org.apache.log4j.Logger;
import org.hamcrest.Matchers;
import org.junit.Assert;
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

        for (int i = 0; i < primaryDto.getExchangeRate().length; i++) {

            Assert.assertEquals("Base currency is not matched in post " + i,
                    "UAH",
                    primaryDto.getExchangeRate()[i].getBaseCurrency());

            Assert.assertEquals("Currency is not matched in post " + i,
                    listOfCurrency.get(i),
                    primaryDto.getExchangeRate()[i].getCurrency());
        }


    }


}
