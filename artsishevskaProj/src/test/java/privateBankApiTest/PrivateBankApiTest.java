package privateBankApiTest;

import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import org.apache.log4j.Logger;
import org.assertj.core.api.SoftAssertions;
import org.junit.Test;
import privateBankApi.dto.CurrencyDto;
import privateBankApi.dto.ExchangeRateDto;
import privateBankApi.dto.PrivateBankEndPoints;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class PrivateBankApiTest {
    final String DATE = "22.03.2022";
    final Integer BASE_CURRENCY = 980;
    Logger logger = Logger.getLogger(getClass());


    @Test
    public void getPrivatUserTest() {
        CurrencyDto responseAsDto = given()
                .contentType(ContentType.JSON)
                .queryParam("date", DATE)
                .log().all()
                .when()
                .get(PrivateBankEndPoints.CURRENCY_EXCHANGE)
                .then()

                .statusCode(200)
                .log().all()
                .assertThat()
                .extract().body().as(CurrencyDto.class); // витягуємо тіло відповіді і конвертуємо в обєкт PrivatCurrencyDto
        logger.info(responseAsDto.toString());//
        logger.info(responseAsDto.getExchangeRate().length); // кылькысть елементыв в масиві ExchangeRate

        SoftAssertions softAssertions = new SoftAssertions(); // створюємо обєкт класу SoftAssertions для  перевірки

        softAssertions.assertThat(responseAsDto.getDate())
                .as("Date is not matched")
                .isEqualTo(DATE);

        softAssertions.assertThat(responseAsDto.getBank())
                .as("Bank is not matched")
                .isEqualTo("PB");

        softAssertions.assertThat(responseAsDto.getBaseCurrency())
                .as("BaseCurrency is not matched")
                .isEqualTo(BASE_CURRENCY);

        softAssertions.assertThat(responseAsDto.getBaseCurrencyLit())
                .as("BaseCurrencyLit is not matched")
                .isEqualTo("UAH");

        for (int i = 0; i < responseAsDto.getExchangeRate().length; i++) {
            softAssertions.assertThat(responseAsDto.getExchangeRate()[i].getBaseCurrency())
                    .as("BaseCurrency is not matched in post " + i)
                    .isEqualTo("UAH");
        }




//задаємо очікуваний результат
        ExchangeRateDto[] expectedExchangeRates = {
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
                new ExchangeRateDto("UAH", "UZS")
        };


// очікуваний результат
        CurrencyDto expectedCurrencyDto = new CurrencyDto(DATE, "PB", BASE_CURRENCY, "UAH", expectedExchangeRates);
//цикл який перевіряє значення в массиві expectedExchangeRates
//        SoftAssertions softAssertions = new SoftAssertions();

        //цикл який перевіряє значення в массиві expectedExchangeRates
        for (int i = 0; i < expectedExchangeRates.length; i++) {
            softAssertions.assertThat(responseAsDto.getExchangeRate()[i])
                    .isEqualToIgnoringGivenFields(expectedExchangeRates[i], "saleRateNB", "purchaseRateNB", "saleRate", "purchaseRate");

        }
        softAssertions.assertAll();
    }



    // HW_02_1_тест на перевірку типыв данних
    @Test
    public void Privat_Schema() {
        ValidatableResponse responseAsDto = given()
                .contentType(ContentType.JSON)
                .queryParam("date", DATE)
                .log().all()
                .when()
                .get(PrivateBankEndPoints.CURRENCY_EXCHANGE)
                .then()

                .statusCode(200)
                .log().all()
                .assertThat().body(matchesJsonSchemaInClasspath("privatCurrencySchema.json"));
    }
}

