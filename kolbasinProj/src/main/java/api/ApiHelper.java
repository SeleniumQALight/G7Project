package api;

import api.dto.responseDto.PostDto;
import data.TestData;
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

    Logger logger =Logger.getLogger(getClass());

    RequestSpecification requestSpecification = new RequestSpecBuilder()
            .setContentType(ContentType.JSON)
            .log(LogDetail.ALL)
            .build();

    /**
     * Token for LOGIN_API_DEFAULT
     * @return
     */

    public String getToken(){
        return getToken(TestData.LOGIN_API_DEFAULT, TestData.PASSWORD_API_DEFAULT);
    }

    public String getToken (String login, String password){
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
                        .post(Endpoints.LOGIN)
                        .then()
                        .statusCode(200)
                        .log().all()
                        .extract().response().getBody();

        return responseBody.asString().replace("\"", "");
    }

    public PostDto[] getAllPostByUser() {
        return getAllPostByUser(TestData.LOGIN_API_DEFAULT);
    }

    public PostDto[] getAllPostByUser(String userName){
        return given()
                .spec(requestSpecification)
                .when()
                .get(Endpoints.POSTS_BY_USER, userName)
                .then()
                .statusCode(200)
                .log().all()
                .extract().response().getBody().as(PostDto[].class);
    }

    public void deletePostTellPresent() {
        deletePostTellPresent(TestData.LOGIN_API_DEFAULT, TestData.PASSWORD_API_DEFAULT);
    }
    
    public void deletePostTellPresent(String userName, String password){
        PostDto[] listOfPost = getAllPostByUser(userName);
        String token = getToken(userName, password);

        for (int i = 0; i < listOfPost.length; i++) {
            deletePostById(token, listOfPost[i].getId());
            logger.info(String.format("Post with id %s and title '%s' was deleted", listOfPost[i].getId(), listOfPost[i].getTitle()));
        }
        Assert.assertEquals("Number of post ", 0, getAllPostByUser(userName).length);
    }

    private void deletePostById(String token, String id) {
        JSONObject bodyParams = new JSONObject();
        bodyParams.put("token", token);

        String actualMessage = given()
                .spec(requestSpecification)
                .body(bodyParams.toMap())
                .when()
                .delete(Endpoints.DELETE_POST, id)
                .then()
                .statusCode(200)
                .log().all()
                .extract().response().body().asString();

        Assert.assertEquals("Message in response ", "\"Success\"", actualMessage);
    }
}
