package pages.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.ActionsWithElements;

public class Header extends ActionsWithElements {
    public Header(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = "//button[text()='Sign Out']")
    private WebElement buttonSignOut;

    @FindBy(xpath = "//a[@class='btn btn-sm btn-success mr-2']")
    private WebElement buttonCreatePost;

    @FindBy(xpath = "//span[@class='text-white mr-2']")
    private WebElement profileName;

    @FindBy(xpath = "//img[@alt='My profile']")
    private WebElement profileAvatar;

    @FindBy(xpath = "//span[@class='text-white mr-2 header-chat-icon']")
    private WebElement buttonChat;

    @FindBy(xpath = "//a[@class='text-white mr-2 header-search-icon']")
    private WebElement buttonSearch;

    @FindBy(xpath = "//a[@class='text-white']")
    private WebElement buttonHomePage;

    public void checkIsButtonSignOutVisible() {
        checkElementDisplay(buttonSignOut);
    }

    public void clickOnButtonSignOut() {
        clickOnElement(buttonSignOut);
    }

    public void checkIsButtonSignOutNotVisible() {
        isElementNotDisplayed(buttonSignOut);
    }

    public void checkIsButtonCreatePostVisible() {
        checkElementDisplay(buttonCreatePost);
    }

    public void checkIsButtonCreatePostNotVisible() {
        isElementNotDisplayed(buttonCreatePost);
    }

    public void checkIsProfileNameVisible() {
        checkElementDisplay(profileName);
    }

    public void checkIsProfileNameNotVisible() {
        isElementNotDisplayed(profileName);
    }

    public void checkIsProfileAvatarVisible() {
        checkElementDisplay(profileAvatar);
    }

    public void checkIsProfileAvatarNotVisible() {
        isElementNotDisplayed(profileAvatar);
    }

    public void checkIsButtonChatVisible() {
        checkElementDisplay(buttonChat);
    }

    public void checkIsButtonChatNotVisible() {
        isElementNotDisplayed(buttonChat);
    }

    public void checkIsButtonSearchVisible() {
        checkElementDisplay(buttonSearch);
    }

    public void checkIsButtonSearchNotVisible() {
        isElementNotDisplayed(buttonSearch);
    }

    public void checkIsButtonHomePageVisible() {
        checkElementDisplay(buttonHomePage);
    }
}
