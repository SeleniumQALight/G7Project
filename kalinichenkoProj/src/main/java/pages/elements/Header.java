package pages.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.ActionsWithElements;
import pages.CreatePostPage;
import pages.MyProfilePage;

public class Header extends ActionsWithElements {
    public Header (WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = "//button[text()='Sign Out']")
    private WebElement buttonSignOut;

    @FindBy(xpath = "//a[@class='text-white']")
    private WebElement homePageButton;

    @FindBy(xpath = "//a[@class='btn btn-sm btn-success mr-2']")
    private WebElement addNewPostButton;

    @FindBy(xpath = "//span[@class='text-white mr-2']")
    private WebElement userName;

    @FindBy(xpath = "//a[@class='mr-2']")
    private WebElement buttonMyProfile;

    @FindBy(xpath = "//span[@class='text-white mr-2 header-chat-icon']")
    private WebElement chatIcon;

    @FindBy(xpath = "//a[@class='text-white mr-2 header-search-icon']")
    private WebElement searchIcon;


    public void checkIsButtonSignOutVisible() {
        checkElementDisplay(buttonSignOut);
    }

    public void checkIsButtonSignOutNotVisible() {
        checkElementNotDisplay(buttonSignOut);
    }

    public void clickOnButtonSignOut() {
        clickOnElement(buttonSignOut);
    }

    public void checkHomePageButtonVisible() {
        checkElementDisplay(homePageButton);
    }

    public void checkAddNewPostButtonVisible() {
        checkElementDisplay(addNewPostButton);
    }

    public void checkAddNewPostButtonNotVisible() {
        checkElementNotDisplay(addNewPostButton);
    }


    public void checkUserNameVisible() {
        checkElementDisplay(userName);
    }

    public void checkUserNameNotVisible() {
        checkElementNotDisplay(userName);
    }


    public void checkUserIconVisible() {
        checkElementDisplay(buttonMyProfile);
    }

    public void checkUserIconNotVisible() {
        checkElementNotDisplay(buttonMyProfile);
    }


    public void checkChatIconVisible() {
        checkElementDisplay(chatIcon);
    }

    public void checkChatIconNotVisible() {
        checkElementNotDisplay(chatIcon);
    }


    public void checkSearchIconVisible() {
        checkElementDisplay(searchIcon);
    }

    public void checkSearchIconNotVisible() {
        checkElementNotDisplay(searchIcon);
    }
    public CreatePostPage clickOnButtonCreatePost() {
        clickOnElement(addNewPostButton);
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
