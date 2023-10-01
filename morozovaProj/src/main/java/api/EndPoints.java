package api;

public interface EndPoints {
    final String BASE_URL = "https://aqa-complexapp.onrender.com";
    final String POSTS_BY_USER = BASE_URL + "/api/postsByAuthor/{0}";//ресташуред {0} працює аналогічно стрінгформату
    final String LOGIN = BASE_URL + "/api/login";
    final String CREATE_POST = BASE_URL + "/api/create-post";
    final String DELETE_POST = BASE_URL + "/api/post/{0}";

    //    PrivatBankEndPoints
    final String PRIVATBANK_UIURL = "https://privatbank.ua";

    final String BASE_URL_PRIVAT = "https://api.privatbank.ua/p24api";
    final String PRIVAT_URL = BASE_URL_PRIVAT + "/exchange_rates";
    //  https://api.privatbank.ua/p24api/pubinfo?json&exchange&coursid=5 - API get currency
    final String PRIVATBANK_URL = BASE_URL_PRIVAT + "/pubinfo?json&exchange&coursid=5";

}
