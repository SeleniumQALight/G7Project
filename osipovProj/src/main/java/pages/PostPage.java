package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PostPage extends ParentPageWithHeader {
    @FindBy(xpath = "//div[@class='alert alert-success text-center']")
    WebElement successMessageElement;
    @FindBy(xpath = "//h2")
    WebElement postTitle;
    @FindBy(xpath = "//div[@class='body-content'][2]//p")
    WebElement postBody;
    @FindBy(xpath = "//p//i")
    WebElement selectedValueFromDropDown;
    @FindBy(xpath = "//div[not(@*)]//p")
    WebElement uniquePostMessage;
    @FindBy(xpath = ".//button[@class='delete-post-button text-danger']")
    private WebElement buttonDelete;

    public PostPage(WebDriver webDriver) {
        super(webDriver);
    }

    public PostPage checkIsRedirectToPostPage() {
        //TODO check url
        //TODO unique elements
        return this;
    }

    public PostPage checkIsSuccessMessageDisplayed() {
        checkElementDisplayed(successMessageElement);
        return this;
    }

    public PostPage checkTextInSuccessMessage(String text) {
        Assert.assertEquals("Text in message", text, successMessageElement.getText());
        return this;
    }

    public PostPage checkTitleIsMatchingWithCreatePostStep(String text) {
        Assert.assertEquals("Text in message", text, postTitle.getText());
        return this;
    }

    public PostPage checkBodyIsMatchingWithCreatePostStep(String text) {
        Assert.assertEquals("Text in message", text, postBody.getText());
        return this;
    }

    public PostPage checkPostIsPrivate(String text) {
        Assert.assertEquals("Text in message", text, selectedValueFromDropDown.getText());
        return this;
    }

    public PostPage checkPostIsUnique(String text) {
        Assert.assertEquals("Text in message", text, uniquePostMessage.getText());
        return this;
    }

    public MyProfilePage clickOnDeletePostButton() {
        clickOnElement(buttonDelete);
        return new MyProfilePage(webDriver);
    }
}
