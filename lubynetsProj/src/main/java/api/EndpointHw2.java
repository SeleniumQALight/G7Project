package api;

public interface EndpointHw2 {
    final String BASE_URL = "https://demoqa.com";
    final String LOGIN = BASE_URL + "/Account/v1/Login";
    final String BOOKS = BASE_URL + "/BookStore/v1/Books";
    final String DELETE_BOOKS = BASE_URL + "/BookStore/v1/Books?UserId={userId}";
}

