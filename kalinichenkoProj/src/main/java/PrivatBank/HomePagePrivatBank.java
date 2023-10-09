package PrivatBank;


import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.ParentPage;

@Getter
public class HomePagePrivatBank extends ParentPage {

    @FindBy(xpath = ".//td[@id='EUR_buy']")
    private WebElement eurBuy;
    @FindBy(xpath = ".//td[@id='EUR_sell']")
    private WebElement eurSell;
    @FindBy(xpath = ".//td[@id='USD_buy']")
    private WebElement usdBuy;
    @FindBy(xpath = ".//td[@id='USD_sell']")
    private WebElement usdSell;

    public HomePagePrivatBank(WebDriver webDriver) {
        super(webDriver);

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

