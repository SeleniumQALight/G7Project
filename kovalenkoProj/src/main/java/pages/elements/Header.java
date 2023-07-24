package pages.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.ActionsWithElements;

public class Header extends ActionsWithElements {

    public Header(WebDriver webDriver) {
        super(webDriver);
    }
    @FindBy(xpath = "//button[text() = 'Sign Out']")
    private WebElement buttonSignOut;

    @FindBy(xpath = "//div[@class='flex-row my-3 my-md-0']//*[@data-icon='search']")
    private WebElement searchIcon;

    @FindBy(xpath = "//*[@data-icon='comment']")
    private WebElement chatIcon;

    @FindBy(xpath = "//span[@class='text-white mr-2']")
    private WebElement avatarIcon;

    @FindBy(xpath = "//a[@href='/create-post']")
    private WebElement buttonCreatePost;

    public void checkIsButtonSignOutVisible() {
        checkElementDisplayed(buttonSignOut);
    }
    public void checkIsButtonSignOutNotVisible() {
        checkElementNotDisplayed(buttonSignOut);
    }

    public void clickOnButtonSignOut() {
        clickOnElement(buttonSignOut);
    }

    public void checkIsSearchVisible() {
        checkElementDisplayed(searchIcon);
    }

    public void checkIsSearchNotVisible() {
        checkElementNotDisplayed(searchIcon);
    }

    public void checkIsChatVisible() {
        checkElementDisplayed(chatIcon);
    }

    public void checkIsChatNotVisible() {
        checkElementNotDisplayed(chatIcon);
    }

    public void checkIsAvatarVisible() {
        checkElementDisplayed(avatarIcon);
    }

    public void checkIsAvatarNotVisible() {
        checkElementNotDisplayed(avatarIcon);
    }

    public void checkIsCreatePostVisible() {
        checkElementDisplayed(buttonCreatePost);
    }

    public void checkIsCreatePostNotVisible() {
        checkElementNotDisplayed(buttonCreatePost);
    }

}
