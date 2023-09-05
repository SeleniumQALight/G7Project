package apiTest;

import api.EndPoints;
import api.dto.responseDto.AuthorDto;
import api.dto.responseDto.PostDto;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.log4j.Logger;
import org.assertj.core.api.SoftAssertions;
import org.junit.Assert;
import org.junit.Test;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.everyItem;

public class ApiTest {
    final String USER_NAME = "autoapi";
    Logger logger = Logger.getLogger(getClass());

    @Test
    public void GetPostByUserTest() {
        PostDto[] responseAsDto = given()
                .contentType(ContentType.JSON)
                .log().all()
                .when()
                .get(EndPoints.GET_POST_BY_USER, USER_NAME)
                .then()
                .statusCode(200)
                .log().all()
                .assertThat()
                .body("[0].title", equalTo("test2"))
                .body("author.username", everyItem(equalTo(USER_NAME)))
                .extract().body().as(PostDto[].class);
        logger.info(responseAsDto[0].toString());
        logger.info(responseAsDto.length);
        logger.info(responseAsDto[0].getTitle());
        logger.info(responseAsDto[0].getAuthor().getUsername());

        for (int i = 0; i < responseAsDto.length; i++) {
            Assert.assertEquals("UserName is not expected in post " + i
                    , USER_NAME
                    , responseAsDto[i].getAuthor().getUsername());
        }

        PostDto[] expectedPostDto = {
//                new PostDto("test2", "test body2", "All Users", "no", new AuthorDto(USER_NAME),false), // 1st way without builder
//                new PostDto("test", "test body", "All Users", "no", new AuthorDto(USER_NAME),false) // 1st way without builder
                PostDto.builder()
                        .title("test2")
                        .body("test body2")
                        .select("All Users")
                        .uniquePost("no")
                        .author(AuthorDto.builder().username(USER_NAME).build())
                        .isVisitorOwner(false)
                        .build(),
                PostDto.builder()
                        .title("test")
                        .body("test body")
                        .select("All Users")
                        .uniquePost("no")
                        .author(AuthorDto.builder().username(USER_NAME).build())
                        .isVisitorOwner(false)
                        .build()
        };

        Assert.assertEquals("Number of posts ", expectedPostDto.length, responseAsDto.length);

        SoftAssertions softAssertions = new SoftAssertions();

//        for (int i = 0; i < responseAsDto.length; i++) {
//            softAssertions.assertThat(responseAsDto[i])
//                    .isEqualToIgnoringGivenFields(expectedPostDto[i], "id", "createdDate", "author");
//            softAssertions.assertThat(responseAsDto[i].getAuthor())
//                    .isEqualToIgnoringGivenFields(expectedPostDto[i].getAuthor(), "avatar");
//        } // 2nd way with loop

        softAssertions.assertThat(responseAsDto)
                .usingRecursiveComparison()
                .ignoringFields("id", "createdDate", "author.avatar")
                .isEqualTo(expectedPostDto);

        softAssertions.assertAll();

    }

    @Test
    public void getAllPostByUsernegative(){
        String actualResponse = given()
                .contentType(ContentType.JSON)
                .log().all()
                .when()
                .get(EndPoints.GET_POST_BY_USER, "wrongUserName")
                .then()
                .statusCode(200)
                .log().all()
                .extract().body().asString();

        Assert.assertEquals("Response is not expected", "\"Sorry, invalid user requested.undefined\"", actualResponse);
        Assert.assertEquals("Response is not expected", "Sorry, invalid user requested.undefined",
                actualResponse.replace("\"", ""));
    }

    @Test
    public void getAllPostByUserPath(){
       Response response =  given()
                .contentType(ContentType.JSON)
                .log().all()
                .when()
                .get(EndPoints.GET_POST_BY_USER, USER_NAME)
                .then()
                .statusCode(200)
                .log().all()
                .extract().response();

        List<String> actualTitleList = response.jsonPath().getList("title", String.class);
        SoftAssertions softAssertions = new SoftAssertions();
        for (int i = 0; i < actualTitleList.size(); i++) {
            softAssertions.assertThat(actualTitleList.get(i))
                    .as("Title is not expected in post " + i)
                    .contains("test");
        }

        List<Map> actualAutorList = response.jsonPath().getList("author", Map.class);

        for (int i = 0; i < actualAutorList.size(); i++) {
            softAssertions.assertThat(actualAutorList.get(i).get("username"))
                    .as("UserName is not expected in post " + i)
                    .isEqualTo(USER_NAME);
        }

        softAssertions.assertAll();
    }
}
