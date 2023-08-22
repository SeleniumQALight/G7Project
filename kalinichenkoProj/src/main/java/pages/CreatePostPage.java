package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.elements.commonCreatePostAndEditPost;
public class CreatePostPage extends commonCreatePostAndEditPost {

    @FindBy(xpath = "//button[text()='Save New Post']")
    private WebElement buttonSave;

    public CreatePostPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    protected String getRelativeUrl() {
        return "/create-post";
    }

    public CreatePostPage checkIsRedirectToCreatePostPage() {
        checkUrl();
        checkElementDisplay(buttonSave);
        getHeader().checkIsButtonSignOutVisible();
        return this;
    }

    public PostPage clickOnButtonSaveNewPost() {
        clickOnElement(buttonSave);
        return new PostPage(webDriver);
    }
}
