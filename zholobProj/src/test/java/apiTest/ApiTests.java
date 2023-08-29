package apiTest;

import api.EndPoints;
import io.restassured.http.ContentType;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class ApiTests {
    final String USER_NAME = "autoapi";

    @Test
    public void getPostsByUserTest() {
        given()
                .contentType(ContentType.JSON)
                .log().all()
                .when()
                .get(EndPoints.PPOSTS_BY_USER, USER_NAME) //  URL
                .then()
                .statusCode(200)
                .log().all();
    }
}
