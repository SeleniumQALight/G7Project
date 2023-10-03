package demoQaApiTests;

import demoQaApi.DemoQaApiEndPoints;
import demoQaApi.DemoQaApiHelper;
import demoQaApi.dto.AuthorizationDto;
import demoQaApi.dto.RequestDto;
import io.restassured.http.ContentType;
import org.junit.Before;
import org.junit.Test;


import static io.restassured.RestAssured.given;

public class DemoQaApiTest {
    DemoQaApiHelper demoQaApiHelper = new DemoQaApiHelper();
    AuthorizationDto authorizationDto = new AuthorizationDto();
    RequestDto requestDto = new RequestDto();

    @Before
    public void authorizeAndDeleteAllBooks() {
        authorizationDto = demoQaApiHelper.authorization();
        demoQaApiHelper.deleteAllBooks(authorizationDto.getToken(), authorizationDto.getUserId());
        requestDto = demoQaApiHelper.addingFirstBookAndFormRequestDto(authorizationDto.getUserId());
    }

    @Test
    public void addingFirstBook() {
        given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + authorizationDto.getToken())
                .log().all()
                .body(requestDto)
                .when()
                .post(DemoQaApiEndPoints.ALL_BOOKS_URL)
                .then()
                .statusCode(201)
                .log().all();

        demoQaApiHelper.checkIfUserHaveTheBookHeAddedInHisProfile(authorizationDto.getToken()
                , authorizationDto.getUserId(), requestDto.getCollectionOfIsbns()[0].getIsbn());
    }
}
