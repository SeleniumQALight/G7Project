package apiTests;

import api.EndPoints;
import api.dto.responseDto.AuthorDto;
import api.dto.responseDto.PostDto;
import io.restassured.http.ContentType;
import org.apache.log4j.Logger;
import org.assertj.core.api.SoftAssertions;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.everyItem;

public class ApiTest {
    final String USER_NAME = "autoapi";
    Logger logger = Logger.getLogger(getClass());

    @Test
    public void getPostsByUserTest() {
        PostDto[] responseAsDto = given()
                .contentType(ContentType.JSON)//додали хедер аплікейшина
                .log().all()//виводимо в колсоль весь запит
                .when()// дія
                .get(EndPoints.POSTS_BY_USER, USER_NAME)//URL= ресташуред USER_NAME ={0} працює аналогічно стрінгформату
                .then()
                .statusCode(200)//перевір, що повернуло потрібний статус
                .log().all()//виводимо в колсоль весь респонс
                .assertThat()
                .body("[0].title", equalTo("test2"))
                .body("author.username", everyItem(equalTo(USER_NAME)))//пройти по всім айтем і перевірити поле
                .extract().body().as(PostDto[].class);//розпарсь класс і змінна в яку присвоюємо така ж
        logger.info(responseAsDto[0].toString());
        logger.info(responseAsDto.length);
        logger.info("Title " + responseAsDto[0].getTitle());
        logger.info("Username " + responseAsDto[0].getAuthor().getUsername());

        for (int i = 0; i < responseAsDto.length; i++) {
            Assert.assertEquals("Username is not matced in post " + i
                    , USER_NAME
                    , responseAsDto[i].getAuthor().getUsername());
        }
        PostDto[] expectedPostDto = {
               new PostDto("test2", "test body2", "All Users", "no", new AuthorDto(USER_NAME), false),
                new PostDto("test", "test body", "All Users", "no", new AuthorDto(USER_NAME), false)
        };//масив

        //перевірка кількості елементів
        Assert.assertEquals("Number of posts ", expectedPostDto.length, responseAsDto.length);

        SoftAssertions softAssertions = new SoftAssertions();//напоклює помилки до assertAll();
        for (int i = 0; i < responseAsDto.length; i++) {
            softAssertions.assertThat(responseAsDto[i])
                    .isEqualToIgnoringGivenFields(expectedPostDto[i], "id", "createdDate", "author");
            softAssertions.assertThat(responseAsDto[i].getAuthor())
                    .isEqualToIgnoringGivenFields(expectedPostDto[i].getAuthor(), "avatar");
        }
        softAssertions.assertAll();

    }
}
