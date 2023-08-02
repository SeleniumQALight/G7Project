package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PostPage extends ParentPageWithHeader{

    @FindBy(xpath = "//div[@class='alert alert-success text-center']")
    private WebElement successMessageElement;

    @FindBy(xpath = "//div//p[contains(text(),'yes')]")
    private WebElement postIsUnique;

    @FindBy(xpath = "//h2")
    private WebElement postTitle;

    @FindBy(xpath = "//div[@class = 'body-content'][2]")
    private WebElement postBody;

    @FindBy(xpath = "//div//u[contains(text(),'One Person')] ")
    private WebElement postNote;

    public PostPage(WebDriver webDriver) {
        super(webDriver);
    }

    public PostPage checkIsRedirectToPostPage() {
        //TODO check URL
        //TODO some unique element
        return this;
    }

    public PostPage checkIsSuccessMessageDisplayed() {
        checkElementIsDisplayed(successMessageElement);
        return this;
    }

    public PostPage checkTextInSuccessMessage(String text) {
        Assert.assertEquals("Text in message", text, successMessageElement.getText());
        logger.info("Success message is correct");
        return this;
    }

    public PostPage checkTextIsPostUnique(String text) {
        Assert.assertEquals("Text in message", text, postIsUnique.getText());
        logger.info("Post is unique");
        return this;
    }

    public PostPage checkTextPostTitle(String text) {
        Assert.assertEquals("Text in message", text, postTitle.getText());
        logger.info("Title is correct");
        return this;
    }

    public PostPage checkTextPostBody(String text) {
        Assert.assertEquals("Text in message", text, postBody.getText());
        logger.info("Body is correct");
        return this;
    }

    public PostPage checkNote (String text) {
        Assert.assertEquals("Text in message", text, postNote.getText());
        logger.info("Note is correct");
        return this;
    }

}
