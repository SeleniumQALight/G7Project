package pages.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.ActionWithElements;
import pages.CreatePostPage;
import pages.MyProfilePage;

public class Header extends ActionWithElements {
    @FindBy(xpath = "//button[text()='Sign Out']")
    private WebElement buttonSignOut;
    @FindBy(xpath = "(//div[contains(@class, 'alert alert-danger text-center') and contains(text(), 'Invalid username  pasword')]")
    private WebElement invalidMessage;
    @FindBy(xpath = "//a[@href=\"/create-post\"]")
    private WebElement buttonCreatePost;
    @FindBy(xpath = "//a[contains(@href, '/profile/') and contains(@class, 'mr-2')]")
    private WebElement buttonProfile;
    @FindBy(xpath = "//span[contains( @class, 'text-white mr-2 header-chat-icon')]")
    private WebElement buttonChat;
    @FindBy(xpath = "//a[contains( @class, 'text-white mr-2 header-search-icon')]")
    private WebElement buttonSearch;
    @FindBy(xpath = "//a[contains(@class, 'text-white') and contains(text(), 'Complex app for testing - QA')]")
    private WebElement buttonLogo;

    @FindBy(xpath = "//img[@alt='My profile']")
    private WebElement buttonMyProfile;


    public Header(WebDriver webDriver) {
        super(webDriver);

    }

    public void checkIsButtonSignOutVisible() {
        checkElementDisplayed(buttonSignOut);
    }

    public void checkIsButtonSignOutNotVisible() {
        checkElementNotDisplayed(buttonSignOut);
    }

    public void checkIsMassageInvalidDisplayed() {
        checkElementNotDisplayed(invalidMessage);
    }


    public void checkIsButtonCreatePostVisible() {
        checkElementDisplayed(buttonCreatePost);
    }


    public void checkIsButtonCreatePostNotVisible() {
        checkElementNotDisplayed(buttonCreatePost);
    }

    public void checkIsButtonProfileVisible() {
        checkElementDisplayed(buttonProfile);
    }

    public void checkIsButtonProfileNotVisible() {
        checkElementNotDisplayed(buttonProfile);
    }

    public void checkIsButtonChatVisible() {
        checkElementDisplayed(buttonChat);
    }

    public void checkIsButtonChatNotVisible() {
        checkElementNotDisplayed(buttonChat);
    }

    public void checkIsButtonSearchVisible() {
        checkElementDisplayed(buttonSearch);
    }

    public void checkIsButtonSearchNotVisible() {
        checkElementNotDisplayed(buttonSearch);
    }

    public void checkIsButtonLogoVisible() {
        checkElementDisplayed(buttonLogo);
    }

    public void checkIsButtonLogoNotVisible() {
        checkElementNotDisplayed(buttonLogo);
    }

    public void clickOnButtonSignOut() {
        clickOnElement(buttonSignOut);
    }

    public CreatePostPage clickOnButtonCreatePost() {
        clickOnElement(buttonCreatePost);
        return new CreatePostPage(webDriver);
    }

    public MyProfilePage clickOnMyProfileButton() {
        clickOnElement(buttonMyProfile);
        return new MyProfilePage(webDriver);
        
    }

    public boolean IsButtonSignOutVisible() {
        return isElementDisplayed(buttonSignOut);
    }
}