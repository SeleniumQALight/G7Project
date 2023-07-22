package pages.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.ActionsWithElements;

public class Header extends ActionsWithElements {
    @FindBy(xpath = "//button[text() = 'Sign Out']")
    private WebElement buttonSignOut;

    public Header(WebDriver webDriver) {
        super(webDriver);
    }

    public void checkIsButtonSignOutVisible() {
        checkElementDisplayed(buttonSignOut);
    }
    public void checkIsButtonSignOutNotVisible() {
        checkElementNotDisplayed(buttonSignOut);
    }

    @FindBy(xpath = "//button[text() = 'Sign In']")
    private WebElement buttonSignIn;

    public void checkIsButtonSignInVisible() {
        checkElementDisplayed(buttonSignIn);
    }

    public void checkIsButtonSignInNotVisible() {
        checkElementNotDisplayed(buttonSignIn);
    }

    @FindBy(xpath = "//*[@class='alert alert-danger text-center']")
    private WebElement alertMessageWrongLoginOrPassword;

    public void checkIsAlertMessageVisible() {
        checkElementDisplayed(alertMessageWrongLoginOrPassword);
    }

    @FindBy(xpath = "//div[@class='flex-row my-3 my-md-0']//*[@data-icon='search']")
    private WebElement searchIcon;

    public void checkIsSearchVisible() {
        checkElementDisplayed(searchIcon);
    }

    public void checkIsSearchNotVisible() {
        checkElementNotDisplayed(searchIcon);
    }

    @FindBy(xpath = "//*[@data-icon='comment']")
    private WebElement chatIcon;

    public void checkIsChatVisible() {
        checkElementDisplayed(chatIcon);
    }

    public void checkIsChatNotVisible() {
        checkElementNotDisplayed(chatIcon);
    }

    @FindBy(xpath = "//span[@class='text-white mr-2']")
    private WebElement avatarIcon;

    public void checkIsAvatarVisible() {
        checkElementDisplayed(avatarIcon);
    }

    public void checkIsAvatarNotVisible() {
        checkElementNotDisplayed(avatarIcon);
    }

    @FindBy(xpath = "//a[@href='/create-post']")
    private WebElement buttonCreatePost;

    public void checkIsCreatePostVisible() {
        checkElementDisplayed(buttonCreatePost);
    }

    public void checkIsCreatePostNotVisible() {
        checkElementNotDisplayed(buttonCreatePost);
    }

    @FindBy(xpath = "//input[@placeholder='Username']")
    private WebElement inputUserName;

    public void checkIsInputUserNameVisible() {
        checkElementDisplayed(inputUserName);
    }

    public void checkIsInputUserNameNotVisible() {
        checkElementNotDisplayed(inputUserName);
    }

    @FindBy(xpath = "//input[@placeholder='Password']")
    private WebElement inputPassword;

    public void checkIsInputPasswordVisible() {
        checkElementDisplayed(inputPassword);
    }

    public void checkIsInputPasswordNotVisible() {
        checkElementNotDisplayed(inputPassword);
    }
}
