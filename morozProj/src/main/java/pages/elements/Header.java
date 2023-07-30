package pages.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.ActionsWithElements;
import pages.CreatePostPage;

public class Header extends ActionsWithElements {

    @FindBy(xpath = "//div[text()='Invalid username / pasword']")
    private WebElement loginValidation;

    @FindBy(xpath = "//button[text()='Sign In']")
    private WebElement signInButton;

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

    public CreatePostPage clickOnButtonCreatePost(){
        clickOnElement(buttonCreatePost);
        return new CreatePostPage(webDriver);
    }

    public void checkIsSignInButtonVisible(){
        checkElementDisplayed(signInButton);
    }

    public void checkIsLoginValidationDisplayed(){
        checkElementDisplayed(loginValidation);
    }


}
