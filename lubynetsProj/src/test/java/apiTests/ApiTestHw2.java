package apiTests;

import api.EndpointHw2;
import api.dto.responseDto.HW2.UserBookActions;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ApiTestHw2 {
    private String token;
    private String userId;
    private String firstBookISBN;
    private UserBookActions userBookActions;
    Logger logger = Logger.getLogger(ApiTestHw2.class);

    @Before
    public void ValidLogin() {
        Response loginResponse = given()
                .contentType(ContentType.JSON)
                .body("{\"userName\":\"vladqaauto\",\"password\":\"Vladqaauto7773$\"}")
                .when()
                .post(EndpointHw2.LOGIN);

        assertEquals("User should be logged in successfully.", 200, loginResponse.getStatusCode());

        token = loginResponse.jsonPath().getString("token");
        userId = loginResponse.jsonPath().getString("userId");
        logger.info("User logged in successfully.");
        userBookActions = new UserBookActions(token);

    }

    @Test
    public void testBookstoreActions() {
        assertTrue("Token should not be empty.", !token.isEmpty());
        assertTrue("UserId should not be empty.", !userId.isEmpty());
        logger.info("Token and UserId are not empty.");

        Response deleteResponse = given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .queryParam("UserId", userId)
                .delete(EndpointHw2.DELETE_BOOKS);

        assertEquals("All user's books should be deleted.", 204, deleteResponse.getStatusCode());
        logger.info("All user's books have been deleted.");

        Response booksResponse = given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .when()
                .get(EndpointHw2.BOOKS);

        assertEquals("Books should be retrieved successfully.", 200, booksResponse.getStatusCode());
        firstBookISBN = booksResponse.jsonPath().getString("books[0].isbn");
        logger.info("Retrieved the first book ISBN: " + firstBookISBN);


        Response addBookResponse = given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .body("{\"userId\":\"" + userId + "\",\"collectionOfIsbns\":[{\"isbn\":\"" + firstBookISBN + "\"}]}")
                .when()
                .post(EndpointHw2.BOOKS);

        assertEquals("Book should be added successfully to the user.", 201, addBookResponse.getStatusCode());
        logger.info("Book has been added to the user");

        userBookActions.verifyUserHasSingleBook(firstBookISBN);
        logger.info("User has only one book with ISBN: " + firstBookISBN);
    }

    @After
    public void deleteAllUserBooks() {
        Response deleteResponse = given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .queryParam("UserId", userId)
                .delete(EndpointHw2.DELETE_BOOKS);

        assertEquals("All user's books should be deleted.", 204, deleteResponse.getStatusCode());
        logger.info("All user's books have been deleted.");
    }

}