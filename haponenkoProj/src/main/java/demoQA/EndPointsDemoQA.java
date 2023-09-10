package demoQA;

public interface EndPointsDemoQA {
    final String BASE_URL = "https://demoqa.com";
    final String BOOKS = BASE_URL + "/books";
    final String LOGIN = BASE_URL + "/Account/v1/Login";
    final String DELETE_ALL_BOOKS = BASE_URL + "/BookStore/v1/Books?UserId={userId}";
    final String ADD_BOOK = BASE_URL + "/BookStore/v1/Books";
    final String GET_BOOK = BASE_URL + "/Account/v1/Books";
    final String PROFILE = BASE_URL + "/Account/v1/User/{userId}";

}
