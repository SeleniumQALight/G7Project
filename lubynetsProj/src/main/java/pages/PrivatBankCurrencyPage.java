package pages;

import data.TestData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class PrivatBankCurrencyPage {
    private WebDriver webDriver;


    public PrivatBankCurrencyPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void openPrivatBankWebsite() {
        webDriver.get("https://privatbank.ua/");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String getExchangeRate(String currency, String transaction) {
        String locatorId = currency + "_" + transaction;
        WebElement rateElement = webDriver.findElement(By.xpath("//td[@id='" + locatorId + "']"));

        if (rateElement != null) {
            String rate = rateElement.getText();
            System.out.println(currency + " " + transaction + " rate is " + rate);

            return rate;
        } else {
            System.out.println("Element with id " + locatorId + " was not found on the web page.");
            return null;
        }
    }

    public String getExchangeRateSell(String currency, String transaction) {
        String locatorId = currency + "_" + transaction;
        WebElement rateElement = webDriver.findElement(By.xpath("//td[@id='" + locatorId + "']"));

        if (rateElement != null) {
            String rate = rateElement.getText();
            System.out.println(currency + " " + transaction + " rate is " + rate);

            return rate;
        } else {
            System.out.println("Element with id " + locatorId + " was not found on the web page.");
            return null;
        }
    }

    public String getExchangeRateUI(String currency, String transaction, String key) {
        String rate = getExchangeRate(currency, transaction);
        TestData.saveExchangeRate(key, rate);
        return rate;
    }

    public String getExchangeRateSellUI(String currency, String transaction, String key) {
        String rate = getExchangeRateSell(currency, transaction);
        TestData.saveExchangeRateSell(key, rate);
        return rate;
    }
}