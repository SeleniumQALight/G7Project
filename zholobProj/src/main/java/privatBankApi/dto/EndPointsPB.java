package privatBankApi.dto;

public interface EndPointsPB {
    final String BASE_URL = "https://api.privatbank.ua/p24api";
    final String CURRENCY = BASE_URL + "/exchange_rates";
    final String CURRENCY_BY_DATE = BASE_URL + "/exchange_rates?json&date={0}";

}
