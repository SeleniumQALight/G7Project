package pages.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.ActionsWithElements;
import pages.CreatePostPage;
import pages.LoginPage;

public class Header extends ActionsWithElements {

    @FindBy(xpath = "//*[@data-icon='search']")
    private WebElement searchButton;

    @FindBy(xpath = "//span[@data-original-title='Chat']")
    private WebElement chatButton;

    @FindBy(xpath = "//img[@alt='My profile']")
    private WebElement profileButton;


    @FindBy(xpath = "//button[text()='Sign Out']")
    private WebElement signOutButton;

    @FindBy(xpath = ".//a[@class='btn btn-sm btn-success mr-2']")
    private WebElement buttonCreatePost;
    public Header(WebDriver webDriver) {
        super(webDriver);
    }

    public void checkIsSignOutButtonVisible(){
        checkElementDisplayed(signOutButton);
    }

    public void checkIsSignOutButtonNotVisible(){
        checkElementNotDisplayed(signOutButton);
    }

    public LoginPage clickOnSignOutButton(){
        clickOnElement(signOutButton);
        return new LoginPage(webDriver);
    }


    public CreatePostPage clickOnButtonCreatePost(){
        clickOnElement(buttonCreatePost);
        return new CreatePostPage(webDriver);
    }

    public void checkButtonCreatePostVisible(){
        checkElementDisplayed(buttonCreatePost);
    }

    public void checkButtonCreatePostNotVisible(){
        checkElementNotDisplayed(buttonCreatePost);
    }


    public void checkSearchButtonVisible(){
        checkElementDisplayed(searchButton);
    }

    public void checkSearchButtonNotVisible(){
        checkElementNotDisplayed(searchButton);
    }

    public void checkChatButtonVisible(){
        checkElementDisplayed(chatButton);
    }

    public void checkChatButtonNotVisible(){
        checkElementNotDisplayed(chatButton);
    }

    public void checkProfileButtonVisible(){
        checkElementDisplayed(profileButton);
    }

    public void checkProfileButtonNotVisible(){
        checkElementNotDisplayed(profileButton);
    }




}
