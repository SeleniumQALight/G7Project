package pages.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.ActionWithElements;

public class Header extends ActionWithElements {
@FindBy(xpath = "//button[text()='Sign Out']")
private WebElement buttonSignOut;

    public Header(WebDriver webDriver) {
        super(webDriver);

    }

    public void checkIsButtonSignOutVisible() {
        checkElementDisplayed(buttonSignOut);
    }
}
