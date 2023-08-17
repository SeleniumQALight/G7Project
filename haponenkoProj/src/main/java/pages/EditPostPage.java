package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditPostPage extends ParentPageWithHeader{
    public EditPostPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    protected String getRelativeUrl() {
        return "/post/[a-zA-Z0-9]*/edit";
    }

    @FindBy(xpath = ".//a[@class='small font-weight-bold']")
    private WebElement buttonBack;

    @FindBy(xpath = "//button[text()='Save Updates']")
    private WebElement buttonSaveUpdates;

    @FindBy(id = "post-title") // xpath = //*[@id='post-title']
    private WebElement inputTitle;

    @FindBy(xpath = "//div[@class='alert alert-success text-center']")
    private WebElement successMessageEditedPost;

    public EditPostPage checkIsRedirectToEditPostPage() {
        checkUrlWithPattern();
        //TODO some unique element
        return this;
    }

    public EditPostPage checkIsBackButtonDisplayed() {
        checkElementIsDisplayed(buttonBack);
        return this;
    }

    public EditPostPage enterTextIntoInputTitle(String title) {
        enterTextIntoInput(inputTitle, title);
        return this;
    }

    public EditPostPage clickOnButtonSaveEditedPost() {
        clickOnElement(buttonSaveUpdates);
        return new EditPostPage(webDriver);
    }

    public EditPostPage checkTextInSuccessMessage(String text) {
        Assert.assertEquals("Text in message", text, successMessageEditedPost.getText());
        logger.info("Success message is correct");
        return this;
    }

}