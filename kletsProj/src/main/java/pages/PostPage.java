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
   
  @FindBy(xpath = ".//button[@class='delete-post-button text-danger']")
    private WebElement buttonDelete;

  @FindBy (xpath = "//a[@class='text-primary mr-2']")
    private WebElement buttonEdit;

    public PostPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    protected String getRelativeUrl() {
        return "/post/[a-zA-Z0-9]*";
    }

    public PostPage checkIsRedirectToPostPage() {
        checkUrlWithPattern();
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


    public PostPage checkTextInTitle(String text) {
        Assert.assertEquals("Text in title ", text, postTitle.getText());
        return this;
    }

    public PostPage checkTextInBody(String text) {
        Assert.assertEquals("Text in body", text, postBody.getText());
        return this;
    }

    public PostPage checkTextInPrivate(String text) {
        Assert.assertEquals("Text in private", text, dropDownSelectValueGroup.getText());
        return this;
    }

    public PostPage checkTextInUnique(String text) {
        Assert.assertEquals("Text in unique", text, checkBoxUniquePost.getText());
        return this;
    }

    public MyProfilePage clickOnDeletePostButton() {
        clickOnElement(buttonDelete);
        return new MyProfilePage(webDriver);
    }

    public EditPostPage clickOnEditPostButton() {
        clickOnElement(buttonEdit);
        return new EditPostPage(webDriver);
    }

}
