package apiTests;

import api.ApiHelper;
import api.EndPoints;
import api.dto.requestDto.CreatePostDTO;
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
    public void deleteAllPostsByUser() {
        apiHelper.deletePostsTillPresent();
    }

    @Test
    public void createPostByApiTest() {
        String token = apiHelper.getToken();

        CreatePostDTO createPostBody = CreatePostDTO.builder()
                .title("Post from Api Klets")
                .body("Body for post from Api Klets")
                .select1("All Users")
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
                        .extract()
                        .response()
                        .getBody()
                        .asString();


        Assert.assertEquals("Message in actualResponse", "\"Congrats.\"", actualResponse); // check message in response

        PostDto[] actualPostsByUser = apiHelper.getAllPostsByUser();// get all posts by user
        Assert.assertEquals("Number of posts by user ", 1, actualPostsByUser.length);// check number of posts by user

        PostDto[] expectedPostDto = { // create array of expected posts
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
        softAssertions.assertThat(actualPostsByUser) // check actual posts by user
                .usingRecursiveComparison()
                .ignoringFields("id", "createdDate", "author.avatar")
                .isEqualTo(expectedPostDto)
        ;

        softAssertions.assertAll();
    }
}
