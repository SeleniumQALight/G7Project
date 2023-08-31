package apiTests;

import api.Endpoints;
import io.restassured.http.ContentType;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class ApiTest {
    final String USER_NAME = "autoapi";

    @Test
    public void getPostByUser() {
        given()

                .contentType(ContentType.JSON)
                .when()
                .get(Endpoints.POSTS_BY_USER, USER_NAME) //URL
                .then()
                .statusCode(200)
                .log().all()
        ;
    }
}
