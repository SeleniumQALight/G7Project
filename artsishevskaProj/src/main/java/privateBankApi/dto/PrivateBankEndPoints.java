package privateBankApi.dto;

public interface PrivateBankEndPoints {

    final String BASE_URL = "https://api.privatbank.ua/p24api";
    final String CURRENCY_EXCHANGE = BASE_URL + "/exchange_rates";
    final String CURRENCY_RATE_EXAM = "https://api.privatbank.ua/p24api/pubinfo";
}
