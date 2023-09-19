package demoQA;

public interface EndPointsDemoQA {
    final String BASE_URL = "https://demoqa.com";
    final String BOOKS = BASE_URL + "/BookStore/v1/Books";
    final String LOGIN = BASE_URL + "/Account/v1/Login";
    final String DELETE_ALL_BOOKS = BASE_URL + "/BookStore/v1/Books?UserId={userId}"; //замісць цього окремого ендпоінта по видаленню можна використати ендпоінт на отримання всіх книжок в системі, додавши userId в queryParams в Given

    final String PROFILE = BASE_URL + "/Account/v1/User/{userId}";

}
