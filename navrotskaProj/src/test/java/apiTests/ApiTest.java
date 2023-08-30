package apiTests;

import io.restassured.http.ContentType;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class ApiTest {
    final String USER_NAME = "autoapi";
    @Test
    public void getPostsByUserTest() {
        given()
                .contentType(ContentType.JSON)
                .log().all()
                .when()
                .get(EndPoints.GET_POSTS_BY_USER, USER_NAME)
                .then()
                .statusCode(200)
                .log().all()
        ;
    }
}
