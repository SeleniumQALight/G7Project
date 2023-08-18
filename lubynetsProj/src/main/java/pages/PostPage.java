package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

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

    @FindBy(xpath = "//a[@href and @class='text-primary mr-2']")
    private WebElement buttonEdit;


    @FindBy(xpath = ".//button[@class='delete-post-button text-danger']")
    private WebElement buttonDelete;

    @FindBy(xpath = "//button[text()='Save Post']")
    private WebElement buttonSavePost;

    @FindBy(xpath = "//button[@class='btn btn-primary']")
    private WebElement buttonSaveUpdatedPost;

    @FindBy(xpath = "//a[@class='small font-weight-bold' and contains(@href, '/post/')]")
    private WebElement buttonViewPost;
    private String postTitleLocator = ".//*[text()='%s']";

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

    public PostPage clickOnButtonSaveUpdatedPost() {
        clickOnElement(buttonSaveUpdatedPost);
        return this;
    }

    public PostPage clickOnButtonEdit() {
        clickOnElement(buttonEdit);
        return this;
    }

    public MyProfilePage clickOnDeleteButton() {
        clickOnElement(buttonDelete);
        return new MyProfilePage(webDriver);

    }

    public PostPage enterTextIntoInputTitle(String title) {
        postTitle.clear();
        postTitle.sendKeys(title);
        return this;
    }


    public PostPage isButtonViewPostDisplayed() {
        Assert.assertTrue("Button View Post is not displayed", isElementDisplayed(buttonViewPost));
        return this;
    }

    public PostPage isButtonUpdatePostDisplayed() {
        Assert.assertTrue("Button Update Post is not displayed", isElementDisplayed(buttonSaveUpdatedPost));
        return this;
    }

    public List<WebElement> getPostList(String title) {

        return webDriver.findElements(By.xpath(
                String.format(postTitleLocator, title
                )));
    }

    public boolean isPostWithTitlePresent(String title) {
        List<WebElement> postTitleElements = getPostList(title);
        return !postTitleElements.isEmpty();
    }

    public boolean isOnlyOnePostWithTitlePresent(String title) {
        List<WebElement> postTitleElements = getPostList(title);
        return postTitleElements.size() == 1;
    }

    public PostPage assertPostWithTitleIsPresent(String title) {
        Assert.assertTrue("Post with title '" + title + "' is not present", isPostWithTitlePresent(title));
        return this;
    }

    public PostPage assertOnlyOnePostWithTitlePresent(String title) {
        Assert.assertTrue("More than one post with title '" + title + "' is present", isOnlyOnePostWithTitlePresent(title));
        return this;
    }

    public PostPage assertPostWithTitlesIsNotPresent(String title) {
        Assert.assertFalse("Post with title '" + title + "' is present, but should not", isPostWithTitlePresent(title));
        return this;
    }
    public PostPage findAndClickOnPostByTitle(String title) {
        List<WebElement> postList = webDriver.findElements(By.xpath(
                String.format(postTitleLocator, title)
        ));

        for (WebElement post : postList) {
            if (post.getText().contains(title)) {
                clickOnElement(post);
                break;
            }
        }

        return this;
    }

    public void deletePostByTitle(String title) {
        List<WebElement> postList = getPostList(title);
        int counter = 0;
        while (!postList.isEmpty() && counter < 100) {
            clickOnElement(postList.get(0));
            new PostPage(webDriver).checkIsRedirectOnPostPage()
                    .clickOnDeleteButton()
                    .checkIsRedirectToMyProfilePage();
            logger.info("Post with title " + title + " was deleted");
            postList = getPostList(title);
            counter++;
        }

        if (counter >= 100) {
            Assert.fail("There are more than 100 posts with title " + title + " or delete button does not work");
        }


    }
}

