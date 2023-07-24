package pages.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.ActionsWithElements;

public class Header extends ActionsWithElements {
    @FindBy(xpath = "//button[text()='Sign Out']") // this is a locator
    private WebElement buttonSignOut;

    @FindBy(xpath = "//button[text()='Sign In']")
    private WebElement buttonSignIn;

    @FindBy(xpath = "//div[text()='Invalid username / pasword']")
    private WebElement errorMessageInvalidUsernamePassword;

    @FindBy(xpath = "//a[@data-original-title='Search']")
    private WebElement buttonSearch;

    @FindBy(xpath = "//span[@data-original-title='Chat']")
    private WebElement buttonChat;

    @FindBy(xpath = "//img[@alt='My profile']")
    private WebElement buttonMyProfile;

    @FindBy(xpath = "//a[@href='/create-post']")
    private WebElement buttonCreatePost;


    public Header(WebDriver webDriver) {
        super(webDriver);
    }

    public void checkIsButtonSignOutVisible() {
        checkElementDisplayed(buttonSignOut);
    }

    public void checkIsButtonSignOutNotVisible() {
        checkElementNotDisplayed(buttonSignOut);
    }

    public void checkIsButtonSignInVisible() {
        checkElementDisplayed(buttonSignIn);
    }


    public void checkIsErrorMessageInvalidUsernamePasswordDisplayed() {
        checkElementDisplayed(errorMessageInvalidUsernamePassword);
    }

    public void clickOnButtonSignOut() {
        clickOnElement(buttonSignOut);
    }

    public void checkIsButtonSearchVisible() {
        checkElementDisplayed(buttonSearch);
    }

    public void checkIsButtonChatVisible() {
        checkElementDisplayed(buttonChat);
    }

    public void checkIsButtonMyProfileVisible() {
        checkElementDisplayed(buttonMyProfile);
    }

    public void checkIsButtonCreatePostVisible() {
        checkElementDisplayed(buttonCreatePost);
    }

    public void checkIsButtonSignInNotVisible() {
        checkElementNotDisplayed(buttonSignIn);
    }


}
