package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PostPage extends ParentPageWithHeader {
    @FindBy(xpath = ".//div[@class='alert alert-success text-center']")
    private WebElement successMessageElement;

    @FindBy(xpath = "//input[@id='post-title']")
    private WebElement postTitle;

    @FindBy(xpath = "//textarea[@id='post-body']")
    private WebElement postBody;

    @FindBy(tagName = "select")
    private WebElement dropDownSelectValue;

    @FindBy(xpath = "//i[contains(text(), 'Note: This post was written for ')]/u[contains(text(), 'One Person')]")
    private WebElement noteMessage;

    @FindBy(xpath = "//i[contains(text(), 'Note: This post was written for ')]")
    private WebElement afterNoteMessage;

    @FindBy(xpath = "//p[contains(text(), 'Is this post unique? : yes')]")
    private WebElement uniquePostMessage;

    @FindBy(xpath = "//p[contains(text(), 'Is this post unique? : no')]")
    private WebElement negativeUniquePostMessage;
    @FindBy(xpath = "//button[text()='Save New Post']")
    private WebElement buttonSave;



    @FindBy (xpath = ".//button[@class='delete-post-button text-danger']")
    private WebElement buttonDelete;


    public PostPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    protected String getRelativeUrl() {
        return "/post/[a-zA-Z0-9]*";
    }

    public PostPage checkIsRedirectOnPostPage() {
        checkUrlWithPattern();
        // TODO SOME UNIQUE ELEMENT
        return this;
    }

    public PostPage checkIsSuccessMessageDisplayed() {
        checkElementDisplayed(successMessageElement);
        return this;
    }

    public String getPostTitleText() {
        return postTitle.getText();
    }

    public WebElement getDropDownSelectValue() {
        return dropDownSelectValue;
    }

    public String getPostBodyText() {
        return postBody.getText();
    }

    public String getNoteMessageText() {
        return noteMessage.getText();
    }

    public String getUniquePostMessageText() {
        return uniquePostMessage.getText();
    }

    public String getNegativeUniquePostMessageText() {
        return negativeUniquePostMessage.getText();
    }

    public PostPage checkTitleAndBodyText(String expectedTitle, String expectedBody) {
        String actualTitle = getPostTitleText();
        String actualBody = getPostBodyText();

        Assert.assertEquals("Unexpected post title", expectedTitle, actualTitle);
        Assert.assertEquals("Unexpected post body", expectedBody, actualBody);

        return this;
    }

    public PostPage checkIsNoteMessageDisplayed(String text) {
        Assert.assertTrue("Note message is not displayed after creating the post", afterNoteMessage.isDisplayed());
        return this;
    }

    public PostPage checkIsPostWrittenFor(String expectedMessage) {
        String actualMessage = getNoteMessageText();
        Assert.assertEquals("Unexpected note message", expectedMessage, actualMessage);

        return this;
    }

    public PostPage checkIsPostUnique(String expectedMessage, String expectedUniqueValue) {
        String actualMessage = getUniquePostMessageText();
        Assert.assertTrue("The post uniqueness is not as expected", actualMessage.contains(expectedUniqueValue));
        Assert.assertEquals("Unexpected unique post message", expectedMessage, actualMessage);

        return this;
    }

    public PostPage checkIsNegativePostUnique(String expectedMessage, String expectedUniqueValue) {
        String actualMessage = getNegativeUniquePostMessageText();
        Assert.assertTrue("The post uniqueness is not as expected", actualMessage.contains(expectedUniqueValue));
        Assert.assertEquals("Unexpected unique post message", expectedMessage, actualMessage);

        return this;
    }

    public PostPage checkTextInSuccessMessage(String text) {
        Assert.assertEquals("Text in message", text, successMessageElement.getText());
        return this;
    }


    public PostPage checkPostTitle(String expectedTitle) {
        String actualTitle = postTitle.getAttribute("value");
        Assert.assertEquals("Unexpected post title", expectedTitle, actualTitle);
        return this;
    }

    public PostPage checkPostBody(String expectedBody) {
        String actualBody = postBody.getAttribute("value");
        Assert.assertEquals("Unexpected post body", expectedBody, actualBody);
        return this;
    }

    public PostPage clickOnButtonSavePost() {
        clickOnElement(buttonSave);
        return this;
    }

    public MyProfilePage clickOnDeleteButton() {
        clickOnElement(buttonDelete);
        return new MyProfilePage(webDriver);

    }
}

