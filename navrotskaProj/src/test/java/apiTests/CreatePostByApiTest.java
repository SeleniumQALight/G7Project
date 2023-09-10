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
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class CreatePostByApiTest {
    ApiHelper apiHelper = new ApiHelper();

    @Test
    public void createPostByApi() {
        String token = apiHelper.getToken();

        CreatePostDTO createPostBody =
                CreatePostDTO.builder()
                        .title("title olesya")
                        .body("body navrotska")
                        .select1("One Person")
                        .uniquePost("yes")
                        .token(token)
                        .build();
        String actualResponse = given()
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

        PostDto[] actualPostByUser = apiHelper.getAllPostsByUser();

        Assert.assertEquals("Number of posts is incorrect", 1, actualPostByUser.length);


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
        softAssertions.assertThat(actualPostByUser)
                .usingRecursiveComparison()
                .ignoringFields("id", "createdDate", "author.avatar")
                .isEqualTo(expectedPostsDTO);

        softAssertions.assertAll();
    }

}
