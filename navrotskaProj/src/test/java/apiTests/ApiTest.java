package apiTests;


import io.restassured.http.ContentType;
import api.EndPoints;
import api.dto.responseDto.AuthorDto;
import api.dto.responseDto.PostDto;
import org.apache.log4j.Logger;
import org.assertj.core.api.SoftAssertions;
import org.junit.Assert;
import org.junit.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.everyItem;

public class ApiTest {
    final String USER_NAME = "autoapi";
    Logger logger= Logger.getLogger(getClass());
    @Test
    public void getPostsByUserTest(){
        PostDto[] responseAsDto = given()
                .contentType(ContentType.JSON)//додали хедер аплікейшина
                .log().all()//виводимо в колсоль весь запит
                .when()// дія
                .get(EndPoints.GET_POSTS_BY_USER,USER_NAME )
                .then()
                .statusCode(200)
                .log().all()
                .assertThat()
                .body("[0].title", equalTo("test2"))
                .body("author.username", everyItem(equalTo(USER_NAME)))
                .extract().body().as(PostDto[].class) ;
        logger.info(responseAsDto.toString());
        logger.info(responseAsDto.length);
        logger.info(responseAsDto[0].getTitle());
        logger.info(responseAsDto[0].getAuthor().getUsername());

        for (int i = 0; i <responseAsDto.length ; i++) {
            Assert.assertEquals("UserName is not matched in post" +i,USER_NAME,responseAsDto[i].getAuthor().getUsername());

        }
        PostDto[] expectedPostDto = {
    //                new PostDto("test2", "test body2", "All Users", "no", new AuthorDto(USER_NAME),false),
    //                new PostDto("test", "test body", "All Users", "no", new AuthorDto(USER_NAME),false)
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
        Assert.assertEquals("Number of posts",expectedPostDto.length,responseAsDto.length);
        SoftAssertions softAssertions = new SoftAssertions();



 //       for (int i = 0; i < expectedPostDto.length; i++) {
//            softAssertions.assertThat(responseAsDto[i])
//                    .isEqualToIgnoringGivenFields(expectedPostDto[i], "id", "createdDate","author");
//            softAssertions.assertThat(responseAsDto[i].getAuthor())
//                    .isEqualToIgnoringGivenFields(expectedPostDto[i].getAuthor(), "avatar");
            softAssertions.assertThat(responseAsDto)
                    .usingRecursiveComparison()
                    .ignoringFields("id", "createdDate", "author.avatar")
                    .isEqualTo(expectedPostDto);
       // }

        softAssertions.assertAll();

    }
}