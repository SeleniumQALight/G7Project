package pages.elements;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.ActionsWithElements;
import pages.CreatePostPage;
import pages.MyProfilePage;

public class Header extends ActionsWithElements {

    @FindBy(xpath = "//a[@class='text-white mr-2 header-search-icon']")
    private WebElement linkSearch;

    @FindBy(xpath = "//span[@class='text-white mr-2 header-chat-icon']")
    private WebElement iconChat;

    @FindBy(xpath = "//a[@class=\"mr-2\"]")
    private WebElement buttonMyProfile;

    @FindBy(xpath = "//span[@class='text-white mr-2']")
    private WebElement textUserName;

    @FindBy(xpath = "//a[@class='btn btn-sm btn-success mr-2']")
    private WebElement buttonCreatePost;

    @FindBy(xpath = "//button[text()='Sign Out']")
    private WebElement buttonSignOut;

    public Header(WebDriver webDriver) {
        super(webDriver);
    }
    @Step
    public void checkIsButtonSignOutVisible() {
        checkIsElementDisplayed(buttonSignOut);
    }
    @Step
    public void checkIsLinkSearchVisible() {
        checkIsElementDisplayed(linkSearch);
    }
    @Step
    public void checkIsIconChatVisible() {
        checkIsElementDisplayed(iconChat);
    }
    @Step
    public void checkIsLinkAvatarVisible() {
        checkIsElementDisplayed(buttonMyProfile);
    }
    @Step
    public void checkIsTextUserNameVisible() {
        checkIsElementDisplayed(textUserName);
    }
    @Step
    public void checkIsLinkCreatePostVisible() {
        checkIsElementDisplayed(buttonCreatePost);
    }
    @Step
    public void clickOnButtonSignOut() {
        clickOnElement(buttonSignOut);
    }
    @Step
    public void checkIsLinkSearchNotVisible() {
        checkIsElementNotDisplayed(linkSearch);
    }
    @Step
    public void checkIsIconChatNotVisible() {
        checkIsElementNotDisplayed(iconChat);
    }
    @Step
    public void checkIsLinkAvatarNotVisible() {
        checkIsElementNotDisplayed(buttonMyProfile);
    }
    @Step
    public void checkIsTextUserNameNotVisible() {
        checkIsElementNotDisplayed(textUserName);
    }
    @Step
    public void checkIsLinkCreatePostNotVisible() {
        checkIsElementNotDisplayed(buttonCreatePost);
    }
    @Step
    public void checkIsButtonSignOutNotVisible() {
        checkIsElementNotDisplayed(buttonSignOut);
    }
    @Step
    public CreatePostPage clickOnButtonCreatePost() {
        clickOnElement(buttonCreatePost);
        return new CreatePostPage(webDriver);
    }
    @Step
    public MyProfilePage clickOnMyProfileButton() {
        clickOnElement(buttonMyProfile);
        return new MyProfilePage(webDriver);

    }
    @Step
    public boolean isButtonSignOutVisible() {
        return isElementDisplayed(buttonSignOut);
    }
}


