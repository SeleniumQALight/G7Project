package apiTest;

import api.EndPoints;
import api.dto.responseDto.AuthorDto;
import api.dto.responseDto.PostDto;
import io.qameta.allure.restassured.AllureRestAssured;
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

public class ApiTest {
    final String USER_NAME = "autoapi";
    Logger logger = Logger.getLogger(getClass());
    @Test
    public void getPostsByUserTest() {
        PostDto[] responseAsDto = given()
                .filter(new AllureRestAssured())
                .contentType(ContentType.JSON)
                .log().all()
                .when()
                .get(EndPoints.POSTS_BY_USER, USER_NAME)
                .then()
                .statusCode(200)
                .log().all()
                .assertThat()
                .body("[0].title", equalTo("test2"))
                .body("autor.username", everyItem(equalTo(USER_NAME)))
                .extract().body().as(PostDto[].class);
        logger.info(responseAsDto[0].toString());//cycle needed
        logger.info(responseAsDto.length);
        logger.info(responseAsDto[0].getTitle());
        logger.info(responseAsDto[0].getAuthor().getUsername());

        for (int i = 0; i < responseAsDto.length; i++) {
            Assert.assertEquals("User name is not matched in post" + i
                    , USER_NAME
                    , responseAsDto[i].getAuthor().getUsername());

        }

        PostDto[] expectedPostDto = {
//                new PostDto("test2", "test body2", "All Users", "no", new AuthorDto(USER_NAME), false),
//                new PostDto("test", "test body", "All Users", "no", new AuthorDto(USER_NAME), false)
                PostDto.builder().title("test2").body("test body2").select("All Users").uniquePost("no")
                        .isVisitorOwner(false).author(AuthorDto.builder().username(USER_NAME).build()).build(),
                PostDto.builder().title("test").body("test body").select("All Users").uniquePost("no")
                        .isVisitorOwner(false).author(AuthorDto.builder().username(USER_NAME).build()).build()

        };
Assert.assertEquals("Number of posts", expectedPostDto.length, responseAsDto.length);
        SoftAssertions softAssertions = new SoftAssertions();
//        for (int i = 0; i < expectedPostDto.length; i++) {
//            softAssertions.assertThat(responseAsDto[i])
//                    .isEqualToIgnoringGivenFields(expectedPostDto[i]
//                            , "id"
//                            , "createdDate"
//                            , "author"
//                            );
//            softAssertions.assertThat(responseAsDto[i].getAuthor())
//                    .isEqualToIgnoringGivenFields(expectedPostDto[i].getAuthor()
//                            , "avatar");

            softAssertions.assertThat(responseAsDto)
                    .usingRecursiveComparison()
                    .ignoringFields("id", "createdDate", "author.avatar")
                    .isEqualTo(expectedPostDto);

       // }

        softAssertions.assertAll();
    }



    @Test
    public void getAllPostsByUserNegative(){
        String actualResponse = given()
                .filter(new AllureRestAssured())
                .contentType(ContentType.JSON)
                .log().all()
                .when()
                .get(EndPoints.POSTS_BY_USER, "NotValidUser")
                .then()
                .statusCode(200)
                .log().all()
                .extract().response().body().asString();
        Assert.assertEquals("Message in response", "\"Sorry, invalid user requested.undefined\"", actualResponse);
        Assert.assertEquals("Message in response", "Sorry, invalid user requested.undefined", actualResponse.replace("\"", ""));
    }

    @Test
    public void getAllPostsByUserPath(){//in case we dont have dto and just want to check one field
        Response response = given()
                .filter(new AllureRestAssured())
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
            softAssertions.assertThat(actualTitlesList.get(i))
                    .as("TItem number" + i)
                    .contains("test");
        }

        List<Map> actualAutorList = response.jsonPath().getList("author", Map.class);

        for (int i = 0; i < actualAutorList.size(); i++) {
            softAssertions.assertThat(actualAutorList.get(i).get("username"))
                    .as("Item number" + i)
                    .isEqualTo(USER_NAME);
        }

        softAssertions.assertAll();

    }

    @Test
    public void getAllPostsByUserSchema(){given()
            .filter(new AllureRestAssured())
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
