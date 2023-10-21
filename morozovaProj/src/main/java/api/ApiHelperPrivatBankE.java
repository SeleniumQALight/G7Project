package api;

import api.dto.responseDto.PrivatGET;
import data.TestData;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.apache.log4j.Logger;
import static io.restassured.RestAssured.given;

public class ApiHelperPrivatBankE {
    Logger logger = Logger.getLogger(getClass());
    RequestSpecification requestSpecification = new RequestSpecBuilder()
            .setContentType(ContentType.JSON)
            .log(LogDetail.ALL)
            .build();

    public PrivatGET[] getCurrencyWithAPIPB(String currency) {
        Logger logger = Logger.getLogger(getClass());
        PrivatGET[] responceDto = given()
                .filter(new AllureRestAssured())//для виводу в звіт
                .contentType(ContentType.JSON)//додали хедер аплікейшина
                //  https://api.privatbank.ua/p24api/pubinfo?json&exchange&coursid=5 - API get currency
               .queryParam("json")
                .queryParam("exchange")
                .queryParam("coursid", 5)
                .log().all()//виводимо в колсоль весь запит
                .when()// дія
                .get(EndPoints.PRIVATBANK_URL)
                .then()
                .statusCode(200)//перевір, що повернуло потрібний статус
                .log().all()//виводимо в колсоль весь респонс
                .extract().as(PrivatGET[].class);
        for (int i = 0; i < responceDto.length; i++) {
            if (responceDto[i].getCcy().equalsIgnoreCase(currency)) {
                TestData.curs_buy_api = responceDto[i].getBuy();
                TestData.curs_sale_api = responceDto[i].getSale();
            }
        }
        return responceDto;
    }
}