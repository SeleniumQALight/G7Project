package privatBankApi;

public interface PrivatBankEndPoints {
    final String BASE_URL = "https://api.privatbank.ua/p24api";
    final String CURRENCY_RATES = BASE_URL + "/exchange_rates";
    final String CURRENCY_RATES_EXAM = "https://api.privatbank.ua/p24api/pubinfo";
}
