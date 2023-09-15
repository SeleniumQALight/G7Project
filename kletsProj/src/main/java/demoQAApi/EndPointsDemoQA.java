package demoQAApi;

public interface EndPointsDemoQA {

    final String BASE_URL = "https://demoqa.com";
    final String LOGIN = BASE_URL + "/Account/v1/Login";
    final String Profile = BASE_URL + "/Account/v1/User/{userId}"; //{userId}";
    final String ADD_BOOK = BASE_URL + "/BookStore/v1/Books";
    final String GET_BOOKS = BASE_URL + "/BookStore/v1/Books";
    final String DELETE_BOOKS = BASE_URL + "/BookStore/v1/Books";// ?UserId={userId}

}
