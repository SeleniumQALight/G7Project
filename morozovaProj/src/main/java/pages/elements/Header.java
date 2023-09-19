package pages.elements;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.ActionsWithElements;
import pages.CreatePostPage;
import pages.MyProfilePage;

public class Header extends ActionsWithElements {
    @FindBy(xpath = "//img[@alt='My profile']")
    private WebElement profileButton;

    @FindBy(xpath = "//a[@class='text-white mr-2 header-search-icon']//*[@class='svg-inline--fa fa-search fa-w-16']")
    private WebElement searchIcon;

    @FindBy(xpath = "//span[@class=\"text-white mr-2 header-chat-icon\"]//*[@class=\"svg-inline--fa fa-comment fa-w-16\"]")
    private WebElement chatIcon;

//    @FindBy(xpath = "//img[@alt='My profile']")
//    private WebElement avatarIcon;

    @FindBy(xpath = "//button[text()= 'Sign Out']")
    private WebElement buttonSignOut;

    //button create post
    @FindBy(xpath = "//*[@class='btn btn-sm btn-success mr-2']")
    private WebElement buttonCreatePost;

    @FindBy(xpath = "//*[@data-original-title='My Profile']") //
    private WebElement buttonMyProfile;

    public Header(WebDriver webDriver) {
        super(webDriver);
    }

    public void checkIsButtonSignOutVisible() {
        checkElementDisplayed(buttonSignOut);
    }

    public CreatePostPage clickOnButtonCreatePost() {
        clickOnElement(buttonCreatePost);
        return new CreatePostPage(webDriver);
    }

    public void clickOnButtonSignOut() {
        clickOnElement(buttonSignOut);
    }

    public void checkIsButtonSignOutNotVisible() {
        checkElementNotDisplayed(buttonSignOut);
    }

    public void checkIsButtonSearchVisible() {
        checkElementDisplayed(searchIcon);
    }

    public void checkIsButtonSearchNotVisible() {
        checkElementNotDisplayed(searchIcon);
    }

    public void checkIsButtonChatVisible() {
        checkElementDisplayed(chatIcon);
    }

    public void checkIsButtonChatNotVisible() {
        checkElementNotDisplayed(chatIcon);
    }

    @Step
    public void checkIsMyProfileVisible() {
        checkElementDisplayed(profileButton);
    }

    public void checkIsButtonAvatarNotVisible() {
        checkElementNotDisplayed(profileButton);
    }

    public void checkIsButtonCreatePostVisible() {
        checkElementDisplayed(buttonCreatePost);
    }

    public void checkIsButtonCreatePostNotVisible() {
        checkElementNotDisplayed(buttonCreatePost);
    }

    public MyProfilePage clickOnMyProfileButton() {
        clickOnElement(buttonMyProfile);
        return new MyProfilePage(webDriver);
    }

    public boolean IsButtonSignOutVisible() {
        return isElementDisplayed(buttonSignOut);
    }
}
