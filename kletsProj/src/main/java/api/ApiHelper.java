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

    Logger logger = Logger.getLogger(getClass());

    RequestSpecification requestSpecification = new RequestSpecBuilder()
            .setContentType(ContentType.JSON)
            .log(LogDetail.ALL)
            .build();

    /**
     * Method to get token
     * Token for LOGIN_API_DEFAULT and PASSWORD_API_DEFAULT
     *
     * @return token
     */

    public String getToken() {
        return getToken(TestData.LOGIN_API_DEFAULT, TestData.PASSWORD_API_DEFAULT);
    }

    /**
     * Method to get token
     *
     * @param login    user name
     * @param password user password
     * @return token
     */

    public String getToken(String login, String password) {
        JSONObject requestBody = new JSONObject(); // create object JSON
        requestBody.put("username", login);
        requestBody.put("password", password);

        ResponseBody responseBody =
                given()
//                        .contentType(ContentType.JSON) // set type of content
//                        .log().all()
                        .spec(requestSpecification) // set specification
                        .body(requestBody.toMap()) // set body of request
                        .when()
                        .post(EndPoints.LOGIN) // send request
                        .then()
                        .statusCode(200) // check status code
                        .log().all()
                        .extract()
                        .response()
                        .getBody();

        return responseBody.asString().replace("\"", "");
    }

    /**
     * Method to get all posts by user
     *
     * @return array of posts
     */

    public PostDto[] getAllPostsByUser() { // get all posts by user
        return getAllPostsByUser(TestData.LOGIN_API_DEFAULT);
    }

    public PostDto[] getAllPostsByUser(String userName) { // get all posts by user
        return given()
                .spec(requestSpecification)
                .when()
                .get(EndPoints.POSTS_BY_USER, userName)
                .then()
                .statusCode(200)
                .log().all()
                .extract()
                .response()
                .getBody()
                .as(PostDto[].class);
    }

    public void deletePostsTillPresent() { // delete all posts by user
        deletePostsTillPresent(TestData.LOGIN_API_DEFAULT, TestData.PASSWORD_API_DEFAULT);
    }

    public void deletePostsTillPresent(String userName, String password) { // delete all posts by user
        PostDto[] listOfPosts = getAllPostsByUser(userName); // get all posts by user
        String token = getToken(userName, password); // get token

        for (int i = 0; i < listOfPosts.length; i++) { // cycle for delete all posts by user
            deletePostById(token, listOfPosts[i].getId()); // delete post by id
            logger.info(String.format("Post with id %s and title '%s' was deleted",
                    listOfPosts[i].getId(),
                    listOfPosts[i].getTitle()));
        }

        Assert.assertEquals("Number of posts by user ", 0, getAllPostsByUser(userName).length); // check number of posts by user
    }

    private void deletePostById(String token, String id) { // delete post by id
        JSONObject bodyParams = new JSONObject(); // create object JSON
        bodyParams.put("token", token);

        String actualMessage = given()
                .spec(requestSpecification)
                .body(bodyParams.toMap()) // set body of request
                .when()
                .delete(EndPoints.DELETE_POST, id)
                .then()
                .statusCode(200)
                .log().all()
                .extract()
                .response().getBody().asString();

        Assert.assertEquals("Message in response", "\"Success\"", actualMessage);
    }
}


