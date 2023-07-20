package pages.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.ActionsWithElements;

public class Header extends ActionsWithElements {
    public Header (WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = "//button[text()='Sign Out']")
    private WebElement buttonSignOut;

    public void checkIsButtonSignOutVisible() {
        checkElementDisplay(buttonSignOut);
    }

}
