package apiTests;

import api.EndPoints;
import io.restassured.http.ContentType;
import org.junit.Test;
import static io.restassured.RestAssured.given;

public class ApiTest {
    final String USER_NAME = "autoapi";
    @Test
    public void getPostsByUserTest(){
       given()
               .contentType(ContentType.JSON)//додали хедер аплікейшина
               .log().all()
               .when()
               .get(EndPoints.POSTS_BY_USER,USER_NAME )//URL= ресташуред USER_NAME ={0} працює аналогічно стрінгформату
               .then()
               .statusCode(200)//перевір, що повернуло потрібний статус
               .log().all();
    }
}
