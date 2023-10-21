package BooksDemoqa;

import BooksDemoqa.BooksDto.*;
import io.restassured.http.ContentType;
import org.apache.log4j.Logger;
import org.assertj.core.api.SoftAssertions;
import org.json.JSONObject;

import static io.restassured.RestAssured.given;

public class ApiHelperBooks {
    Logger logger = Logger.getLogger(getClass());


//метод отримує інформацію про користувача і токен
    public static LoginBooksDto getUserInfo(String login, String password) {

        SoftAssertions softAssertions = new SoftAssertions();

        JSONObject requestParams = new JSONObject();
        requestParams.put("userName", login);
        requestParams.put("password", password);

        LoginBooksDto apiResponseDTO =
                given()
                        .contentType(ContentType.JSON)
                        .log().all()
                        .body(requestParams.toMap())
                        .when()
                        .post(EndPoinBooks.LOGIN)
                        .then()
                        .statusCode(200)
                        .log().all()
                        .extract()
                        .response()
                        .getBody()
                        .as(LoginBooksDto.class);
// // Перевірка, що ідентифікатор користувача та токен не є пустими
        softAssertions.assertThat(apiResponseDTO.getUserId()).as("User id empty").isNotEmpty();
        softAssertions.assertThat(apiResponseDTO.getToken()).as("Token is empty").isNotEmpty();

        softAssertions.assertAll();
        return apiResponseDTO;
    }
//метод видаляє всі книги зі списку користувача
    public static void deleteAllBooksForUser(String token, String userId) {
        given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .queryParam("UserId", userId)
                .log().all()
                .when()
                .delete(EndPoinBooks.BOOKS)
                .then()
                .statusCode(204)
                .log().all();
    }

//метод отримує список книг, які додані до списку юзера
    public UserBooksDto getUserBooks(String userId, String token) {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .pathParam("userId", userId)
                .log().all()
                .when()
                .get(EndPoinBooks.USER_BOOKS, userId)
                .then()
                .statusCode(200)
                .log().all()
                .extract()
                .response()
                .getBody()
                .as(UserBooksDto.class);
    }

    //метод отримує список всіх книг, доступних на сайті
    public static AllBooksDto getAllBooks() {

        SoftAssertions softAssertions = new SoftAssertions();

        AllBooksDto allBooksResponse =
                given()
                        .contentType(ContentType.JSON)
                        .log().all()
                        .when()
                        .get(EndPoinBooks.BOOKS)
                        .then()
                        .statusCode(200)
                        .log().all()
                        .extract()
                        .response()
                        .getBody()
                        .as((Class<AllBooksDto>) AllBooksDto.class);
// перевірка, що список книг не є пустим
        softAssertions.assertThat(allBooksResponse.getBooks())
                .as("Books list is empty")
                .isNotEmpty();

        softAssertions.assertAll();

        return allBooksResponse;
    }

    // метод додає книгу до списку юзера
    public void addBookForUser(String userId, String token, String isbn) {
        CollectionOfIsbnsDto[] collectionOfIsbnsDto = {new CollectionOfIsbnsDto(isbn)};//створюємо масив з одним елементом
        AddBooksDto payload = AddBooksDto.builder()
                .userId(userId)
                .collectionOfIsbns(collectionOfIsbnsDto)
                .build();

        given()
                .contentType(ContentType.JSON)
                .auth().oauth2(token)
                .body(payload) //в тіло запиту додаємо масив з одним елементом
                .log().all()
                .when()
                .post(EndPoinBooks.BOOKS)
                .then()
                .statusCode(201)
                .log().all();
    }
}

