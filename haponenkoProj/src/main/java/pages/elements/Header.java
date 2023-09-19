package pages.elements;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.ActionsWithElements;
import pages.CreatePostPage;
import pages.MyProfilePage;

public class Header extends ActionsWithElements {


    public Header(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = "//button[text()='Sign Out']")
    private WebElement buttonSignOut;

    @FindBy(xpath = "//a//*[@class = 'svg-inline--fa fa-search fa-w-16']")
    private WebElement searchButton;

    @FindBy(xpath = "//*[@class = 'svg-inline--fa fa-comment fa-w-16']")
    private WebElement chatButton;

    @FindBy(xpath = "//a[@class = 'mr-2']")
    private WebElement buttonMyProfile;

    @FindBy(xpath = "//a[@class = 'btn btn-sm btn-success mr-2']")
    private WebElement createPostButton;

    @Step
    public void checkIsButtonSignOutVisible() {
        checkElementIsDisplayed(buttonSignOut);
    }

    @Step
    public void checkIsSearchButtonVisible() {
        checkElementIsDisplayed(searchButton);
    }

    @Step
    public void checkIsChatButtonVisible() {
        checkElementIsDisplayed(chatButton);
    }

    @Step
    public void checkIsButtonProfileAvatarVisible() {
        checkElementIsDisplayed(buttonMyProfile);
    }

    public void checkIsCreatePostButtonVisible() {
        checkElementIsDisplayed(createPostButton);
    }

    public void clickOnButtonSignOut() {
        clickOnElement(buttonSignOut);
    }

    public void checkIsSearchButtonNotVisible() {
        checkElementIsNotDisplayed(searchButton);
    }

    public void checkIsChatButtonNotVisible() {
        checkElementIsNotDisplayed(chatButton);
    }

    public void checkIsProfileAvatarButtonNotVisible() {
        checkElementIsNotDisplayed(buttonMyProfile);
    }

    public void checkIsCreatePostButtonNotVisible() {
        checkElementIsNotDisplayed(createPostButton);
    }

    public void checkIsButtonSignOutNotVisible() {
        checkElementIsNotDisplayed(buttonSignOut);
    }

    @Step
    public CreatePostPage clickOnButtonCreatePost(){
        clickOnElement(createPostButton);
        return new CreatePostPage(webDriver);
    }

    public MyProfilePage clickOnMyProfileButton() {
        clickOnElement(buttonMyProfile);
        return new MyProfilePage(webDriver);
    }

    public boolean isButtonSignOutVisible() {
        return isElementDisplayed(buttonSignOut);
    }
}
