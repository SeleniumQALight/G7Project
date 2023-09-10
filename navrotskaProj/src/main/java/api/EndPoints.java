package api;

import org.assertj.core.api.Java6BDDSoftAssertionsProvider;

import java.net.URI;

public interface EndPoints {
    final String BASE_URL = "https://aqa-complexapp.onrender.com";
    final String GET_POSTS_BY_USER = BASE_URL + "/api/postsByAuthor/{0}";
    final String GET_POSTS_BY_ID = "/posts/";
    final String LOGIN = BASE_URL + "/api/login";
    final String CREATE_POST = BASE_URL + "/api/create-post";
    final String DELETE_POST = BASE_URL + "/api/post/{0}";
}