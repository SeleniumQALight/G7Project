package PrivatBank;


import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.ParentPage;

@Getter
public class HomePagePrivatBank extends ParentPage {

    public HomePagePrivatBank(WebDriver webDriver) {
        super(webDriver);

    }

    private final String locatorForBuy = ".//td[@id='%s_buy']";
    private final String locatorForSell = ".//td[@id='%s_sell']";

    public WebElement getCurrencyBuy(String currency) {
        return webDriver.findElement(By.xpath(String.format(locatorForBuy, currency)));
    }

    public WebElement getCurrencySell(String currency) {
        return webDriver.findElement(By.xpath(String.format(locatorForSell, currency)));
    }



    @Override
    protected String getRelativeUrl() {
        return "/";
    }

    public HomePagePrivatBank openHomepagePrivatBank() {
        openPage(EndPoints.BASE_URL);
        return this;
    }

}

