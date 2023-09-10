package api;

import api.dto.requestDto.CreatePostDto;
import api.dto.responsDto.AuthorDto;
import api.dto.responsDto.PostDto;
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
        apiHelper.deletePostTillPresent();
    }

    @Test
    public void createPostByApi() {

        String token = apiHelper.getToken();
        System.out.println(token);

        CreatePostDto createPostBody =
                CreatePostDto.builder()
                .title("Post from API inna")
                .body("Post body from API")
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

        Assert.assertEquals("Massage in respons", "\"Congrats.\"", actualResponse);

        PostDto[] actualPostByUser = apiHelper.getAllPostByUser();
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
                .ignoringFields("id" , "createdDate", "author.avatar")
                .isEqualTo(expectedPostDto);
        softAssertions.assertAll();


    }
}
