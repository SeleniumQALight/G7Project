package apiTest;

import api.CurrencyApiHelper;
import api.EndPoints;
import api.dto.responseDto.CurrencyDto;
import io.restassured.http.ContentType;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class CurrencyTest {

    CurrencyApiHelper currencyApiHelper = new CurrencyApiHelper();

    @Test
    public void currencyTest() {

//        CurrencyDto[] currencies = given()
//                .contentType(ContentType.JSON)
//                .log().all()
//                .when()
//                .get(EndPoints.CURRENCY_RATES)
//                .then()
//                .statusCode(200)
//                .log().all()
//                .extract().response().as(CurrencyDto[].class);

        CurrencyDto[] currencies = currencyApiHelper.getCurrencies(5);

        for (int i = 0; i < currencies.length; i++) {
            System.out.println(
                    String.format("Currency %s buy %s sale %s",
                            currencies[i].getCcy(),
                            currencies[i].getBuy(),
                            currencies[i].getSale())
            );
        }

    }

}
