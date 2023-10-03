package pages;

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
    private static String exchangeRateBuy;
    public String getExchangeRateBuyOnTheWeb1(String currency) {
        // Формуємо локатор, підставляючи значення currency
        String exchangeRateBuyLocator = String.format(exchangeRateBuyOnTheWeb, currency);
        // Знаходимо елемент за локатором
        WebElement element = webDriver.findElement(By.xpath(exchangeRateBuyLocator));
        // Отримуємо текст елемента та записуємо його в строкову змінну
        String exchangeRateBuy = element.getText();
        // Додаємо три нулі в кінці змінної
        exchangeRateBuy = exchangeRateBuy + "000";
        // Виводимо в лог значення курсу купівлі
        logger.info("currency buying rate for " + currency + " is: " + exchangeRateBuy);
        // Повертаємо значення курсу купівлі
        return exchangeRateBuy;
    }

    //а тепер те саме для курсу продажу
    private static String exchangeRateSale;
    public String getExchangeRateSaleOnTheWeb(String currency) {
        // Формуємо локатор, підставляючи значення currency
        String exchangeRateSaleLocator = String.format(exchangeRateSaleOnTheWeb, currency);
        // Знаходимо елемент за локатором
        WebElement element = webDriver.findElement(By.xpath(exchangeRateSaleLocator));
        // Отримуємо текст елемента та додаємо три нулі в кінці
        String exchangeRateSale = element.getText() + "000";
        // Виводимо в лог значення курсу продажу
        logger.info("currency selling rate for " + currency + " is: " + exchangeRateSale);
        // Повертаємо значення курсу продажу
        return exchangeRateSale;
    }

}

