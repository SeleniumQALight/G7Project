package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PostPage  extends ParentPageWithHeader{

    @FindBy(xpath = ".//div[@class='alert alert-success text-center']")
    private WebElement successMessageElement;

    @FindBy(xpath = "//div/p[text()='Is this post unique? : yes']")
    private WebElement uniquePostMessage;

    @FindBy(xpath = "//div[@class='body-content'][2]//p")
    private WebElement postBody;

    @FindBy(xpath = "//div[@class='d-flex justify-content-between']")
    private WebElement postTitle;

    @FindBy(xpath = "//div[@class='body-content'][1]//p")
    private WebElement postPrivate;

    @FindBy(xpath = ".//button[@class='delete-post-button text-danger']")
    private WebElement buttonDeletePost;

    public PostPage(WebDriver webDriver) {
        super(webDriver);
    }

    public PostPage checkIsRedirectToPostPage() {
        //TODO CHECK URL
        //TODO UNIQUE ELEMENT
        return this;
    }

    public PostPage checkIsSuccessMessageDisplayed() {
        checkElementDisplay(successMessageElement);
        return this;
    }

    public PostPage checkTextInSuccessMessage(String text) {
        Assert.assertEquals("Text in message", text, successMessageElement.getText());
        return this;
    }

    public PostPage checkIsPostUnique (String text) {
        Assert.assertEquals("Text in message", text, uniquePostMessage.getText());
        return this;
    }

    public PostPage checkIsPostBodyDisplayed (String text) {
        Assert.assertEquals("Text in message", text, postBody.getText());
        return this;
    }

    public PostPage checkIsPostTitleDisplayed (String text) {
        Assert.assertEquals("Text in message", text, postTitle.getText());
        return this;
    }

    public PostPage checkIsPostPrivate(String text) {
        Assert.assertEquals("Text in message", text, postPrivate.getText());
        return this;
    }

    public MyProfilePage clickOnDeletePostButton() {
        clickOnElement(buttonDeletePost);
        return new MyProfilePage(webDriver);
    }
}
