package api.dto.responseDto.HW2;

import api.EndpointHw2;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UserLoginActions {
    private String token;
    private String userId;

    public UserLoginActions(String userName, String password) {
        login(userName, password);
    }

    private void login(String userName, String password) {
        LoginRequestDto loginRequest = new LoginRequestDto(userName, password);

        Response loginResponse = given()
                .contentType(ContentType.JSON)
                .body(loginRequest)
                .when()
                .post(EndpointHw2.LOGIN);

        token = loginResponse.jsonPath().getString("token");
        userId = loginResponse.jsonPath().getString("userId");
    }

    public String getToken() {
        return token;
    }

    public String getUserId() {
        return userId;
    }
}

