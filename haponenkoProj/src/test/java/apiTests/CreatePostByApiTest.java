package apiTests;

import api.ApiHelper;
import api.EndPoints;
import api.dto.requestDto.CreatePostDTO;
import api.dto.responseDto.AuthorDto;
import api.dto.responseDto.PostDto;
import data.TestData;
import io.restassured.http.ContentType;
import libs.Util;
import org.assertj.core.api.SoftAssertions;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class CreatePostByApiTest {
    ApiHelper apiHelper = new ApiHelper();

    @Before
    public void deleteAllPostsByUserBeforeTest() {
        apiHelper.deletePostsTillPresent();
    }

    @Test
    public void createPostByApi() {
        String token = apiHelper.getUserToken();//можна прописати цей рядок в секції @Before, тоді буде виконуватися перед кожним тестом

        CreatePostDTO createPostBody =
                CreatePostDTO.builder()
                        .title("New post from API Iryna IJ " + Util.getDateAndTimeFormatted())
                        .body("New post from API Iryna IJ")
                        .select1("One Person")
                        .uniquePost("yes")
                        .token(token)
                        .build();

        String actualResponse = //в цю змінну записується тіло відповіді
                given()
                        .contentType(ContentType.JSON)
                        .log().all()
                        .body(createPostBody)
                        .when()
                        .post(EndPoints.CREATE_POST) //тут закінчується запит, потім тіло запишеться в actualResponse
                        .then()
                        .statusCode(200)
                        .log().all()
                        .extract().response().getBody().asString(); //тут починається витягування тіла відповіді

        Assert.assertEquals("Message in actualResponse", "\"Congrats.\"", actualResponse);

        PostDto[] actualPostsByUser = apiHelper.getAllPostsByUser();
        Assert.assertEquals("Number of posts ", 1, actualPostsByUser.length);

        PostDto[] expectedPostDTO = {
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
                .isEqualTo(expectedPostDTO);

        softAssertions.assertAll();
    }
}
