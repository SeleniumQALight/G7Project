package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignOutPage extends ParentPage {

    @FindBy(xpath = "//button[contains(text(), 'Sign Out')]")
    private WebElement buttonSignOut;


    public SignOutPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void clickOnButtonSignOut() {
        clickOnElement(buttonSignOut);
    }
}