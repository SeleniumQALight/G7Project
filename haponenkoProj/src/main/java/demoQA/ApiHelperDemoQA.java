package demoQA;

import io.restassured.http.ContentType;
import org.apache.log4j.Logger;
import org.assertj.core.api.SoftAssertions;
import org.json.JSONObject;

import java.util.List;

import static io.restassured.RestAssured.given;

public class ApiHelperDemoQA {
    Logger logger = Logger.getLogger(getClass());

    public static UserInfoDTO getUserInfo() {
        return getUserInfo(TestDataDemoQA.LOGIN_DEFAULT, TestDataDemoQA.PASSWORD_DEFAULT);
    }

    public static UserInfoDTO getUserInfo(String login, String password) {
        SoftAssertions softAssertions = new SoftAssertions();
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

        softAssertions.assertThat(userInfo.getUserId()).as("User ID is empty").isNotEmpty();
        softAssertions.assertThat(userInfo.getToken()).as("Token is empty").isNotEmpty();

        softAssertions.assertAll();

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

//    public BookDTO getAllBooksByUser(String userId) {
//        UserProfileDto profileDTO =
//         given()
//                .contentType(ContentType.JSON)
//                .header("Authorization", "Bearer " + getUserInfo().getToken())
//                .log().all()
//                .when()
//                .get(EndPointsDemoQA.PROFILE, userId)
//                .then()
//                .statusCode(200)
//                .log().all()
//                .extract().response().getBody().as(UserProfileDto.class);
//
//        BookDTO userBooks = new BookDTO();
//        if (!profileDTO.getBooks().isEmpty()) {
//            userBooks.setIsbn(profileDTO.getBooks().get(0).getIsbn());
//        } else {
//            // Handle the case where there are no userBooks in the list
//            logger.info("No userBooks found in the list.");
//            // You can set a default value for isbn or handle it as needed
//        }
//
//        return userBooks;
//    }

    public Integer getNumberOfUserBooks(String userId) {
        UserProfileDto profileDTO =
                given()
                        .contentType(ContentType.JSON)
                        .header("Authorization", "Bearer " + getUserInfo().getToken())
                        .log().all()
                        .when()
                        .get(EndPointsDemoQA.PROFILE, userId)
                        .then()
                        .statusCode(200)
                        .log().all()
                        .extract().response().getBody().as(UserProfileDto.class);

        List<BookDTO> booksList = profileDTO.getBooks();

        int numberOfUserBooks = booksList.size();

        return numberOfUserBooks;
    }

    public static AllBooksDTO getAllBooks() {
        SoftAssertions softAssertions = new SoftAssertions();
        AllBooksDTO allBooksResponse =
                given()
                        .contentType(ContentType.JSON)
                        .log().all()
                        .when()
                        .get(EndPointsDemoQA.BOOKS)
                        .then()
                        .statusCode(200)
                        .log().all()
                        .extract().response().getBody().as(AllBooksDTO.class);

        List<BookDTO> books = allBooksResponse.getBooks();

        // Check if books are present in the response
        softAssertions.assertThat(books)
                .as("List of books is empty")
                .isNotEmpty();

        softAssertions.assertAll();
        return allBooksResponse;
    }

}



