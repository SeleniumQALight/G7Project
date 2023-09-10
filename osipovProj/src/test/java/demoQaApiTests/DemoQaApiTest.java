package demoQaApiTests;

import demoQaApi.DemoQaApiEndPoints;
import demoQaApi.DemoQaApiHelper;
import demoQaApi.dto.CollectionOfIsbnsDto;
import demoQaApi.dto.RequestDto;
import io.restassured.http.ContentType;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class DemoQaApiTest {
    DemoQaApiHelper demoQaApiHelper = new DemoQaApiHelper();
    List<String> userIdAndToken = new ArrayList<>();

    @Before
    public void authorizeAndDeleteAllBooks() {
        userIdAndToken = demoQaApiHelper.authorization();
        demoQaApiHelper.deleteAllBooks(userIdAndToken);
    }

    @Test
    public void addingFirstBook() {
        String response = given()
                .contentType(ContentType.JSON)
                .log().all()
                .when()
                .get(DemoQaApiEndPoints.ALL_BOOKS_URL)
                .then()
                .statusCode(200)
                .log().all()
                .extract().response().getBody().asString();

        JSONObject jsonObjectForAllBooks = new JSONObject(response);
        JSONArray jsonArray = jsonObjectForAllBooks.getJSONArray("books");
        List<String> isbn = new ArrayList<>();

        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject temp = jsonArray.getJSONObject(i);
            isbn.add(temp.getString("isbn"));
        }

        CollectionOfIsbnsDto[] collectionOfIsbnsDto = {new CollectionOfIsbnsDto(isbn.get(0))};

        RequestDto requestDto = RequestDto.builder()
                .userId(userIdAndToken.get(0))
                .collectionOfIsbns(collectionOfIsbnsDto)
                .build();

        given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + userIdAndToken.get(1))
                .log().all()
                .body(requestDto)
                .when()
                .post(DemoQaApiEndPoints.ALL_BOOKS_URL)
                .then()
                .statusCode(201)
                .log().all();

        String booksOnProfilePage = given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + userIdAndToken.get(1))
                .log().all()
                .when()
                .get(DemoQaApiEndPoints.MY_BOOKS_URL, userIdAndToken.get(0))
                .then()
                .statusCode(200)
                .log().all()
                .extract().response().getBody().asString();

        Assert.assertFalse("more then 1 book", booksOnProfilePage.contains("},"));
        Assert.assertTrue("different books", booksOnProfilePage.contains(isbn.get(0)));
    }
}
