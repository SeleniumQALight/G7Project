package pages.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.ActionsWithElements;

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
    private WebElement linkCreatePost;

    @FindBy(xpath = "//button[text()='Sign Out']")
    private WebElement buttonSignOut;

    public Header(WebDriver webDriver) {
        super(webDriver);
    }

    public void checkIsButtonSignOutVisible() {
        checkElementDisplayed(buttonSignOut);
    }

    public void checkIsLinkSearchVisible() {
        checkElementDisplayed(linkSearch);
    }

    public void checkIsIconChatVisible() {
        checkElementDisplayed(iconChat);
    }

    public void checkIsLinkAvatarVisible() {
        checkElementDisplayed(linkAvatar);
    }

    public void checkIsTextUserNameVisible() {
        checkElementDisplayed(textUserName);
    }

    public void checkIsLinkCreatePostVisible() {
        checkElementDisplayed(linkCreatePost);
    }

    public void clickOnButtonSignOut() {
        clickOnElement(buttonSignOut);
    }

}


