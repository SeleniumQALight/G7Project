package api;

import api.dto.responseDto.PostDto;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.junit.Assert;

import static data.TestData.LOGIN_API_DEFAULT;
import static data.TestData.PASSWORD_API_DEFAULT;
import static io.restassured.RestAssured.given;
import org.apache.log4j.Logger;

public class ApiHelper {

    Logger logger = Logger.getLogger(getClass());

    RequestSpecification requestSpecification = new RequestSpecBuilder()
            .setContentType(ContentType.JSON)
            .log(LogDetail.ALL)
            .build();


    /**
     * Token for LOGIN_API_DEFAULT
     *
     * @return
     */

    public String getToken() {
        return getToken(LOGIN_API_DEFAULT, PASSWORD_API_DEFAULT);
    }

    public String getToken(String login, String password) {
        JSONObject requestBody = new JSONObject();
        requestBody.put("username", login);
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
                        .extract().response().getBody();
        return responseBody.asString().replaceAll("\"", "");


    }

    /**
     * Get all posts for by LOGIN_API_DEFAULT user
     *
     * @return
     */

    public PostDto[] getAllPostsByUser() {
        return getAllPostsByUser(LOGIN_API_DEFAULT);

    }

    public PostDto[] getAllPostsByUser(String userName) {
        return given()
//                .contentType(ContentType.JSON)
//                .log().all()
                .spec(requestSpecification)
                .when()
                .get(EndPoints.GET_POSTS_BY_USER, userName)
                .then()
                .statusCode(200)
                .log().all()
                .extract().response().as(PostDto[].class);

    }

    public void deletePostTillPresent() {
        deletePostTillPresent(LOGIN_API_DEFAULT, PASSWORD_API_DEFAULT);
    }

    public void deletePostTillPresent(String userName, String password) {
        PostDto[] listPosts = getAllPostsByUser(userName);
        String token = getToken(userName, password);
        for (int i = 0; i < listPosts.length; i++) {
            deletePostById(listPosts[i].getId(), token);
            logger.info(String.format("Post with id %s and title '%s' was deleted"
                    , listPosts[i].getId()
                    , listPosts[i].getTitle()));
        }
        Assert.assertEquals("Number of posts ", 0, getAllPostsByUser(userName).length);
    }

    private void deletePostById(String id, String token) {
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
