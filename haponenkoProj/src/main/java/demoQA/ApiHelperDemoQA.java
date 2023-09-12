package demoQA;

import io.restassured.http.ContentType;
import org.apache.log4j.Logger;
import org.assertj.core.api.SoftAssertions;
import org.json.JSONObject;
import static io.restassured.RestAssured.given;

public class ApiHelperDemoQA {
    Logger logger = Logger.getLogger(getClass());

    public static LoginApiResponseDTO getUserInfo() {
        return getUserInfo(TestDataDemoQA.LOGIN_DEFAULT, TestDataDemoQA.PASSWORD_DEFAULT);
    }

    public static LoginApiResponseDTO getUserInfo(String login, String password) {
        SoftAssertions softAssertions = new SoftAssertions();
        JSONObject requestParams = new JSONObject();
        requestParams.put("userName", login);
        requestParams.put("password", password);

        LoginApiResponseDTO apiResponseDTO =
                given()
                        .contentType(ContentType.JSON)
                        .log().all()
                        .body(requestParams.toMap())
                        .when()
                        .post(EndPointsDemoQA.LOGIN)
                        .then()
                        .statusCode(200)
                        .log().all()
                        .extract().response().getBody().as(LoginApiResponseDTO.class);

//        UserLoginInfoDTO userInfo = new UserLoginInfoDTO();
//        userInfo.setToken(apiResponseDTO.getToken());
//        userInfo.setUserId(apiResponseDTO.getUserId());

        softAssertions.assertThat(apiResponseDTO.getUserId()).as("User ID is empty").isNotEmpty();
        softAssertions.assertThat(apiResponseDTO.getToken()).as("Token is empty").isNotEmpty();

        softAssertions.assertAll();

        return apiResponseDTO;
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

    public UserProfileDto getUserProfile(String userId, String token) {
        return
                given()
                        .contentType(ContentType.JSON)
                        .header("Authorization", "Bearer " + token)
                        .log().all()
                        .when()
                        .get(EndPointsDemoQA.PROFILE, userId)
                        .then()
                        .statusCode(200)
                        .log().all()
                        .extract().response().getBody().as(UserProfileDto.class);

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


        // Check if books are present in the response
        softAssertions.assertThat(allBooksResponse.getBooks())
                .as("List of books is empty")
                .isNotEmpty();

        softAssertions.assertAll();

        return allBooksResponse;
    }

//    public void addBookToUserByApi() {
//        String response = given()
//                .contentType(ContentType.JSON)
//                .log().all()
//                .when()
//                .get(EndPointsDemoQA.ADD_BOOK)
//                .then()
//                .statusCode(200)
//                .log().all()
//                .extract().response().getBody().asString();
//
//        JSONObject jsonObjectForAllBooks = new JSONObject(response);
//        JSONArray jsonArray = jsonObjectForAllBooks.getJSONArray("books");
//        List<String> isbn = new ArrayList<>();
//
//        for (int i = 0; i < jsonArray.length(); i++) {
//            JSONObject temp = jsonArray.getJSONObject(i);
//            isbn.add(temp.getString("isbn"));
//        }
//
//        CollectionOfIsbnsDto[] collectionOfIsbnsDto = {new CollectionOfIsbnsDto(isbn.get(0))};
//
//        AddBookDTO addBookDTO = AddBookDTO.builder()
//                .userId(getUserInfo().userId)
//                .collectionOfIsbns(collectionOfIsbnsDto)
//                .build();
//
//        given()
//                .contentType(ContentType.JSON)
//                .header("Authorization", "Bearer " + getUserInfo().getToken())
//                .log().all()
//                .body(addBookDTO)
//                .when()
//                .post(EndPointsDemoQA.ADD_BOOK)
//                .then()
//                .statusCode(201)
//                .log().all();
//    }

    public void addBooksToUser(String userId, String isbns, String token) {
        // Create the request payload as a Map
//        Map<String, Object> payload = new HashMap<>();
//        payload.put("userId", userId);
//        payload.put("collectionOfIsbns", isbns);
        CollectionOfIsbnsDto[] collectionOfIsbnsDto = {new CollectionOfIsbnsDto(isbns)};
        AddBookDTO payload = AddBookDTO.builder()
                .userId(userId)
                .collectionOfIsbns(collectionOfIsbnsDto)
                .build();

        // Send the POST request with the payload
        given()
                .contentType(ContentType.JSON)
                .auth().oauth2(token)
                .body(payload)
                .log().all()
                .when()
                .post(EndPointsDemoQA.ADD_BOOK)
                .then()
                .statusCode(201)
                .log().all();
    }
}



