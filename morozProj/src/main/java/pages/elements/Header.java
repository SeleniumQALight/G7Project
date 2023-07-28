package pages.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.ActionsWithElements;
import pages.CreatePostPage;

public class Header extends ActionsWithElements {
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

    public CreatePostPage clickOnButtonCreatePost(){
        clickOnElement(buttonCreatePost);
        return new CreatePostPage(webDriver);
    }
}
