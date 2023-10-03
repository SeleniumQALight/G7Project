package pages.PrivateBank;

import data.TestData;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;



public class PrivateBankPage extends ParentPagePB {

    public PrivateBankPage(WebDriver webDriver) {
        super(webDriver);
        this.webDriver = webDriver;
        this.webDriverWait10 = new WebDriverWait(webDriver, Duration.ofSeconds(10));

    }

    Logger logger = Logger.getLogger(getClass());
    protected WebDriverWait webDriverWait10;

    private String courseBuy = "//td[@id='%s_buy']";
    private String courseSell = "//td[@id='%s_sell']";


    public void openPrivateBankPage() {
        openPage(MAIN_URL);
    }

    public WebElement getCourseBuy(String currency) {
        webDriverWait10.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(courseBuy, currency))));
        return webDriver.findElement(By.xpath(String.format(courseBuy, currency)));
    }

    public WebElement getCourseSell(String currency) {
        webDriverWait10.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(courseSell, currency))));
        return webDriver.findElement(By.xpath(String.format(courseSell, currency)));
    }

    public void getBuyAnaSellRateFromUi(String expectedCurrency) {

        TestData.rate_buy_ui = getCourseBuy(expectedCurrency).getText();
        TestData.rate_sell_ui = getCourseSell(expectedCurrency).getText();
        logger.info("Buy rate from UI: " + TestData.rate_buy_ui);
        logger.info("Sell rate from UI: " + TestData.rate_sell_ui);

    }


    public void compareRates() {
        if (TestData.rate_buy_api.equals(TestData.rate_buy_ui)) {
            logger.info("Buy rate from API and UI are equal");
        } else {
            logger.info("Buy rate from API and UI are NOT equal");
        }
        if (TestData.rate_sell_api.equals(TestData.rate_sell_ui)) {
            logger.info("Sell rate from API and UI are equal");
        } else {
            logger.info("Sell rate from API and UI are NOT equal");
        }
    }
}
