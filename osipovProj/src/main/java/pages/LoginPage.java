package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends ParentPage {
    @FindBy(xpath = "//div[text()='Invalid username / pasword']")
    private WebElement invalidLoginMessage;

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void openLoginPage(){
        openPage(BASE_URL);
    }

    public void isInvalidLoginMessageDisplayed(){
        checkElementDisplayed(invalidLoginMessage);
    }
}

