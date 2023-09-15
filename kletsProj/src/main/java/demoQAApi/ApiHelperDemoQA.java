package demoQAApi;

import dataDemoQA.TestDataDemoQA;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.assertj.core.api.SoftAssertions;
import org.json.JSONObject;

import static io.restassured.RestAssured.given;

public class ApiHelperDemoQA {

    RequestSpecification requestSpecification = new RequestSpecBuilder()
            .setContentType(ContentType.JSON)
            .log(LogDetail.ALL)
            .build();

    public LoginResponseDto getUserInfo() {
        return getUserInfo(TestDataDemoQA.LOGIN_DEFAULT, TestDataDemoQA.PASSWORD_DEFAULT);
    }

    public LoginResponseDto getUserInfo(String login, String password) {
        SoftAssertions softAssertions = new SoftAssertions();
        JSONObject requestBody = new JSONObject();
        requestBody.put("userName", login);
        requestBody.put("password", password);

        LoginResponseDto responseDto =
                given()
                        .spec(requestSpecification)
                        .body(requestBody.toMap())
                        .when()
                        .post(EndPointsDemoQA.LOGIN)
                        .then()
                        .statusCode(200)
                        .log().all()
                        .extract()
                        .response()
                        .getBody().as(LoginResponseDto.class);

        softAssertions.assertThat(responseDto.getUserId()).as("User ID is empty").isNotEmpty();
        softAssertions.assertThat(responseDto.getToken()).as("Token is empty").isNotEmpty();

        softAssertions.assertAll();

        return responseDto;

    }

    public void deleteBookByUserId(String userId, String token) {
        given()
                .spec(requestSpecification)
                .header("Authorization", "Bearer " + token)
                .queryParam("UserId", userId)
                .when()
                .delete(EndPointsDemoQA.DELETE_BOOKS)
                .then()
                .statusCode(204)
                .log().all()
        ;

    }

    public UserProfileDto getUserProfile(String userId, String token) {
        return
                given()
                        .spec(requestSpecification)
                        .header("Authorization", "Bearer " + token)
                        .when()
                        .get(EndPointsDemoQA.Profile, userId)
                        .then()
                        .statusCode(200)
                        .log().all()
                        .extract()
                        .response()
                        .getBody().as(UserProfileDto.class);

    }

    public AllBooksDto getAllListOfBooks() {
        SoftAssertions softAssertions = new SoftAssertions();
        AllBooksDto allBooks =
                given()
                        .spec(requestSpecification)
                        .when()
                        .get(EndPointsDemoQA.GET_BOOKS)
                        .then()
                        .statusCode(200)
                        .log().all()
                        .extract()
                        .response()
                        .getBody().as(AllBooksDto.class);

        softAssertions.assertThat(allBooks.getBooks()).as("List of books is empty").isNotEmpty();

        softAssertions.assertAll();

        return allBooks;
    }

    public void addBookToCollection(String userId, String isbn, String token) {

        CollectionOfIsbnsDto[] collectionOfIsbnsDto = {new CollectionOfIsbnsDto(isbn)};

        AddBookDto addBookDto = AddBookDto.builder()
                .userId(userId)
                .collectionOfIsbns(collectionOfIsbnsDto)
                .build();

        given()
                .spec(requestSpecification)
                .header("Authorization", "Bearer " + token)
                .body(addBookDto)
                .when()
                .post(EndPointsDemoQA.ADD_BOOK)
                .then()
                .statusCode(201)
                .log().all();

    }


}
