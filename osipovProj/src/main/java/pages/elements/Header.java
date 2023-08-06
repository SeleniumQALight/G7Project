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
    @FindBy(xpath = "//a[@class='text-white mr-2 header-search-icon']")
    private WebElement searchIcon;
    @FindBy(xpath = "//span[@class='text-white mr-2 header-chat-icon']")
    private WebElement chatIcon;
    @FindBy(xpath = "//img[@alt='My profile']")
    private WebElement profileIcon;
    @FindBy(xpath = "//a[text()='Create Post']")
    private WebElement buttonCreatePost;

    public Header(WebDriver webDriver) {
        super(webDriver);
    }

    public void checkIsButtonSignOutVisible() {
        checkElementDisplayed(buttonSignOut);
    }

    public void checkIsButtonSignOutNotVisible() {
        checkElementIsNotDisplayed(buttonSignOut);
    }

    public void clickOnButtonSignOut() {
        clickOnElement(buttonSignOut);
    }

    public void checkIsSearchIconDisplayed() {
        checkElementDisplayed(searchIcon);
    }

    public void checkIsSearchIconNotDisplayed() {
        checkElementIsNotDisplayed(searchIcon);
    }

    public void checkIsChatIconDisplayed() {
        checkElementDisplayed(chatIcon);
    }

    public void checkIsChatIconNotDisplayed() {
        checkElementIsNotDisplayed(chatIcon);
    }

    public void checkIsProfileIconDisplayed() {
        checkElementDisplayed(profileIcon);
    }

    public void checkIsProfileIconNotDisplayed() {
        checkElementIsNotDisplayed(profileIcon);
    }

    public void checkIsButtonCreatePostDisplayed() {
        checkElementDisplayed(buttonCreatePost);
    }

    public void checkIsButtonCreatePostNotDisplayed() {
        checkElementIsNotDisplayed(buttonCreatePost);
    }

    public CreatePostPage clickOnButtonCreatePost() {
        clickOnElement(buttonCreatePost);
        return new CreatePostPage(webDriver);
    }

    public MyProfilePage clickOnMyProfileButton() {
        clickOnElement(profileIcon);
        return new MyProfilePage(webDriver);
    }

    public boolean isButtonSignOutVisible() {
        return isElementDisplayed(buttonSignOut);
    }
}
