package api;


import api.dto.responseDto.PostDto;
import data.TestData;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.junit.Assert;

import static io.restassured.RestAssured.given;

public class ApiHelper {
    Logger logger = Logger.getLogger(getClass());

    RequestSpecification requestSpecification =  new RequestSpecBuilder()
            .setContentType(ContentType.JSON)
            .log(LogDetail.ALL)
            .build();

    //token for LOGIN_API_DEFAULT
    public String getToken(){
         return getToken(TestData.LOGIN_API_DEFAULT, TestData.PASSWORD_API_DEFAULT);

    }

    public String getToken(String login, String password) {
        JSONObject requestBody = new JSONObject();
        requestBody.put("username", login);
        requestBody.put("password", password);

        ResponseBody responseBody =given()
//                .contentType(ContentType.JSON)
//                .log().all()
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

    public PostDto[] getPostsByUser() {
        return getPostsByUser(TestData.LOGIN_API_DEFAULT);
    }

    /**
     *
     *Get posts for LOGIN_API_DEFAULT
     * @return
     */
    public PostDto[] getPostsByUser(String username) {
        return given().spec(requestSpecification)
                .when()
                .get(EndPoints.POST_BY_USER, username)
                .then()
                .statusCode(200)
                .log().all()
                .extract().response().getBody().as(PostDto[].class);
    }

    public void deletePostsTillPresent() {
        deletePostsTillPresent(TestData.LOGIN_API_DEFAULT, TestData.PASSWORD_API_DEFAULT);

    }
    public void deletePostsTillPresent(String username, String password) {
        PostDto[] listOfPosts = getPostsByUser(username);
        String token = getToken(username, password);

        for (int i = 0; i < listOfPosts.length; i++) {
            deletePostById(token, listOfPosts[i].getId());
            logger.info(String.format("Post with id %s and title '%s' was deleted" ,
                    listOfPosts[i].getId(), listOfPosts[i].getTitle()));
        }

        Assert.assertEquals("Number of posts", 0, getPostsByUser(username).length);

        }

    private void deletePostById(String token,String id ) {

     JSONObject  bodyParams = new JSONObject();
     bodyParams.put("token", token);

                 String actualMessage =  given()
                    .spec(requestSpecification)
                    .body(bodyParams.toMap())
                    .when()
                    .delete(EndPoints.DELETE_POST, id)
                    .then()
                    .statusCode(200)
                    .log().all().
                   extract().response().getBody().asString();
        Assert.assertEquals("Message in response", "\"Success\"", actualMessage);


    }
}

