package privatBankApiTest;

import io.restassured.http.ContentType;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import privatBankApi.dto.EndPointsPB;
import privatBankApi.dto.PrivatCurrencyDto;

import static io.restassured.RestAssured.given;

// Відправити GET https://api.privatbank.ua/p24api/exchange_rates?date=22.03.2022, і провалідувати
// поля date, bank,baseCurrency,baseCurrencyLit і в полі exchangeRate   назву валют в полях baseCurrency та currency ,
// заігноривши поля в яких вказані курси валют (saleRateNB, purchaseRateNB, saleRate, purchaseRate ).

public class PrivatBankApiTest {
    Logger logger = Logger.getLogger(getClass());

    final String DATE = "22.03.2022";



@Test
public void getPrivatUserTest() {
    PrivatCurrencyDto responseDto = given()
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
    logger.info(responseDto.toString());
    logger.info(responseDto.getExchangeRate().length);
    //масив не потрыбний бо выдповыдь тыльки одна

    //введемо для перевырки очыкувані значення полів в заданому порядку

    Assert.assertEquals("not expected", DATE, responseDto.getDate());
    Assert.assertEquals("not expected", "PB", responseDto.getBank());
    Assert.assertEquals("not expected", "980", responseDto.getBaseCurrency());
    Assert.assertEquals("not expected", "UAH", responseDto.getBaseCurrencyLit());


    }


}


