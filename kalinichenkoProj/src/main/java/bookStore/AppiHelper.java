package bookStore;

import bookStore.respossDto.ApiLoginResponseDto;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.assertj.core.api.SoftAssertions;
import org.json.JSONObject;

import static io.restassured.RestAssured.given;
import static test_data.TestData.*;

public class AppiHelper {
    RequestSpecification requestSpecification = new RequestSpecBuilder()
            .setContentType(ContentType.JSON)
            .log(LogDetail.ALL)
            .build();

    public ApiLoginResponseDto getUser() {
        return getUser(LOGIN_API_BOOK, PASSWORD_API_BOOK);
    }

    public ApiLoginResponseDto getUser(String username, String password) {
        SoftAssertions softAssertions = new SoftAssertions();
        JSONObject requestBody = new JSONObject();
        requestBody.put("userName", username);
        requestBody.put("password", password);
        ApiLoginResponseDto responseBody =
                given()
                        .spec(requestSpecification)
                        .body(requestBody.toMap())
                        .log().all()
                        .when()
                        .post(EndPoints.LOGIN)
                        .then()
                        .statusCode(200)
                        .log().all()
                        .extract().response()
                        .getBody().as(ApiLoginResponseDto.class);
        softAssertions.assertThat(responseBody.getToken()).as("Token is Null").isNotEmpty();
        softAssertions.assertThat(responseBody.getUserId()).as("UserId is Null").isNotEmpty();
        softAssertions.assertAll();
        return responseBody;
    }

    public void deleteAllBooks(String token, String userId) {
        given()
                .spec(requestSpecification)
                .header("Authorization", "Bearer " + token)
                .queryParam("UserId", userId)
                .log().all()
                .when()
                .delete(EndPoints.BOOKS)
                .then()
                .log().all()
                .statusCode(204);

    }
}
