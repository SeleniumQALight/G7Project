
package apiTests;

import api.EndPoints;
import api.dto.responseDto.ExchangeRateCurrencyDto;
import api.dto.responseDto.PrivatGET;
import api.dto.responseDto.PrivatHW;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.log4j.Logger;
import org.assertj.core.api.SoftAssertions;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class PrivatBankGETApiTest {
    Logger logger = Logger.getLogger(getClass());

  @Test
    static public void getCurrencyPrivat() {
        PrivatGET[] response = given()
                .filter(new AllureRestAssured())//для виводу в звіт
                .contentType(ContentType.JSON)//додали хедер аплікейшина
                .log().all()//виводимо в колсоль весь запит
                .when()// дія
                .get(EndPoints.PRIVATBANK_URL)
                .then()
                .statusCode(200)//перевір, що повернуло потрібний статус
                .log().all()//виводимо в колсоль весь респонс
                .extract().as(PrivatGET[].class);
    }
}
