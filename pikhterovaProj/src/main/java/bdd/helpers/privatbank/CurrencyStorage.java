package bdd.helpers.privatbank;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.junit.Assert;

public class CurrencyStorage {

    private final Logger logger = Logger.getLogger(getClass());

    private final HashMap<String, Currency> siteCurrencies = new HashMap<>();
    private final HashMap<String, Currency> apiCurrencies = new HashMap<>();

    public void addSiteCurrency(Currency currency) {
        siteCurrencies.put(currency.getName(), currency);
    }

    public void addApiCurrency(Currency currency) {
        apiCurrencies.put(currency.getName(), currency);
    }

    public void checkCurrencies(float accuracy) {

        for (Map.Entry<String, Currency> set : siteCurrencies.entrySet()) {

            String currencyName = set.getKey();
            Currency siteCurrency = set.getValue();

            if (apiCurrencies.containsKey(currencyName)) {

                Currency apiCurrency = apiCurrencies.get(currencyName);

                Assert.assertEquals(
                        String.format("Buy currency %s", currencyName),
                        siteCurrency.getBuy(),
                        apiCurrency.getBuy(),
                        accuracy
                );

                Assert.assertEquals(
                        String.format("Sell currency %s", currencyName),
                        siteCurrency.getSell(),
                        apiCurrency.getSell(),
                        accuracy
                );

                logger.info(String.format("Site and API courses for %s are equal with accuracy %s", currencyName, accuracy));

            }

        }

    }

}
