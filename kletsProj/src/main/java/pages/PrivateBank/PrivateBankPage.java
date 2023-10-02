package pages.PrivateBank;

import data.TestData;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PrivateBankPage extends ParentPagePB {

    Logger logger = Logger.getLogger(getClass());

    private String courseBuy = "//td[@id='%s_buy']";
    private String courseSell = "//td[@id='%s_sell']";

    public PrivateBankPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void openPrivateBankPage() {
        openPage(MAIN_URL);
    }

    public WebElement getCourseBuy(String currency) {
        return webDriver.findElement(By.xpath(String.format(courseBuy, currency)));
    }

    public WebElement getCourseSell(String currency) {
        return webDriver.findElement(By.xpath(String.format(courseSell, currency)));
    }

    public void getBuyAnaSellRateFromUi(String expectedCurrency) {
        TestData.rate_buy_ui = getCourseBuy(expectedCurrency).getText();
        TestData.rate_sell_ui = getCourseSell(expectedCurrency).getText();
        logger.info("Buy rate from UI: " + TestData.rate_buy_ui);
        logger.info("Sell rate from UI: " + TestData.rate_sell_ui);

    }
}
