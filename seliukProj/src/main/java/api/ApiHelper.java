package api;

import api.dto.responseDto.PostDto;
import data.TestData;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.config.RestAssuredConfig;
import io.restassured.filter.Filter;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.*;
import io.restassured.mapper.ObjectMapper;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.*;
import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.junit.Assert;

import java.io.File;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.security.KeyStore;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;


public class ApiHelper {
    Logger logger = Logger.getLogger(getClass());
    RequestSpecification requestSpecification = new RequestSpecBuilder()
            .setBaseUri(EndPoints.BASE_URL).setContentType(ContentType.JSON)
            .log(LogDetail.ALL)
            .build();


    /**
     * @return token for LOGIN_API_DEFAULT and PASSWORD_API_DEFAULT
     */
    public String getToken() {
        return getToken(TestData.LOGIN_API_DEFAULT, TestData.PASSWORD_API_DEFAULT);
    }

    //post request with body json
    public String getToken(String login, String password) {
        JSONObject requestBody = new JSONObject();
        requestBody.put("username", login);
        requestBody.put("password", password);

        ResponseBody responseBody =
                given()
                        //.contentType(ContentType.JSON)
                        //.log().all()
                        .spec(requestSpecification)
                        .body(requestBody.toMap())
                        .when()
                        .post(EndPoints.LOGIN)
                        .then()
                        .statusCode(200)
                        .log().all()
                        .extract().response().getBody();

        return responseBody.asString().replace("\"", "");

    }

    public PostDto[] getAllPostsByUser() {
        return getAllPostsByUser(TestData.LOGIN_API_DEFAULT);
    }

    public PostDto[] getAllPostsByUser(String username) {
        return given()
                //.contentType(ContentType.JSON)
                //.log().all()
                .spec(requestSpecification)
                .when()
                .get(EndPoints.POSTS_BY_USER, username)
                .then()
                .statusCode(200)
                .log().all()
                .extract().response().as(PostDto[].class);
    }


    public void deletePostsTillPresent(String userName, String password) {
        PostDto[] listOfPosts = getAllPostsByUser(userName);
        String token = getToken(userName, password);

        for (int i = 0; i < listOfPosts.length; i++) {
            deletePostById(token, listOfPosts[i].getId());
            logger.info(String.format("Post with id %s and title '%s' was deleted",
                    listOfPosts[i].getId(), listOfPosts[i].getTitle()));

        }
        Assert.assertEquals("Number of posts ", 0, getAllPostsByUser(userName).length);

    }

    private void deletePostById(String token, String id) {
        JSONObject bodyParams = new JSONObject();
        bodyParams.put("token", token);

        String actualMessage = given()
                .spec(requestSpecification)
                .body(bodyParams.toMap())
                .when()
                .delete(EndPoints.DELETE_POST, id)
                .then()
                .statusCode(200)
                .log().all()
                .extract().response().asString();

        Assert.assertEquals("Message in response ", "\"Success\"", actualMessage);
    }
}
