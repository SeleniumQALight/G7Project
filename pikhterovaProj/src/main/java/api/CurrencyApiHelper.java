package api;

import api.dto.responseDto.CurrencyDto;
import io.restassured.http.ContentType;
import org.apache.log4j.Logger;

import static io.restassured.RestAssured.given;

public class CurrencyApiHelper {

    Logger logger = Logger.getLogger(getClass());

    public CurrencyDto[] getCurrencies(int courseId) {

        CurrencyDto[] responseBody =
                given()
                        .contentType(ContentType.JSON)
                        .log().all()
                        .when()
                        .get(String.format(EndPoints.CURRENCY_RATES_TEMPLATE, courseId))
                        .then()
                        .statusCode(200)
                        .log().all()
                        .extract().response().as(CurrencyDto[].class);

        for (int i = 0; i < responseBody.length; i++) {
            logger.info(
                    String.format("Currency %s buy %s sale %s",
                            responseBody[i].getCcy(),
                            responseBody[i].getBuy(),
                            responseBody[i].getSale())
            );
        }

        return responseBody;

    }

}
