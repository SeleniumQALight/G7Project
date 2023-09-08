package privatBankApiTest;

import io.restassured.http.ContentType;
import org.apache.log4j.Logger;
import org.assertj.core.api.SoftAssertions;
import org.junit.Assert;
import org.junit.Test;
import privatBankApi.dto.EndPointsPB;
import privatBankApi.dto.ExchangeRateDto;
import privatBankApi.dto.PrivatCurrencyDto;

import static io.restassured.RestAssured.given;

// Відправити GET https://api.privatbank.ua/p24api/exchange_rates?date=22.03.2022, і провалідувати
// поля date, bank,baseCurrency,baseCurrencyLit і в полі exchangeRate   назву валют в полях baseCurrency та currency ,
// заігноривши поля в яких вказані курси валют (saleRateNB, purchaseRateNB, saleRate, purchaseRate ).

public class PrivatBankApiTest {

    final String DATE = "22.03.2022";
    final Integer BASE_CURRENCY = 980;
    Logger logger = Logger.getLogger(getClass());



    String[] ListOfCurrensies = {"AUD", "AZN", "BYN", "CAD", "CHF", "CNY", "CZK", "DKK",
            "EUR", "GBP", "GEL", "HUF", "ILS", "JPY", "KZT", "MDL", "NOK", "PLN", "SEK", "SGD", "TMT", "TRY",
            "UAH", "USD", "UZS"}; // массив з переліком валют заданому порядку
// робимо змінну listOfCurrensies


    int listOfCurrensiesLength = ListOfCurrensies.length;


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

        SoftAssertions softAssertions = new SoftAssertions(); // створюємо обєкт класу SoftAssertions для  перевірки

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

        //Всі значення responseAsDto.getExchangeRate().baseCurrency мають бути 'UAH'
        for (int i = 0; i < responseAsDto.getExchangeRate().length; i++) {
            Assert.assertEquals("BaseCurrency is not matched in post  " + i
                    , "UAH"
                    , responseAsDto.getExchangeRate()[i].getBaseCurrency());
        }
// цикл який перевіряє значення поля currency в кожному елементі масиву ExchangeRate
        for (int i = 0; i < responseAsDto.getExchangeRate().length; i++) {
            Assert.assertEquals("Currency is not matched"
                    , ListOfCurrensies[i]
                    , responseAsDto.getExchangeRate()[i].getCurrency());

        }
       softAssertions.assertAll(); // перевірка всіх попередніх перевірок
    }



    private ExchangeRateDto[] expectedExchangeRates= new ExchangeRateDto[listOfCurrensiesLength];
    //задаю массив expectedExchangeRates циклом

    {
        for (int i = 0; i < listOfCurrensiesLength; i++) {
            expectedExchangeRates[i] = new ExchangeRateDto("UAH", ListOfCurrensies[i]);
        }
    }

    PrivatCurrencyDto expectedCurrencyDto = new PrivatCurrencyDto(DATE, "PB", BASE_CURRENCY, "UAH", expectedExchangeRates);


    }





//        Assert.assertEquals("Currency is not matched"
//                , "AUD"
//                , responseAsDto.getExchangeRate()[0].getCurrency()); // перевіряємо поле currency першого елемента масиву ExchangeRate
//        Assert.assertEquals("Currency is not matched"
//                , "AZN"
//                , responseAsDto.getExchangeRate()[1].getCurrency());
//        Assert.assertEquals("Currency is not matched"
//                , "BYN"
//                , responseAsDto.getExchangeRate()[2].getCurrency());
//        Assert.assertEquals("Currency is not matched"
//                , "CAD"
//                , responseAsDto.getExchangeRate()[3].getCurrency());
//        Assert.assertEquals("Currency is not matched"
//                , "CHF"
//                , responseAsDto.getExchangeRate()[4].getCurrency());
//        Assert.assertEquals("Currency is not matched"
//                , "CNY"
//                , responseAsDto.getExchangeRate()[5].getCurrency());
//        Assert.assertEquals("Currency is not matched"
//                , "CZK"
//                , responseAsDto.getExchangeRate()[6].getCurrency());
//        Assert.assertEquals("Currency is not matched"
//                , "DKK"
//                , responseAsDto.getExchangeRate()[7].getCurrency());
//        Assert.assertEquals("Currency is not matched"
//                , "EUR"
//                , responseAsDto.getExchangeRate()[8].getCurrency());
//        Assert.assertEquals("Currency is not matched"
//                , "GBP"
//                , responseAsDto.getExchangeRate()[9].getCurrency());
//        Assert.assertEquals("Currency is not matched"
//                , "GEL"
//                , responseAsDto.getExchangeRate()[10].getCurrency());
//        Assert.assertEquals("Currency is not matched"
//                , "HUF"
//                , responseAsDto.getExchangeRate()[11].getCurrency());
//        Assert.assertEquals("Currency is not matched"
//                , "ILS"
//                , responseAsDto.getExchangeRate()[12].getCurrency());
//        Assert.assertEquals("Currency is not matched"
//                , "JPY"
//                , responseAsDto.getExchangeRate()[13].getCurrency());
//        Assert.assertEquals("Currency is not matched"
//                , "KZT"
//                , responseAsDto.getExchangeRate()[14].getCurrency());
//        Assert.assertEquals("Currency is not matched"
//                , "MDL"
//                , responseAsDto.getExchangeRate()[15].getCurrency());
//        Assert.assertEquals("Currency is not matched"
//                , "NOK"
//                , responseAsDto.getExchangeRate()[16].getCurrency());
//        Assert.assertEquals("Currency is not matched"
//                , "PLN"
//                , responseAsDto.getExchangeRate()[17].getCurrency());
//        Assert.assertEquals("Currency is not matched"
//                , "SEK"
//                , responseAsDto.getExchangeRate()[18].getCurrency());
//        Assert.assertEquals("Currency is not matched"
//                , "SGD"
//                , responseAsDto.getExchangeRate()[19].getCurrency());
//        Assert.assertEquals("Currency is not matched"
//                , "TMT"
//                , responseAsDto.getExchangeRate()[20].getCurrency());
//        Assert.assertEquals("Currency is not matched"
//                , "TRY"
//                , responseAsDto.getExchangeRate()[21].getCurrency());
//        Assert.assertEquals("Currency is not matched"
//                , "UAH"
//                , responseAsDto.getExchangeRate()[22].getCurrency());
//        Assert.assertEquals("Currency is not matched"
//                , "USD"
//                , responseAsDto.getExchangeRate()[23].getCurrency());
//        Assert.assertEquals("Currency is not matched"
//                , "UZS"
//                , responseAsDto.getExchangeRate()[24].getCurrency());




