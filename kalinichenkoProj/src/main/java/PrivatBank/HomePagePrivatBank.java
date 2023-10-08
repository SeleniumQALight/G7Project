package PrivatBank;

import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
@Getter
@Setter
public class HomePagePrivatBank {

    @FindBy(xpath = ".//td[@id='EUR_buy']")
    private WebElement eurBuy;
    @FindBy(xpath = ".//td[@id='EUR_sell']")
    private WebElement eurSell;
    @FindBy(xpath = ".//td[@id='USD_buy']")
    private WebElement usdBuy;
    @FindBy(xpath = ".//td[@id='USD_sell']")
    private WebElement usdSell;
}

