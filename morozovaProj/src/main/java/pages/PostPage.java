package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PostPage extends ParentPageWithHeder {
    @FindBy(xpath = ".//div[@class='alert alert-success text-center']")
    private WebElement successMessageElement;

    @FindBy(xpath = ".//button[@class='delete-post-button text-danger']")
    private WebElement buttonDeletePost;

    @FindBy(xpath = ".//div[@class='body-content']/p/*[last()]")
    private WebElement postBodyThisPostWasWritten;

    @FindBy(xpath = "//p[contains (text(),'Is this post unique')]") ////p[text()='Is this post unique? : yes']
    private WebElement postUnique;

    public PostPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    protected String getRelativeUrl() {
        return "/post/[a-zA-Z0-9]*";// можемо ставити{24} або * - будь-який символ [0-9] - цифри [a-zA-Z] - букви
    }

    public PostPage checkIsRedirectToPostPage() {
        checkUrlWithPattern();
        // TODO unique elements
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

    public MyProfilePage clickOnDeletePostButton() {
        clickOnElement(buttonDeletePost);
        return new MyProfilePage(webDriver);
    }

    public PostPage checkTextInThisPostWasWritten(String text) {
        Assert.assertEquals("Text in message", text, postBodyThisPostWasWritten.getText());
        return this;
    }

    public PostPage checkIsPostUnique(String post_unique) {//перевірка чи пост унікальний
        Assert.assertEquals("Post unique", post_unique, postUnique.getText());
        return this;
    }
}
