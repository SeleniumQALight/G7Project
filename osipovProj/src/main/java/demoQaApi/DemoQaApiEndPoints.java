package demoQaApi;

public interface DemoQaApiEndPoints {
    final String BASE_URL = "https://demoqa.com";
    final String LOGIN_URL = BASE_URL + "/Account/v1/Login";
    final String MY_BOOKS_URL = BASE_URL + "/Account/v1/User/{userId}";
    final String ALL_BOOKS_URL = BASE_URL + "/Bookstore/v1/Books";
    final String DELETE_BOOKS_BY_USER = BASE_URL + "/BookStore/v1/Books?UserId={userId}";
}
