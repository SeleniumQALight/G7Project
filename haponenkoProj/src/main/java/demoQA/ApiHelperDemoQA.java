package demoQA;

import io.restassured.http.ContentType;
import io.restassured.response.ResponseBody;
import org.apache.log4j.Logger;
import org.json.JSONObject;

import static io.restassured.RestAssured.given;

public class ApiHelperDemoQA {
    Logger logger = Logger.getLogger(getClass());

    public static UserInfoDTO getUserInfo() {
        return getUserInfo(TestDataDemoQA.LOGIN_DEFAULT, TestDataDemoQA.PASSWORD_DEFAULT);
    }

    public static UserInfoDTO getUserInfo(String login, String password) {
        JSONObject requestParams = new JSONObject();
        requestParams.put("userName", login);
        requestParams.put("password", password);

        ApiResponseDTO apiResponseDTO =
                given()
                        .contentType(ContentType.JSON)
                        .log().all()
                        .body(requestParams.toMap())
                        .when()
                        .post(EndPointsDemoQA.LOGIN)
                        .then()
                        .statusCode(200)
                        .log().all()
                        .extract().response().getBody().as(ApiResponseDTO.class);

        UserInfoDTO userInfo = new UserInfoDTO();
        userInfo.setToken(apiResponseDTO.getToken());
        userInfo.setUserId(apiResponseDTO.getUserId());

        return userInfo;
    }

//    public void deleteAllBooksByUser(userInfo) {
//given()
//                .contentType(ContentType.JSON)
//        .header("Authorization", "Bearer " + UserInfoDTO.token)
//                .log().all()
//                .when()
//                .delete(EndPointsDemoQA.DELETE_ALL_BOOKS, userId)
//                .then()
//                .statusCode(204)
//                .log().all();
//    }

}
