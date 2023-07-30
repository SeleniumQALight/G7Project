package pages.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.ActionsWithElements;
import pages.CreatePostPage;

public class Header extends ActionsWithElements {
    @FindBy(xpath = "//button[text()='Sign Out']") // this is a locator
    private WebElement buttonSignOut;

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

    public void clickOnButtonSignOut() {
        clickOnElement(buttonSignOut);
    }

    public void checkIsButtonSearchVisible() {
        checkElementDisplayed(buttonSearch);
    }

    public void checkIsButtonSearchNotVisible() {
        checkElementNotDisplayed(buttonSearch);
    }

    public void checkIsButtonChatVisible() {
        checkElementDisplayed(buttonChat);
    }

    public void checkIsButtonChatNotVisible() {
        checkElementNotDisplayed(buttonChat);
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

}
