package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static data.TestData.*;

public class MainPrivatPage extends ParentPage {
    public MainPrivatPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    protected String getRelativeUrl() {
        return null;
    }

    public MainPrivatPage openMainPage() {
        openPage("https://privatbank.ua/");
        return this;
    }

    public void discoverUiCurrencyBuySaleRate(String currency) {
        uiCurrencyBuySaleRates[0] = Double.valueOf(webDriver.findElement(By.xpath(
                "//div[@class='wr_inner course_type_container']//tbody//tr//td[@id='" + currency + "_buy']")).getText());
        uiCurrencyBuySaleRates[1] = Double.valueOf(webDriver.findElement(By.xpath(
                "//div[@class='wr_inner course_type_container']//tbody//tr//td[@id='" + currency + "_sell']")).getText());
    }
}
