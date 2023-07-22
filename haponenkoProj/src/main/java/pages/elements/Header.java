package pages.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.ActionsWithElements;
import pages.LoginPage;

public class Header extends ActionsWithElements {

    public Header(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = "//button[text()='Sign Out']")
    public static WebElement buttonSignOut;

    @FindBy(xpath = "//a//*[@class = 'svg-inline--fa fa-search fa-w-16']")
    public static WebElement searchButton;

    @FindBy(xpath = "//*[@class = 'svg-inline--fa fa-comment fa-w-16']")
    public static WebElement chatButton;

    @FindBy(xpath = "//a[@class = 'mr-2']")
    public static WebElement profileButton;

    @FindBy(xpath = "//a[@class = 'btn btn-sm btn-success mr-2']")
    public static WebElement createPostButton;

    public void checkIsButtonSignOutVisible() {
        checkElementIsDisplayed(buttonSignOut);
    }

    public void checkIsSearchButtonVisible() {
        checkElementIsDisplayed(searchButton);
    }

    public void checkIsChatButtonVisible() {
        checkElementIsDisplayed(chatButton);
    }

    public void checkIsProfileAvatarButtonVisible() {
        checkElementIsDisplayed(profileButton);
    }

    public void checkIsCreatePostButtonVisible() {
        checkElementIsDisplayed(createPostButton);
    }

    public void checkIsButtonSignInNotVisible() {
        checkElementIsNotDisplayed(LoginPage.buttonSignIn);
    }

    public void checkIsInputUserNameNotVisible() {
        checkElementIsNotDisplayed(LoginPage.inputUserName);
    }

    public void checkIsInputPasswordNotVisible() {
        checkElementIsNotDisplayed(LoginPage.inputPassword);
    }

    public void clickOnButtonSignOut() {
        clickOnElement(buttonSignOut);
    }
}
