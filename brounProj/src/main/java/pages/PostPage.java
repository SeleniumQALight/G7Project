package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PostPage extends ParentPageWithHeader {

    @FindBy(xpath = ".//div[@class='alert alert-success text-center']")
    private WebElement successMessageElement;
    @FindBy(xpath = ".//button[@class='delete-post-button text-danger']")
    private WebElement buttonDelete;


    @FindBy(tagName = "h2")
    private WebElement postTitle;

    @FindBy(xpath = "//div[@class='body-content'][2]")
    private WebElement postBody;

    @FindBy(tagName = "i")
    private WebElement postNote;

    @FindBy(xpath = "//p[text()='Is this post unique? : yes']")
    private WebElement postUnique;

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

    public PostPage checkIsPostTitleCorrect(String post_title) {
        Assert.assertEquals("Post title", post_title, postTitle.getText());
        return this;
    }

    public PostPage checkIsPostBodyCorrect(String post_body) {
        Assert.assertEquals("Post body", post_body, postBody.getText());
        return this;
    }

    public PostPage checkIsPostNoteCorrect(String post_note) {
        Assert.assertEquals("Post note", post_note, postNote.getText());
        return this;
    }

    public PostPage checkIsPostUniqueCorrect(String post_unique) {
        Assert.assertEquals("Post unique", post_unique, postUnique.getText());
        return this;
    }

    public MyProfilePage clickOnDeleteButton() {
        clickOnElement(buttonDelete);
        return new MyProfilePage(webDriver);
    }
}
