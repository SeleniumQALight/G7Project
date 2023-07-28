package pages.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.ActionsWithElements;

public class Header extends ActionsWithElements {
    public Header(WebDriver webDriver) {
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
    private WebElement userIcon;

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

    public void isHomePageButtonVisible() {
        checkElementDisplay(homePageButton);
    }

    public void isAddNewPostButtonVisible() {
        checkElementDisplay(addNewPostButton);
    }

    public void isAddNewPostButtonNotVisible() {
        checkElementNotDisplay(addNewPostButton);
    }


    public void isUserNameVisible() {
        checkElementDisplay(userName);
    }

    public void isUserNameNotVisible() {
        checkElementNotDisplay(userName);
    }


    public void isUserIconVisible() {
        checkElementDisplay(userIcon);
    }

    public void isUserIconNotVisible() {
        checkElementNotDisplay(userIcon);
    }


    public void isChatIconVisible() {
        checkElementDisplay(chatIcon);
    }

    public void isChatIconNotVisible() {
        checkElementNotDisplay(chatIcon);
    }


    public void isSearchIconVisible() {
        checkElementDisplay(searchIcon);
    }

    public void isSearchIconNotVisible() {
        checkElementNotDisplay(searchIcon);
    }
}
