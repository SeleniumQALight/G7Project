package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditPostPage extends ParentPageWithHeader {
    @FindBy(xpath = "//input[@name='title']")
    WebElement postTitleForEdit;
    @FindBy(xpath = "//button[@class='btn btn-primary']")
    WebElement saveChangesButton;
    @FindBy(xpath = "//div[@class='alert alert-success text-center']")
    WebElement savedChangesSuccessfulMessage;

    public EditPostPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    protected String getRelativeUrl() {
        return "/post/[a-zA-Z0-9]*/edit";
    }

    public EditPostPage checkIsRedirectToEditPostPage() {
        checkUrlWithPattern();
        return this;
    }
    public EditPostPage editPostTitle(String newTitle) {
        enterTextIntoInput(postTitleForEdit, newTitle);
        return this;
    }

    public EditPostPage saveEditPostChanges() {
        clickOnElement(saveChangesButton);
        checkElementDisplayed(savedChangesSuccessfulMessage);
        return this;
    }
}
