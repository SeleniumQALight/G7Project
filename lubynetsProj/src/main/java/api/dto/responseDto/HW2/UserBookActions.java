package api.dto.responseDto.HW2;

import api.EndpointHw2;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class UserBookActions {
    private final String token;

    public UserBookActions(String token) {
        this.token = token;
    }

    public List<String> getUserBooks() {
        Response booksResponse = given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .when()
                .get(EndpointHw2.BOOKS);

        assertEquals("Books should be retrieved successfully.", 200, booksResponse.getStatusCode());

        List<String> userBooks = booksResponse.jsonPath().getList("books.isbn");

        return userBooks;
    }

    public void verifyUserHasSingleBook(String bookISBN) {
        List<String> userBooks = getUserBooks();
        int count = 0;
        for (int i = 0; i < userBooks.size(); i++) {
            if (userBooks.get(i).equals(bookISBN)) {
                count++;
            }
        }
        assertEquals("User should have exactly one book with ISBN: " + bookISBN, 1, count);
        
    }
}