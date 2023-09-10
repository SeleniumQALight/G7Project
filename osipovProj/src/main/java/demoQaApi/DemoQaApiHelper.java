package demoQaApi;

import data.TestData;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.apache.log4j.Logger;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class DemoQaApiHelper {
    Logger logger = Logger.getLogger(getClass());

    RequestSpecification requestSpecification = new RequestSpecBuilder()
            .setContentType(ContentType.JSON)
            .log(LogDetail.ALL)
            .build();

    public List<String> authorization(){
        return authorization(TestData.LOGIN_DEMOQA_API_DEFAULT, TestData.PASSWORD_DEMOQA_API_DEFAULT);
    }
    public List<String> authorization(String userName, String password){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("userName", userName);
        jsonObject.put("password", password);

        ResponseBody responseBody = given()
                .spec(requestSpecification)
                .body(jsonObject.toMap())
                .when()
                .post(DemoQaApiEndPoints.LOGIN_URL)
                .then()
                .statusCode(200)
                .log().all()
                .extract().response().getBody();

        List<String > userIdAndToken = new ArrayList<>();
        userIdAndToken.add(responseBody.jsonPath().get("userId"));
        userIdAndToken.add(responseBody.jsonPath().get("token"));
        return userIdAndToken;
    }

    public void deleteAllBooks(List userIdAndToken){
        given()
                .spec(requestSpecification)
                .header("Authorization", "Bearer " + userIdAndToken.get(1))
                .when()
                .delete(DemoQaApiEndPoints.DELETE_BOOKS_BY_USER, userIdAndToken.get(0))
                .then()
                .statusCode(204)
                .log().all();
    }
}
