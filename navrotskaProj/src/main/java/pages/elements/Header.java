package pages.elements;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.ActionsWithElements;
import pages.CreatePostPage;
import pages.MyProfilePage;

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
    @Step
    public void checkIsButtonSignOutVisible() {
        checkElementDisplayed(buttonSignOut);
    }
    @Step
    public void clickOnButtonSignOut() {
        clickOnElement(buttonSignOut);
    }
    @Step
    public void checkIsButtonSignOutNotVisible() {
        checkElementNotDisplayed(buttonSignOut);
    }
    @Step
    public void checkIsButtonChatVisible() {
        checkElementDisplayed(buttonChat);
    }
    @Step
    public void checkIsButtonChatNotVisible() {
        checkElementNotDisplayed(buttonChat);
    }
    @Step
    public void checkIsButtonSearchVisible() {
        checkElementDisplayed(buttonSearch);
    }
    @Step
    public void checkIsButtonSearchNotVisible() {
        checkElementNotDisplayed(buttonSearch);
    }
    @Step
    public void checkIsButtonMyProfileVisible() {
        checkElementDisplayed(buttonMyProfile);
    }
    @Step
    public void checkIsButtonMyProfileNotVisible() {
        checkElementNotDisplayed(buttonMyProfile);
    }
    @Step
    public void checkIsButtonCreatePostVisible() {
        checkElementDisplayed(buttonCreatePost);
    }
    @Step
    public void checkIsButtonCreatePostNotVisible() {
        checkElementNotDisplayed(buttonCreatePost);
    }
    @Step
    public CreatePostPage clickOnButtonCreatePost() {
        clickOnElement(buttonCreatePost);
        return new CreatePostPage(webDriver);
    }

    public MyProfilePage clickOnMyProfileButton() {
        clickOnElement(buttonMyProfile);
        return new MyProfilePage(webDriver);
    }
    public boolean isButtonSignOutVisible(){
        return isElementDisplayed(buttonSignOut);
    }
}
