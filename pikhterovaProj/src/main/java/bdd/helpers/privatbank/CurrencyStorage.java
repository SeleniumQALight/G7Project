package bdd.helpers.privatbank;

import java.util.HashMap;

public class CurrencyStorage {

    private final HashMap<String, Currency> siteCurrencies = new HashMap<>();
    private final HashMap<String, Currency> apiCurrencies = new HashMap<>();

    public void addSiteCurrency(Currency currency) {
        siteCurrencies.put(currency.getName(), currency);
    }

    public void addApiCurrency(Currency currency) {
        apiCurrencies.put(currency.getName(), currency);
    }

    public void checkCurrencies() {

    }

}
