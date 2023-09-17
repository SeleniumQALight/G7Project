package demoQaApi;

import data.TestData;
import demoQaApi.dto.AuthorizationDto;
import demoQaApi.dto.BooksDto;
import demoQaApi.dto.CollectionOfIsbnsDto;
import demoQaApi.dto.RequestDto;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.junit.Assert;


import static io.restassured.RestAssured.given;

public class DemoQaApiHelper {

    RequestSpecification requestSpecification = new RequestSpecBuilder()
            .setContentType(ContentType.JSON)
            .log(LogDetail.ALL)
            .build();

    public AuthorizationDto authorization() {
        return authorization(TestData.LOGIN_DEMOQA_API_DEFAULT, TestData.PASSWORD_DEMOQA_API_DEFAULT);
    }

    public AuthorizationDto authorization(String userName, String password) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("userName", userName);
        jsonObject.put("password", password);

        return given()
                .spec(requestSpecification)
                .body(jsonObject.toMap())
                .when()
                .post(DemoQaApiEndPoints.LOGIN_URL)
                .then()
                .statusCode(200)
                .log().all()
                .extract().body().as(AuthorizationDto.class);
    }


    public void deleteAllBooks(String token, String userId) {
        given()
                .spec(requestSpecification)
                .header("Authorization", "Bearer " + token)
                .queryParam("UserId", userId)
                .when()
                .delete(DemoQaApiEndPoints.ALL_BOOKS_URL)
                .then()
                .statusCode(204)
                .log().all();
    }

    public RequestDto addingFirstBookAndFormRequestDto(String userId) {
        BooksDto response = given()
                .contentType(ContentType.JSON)
                .log().all()
                .when()
                .get(DemoQaApiEndPoints.ALL_BOOKS_URL)
                .then()
                .statusCode(200)
                .log().all()
                .extract().body().as(BooksDto.class);


        CollectionOfIsbnsDto[] collectionOfIsbnsDto = {new CollectionOfIsbnsDto(response.getBooks()[0].getIsbn())};

        return RequestDto.builder()
                .userId(userId)
                .collectionOfIsbns(collectionOfIsbnsDto)
                .build();
    }

    public void checkIfUserHaveTheBookHeAddedInHisProfile(String token, String userId, String isbn) {
        String booksOnProfilePage = given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .log().all()
                .when()
                .get(DemoQaApiEndPoints.MY_BOOKS_URL, userId)
                .then()
                .statusCode(200)
                .log().all()
                .extract().response().getBody().asString();

        Assert.assertFalse("more then 1 book", booksOnProfilePage.contains("},"));
        Assert.assertTrue("different books", booksOnProfilePage.contains(isbn));
    }
}
