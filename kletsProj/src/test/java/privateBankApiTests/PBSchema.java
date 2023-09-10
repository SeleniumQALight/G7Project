package privateBankApiTests;

import io.restassured.http.ContentType;
import org.apache.log4j.Logger;
import org.junit.Test;
import privateBankApi.PrivateBankEndPoints;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;


public class PBSchema {

    Logger logger = Logger.getLogger(getClass());
    final String DATE = "22.03.2022";
    final String BASE_CURRENCY = "UAH";

    @Test
    public void getCurrencyExchangeRateTestBySchema() {
        given()
                .contentType(ContentType.JSON)
                .queryParam("date", DATE)
                .log().all()
                .when()
                .get(PrivateBankEndPoints.CURRENCY_EXCHANGE)
                .then()
                .statusCode(200)
                .log().all()
                .assertThat()
                .body(matchesJsonSchemaInClasspath("privateBankSchema.json"));
    }
}
