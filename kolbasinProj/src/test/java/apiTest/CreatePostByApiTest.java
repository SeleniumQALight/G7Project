package apiTest;

import api.ApiHelper;
import api.Endpoints;
import api.dto.requestDto.CreatePostDto;
import api.dto.responseDto.AuthorDto;
import api.dto.responseDto.PostDto;
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
    public void deleteAllPostByUser(){
        apiHelper.deletePostTellPresent();
    }

    @Test
    public void createPostByApi(){
        String token = apiHelper.getToken();

        CreatePostDto createPostBody =
                CreatePostDto.builder()
                        .title("Post from API")
                        .body("Post test body")
                        .select1("One Person")
                        .uniquePost("yes")
                        .token(token)
                        .build();

        String response =
                given()
                        .contentType(ContentType.JSON)
                        .log().all()
                        .body(createPostBody)
                        .when()
                        .post(Endpoints.CREATE_POST)
                        .then()
                        .statusCode(200)
                        .log().all()
                        .extract().response().getBody().asString();

        Assert.assertEquals("Message in response", "\"Congrats.\"", response);

        PostDto [] actualPostByUser = apiHelper.getAllPostByUser();

        Assert.assertEquals("Number of posts", 1, actualPostByUser.length);

        PostDto[] expectedPostDto = {
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
        softAssertions.assertThat(actualPostByUser)
                        .usingRecursiveComparison()
                                .ignoringFields("id", "createdDate", "author.avatar")
                                        .isEqualTo(expectedPostDto);

        softAssertions.assertAll();

    }
}
