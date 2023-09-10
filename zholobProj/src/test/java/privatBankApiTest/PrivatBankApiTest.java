package privatBankApiTest;

import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import org.apache.log4j.Logger;
import org.assertj.core.api.SoftAssertions;
import org.junit.Assert;
import org.junit.Test;
import privatBankApi.dto.EndPointsPB;
import privatBankApi.dto.ExchangeRateDto;
import privatBankApi.dto.PrivatCurrencyDto;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

// Відправити GET https://api.privatbank.ua/p24api/exchange_rates?date=22.03.2022, і провалідувати
// поля date, bank,baseCurrency,baseCurrencyLit і в полі exchangeRate   назву валют в полях baseCurrency та currency ,
// заігноривши поля в яких вказані курси валют (saleRateNB, purchaseRateNB, saleRate, purchaseRate ).

public class PrivatBankApiTest {

    final String DATE = "22.03.2022";
    final Integer BASE_CURRENCY = 980;
    Logger logger = Logger.getLogger(getClass());


    @Test
    public void getPrivatUserTest() {
        PrivatCurrencyDto responseAsDto = given()
                .contentType(ContentType.JSON)
                .queryParam("date", DATE)
                .log().all()
                .when()
                .get(EndPointsPB.CURRENCY)
                .then()

                .statusCode(200)
                .log().all()
                .assertThat()
                .extract().body().as(PrivatCurrencyDto.class); // витягуємо тіло відповіді і конвертуємо в обєкт PrivatCurrencyDto
        logger.info(responseAsDto.toString());//
        logger.info(responseAsDto.getExchangeRate().length); // кылькысть елементыв в масиві ExchangeRate

        //       SoftAssertions softAssertions = new SoftAssertions(); // створюємо обєкт класу SoftAssertions для  перевірки

        Assert.assertEquals("Date is not matched"
                , DATE
                , responseAsDto.getDate());
        Assert.assertEquals("Bank is not matched"
                , "PB"
                , responseAsDto.getBank());
        Assert.assertEquals("BaseCurrency is not matched"
                , BASE_CURRENCY
                , responseAsDto.getBaseCurrency());
        Assert.assertEquals("BaseCurrencyLit is not matched"
                , "UAH"
                , responseAsDto.getBaseCurrencyLit()); // перевіряємо поля date, bank,baseCurrency,baseCurrencyLit

        //Всі значення responseAsDto.getExchangeRate()
        for (int i = 0; i < responseAsDto.getExchangeRate().length; i++) {
            Assert.assertEquals("BaseCurrency is not matched in post  " + i
                    , "UAH"
                    , responseAsDto.getExchangeRate()[i].getBaseCurrency());

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
        PrivatCurrencyDto expectedCurrencyDto = new PrivatCurrencyDto(DATE, "PB", BASE_CURRENCY, "UAH", expectedExchangeRates);
//цикл який перевіряє значення в массиві expectedExchangeRates
        SoftAssertions softAssertions = new SoftAssertions();
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
                .get(EndPointsPB.CURRENCY)
                .then()

                .statusCode(200)
                .log().all()
                .assertThat().body(matchesJsonSchemaInClasspath("privatCurrencySchema.json"));
    }
}

