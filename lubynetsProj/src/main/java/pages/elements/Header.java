package pages.elements;

import io.qameta.allure.Step;
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
    @Step
    public void checkIsButtonSignOutVisible() {
        checkElementDisplayed(buttonSignOut);
    }
    @Step
    public void checkIsButtonSignOutNotVisible() {
        checkElementNotDisplayed(buttonSignOut);
    }
    @Step
    public void checkIsMassageInvalidDisplayed() {
        checkElementNotDisplayed(invalidMessage);
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
    public void checkIsButtonProfileVisible() {
        checkElementDisplayed(buttonProfile);
    }
    @Step
    public void checkIsButtonProfileNotVisible() {
        checkElementNotDisplayed(buttonProfile);
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
    public void checkIsButtonLogoVisible() {
        checkElementDisplayed(buttonLogo);
    }
    @Step
    public void checkIsButtonLogoNotVisible() {
        checkElementNotDisplayed(buttonLogo);
    }
    @Step
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
@Step
    public boolean IsButtonSignOutVisible() {
        return isElementDisplayed(buttonSignOut);
    }
@Step
    public void checkIsMyProfileVisible() {
        checkElementDisplayed(buttonMyProfile);
    }
}