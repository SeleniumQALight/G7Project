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

    @FindBy(xpath = "//a[@class='text-white mr-2 header-search-icon']//*[@class='svg-inline--fa fa-search fa-w-16']")
    private WebElement buttonSearch;

    @FindBy(xpath = "//span[@class=\"text-white mr-2 header-chat-icon\"]//*[@class=\"svg-inline--fa fa-comment fa-w-16\"]")
    private WebElement buttonChat;

    @FindBy(xpath = "//*[@data-original-title=\"My Profile\"]")
    private WebElement buttonAvatar;

    @FindBy(xpath = "//a[@class=\"btn btn-sm btn-success mr-2\"]")
    private WebElement buttonCreatePost;

    public Header(WebDriver webDriver) {
        super(webDriver);
    }

    //actions
    public void clickOnButtonSignOut() {
        clickOnElement(buttonSignOut);
    }

    public CreatePostPage clickOnButtonCreatePost() {
        clickOnElement(buttonCreatePost);
        return new CreatePostPage(webDriver);
    }

    //checks
    @Step
    public void checkIsButtonSignOutVisible() {
        checkElementDisplayed(buttonSignOut);
    }

    public void checkIsButtonSignOutNotVisible() {
        checkElementNotDisplayed(buttonSignOut);
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

    public void checkIsButtonAvatarVisible() {
        checkElementDisplayed(buttonAvatar);
    }

    public void checkIsButtonAvatarNotVisible() {
        checkElementNotDisplayed(buttonAvatar);
    }

    public void checkIsButtonCreatePostVisible() {
        checkElementDisplayed(buttonCreatePost);
    }

    public void checkIsButtonCreatePostNotVisible() {
        checkElementNotDisplayed(buttonCreatePost);
    }

    public MyProfilePage clickOnMyProfileButton() {
        clickOnElement(buttonAvatar);
        return new MyProfilePage(webDriver);
    }

    public boolean isButtonSignOutVisible() {
        return isElementDisplayed(buttonSignOut);
    }
}
