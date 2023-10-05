package pages.elements;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.ActionsWithElements;
import pages.CreatePostPage;
import pages.MyProfilePage;

public class Header extends ActionsWithElements {
    @FindBy(xpath = "//button[text()='Sign Out']")
    private WebElement buttonSignOut;

    @FindBy(xpath = ".//a[@class='btn btn-sm btn-success mr-2']")
    private WebElement buttonCreatePost;

    @FindBy(xpath = "//img[@alt='My profile']")
    private WebElement buttonMyProfile;

    @FindBy(xpath = "//*[@class='text-white mr-2 header-search-icon']//*[@class='svg-inline--fa fa-search fa-w-16']")
    private WebElement buttonSearch;

    @FindBy(xpath = "//*[@class='svg-inline--fa fa-comment fa-w-16']//*[@fill='currentColor']")
    private WebElement buttonChat;

    @FindBy(xpath = "//*[@data-original-title='My Profile']")
    private WebElement buttonAvatar;

    public Header(WebDriver webDriver) {
        super(webDriver);
    }

    @Step
    public void checkIsButtonSignOutVisible() {
        checkElementDisplayed(buttonSignOut);
    }

    @Step
    public CreatePostPage clickOnButtonCreatePost() {
        clickOnElement(buttonCreatePost);
        return new CreatePostPage(webDriver);
    }

    public void checkIsButtonAvatarNotVisible() {
        checkElementNotDisplayed(buttonAvatar);
    }

    public void checkIsButtonCreatePostNotVisible() {
        checkElementNotDisplayed(buttonCreatePost);
    }

    public void checkIsButtonSignOutNotVisible() {
        checkElementNotDisplayed(buttonSignOut);
    }

    @Step
    public MyProfilePage clickOnMyProfileButton() {
        clickOnElement(buttonMyProfile);
        return new MyProfilePage(webDriver);
    }

    public void checkIsButtonAvatarVisible() {
        checkElementDisplayed(buttonAvatar);
    }

    public void checkIsButtonCreatePostVisible() {
        checkElementDisplayed(buttonCreatePost);
    }

    public void checkIsButtonChatNotVisible() {
        checkElementNotDisplayed(buttonChat);
    }


    public void checkIsButtonChatVisible() {
        checkElementDisplayed(buttonChat);
    }

    @Step
    public boolean isButtonSignOutVisible() {
        return isElementDisplayed(buttonSignOut);
    }

    @Step
    public void checkIsMyProfileVisible() {
        checkElementDisplayed(buttonMyProfile);
    }

    @Step
    public void checkIsButtonSearchVisible() {
        checkElementDisplayed(buttonSearch);
    }

    public void checkIsButtonSearchNotVisible() {
        checkElementNotDisplayed(buttonSearch);
    }


    public void clickOnButtonSignOut() {
        clickOnElement(buttonSignOut);

    }
}
