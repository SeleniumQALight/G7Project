package api;

import api.dto.responseDto.PostDto;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.apache.log4j.Logger;
import org.json.JSONObject;
import io.restassured.response.ResponseBody;
import org.junit.Assert;
import testData.TestData;

import static io.restassured.RestAssured.given;
/**
 * Token for LOGIN_API_DEFAULT
 * @return
 */
public class ApiHelper {
Logger logger = Logger.getLogger(getClass());

    RequestSpecification requestSpecification = new RequestSpecBuilder()
            .setContentType(ContentType.JSON)
            .log(LogDetail.ALL)
            .build();

    public String getToken(){
        return getToken(TestData.LOGIN_API_DEFAULT, TestData.PASSWORD_API_DEFAULT);
    }

    public String getToken (String login, String password) {
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

        return responseBody.asString().replace("\"","");
    }

    public PostDto[] getAllPostsByUser() {
        return getAllPostsByUser(TestData.LOGIN_API_DEFAULT);
    }

    public PostDto[] getAllPostsByUser(String userName) {
       return given()
               .spec(requestSpecification)
                .when()
                .get(EndPoints.POSTS_BY_USER, userName)
               .then()
                .statusCode(200)
                .log().all()
               .extract().response().getBody().as(PostDto[].class);


    }

    public void deleteAllPostsTillPresent() {
        deleteAllPostsTillPresent(TestData.LOGIN_API_DEFAULT, TestData.PASSWORD_API_DEFAULT);
    }

    public void deleteAllPostsTillPresent(String userName, String password) {
        PostDto[] listOfPosts = getAllPostsByUser(userName);
        String token = getToken(userName, password);

        for (int i = 0; i < listOfPosts.length; i++) {
            deletePostById(listOfPosts[i].getId(), token);
            logger.info(String.format("Post with id %s and '%s' titile was deleted"
                    , listOfPosts[i].getId()
                    , listOfPosts[i].getTitle()));

        }
        Assert.assertEquals("Number of posts", 0, getAllPostsByUser(userName).length);

    }

    private void deletePostById(String id, String token) {
        JSONObject bodyParams = new JSONObject();
        bodyParams.put("token", token);

        String actualMessage = given()
                .spec(requestSpecification)
                .body(bodyParams.toMap())
                .when()
                .delete(EndPoints.DELETE_POST,  id)
                .then()
                .statusCode(200)
                .log().all()
                .extract().response().getBody().asString();
        Assert.assertEquals("Message in response ", "\"Success\"", actualMessage);
    }

}
