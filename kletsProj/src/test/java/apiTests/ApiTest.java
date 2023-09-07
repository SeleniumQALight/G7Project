package apiTests;

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
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.everyItem;
import static org.junit.Assert.assertThat;

public class ApiTest {
    final String USER_NAME = "autoapi";
    Logger logger = Logger.getLogger(getClass());

    @Test
    public void getPostsByUserTest() { //BDD - given, when, then
        PostDto[] responseAsDto = given()
                .contentType(ContentType.JSON)
                .log().all()
                .when()
                .get(EndPoints.POSTS_BY_USER, USER_NAME)
                .then()
                .statusCode(200)
                .log().all()
                .assertThat()
                .body("[0].title", equalTo("test2")) // [0] - first element in array
                .body("author.username", everyItem(equalTo(USER_NAME)))
                .extract().body().as(PostDto[].class); // extract response as array of PostDto objects and save it to responseAsDto variable of type PostDto[]
        logger.info(responseAsDto[0].toString());
        logger.info(responseAsDto.length);
        logger.info("Title: " + responseAsDto[0].getTitle());
        logger.info("Username: " + responseAsDto[0].getAuthor().getUsername());

        for (int i = 0; i < responseAsDto.length; i++) { // loop through array of posts
            Assert.assertEquals("Username is not matched in the post ", USER_NAME, responseAsDto[i].getAuthor()
                    .getUsername());
        }

        PostDto[] expectedPostDto = { // create array of expected posts
//                new PostDto("test2", "test body2", "All Users", "no", new AuthorDto(USER_NAME), false ),
//                new PostDto("test", "test body", "All Users", "no", new AuthorDto(USER_NAME), false )
                PostDto.builder().title("test2").body("test body2").select("All Users").uniquePost("no")
                        .author(AuthorDto.builder().username(USER_NAME).build()).isVisitorOwner(false)
                        .build(),
                PostDto.builder().title("test").body("test body").select("All Users").uniquePost("no")
                        .author(AuthorDto.builder().username(USER_NAME).build()).isVisitorOwner(false)
                        .build()

        };

        Assert.assertEquals("Number of posts ", expectedPostDto.length, responseAsDto.length); // compare number of posts

        SoftAssertions softAssertions = new SoftAssertions(); // soft assertion

        // for (int i = 0; i< expectedPostDto.length; i++) { // loop through array of expected posts
//            softAssertions.assertThat(responseAsDto[i])
//                    .isEqualToIgnoringGivenFields(expectedPostDto[i], "id", "createdDate", "author"); // compare posts by fields
//            softAssertions.assertThat(responseAsDto[i]
//                    .getAuthor()).isEqualToIgnoringGivenFields(expectedPostDto[i].getAuthor(), "avatar"); // compare authors by fields
        //  }

        softAssertions.assertThat(responseAsDto)
                .usingRecursiveComparison()
                .ignoringFields("id", "createdDate", "author.avatar")
                .isEqualTo(expectedPostDto);

        softAssertions.assertAll(); // soft assertion

    }

    @Test
    public void getAllPostByUserNegative() {
        String actualResponse =
                given()
                        .contentType(ContentType.JSON)
                        .log().all()
                        .when()
                        .get(EndPoints.POSTS_BY_USER, "NotValidUser")
                        .then()
                        .statusCode(200)
                        .log().all()
                        .extract().response().body().asString();

        Assert.assertEquals("Message in response is not matched ", "\"Sorry, invalid user requested.undefined\""
                , actualResponse);
        Assert.assertEquals("Message in response is not matched ", "Sorry, invalid user requested.undefined"
                , actualResponse.replace("\"", ""));
    }

    @Test
    public void getAllPostsByUserPath() {
        Response response = given()
                .contentType(ContentType.JSON)
                .log().all()
                .when()
                .get(EndPoints.POSTS_BY_USER, USER_NAME)
                .then()
                .statusCode(200)
                .log().all()
                .extract().response();

        List<String> actualTitlesList = response.jsonPath().getList("title", String.class);
        SoftAssertions softAssertions = new SoftAssertions();
        for (int i = 0; i < actualTitlesList.size(); i++) {
            softAssertions.assertThat(actualTitlesList.get(i)).as("Item number " + i)
                    .contains("test");
        }

        List<Map> actualAutorList = response.jsonPath().getList("author", Map.class);

        for (int i = 0; i < actualAutorList.size(); i++) {
            softAssertions.assertThat(actualAutorList.get(i).get("username")).as("Item number " + i)
                    .isEqualTo(USER_NAME);
        }

        softAssertions.assertAll();
    }

    @Test
    public void getAllPostsByUserSchema() {
        given()
                .contentType(ContentType.JSON)
                .log().all()
                .when()
                .get(EndPoints.POSTS_BY_USER, USER_NAME)
                .then()
                .statusCode(200)
                .log().all()
                .assertThat().body(matchesJsonSchemaInClasspath("response.json"));
    }

}

