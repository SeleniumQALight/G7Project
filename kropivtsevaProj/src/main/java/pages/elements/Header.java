package pages.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.ActionsWithElements;
import pages.CreatePostPage;
import pages.MyProfilePage;

public class Header extends ActionsWithElements {

    @FindBy(xpath = ".//*[text()='Sign Out']")
    private WebElement buttonSignOut;

    @FindBy(xpath = ".//a[@class='text-white mr-2 header-search-icon']")
    private WebElement buttonSearch;

    @FindBy(xpath = ".//span[@class='text-white mr-2 header-chat-icon']")
    private WebElement buttonChat;

    @FindBy(xpath = ".//img[@alt='My profile']")
    private WebElement buttonProfile;

    @FindBy(xpath = ".//a[@class='btn btn-sm btn-success mr-2']")
    private WebElement buttonCreatePost;


    public Header(WebDriver webDriver) {
        super(webDriver);
    }

    public void checkIsButtonSignOutVisible() {
        checkElementDisplay(buttonSignOut);
    }

    public void checkIsButtonSignOutNotVisible() {
        checkElementNotDisplay(buttonSignOut);
    }

    public void checkIsButtonSearchVisible() {
        checkElementDisplay(buttonSearch);
    }

    public void checkIsButtonSearchNotVisible() {
        checkElementNotDisplay(buttonSearch);
    }

    public void checkIsButtonChatVisible() {
        checkElementDisplay(buttonChat);
    }

    public void checkIsButtonChatNotVisible() {
        checkElementNotDisplay(buttonChat);
    }

    public void checkIsButtonProfileVisible() {
        checkElementDisplay(buttonProfile);
    }

    public void checkIsButtonProfileNotVisible() {
        checkElementNotDisplay(buttonProfile);
    }

    public void checkIsButtonCreatePostVisible() {
        checkElementDisplay(buttonCreatePost);
    }

    public void checkIsButtonCreatePostNotVisible() {
        checkElementNotDisplay(buttonCreatePost);
    }

    public void clickOnButtonSignOut() {
        clickOnElement(buttonSignOut);
    }

public CreatePostPage clickOnButtonCreatePost() {
        clickOnElement(buttonCreatePost);
        return new CreatePostPage(webDriver);
    }


    public MyProfilePage clickOnMyProfileButton() {
        clickOnElement(buttonProfile);
        return new MyProfilePage(webDriver);
    }

    public boolean isButtonSignOutVisible() {
        return isElementDisplayed(buttonSignOut);
    }
}
