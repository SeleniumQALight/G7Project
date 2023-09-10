package api;

import api.dto.responseDto.PostDto;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.junit.Assert;

import static io.restassured.RestAssured.given;
import static test_data.TestData.*;

public class ApiHelper {

    Logger logger = Logger.getLogger(getClass());

    RequestSpecification requestSpecification = new RequestSpecBuilder()
            .setContentType(ContentType.JSON)
            .log(LogDetail.ALL)
            .build();

    /**
     * Get token for LOGIN_API_DEFAULT user
     *
     * @return
     */
    public String getToken() {
        return getToken(LOGIN_API_DEFAULT, PASSWORD_API_DEFAULT);
    }

    public String getToken(String username, String password) {
        JSONObject requestBody = new JSONObject();
        requestBody.put("username", username);
        requestBody.put("password", password);
        ResponseBody responseBody =
                given()
//                        .contentType(ContentType.JSON)
//                        .log().all()
                        .spec(requestSpecification)
                        .body(requestBody.toMap())
                        .when()
                        .post(EndPoints.LOGIN)
                        .then()
                        .statusCode(200)
                        .log().all()
                        .extract().response().body();
        return responseBody.asString().replaceAll("\"", "");
    }

    /**
     * Get all posts by LOGIN_API_DEFAULT user
     *
     * @return
     */
    public PostDto[] getAllPostsByUser() {
        return getAllPostsByUser(LOGIN_API_DEFAULT);
    }

    public PostDto[] getAllPostsByUser(String userName) {
        return given()
                .spec(requestSpecification)
                .when()
                .get(EndPoints.GET_POST_BY_USER, userName)
                .then()
                .statusCode(200)
                .log().all()
                .extract().body().as(PostDto[].class);
    }

    public void deletePostTillPresent() {
        deletePostTillPresent(LOGIN_API_DEFAULT, PASSWORD_API_DEFAULT);
    }

    public void deletePostTillPresent(String userName, String password) {
        PostDto[] listPosts = getAllPostsByUser(userName);
        String token = getToken(userName, password);
        for (int i = 0; i < listPosts.length; i++) {
            deletePosById(listPosts[i].getId(), token);
            logger.info(String.format("Post with id %s and title '%s' was deleted"
                    , listPosts[i].getId()
                    , listPosts[i].getTitle()));
        }
        Assert.assertEquals("Number of posts ", 0, getAllPostsByUser(userName).length);
    }

    private void deletePosById(String id, String token) {
        JSONObject requestBody = new JSONObject();
        requestBody.put("token", token);
      String actualMessage = given()
                .spec(requestSpecification)
                .body(requestBody.toMap())
                .when()
                .delete(EndPoints.DELETE_POST, id)
                .then()
                .statusCode(200)
                .log().all()
                .assertThat()
                .extract().response().body().asString();
      Assert.assertEquals("Wrong message", "\"Success\"", actualMessage);
    }
}
