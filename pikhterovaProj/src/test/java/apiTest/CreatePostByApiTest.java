package apiTest;

import api.ApiHelper;
import api.EndPoints;
import api.dto.requestDto.CreatePostDTO;
import api.dto.responseDto.AuthorDto;
import api.dto.responseDto.PostDto;
import io.restassured.http.ContentType;
import org.assertj.core.api.SoftAssertions;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import testData.TestData;

import static io.restassured.RestAssured.given;

public class CreatePostByApiTest {
    ApiHelper apiHelper = new ApiHelper();
@Before
public void deleteAllPostsByUser() {
        apiHelper.deleteAllPostsTillPresent();
        }

    @Test
    public void createPostByApi() {
String token = apiHelper.getToken();

        CreatePostDTO createPostBody = CreatePostDTO.builder()
                .title("Post from API")
                .body("Interesting content")
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

        Assert.assertEquals("Message in response", "\"Congrats.\"", actualResponse);

        PostDto[] actualPostsByUser = apiHelper.getAllPostsByUser();
        Assert.assertEquals("Number of posts", 1, actualPostsByUser.length);

        PostDto[] expectedPostsDTO = {
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
                                .isEqualTo(expectedPostsDTO);

        softAssertions.assertAll();
    }
}
