package api;

public interface EndPoints {
    final String BASE_URL = "https://aqa-complexapp.onrender.com";
    final String POSTS_BY_USER = BASE_URL + "/api/postsByAuthor/{0}";



    final  String LOGIN = BASE_URL + "/api/login";

    final  String CREATE_POST = BASE_URL + "/api/create-post";

    final String DELETE_POST =BASE_URL + "/api/post/{0}";

//сюди затесався приват банк
    final String URL_PB = "https://api.privatbank.ua/p24api/pubinfo";
}

