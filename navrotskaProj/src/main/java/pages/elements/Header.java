package pages.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.ActionsWithElements;
import pages.CreatePostPage;
import pages.LoginPage;

public class Header extends ActionsWithElements {
    @FindBy(xpath = "//*[text()='Sign Out']")
    private WebElement buttonSignOut;

    @FindBy(xpath = "//a[1]//*[name()='svg']")
    private WebElement buttonSearch;

    @FindBy(xpath = "(//*[name()='svg'][1])[2]")
    private WebElement buttonChat;

    @FindBy(xpath = "//img[@alt='My profile']")
    private WebElement buttonMyProfile;

    @FindBy(xpath = "//a[text()='Create Post']")
    private WebElement buttonCreatePost;


    public Header(WebDriver webDriver) {
        super(webDriver);
    }

    public void checkIsButtonSignOutVisible() {
        checkElementDisplayed(buttonSignOut);
    }

    public void clickOnButtonSignOut() {
        clickOnElement(buttonSignOut);
    }

    public void checkIsButtonSignOutNotVisible() {
        checkElementNotDisplayed(buttonSignOut);
    }

    public void checkIsButtonChatVisible() {
        checkElementDisplayed(buttonChat);
    }

    public void checkIsButtonChatNotVisible() {
        checkElementNotDisplayed(buttonChat);
    }

    public void checkIsButtonSearchVisible() {
        checkElementDisplayed(buttonSearch);
    }

    public void checkIsButtonSearchNotVisible() {
        checkElementNotDisplayed(buttonSearch);
    }

    public void checkIsButtonMyProfileVisible() {
        checkElementDisplayed(buttonMyProfile);
    }

    public void checkIsButtonMyProfileNotVisible() {
        checkElementNotDisplayed(buttonMyProfile);
    }

    public void checkIsButtonCreatePostVisible() {
        checkElementDisplayed(buttonCreatePost);
    }

    public void checkIsButtonCreatePostNotVisible() {
        checkElementNotDisplayed(buttonCreatePost);
    }

    public CreatePostPage clickOnButtonCreatePost() {
        clickOnElement(buttonCreatePost);
        return new CreatePostPage(webDriver);
    }

    public void logout() {
        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.openLoginPage();
        clickOnButtonSignOut();
    }
}
