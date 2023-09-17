package privatBankApiTests;

import io.restassured.http.ContentType;
import org.apache.log4j.Logger;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class PrivatBankSchema {
    Logger logger = Logger.getLogger(getClass());
    final String DATE = "22.03.2022";
    final String BASE_CURRENCY = "UAH";

    @Test
    public void getCurrencyRateBySchema(){
        given()
                .contentType(ContentType.JSON)
                .queryParam("date", DATE)
                .log().all()
                .when()
                .get("https://api.privatbank.ua/p24api/exchange_rates")
                .then()
                .statusCode(200)
                .log().all()
                .assertThat().body(matchesJsonSchemaInClasspath("privatBankSchema.json"));

    }
}
