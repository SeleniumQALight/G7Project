package api.dto.responseDto.HW2;

import api.EndpointHw2;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class UserBookActions {
    private String token;
    private String userId;

    public UserBookActions(String token, String userId) {
        this.token = token;
        this.userId = userId;
    }

    public void addBookToUser(String bookISBN) {
        given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .body("{\"userId\":\"" + userId + "\",\"collectionOfIsbns\":[{\"isbn\":\"" + bookISBN + "\"}]}")
                .when()
                .post(EndpointHw2.BOOKS);
    }

    public List<String> getAllBooks() {
        Response response = given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .when()
                .get(EndpointHw2.BOOKS);
        return response.jsonPath().getList("books.isbn");
    }

    public void verifyUserHasSingleBook(String bookISBN) {
        List<String> userBooks = getAllBooks();
        int count = 0;
        for (int i = 0; i < userBooks.size(); i++) {
            if (userBooks.get(i).equals(bookISBN)) {
                count++;
            }
        }
        assertEquals("User should have exactly one book with ISBN: " + bookISBN, 1, count);
    }

    public void deleteAllBooksForUser() {
        given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .when()
                .delete(EndpointHw2.DELETE_BOOKS.replace("{userId}", userId))
                .then()
                .statusCode(204);
    }
}