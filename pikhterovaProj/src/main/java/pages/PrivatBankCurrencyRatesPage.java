package pages;

import bdd.helpers.privatbank.Currency;
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

    public Currency[] getCurrencyRates(String menuItemXpath, String widgetXpath) {

        ArrayList<Currency> currencies = new ArrayList<>();

        clickOnElement(menuItemXpath);

        WebElement widget = webDriver.findElement(org.openqa.selenium.By.xpath(widgetXpath));

        List<WebElement> currencyPairs = widget.findElements(org.openqa.selenium.By.className("currency-pairs"));

        String currencyName;
        float buy, sell;

        for (WebElement currencyPair : currencyPairs) {

            WebElement currencyNameContainer = currencyPair.findElement(org.openqa.selenium.By.className("names"))
                    .findElement(org.openqa.selenium.By.tagName("span"));

            String nestedText = currencyNameContainer.findElement(org.openqa.selenium.By.tagName("span")).getText();

            currencyName = currencyNameContainer.getText().replace(nestedText, "").trim();

            buy = Float.parseFloat(currencyPair.findElement(org.openqa.selenium.By.className("purchase")).findElement(org.openqa.selenium.By.tagName("span")).getText().trim());
            sell = Float.parseFloat(currencyPair.findElement(org.openqa.selenium.By.className("sale")).findElement(org.openqa.selenium.By.tagName("span")).getText().trim());

            Currency currency = new Currency(currencyName, buy, sell);

            currencies.add(currency);

            logger.info(String.format("Site currency: %s", currency));

        }

        return currencies.toArray(new Currency[0]);

    }

}
