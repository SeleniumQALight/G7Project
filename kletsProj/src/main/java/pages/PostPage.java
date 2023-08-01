package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PostPage extends ParentPageWithHeader {

    @FindBy(xpath = ".//div[@class='alert alert-success text-center']")
    private WebElement successMessageElement;

    @FindBy(xpath = "//div[@class=\"container py-md-5 container--narrow\"]//div[2]//h2")
    private WebElement postTitle;

    @FindBy(xpath = "//div[@class=\"container py-md-5 container--narrow\"]//div[5]")
    private WebElement postBody;

    @FindBy(xpath = "//div//u")
        private WebElement dropDownSelectValueGroup;

    @FindBy(xpath = "//div[@class=\"container py-md-5 container--narrow\"]//div[4]")
    private WebElement checkBoxUniquePost;

    public PostPage(WebDriver webDriver) {
        super(webDriver);
    }

    public PostPage checkIsRedirectToPostPage() {
        //TODO check URL
        //TODO check some unique element
        return this;
    }

    public PostPage checkIsSuccessMessageDisplayed() {
        checkIsElementDisplayed(successMessageElement);
        return this;
    }

    public PostPage checkTextInSuccessMessage(String text) {
        Assert.assertEquals("Text in message", text, successMessageElement.getText());
        return this;
    }

//    public PostPage checkIsPostTitleDisplayed(String title) {
//        checkIsElementDisplayed(postTitle);
//        return this;
//    }

    public PostPage checkTextInTitle(String text) {
        Assert.assertEquals("Text in title ", text, postTitle.getText());
        return this;
    }

//    public PostPage checkIsPostBodyDisplayed(String body) {
//        checkIsElementDisplayed(postBody);
//        return this;
//    }

    public PostPage checkTextInBody(String text) {
        Assert.assertEquals("Text in body", text, postBody.getText());
        return this;
    }

//    public PostPage checkIsPostPrivateDisplayed(String option) {
//        checkIsElementDisplayed(dropDownSelectValueGroup);
//        return this;
//    }

    public PostPage checkTextInPrivate(String text) {
        Assert.assertEquals("Text in private", text, dropDownSelectValueGroup.getText());
        return this;
    }

//    public PostPage checkIsPostUniqueDisplayed(String checkBoxState) {
//        checkIsElementDisplayed(checkBoxUniquePost);
//        return this;
//    }

    public PostPage checkTextInUnique(String text) {
        Assert.assertEquals("Text in unique", text, checkBoxUniquePost.getText());
        return this;
    }

}
