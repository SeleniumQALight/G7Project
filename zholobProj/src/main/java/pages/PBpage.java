package pages;

import data.TestData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PBpage extends ParentPage {


    public PBpage(WebDriver webDriver) { // конструктор
        super(webDriver);
    }


    //розділ Курси валют
    @FindBy(xpath = "//*[@class='eclipse-text col-xs-6']")
    WebElement titleExchangeRates;

    //параметризований локатор для пошуку курсу купівлі валюти по назві
    private String exchangeRateBuyOnTheWeb = ".//*[@id='%s_buy']";

    //параметризований локатор для пошуку курсу продажу валюти по назві
    private String exchangeRateSaleOnTheWeb = "//*[@id='%s_sell']";

    @Override
    protected String getRelativeUrl() {
        return null;
    }

    public void openPBpage() {
        openPage(BASE_PB_URL);
    }

    // метод для перевірки чи відображається заголовок "Курси валют"
    public PBpage checkIsTitleExchangeRatesVisible() {
        checkElementDisplayed(titleExchangeRates);
        return this;
    }

    //метод для отримання курсу купівлі валюти

    public String getExchangeRateBuyOnTheWeb1(String currency) {
        // Формуємо локатор, підставляючи значення currency
        String exchangeRateBuyLocator = String.format(exchangeRateBuyOnTheWeb, currency);
        // Знаходимо елемент за локатором
        WebElement element = webDriver.findElement(By.xpath(exchangeRateBuyLocator));
        // Отримуємо текст елемента записуємо в статичну змінну
        TestData.exchangeRateBuy = element.getText();
        // Виводимо в лог значення курсу купівлі
        logger.info("currency buying rate (WEBSITE) for " + currency + " is: " + TestData.exchangeRateBuy);
        // Повертаємо значення курсу купівлі
        return TestData.exchangeRateBuy;
    }

    //а тепер все те саме для курсу продажу

    public String getExchangeRateSaleOnTheWeb(String currency) {
        String exchangeRateSaleLocator = String.format(exchangeRateSaleOnTheWeb, currency);
        WebElement element = webDriver.findElement(By.xpath(exchangeRateSaleLocator));
        TestData.exchangeRateSale = element.getText();
        logger.info("currency selling (WEBSITE) rate for " + currency + " is: " + TestData.exchangeRateSale);
        return TestData.exchangeRateSale;
    }

}

