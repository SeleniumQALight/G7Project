package bookStore;

import bookStore.respossDto.TokenResponseDto;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static test_data.TestData.*;

public class AppiHelper {
    RequestSpecification requestSpecification = new RequestSpecBuilder()
            .setContentType(ContentType.JSON)
            .log(LogDetail.ALL)
            .build();

    public String getToken() {
       return   getToken(LOGIN_API_BOOK, PASSWORD_API_BOOK);
    }

    public String getToken(String username, String password) {
        JSONObject requestBody = new JSONObject();
        requestBody.put("userName", username);
        requestBody.put("password", password);
        TokenResponseDto responseBody =
                given()
                        .spec(requestSpecification)
                        .body(requestBody.toMap())
                        .log().all()
                        .when()
                        .post(EndPoints.LOGIN)
                        .then()
                        .statusCode(200)
                        .log().all()
                        .extract().response().body().as(TokenResponseDto.class);
        return responseBody.getToken();
    }
}
