package privatBankApi;

public interface PrivatBankEndpoints {
    final String BASE_URL = "https://api.privatbank.ua";
    final String EXCHANGE_RATE = BASE_URL + "/p24api/exchange_rates?date={0}";
}
