package pages.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.ActionsWithElements;

public class Header extends ActionsWithElements {
    @FindBy(xpath = "//button[text()='Sign Out']")
    private WebElement buttonSignOut;

    @FindBy (xpath = "//button[@class=\"btn btn-primary btn-sm\"]")
    private WebElement buttonSignIn;

    public Header(WebDriver webDriver) {
        super(webDriver);
    }

    public void checkIsButtonSignInVisible() {
        checkElementDisplayed(buttonSignIn);
    }

    public void checkIsButtonSignOutVisible() {
        checkElementDisplayed(buttonSignOut);
    }


}
