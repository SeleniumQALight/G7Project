package pages.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.ActionsWithElements;
import pages.CreatePostPage;

public class Header extends ActionsWithElements {

    @FindBy(xpath = "//a[@class='text-white mr-2 header-search-icon']")
    private WebElement linkSearch;

    @FindBy(xpath = "//span[@class='text-white mr-2 header-chat-icon']")
    private WebElement iconChat;

    @FindBy(xpath = "//a[@class=\"mr-2\"]")
    private WebElement linkAvatar;

    @FindBy(xpath = "//span[@class='text-white mr-2']")
    private WebElement textUserName;

    @FindBy(xpath = "//a[@class='btn btn-sm btn-success mr-2']")
    private WebElement buttonCreatePost;

    @FindBy(xpath = "//button[text()='Sign Out']")
    private WebElement buttonSignOut;

    public Header(WebDriver webDriver) {
        super(webDriver);
    }

    public void checkIsButtonSignOutVisible() {
        checkIsElementDisplayed(buttonSignOut);
    }

    public void checkIsLinkSearchVisible() {
        checkIsElementDisplayed(linkSearch);
    }

    public void checkIsIconChatVisible() {
        checkIsElementDisplayed(iconChat);
    }

    public void checkIsLinkAvatarVisible() {
        checkIsElementDisplayed(linkAvatar);
    }

    public void checkIsTextUserNameVisible() {
        checkIsElementDisplayed(textUserName);
    }

    public void checkIsLinkCreatePostVisible() {
        checkIsElementDisplayed(buttonCreatePost);
    }

    public void clickOnButtonSignOut() {
        clickOnElement(buttonSignOut);
    }

    public void checkIsLinkSearchNotVisible() {
        checkIsElementNotDisplayed(linkSearch);
    }

    public void checkIsIconChatNotVisible() {
        checkIsElementNotDisplayed(iconChat);
    }

    public void checkIsLinkAvatarNotVisible() {
        checkIsElementNotDisplayed(linkAvatar);
    }

    public void checkIsTextUserNameNotVisible() {
        checkIsElementNotDisplayed(textUserName);
    }

    public void checkIsLinkCreatePostNotVisible() {
        checkIsElementNotDisplayed(buttonCreatePost);
    }

    public void checkIsButtonSignOutNotVisible() {
        checkIsElementNotDisplayed(buttonSignOut);
    }

    public CreatePostPage clickOnButtonCreatePost() {
        clickOnElement(buttonCreatePost);
        return new CreatePostPage(webDriver);
    }

}


