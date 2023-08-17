package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditPostPage extends ParentPageWithHeader {
    public EditPostPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    protected String getRelativeUrl() {
        return "/post/[a-zA-Z0-9]*/edit";
    }

    @FindBy(xpath = "//a[@class=\"small font-weight-bold\"]")
    private WebElement buttonBack;

    @FindBy(xpath = "//input[@name='title' and @id='post-title']")
    private WebElement inputTitle;

    @FindBy(xpath = "//textarea[@name='body' and @id='post-body']")
    private WebElement inputBody;

    @FindBy(xpath = "//input[@type='checkbox']")
    private WebElement checkBoxUniquePost;

    @FindBy(xpath = "//select[@name='select1' and @id='select1']")
    private WebElement dropDownSelectValueGroup;

    @FindBy(xpath = "//button[@class='btn btn-primary']")
    private WebElement buttonSaveUpdates;

    @FindBy(xpath = "//div[@class='alert alert-success text-center']")
    private WebElement successMessageEditPost;

    public EditPostPage checkIsRedirectToEditPostPage() {
        checkUrlWithPattern();
        //TODO check some unique element
        return this;
    }

    public EditPostPage checkIsBackButtonDisplayed() {
        checkIsElementDisplayed(buttonBack);
        return this;
    }

    public EditPostPage enterTextInToInputTitle(String text) {
        enterTextIntoInput(inputTitle, text);
        return this;
    }

    public EditPostPage clickOnButtonSaveUpdates() {
        clickOnElement(buttonSaveUpdates);
        return new EditPostPage(webDriver);
    }

    public EditPostPage checkTextInSuccessMessageEditPost(String text) {
        Assert.assertEquals("Text in message", text, successMessageEditPost.getText());
        logger.info("Text in message is correct");
        return this;
    }

}






