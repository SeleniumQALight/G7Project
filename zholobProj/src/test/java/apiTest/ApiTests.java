package apiTest;

import api.EndPoints;
import api.dto.responsDto.AuthorDto;
import api.dto.responsDto.PostDto;
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

public class ApiTests {
    final String USER_NAME = "autoapi";
    Logger logger = Logger.getLogger(getClass());

    @Test
    public void getPostsByUserTest() {
        PostDto[] responseAsDto = given()

                .contentType(ContentType.JSON)
                .log().all() //виводимо в колсоль весь реквест
                .when() //дія
                .get(EndPoints.PPOSTS_BY_USER, USER_NAME) //  вказуємо ендпоінт і тип запиту
                .then()
                .statusCode(200)//перевір, що повернуло потрібний статус
                .log().all()//виводимо в колсоль весь респонс
                .assertThat() //перевірки
                .body("[0].title",equalTo("test2")) //перевыка що пост з індексом 0 має тайтл test2
                .body("author.username", everyItem(equalTo(USER_NAME)))//пройти по всім айтем і перевірити поле юзернейм
                .extract().body().as(PostDto[].class)//витягнути тіло і перетворити в масив обєктів
                ;
        logger.info(responseAsDto[0].toString());
        logger.info(responseAsDto.length); // питаємо скільки елементів в масиві
        logger.info(responseAsDto[0].getTitle()); //
        logger.info(responseAsDto[0].getAuthor().getUsername()); //питаємо юзернейм автора першого поста

        for (int i = 0; i < responseAsDto.length; i++) {
            Assert.assertEquals("Username is not matched in post  " + i
                    , USER_NAME
                    , responseAsDto[i].getAuthor().getUsername());

        }

//        PostDto[] expectedPostDto = { // створюємо масив з обєктів які мають бути в респонсі
 //               new PostDto("test2", "test body2", "All Users", "no", new AuthorDto(USER_NAME), false),
//                new PostDto("test", "test body", "All Users", "no", new AuthorDto(USER_NAME), false)
        PostDto[] expectedPostDto = { // створюємо масив з обєктів
 //               new PostDto("test2", "test body2", "All Users", "no", new AuthorDto(USER_NAME), false),
 //               new PostDto("test", "test body", "All Users", "no", new AuthorDto(USER_NAME), false)
                PostDto.builder().title("test2").body("test body2").select("All Users") .uniquePost("no").isVisitorOwner(false) .author(AuthorDto.builder().username(USER_NAME).build()) .build(),
                PostDto.builder().title("test").body("test body").select("All Users") .uniquePost("no").isVisitorOwner(false) .author(AuthorDto.builder().username(USER_NAME).build()) .build()

        };

        Assert.assertEquals("Number of posts " //перевірка кількості постів
                , expectedPostDto.length
                , responseAsDto.length);


        SoftAssertions softAssertions = new SoftAssertions();

 //       for (int i = 0; i < expectedPostDto.length; i++) {
//            softAssertions.assertThat(responseAsDto[i])
//                    .isEqualToIgnoringGivenFields(expectedPostDto[i], "id", "createdDate", "author");
//            softAssertions.assertThat(responseAsDto[i].getAuthor())
//                    .isEqualToIgnoringGivenFields(expectedPostDto[i].getAuthor(), "avatar");
       softAssertions.assertThat(responseAsDto)
               .usingRecursiveComparison()
               .ignoringFields("id", "createdDate", "author.avatar")
               .isEqualTo(expectedPostDto);


        softAssertions.assertAll();
    }

    @Test
    public void getPostsByUserTest2() {
        String actualRasponse =
                given()
                        .contentType(ContentType.JSON)
                        .log().all()
                        .when()
                        .get(EndPoints.PPOSTS_BY_USER, "NOtVaidUser") //  URL
                        .then()
                        .statusCode(200)//перевір, що повернуло потрібний статус
                        .log().all()//виводимо в колсоль весь респонс
                        .extract().response().body().asString()  ;
        Assert.assertEquals("Message in response","\"Sorry, invalid user requested.undefined\"",actualRasponse);
        Assert.assertEquals("Message in response","Sorry, invalid user requested.undefined",actualRasponse.replace("\"",""));
}


@Test
public void getAllPostsByUserPatch() {
//    Response response= given()
   Response response= given()
           .contentType(ContentType.JSON)//додали хедер аплікейшина
            .log().all()
            .when()
           .get(EndPoints.PPOSTS_BY_USER, USER_NAME) //  URL
            .then()
            .statusCode(200)//перевір, що повернуло потрібний статус
            .log().all()//виводимо в колсоль весь респонс
            .extract().response() ;

    List<String> actualTitlesList = response.jsonPath().getList("title", String.class);
    SoftAssertions softAssertions = new SoftAssertions();
    for (int i = 0; i < actualTitlesList.size(); i++) {
        softAssertions.assertThat(actualTitlesList.get(i))
                .as("Title number " + i ).contains("test");

    }

    List<Map> actualAuthorsList = response.jsonPath().getList("author", Map.class);

    for (int i = 0; i < actualAuthorsList.size(); i++) {
        softAssertions.assertThat(actualAuthorsList.get(i).get("username"))
                .as("Item number " + i ).isEqualTo(USER_NAME);

    }




}
@Test
    public void getAllPostsByUserShema() {
    given()
            .contentType(ContentType.JSON)
            .log().all()
            .when()
            .get(EndPoints.PPOSTS_BY_USER, USER_NAME) //  URL
            .then()
            .statusCode(200)//перевір, що повернуло потрібний статус
            .log().all()//виводимо в колсоль весь респонс
            .assertThat().body(matchesJsonSchemaInClasspath("response.json"));

    }

}

