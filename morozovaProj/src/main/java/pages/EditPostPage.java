package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
public class EditPostPage extends PostPage {

    @FindBy(xpath = ".//input [@name=\"title\"]")
    private WebElement titleEdit;

    @FindBy(xpath = ".//textarea [@name=\"body\"]")
    private WebElement bodyEdit;

    @FindBy(xpath = ".//button [@class=\"btn btn-primary\"]")
    private WebElement saveUpdates;

    @FindBy(tagName = "select")
    private WebElement dropDownSelectValueEdit;

    @FindBy(xpath = "//input[@type=\"checkbox\"]")
    private WebElement postUniqueEdit;

    @FindBy(xpath = ".//div[@class='alert alert-success text-center']")
    private WebElement successMessageEditPost;

    public EditPostPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    protected String getRelativeUrl() {
        return "/post/[a-zA-Z0-9]*";
    }

    public EditPostPage checkIsRedirectToPostPage() {
        //TODO check url
        //TODO unique elements
        return this;
    }

    public PostPage checkIsSuccessMessageDisplayed() {
        checkElementDisplayed(successMessageEditPost);
        return this;
    }

    public PostPage checkTextInSuccessMessage(String text) {
        Assert.assertEquals("Text in message", text, successMessageEditPost.getText());
        return this;
    }

    public EditPostPage checkIsPostTitleCorrect(String post_title) {
        Assert.assertEquals("Post title", post_title, titleEdit.getText());
        return this;
    }

    public EditPostPage checkIsPostBodyCorrect(String post_body) {
        Assert.assertEquals("Post body", post_body, bodyEdit.getText());
        return this;
    }


    public EditPostPage checkIsPostUniqueCorrect(String post_unique) {
        Assert.assertEquals("Post unique", post_unique, postUniqueEdit.getText());
        return this;
    }

    public EditPostPage enterTextIntoInputTitle(String title) {
        enterTextIntoInput(titleEdit, title);
        return this;
    }

    public EditPostPage clickOnButtonSaveUpdates() {
        clickOnElement(saveUpdates);
        return this;
    }

    public EditPostPage checkIsMessageSuccessEditPost() {
        Assert.assertTrue("Message is not displayed", isElementDisplayed(successMessageEditPost));
        return this;
    }

}
