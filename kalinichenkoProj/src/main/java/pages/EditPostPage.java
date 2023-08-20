package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.elements.commonCreatePostAndEditPost;

public class EditPostPage extends commonCreatePostAndEditPost  {
    public EditPostPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    protected String getRelativeUrl() {
        return "/post/[a-zA-Z0-9]*/edit";
    }

    public EditPostPage checkIsRedirectToEditPostPage() {
        checkUrlWithPattern();
        checkElementDisplay(buttonSaveUpdates);
        getHeader().checkIsButtonSignOutVisible();
        return this;
    }

    @FindBy(xpath = "//button[text()='Save Updates']")
    private WebElement buttonSaveUpdates;

    @FindBy(xpath = ".//div[@class='alert alert-success text-center']")
    private WebElement successUpdatePost;

    public PostPage clickOnButtonSaveUpdates() {
        clickOnElement(buttonSaveUpdates);
        return new PostPage(webDriver);
    }

    public EditPostPage isPostUpdatedDisplayed() {
        isElementDisplayed(successUpdatePost);
        return this;
    }

}
