package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PostPage extends ParentPageWithHeader {
    @FindBy(xpath = ".//div[@class='alert alert-success text-center']")
    private WebElement successMessageElement;

    @FindBy(xpath = ".//div[@class='d-flex justify-content-between']/h2")
    private WebElement postTitleOnPostPage;

    @FindBy(xpath = ".//div[@class='body-content']/p[count(*)=0]")
    private WebElement postBodyOnPostPage;

    @FindBy(xpath = ".//div[@class='body-content']/p/*[last()]")
    private WebElement postBodyThisPostWasWrittenFor;

    @FindBy(xpath = ".//p[contains(text(),'this post')]")
    private WebElement postBodyThisPostUnique;

    @FindBy(xpath = ".//button[@class='delete-post-button text-danger']")
    private WebElement buttonDelete;

    @FindBy(xpath = ".//.//a[@class='text-primary mr-2']")
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
        //TODO check unique element
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

   public PostPage checkTextInBody(String text) {
        Assert.assertEquals("Text in message", text, postBodyOnPostPage.getText());
        return this;
    }

    public PostPage checkTextInTitle(String text) {
        Assert.assertEquals("Text in message", text, postTitleOnPostPage.getText());
        return this;
    }

    public PostPage checkTextInThisPostWasWrittenFor(String text) {
        Assert.assertEquals("Text in message", text, postBodyThisPostWasWrittenFor.getText());
        return this;
    }

    public PostPage checkTextInThisPostUnique(String text) {
        Assert.assertEquals("Text in message", text, postBodyThisPostUnique.getText());
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
