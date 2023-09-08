package apiTests;

import api.ApiHelper;
import api.EndPoints;
import api.dto.requestDto.CreatePostDto;
import api.dto.responsetDto.AuthorDto;
import api.dto.responsetDto.PostDto;
import data.TestData;
import io.restassured.http.ContentType;
import org.assertj.core.api.SoftAssertions;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class CreatePostByApiTest {
    ApiHelper apiHelper = new ApiHelper();

    @Before
    public void deleteAllPostsByUser(){
    apiHelper.deletePostsTillPresent();
    }

    @Test
    public void createPostByApi(){
        String token = apiHelper.getToken();

        CreatePostDto createPostBody =
                CreatePostDto.builder()
                        .title("post from api title")
                        .body("post from api body")
                        .select1("One Person")
                        .uniquePost("yes")
                        .token(token)
                        .build();

        String actualResponse =
                given()
                        .contentType(ContentType.JSON)
                        .log().all()
                        .body(createPostBody)
                        .when()
                        .post(EndPoints.CREATE_POST)
                        .then()
                        .statusCode(200)
                        .log().all()
                        .extract().response().getBody().asString();

        Assert.assertEquals("Message in actualResponse", "\"Congrats.\"", actualResponse);

        PostDto[] actualPostsByUser = apiHelper.getAllPostsByUser();
        Assert.assertEquals("Number of posts ", 1, actualPostsByUser.length);

        PostDto[] expectedPostsDto = {
                PostDto.builder()
                        .title(createPostBody.getTitle())
                        .body(createPostBody.getBody())
                        .select(createPostBody.getSelect1())
                        .uniquePost(createPostBody.getUniquePost())
                        .isVisitorOwner(false)
                        .author(AuthorDto.builder().username(TestData.LOGIN_API_DEFAULT).build())
                        .build()
        };

        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(actualPostsByUser)
                .usingRecursiveComparison()
                .ignoringFields("id", "createdDate", "author.avatar")
                .isEqualTo(expectedPostsDto);
        softAssertions.assertAll();
    }
}
