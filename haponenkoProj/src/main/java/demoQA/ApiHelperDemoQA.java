package demoQA;

import api.dto.responseDto.AuthorDto;
import io.restassured.http.ContentType;
import io.restassured.response.ResponseBody;
import org.apache.log4j.Logger;
import org.json.JSONObject;

import java.awt.print.Book;
import java.util.List;

import static io.restassured.RestAssured.given;

public class ApiHelperDemoQA {
    Logger logger = Logger.getLogger(getClass());

    public static UserInfoDTO getUserInfo() {
        return getUserInfo(TestDataDemoQA.LOGIN_DEFAULT, TestDataDemoQA.PASSWORD_DEFAULT);
    }

    public static UserInfoDTO getUserInfo(String login, String password) {
        JSONObject requestParams = new JSONObject();
        requestParams.put("userName", login);
        requestParams.put("password", password);

        ApiResponseDTO apiResponseDTO =
                given()
                        .contentType(ContentType.JSON)
                        .log().all()
                        .body(requestParams.toMap())
                        .when()
                        .post(EndPointsDemoQA.LOGIN)
                        .then()
                        .statusCode(200)
                        .log().all()
                        .extract().response().getBody().as(ApiResponseDTO.class);

        UserInfoDTO userInfo = new UserInfoDTO();
        userInfo.setToken(apiResponseDTO.getToken());
        userInfo.setUserId(apiResponseDTO.getUserId());

        return userInfo;
    }

    public void deleteAllBooksByUser(String token, String userId) {
        given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .log().all()
                .when()
                .delete(EndPointsDemoQA.DELETE_ALL_BOOKS, userId)
                .then()
                .statusCode(204)
                .log().all();
    }

//    public ProfileDto getAllBooksByUser() {
//        return getAllBooksByUser(TestDataDemoQA.LOGIN_DEFAULT);
//    }

    public BooksDTO getAllBooksByUser(String userId) {
        ProfileDto profileDTO =
         given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + getUserInfo().getToken())
                .log().all()
                .when()
                .get(EndPointsDemoQA.PROFILE, userId)
                .then()
                .statusCode(200)
                .log().all()
                .extract().response().getBody().as(ProfileDto.class);

        BooksDTO books = new BooksDTO();
        if (!profileDTO.getBooks().isEmpty()) {
            books.setIsbn(profileDTO.getBooks().get(0).getIsbn());
        } else {
            // Handle the case where there are no books in the list
            logger.info("No books found in the list.");
            // You can set a default value for isbn or handle it as needed
        }

        return books;
    }

    public int getNumberOfBooks(String userId) {
        ProfileDto profileDTO =
                given()
                        .contentType(ContentType.JSON)
                        .header("Authorization", "Bearer " + getUserInfo().getToken())
                        .log().all()
                        .when()
                        .get(EndPointsDemoQA.PROFILE, userId)
                        .then()
                        .statusCode(200)
                        .log().all()
                        .extract().response().getBody().as(ProfileDto.class);

        List<BooksDTO> booksList = profileDTO.getBooks();

        // Get the number of books in the list
        int numberOfBooks = booksList.size();

        return numberOfBooks;
    }
}
