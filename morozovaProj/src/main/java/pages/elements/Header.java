package pages.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.ActionsWithElements;
import pages.CreatePostPage;


public class Header extends ActionsWithElements {

    @FindBy(xpath = "//a[@class='text-white mr-2 header-search-icon']//*[@class='svg-inline--fa fa-search fa-w-16']")
    private WebElement searchIcon;

    @FindBy(xpath = "//span[@class=\"text-white mr-2 header-chat-icon\"]//*[@class=\"svg-inline--fa fa-comment fa-w-16\"]")
    private WebElement chatIcon;

    @FindBy(xpath = "//img[@alt='My profile']")
    private WebElement avatarIcon;

    @FindBy(xpath = "//button[text()= 'Sign Out']")
    private WebElement buttonSignOut;

    //button create post
    @FindBy(xpath = "//*[@class='btn btn-sm btn-success mr-2']")
    private WebElement buttonCreatePost;

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

    public void clickOnButtonSignOut() { clickOnElement(buttonSignOut); }

    public void checkIsButtonSignOutNotVisible() {
        checkElementNotDisplayed(buttonSignOut);
    }

    public void checkIsButtonSearchVisible() {checkElementDisplayed(searchIcon); }

    public void checkIsButtonSearchNotVisible() {
        checkElementNotDisplayed(searchIcon);
    }

    public void checkIsButtonChatVisible() {
        checkElementDisplayed(chatIcon);
    }

    public void checkIsButtonChatNotVisible() {
        checkElementNotDisplayed(chatIcon);
    }

    public void checkIsButtonAvatarVisible() {
        checkElementDisplayed(avatarIcon);
    }

    public void checkIsButtonAvatarNotVisible() {
        checkElementNotDisplayed(avatarIcon);
    }

    public void checkIsButtonCreatePostVisible() {
        checkElementDisplayed(buttonCreatePost);
    }

    public void checkIsButtonCreatePostNotVisible() {
        checkElementNotDisplayed(buttonCreatePost);
    }
}
