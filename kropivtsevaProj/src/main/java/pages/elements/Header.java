package pages.elements;

import io.qameta.allure.Step;
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

    @Step
    public void checkIsButtonSignOutVisible() {
        checkElementDisplay(buttonSignOut);
    }

    @Step
    public void checkIsButtonSignOutNotVisible() {
        checkElementNotDisplay(buttonSignOut);
    }

    @Step
    public void checkIsButtonSearchVisible() {
        checkElementDisplay(buttonSearch);
    }

    @Step
    public void checkIsButtonSearchNotVisible() {
        checkElementNotDisplay(buttonSearch);
    }

    @Step
    public void checkIsButtonChatVisible() {
        checkElementDisplay(buttonChat);
    }

    @Step
    public void checkIsButtonChatNotVisible() {
        checkElementNotDisplay(buttonChat);
    }

    @Step
    public void checkIsButtonProfileVisible() {
        checkElementDisplay(buttonProfile);
    }

    @Step
    public void checkIsButtonProfileNotVisible() {
        checkElementNotDisplay(buttonProfile);
    }

    @Step
    public void checkIsButtonCreatePostVisible() {
        checkElementDisplay(buttonCreatePost);
    }

    @Step
    public void checkIsButtonCreatePostNotVisible() {
        checkElementNotDisplay(buttonCreatePost);
    }

    @Step
    public void clickOnButtonSignOut() {
        clickOnElement(buttonSignOut);
    }

    @Step
    public CreatePostPage clickOnButtonCreatePost() {
        clickOnElement(buttonCreatePost);
        return new CreatePostPage(webDriver);
    }

    @Step
    public MyProfilePage clickOnMyProfileButton() {
        clickOnElement(buttonProfile);
        return new MyProfilePage(webDriver);
    }

    @Step
    public boolean isButtonSignOutVisible() {
        return isElementDisplayed(buttonSignOut);
    }
}
