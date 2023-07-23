package pages.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.ActionsWithElements;

public class Header extends ActionsWithElements {
    @FindBy(xpath = "//*[text()='Sign Out']")
    private WebElement buttonSignOut;

    public Header(WebDriver webDriver) {
        super(webDriver);
    }

    public void checkIsButtonSignOutVisible() {
        checkElementDisplayed(buttonSignOut);
    }

    public void checkIsButtonSignOutNotVisible(){
        checkElementNotDisplayed(buttonSignOut);
    }

}
