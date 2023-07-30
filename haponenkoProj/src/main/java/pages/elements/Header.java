package pages.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.ActionsWithElements;
import pages.CreatePostPage;
import pages.LoginPage;

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
    private WebElement profileButton;

    @FindBy(xpath = "//a[@class = 'btn btn-sm btn-success mr-2']")
    private WebElement createPostButton;

    public void checkIsButtonSignOutVisible() {
        checkElementIsDisplayed(buttonSignOut);
    }

    public void checkIsSearchButtonVisible() {
        checkElementIsDisplayed(searchButton);
    }

    public void checkIsChatButtonVisible() {
        checkElementIsDisplayed(chatButton);
    }

    public void checkIsProfileAvatarButtonVisible() {
        checkElementIsDisplayed(profileButton);
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
        checkElementIsNotDisplayed(profileButton);
    }

    public void checkIsCreatePostButtonNotVisible() {
        checkElementIsNotDisplayed(createPostButton);
    }

    public void checkIsButtonSignOutNotVisible() {
        checkElementIsNotDisplayed(buttonSignOut);
    }

    public CreatePostPage clickOnButtonCreatePost(){
        clickOnElement(createPostButton);
        return new CreatePostPage(webDriver);
    }
}
