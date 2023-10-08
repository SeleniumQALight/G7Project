package api;

import api.dto.responsDto.PostDto;
import data.TestData;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class ApiHelper {
    Logger logger = Logger.getLogger(getClass());
    RequestSpecification requestSpecification = new RequestSpecBuilder()
            .setContentType(ContentType.JSON)
            .log(LogDetail.ALL)
            .build();

    /**
     * два метода, один без параметрів другий з параметрами(якщо хочемо змінити керди, або будуть дефолтні
     */

    public String getToken() {
        return getToken(TestData.LOGIN_API_DEFAULT, TestData.PASSWORD_API_DEFAULT);
    }

    public String getToken(String login, String password) {
        JSONObject requestBody = new JSONObject();
        requestBody.put("username", login);
        requestBody.put("password", password);
        ResponseBody responseBody =
                given()
// .contentType(ContentType.JSON)
// .log().all()
                        .spec(requestSpecification)
                        .body(requestBody.toMap())
                        .when()
                        .post(EndPoints.LOGIN)
                        .then()
                        .statusCode(200)
                        .log().all()//побачити все в консоль
                        .extract().response().getBody();
        return responseBody.asString().replace("\"", "");
    }

    public PostDto[] getAllPostByUser() {
        return getAllPostByUser(TestData.LOGIN_API_DEFAULT);
    }

    public PostDto[] getAllPostByUser(String userName) {
        return given()
                .spec(requestSpecification)
                .when()
                .get(EndPoints.POSTS_BY_USER, userName)
                .then()
                .statusCode(200)
                .log().all()
                .extract().response().getBody().as(PostDto[].class);
    }

    public void deletePostTillPresent() {
        deletePostTillPresent(TestData.LOGIN_API_DEFAULT, TestData.PASSWORD_API_DEFAULT);
    }

    public void deletePostTillPresent(String userName, String password) {
        PostDto[] listOfPosts = getAllPostByUser(userName);
        String token = getToken(userName, password);

        for (int i = 0; i < listOfPosts.length; i++) {
            deletePostById(token, listOfPosts[i].getId());
            logger.info(String.format("Post with id %s and title '%s' was deleted"
                    , listOfPosts[i].getId(), listOfPosts[i].getTitle()));
        }
        Assert.assertEquals("Number of post ", 0, getAllPostByUser(userName).length);//перевірити що немає постів у юзера }
    }

    private void deletePostById(String token, String id) {
        JSONObject bodyParams = new JSONObject();
        bodyParams.put("token", token);
        String actualMessage = given()
                .spec(requestSpecification)
                .body(bodyParams.toMap())// переганяє джейсон обжек в той що розуміє
                .when()
                .delete(EndPoints.DELETE_POST, id)
                .then()
                .statusCode(200)
                .log().all()
                .extract()
                .response()
                .getBody().asString();
        Assert.assertEquals("Message in response ", "\"Success\"", actualMessage);
    }

    public void createPosts(String userName, String password,
                            Map<String, String> mapForBody, int indexOfPost) {
        String token = getToken(userName, password);

        HashMap<String, String> requestBody = new HashMap<>();
        requestBody.put("title", mapForBody.get("title") + indexOfPost);
        requestBody.put("body", mapForBody.get("body"));
        requestBody.put("select1", mapForBody.get("select"));
        requestBody.put("uniquePost", "no");
        requestBody.put("token", token);

        given()
                .spec(requestSpecification)
                .body(requestBody)
                .when()
                .post(EndPoints.CREATE_POST)
                .then()
                .statusCode(200);

    }



}

