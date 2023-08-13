package pages.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.ActionsWithElements;
import pages.CreatePostPage;
import pages.LoginPage;
import pages.MyProfilePage;

public class Header extends ActionsWithElements {
    @FindBy(xpath = "//button[text()='Sign Out']")
    private WebElement buttonSignOut;
    @FindBy(xpath = ".//a[@class='btn btn-sm btn-success mr-2']")
    private WebElement buttonCreatePost;
    @FindBy(xpath = "//img[@alt='My profile']")
    private WebElement buttonMyProfile;
    @FindBy (xpath = "//*[@class='text-white mr-2 header-search-icon']")
    private WebElement searchIcon;
    @FindBy (xpath = "//*[@class='text-white mr-2 header-chat-icon']")
    private WebElement chatIcon;
    @FindBy (xpath = "//*[@alt='My profile']")
    private WebElement avatar;


    public Header(WebDriver webDriver) {
        super(webDriver);
    }

    public void checkIsButtonSignOutVisible() {
        checkElementDisplay(buttonSignOut);
    }

    public CreatePostPage clickOnCreatePostButton() {
        clickOnElement(buttonCreatePost);
        return new CreatePostPage(webDriver);
    }

    public MyProfilePage clickOnMyProfileButton() {
        clickOnElement(buttonMyProfile);
        return new MyProfilePage(webDriver);
    }

    public LoginPage clickOnButtonSignOut() {
        clickOnElement(buttonSignOut);
        return new LoginPage(webDriver);
    }

    public boolean isButtonSignOutVisible() {
        return isElementDisplayed(buttonSignOut);
    }

    public void checkIsSearchIconVisible() {
        checkElementDisplay(searchIcon);
    }

    public void checkIsChatIconVisible() {
        checkElementDisplay(chatIcon);
    }

    public void checkIsAvatarVisible() {
        checkElementDisplay(avatar);
    }

    public void checkIsCreatePostButtonVisible() {
        checkElementDisplay(buttonCreatePost);
    }


    public void checkIsSearchIconAbsent() {
        checkElementAbsent(searchIcon);
    }
    public void checkIsChatIconAbsent() {
        checkElementAbsent(chatIcon);
    }
    public void checkIsAvatarAbsent () {
        checkElementAbsent(avatar);
    }
    public void checkIsCreatePostButtonAbsent () {
        checkElementAbsent(buttonCreatePost);
    }
}
