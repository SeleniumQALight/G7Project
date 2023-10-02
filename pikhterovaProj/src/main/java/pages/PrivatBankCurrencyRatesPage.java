package pages;

import bdd.helpers.privatbank.Currency;
import bdd.helpers.privatbank.CurrencyStorage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class PrivatBankCurrencyRatesPage extends PrivatBankParentPage {

    public PrivatBankCurrencyRatesPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    protected String getRelativeUrl() {
        return "/rates-archive";
    }

    public PrivatBankCurrencyRatesPage openPrivatBankCurrencyRatesPage() {
        openPage(baseUrl + getRelativeUrl());
        return this;
    }

    public Currency[] getCurrencyRates(String xpath) {

        ArrayList<Currency> currencies = new ArrayList<>();

        clickOnElement(xpath);

        List<WebElement> currencyPairs = webDriver.findElements(org.openqa.selenium.By.className("currency-pairs"));

        String currencyName;
        float buy, sell;

        for (WebElement currencyPair : currencyPairs) {

            currencyName = currencyPair.findElement(org.openqa.selenium.By.className("names")).getText().trim();

            buy = Float.parseFloat(currencyPair.findElement(org.openqa.selenium.By.className("purchase")).findElement(org.openqa.selenium.By.tagName("span")).getText().trim());
            sell = Float.parseFloat(currencyPair.findElement(org.openqa.selenium.By.className("sale")).findElement(org.openqa.selenium.By.tagName("span")).getText().trim());

            currencies.add(new Currency(currencyName, buy, sell));

            System.out.println(currencyName + " " + buy + " " + sell);

        }

        return currencies.toArray(new Currency[0]);

    }

}
