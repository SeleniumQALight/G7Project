package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PostPage extends ParentPageWithHeader{

    @FindBy (xpath = ".//div[@class='alert alert-success text-center']")
    private WebElement successMessageElement;

    @FindBy  (xpath = ".//p[text() = 'Is this post unique? : yes']")
    private WebElement isPostUnique;

    @FindBy (xpath = ".//u[text() = ' One Person']")
    private WebElement onePerson;

    @FindBy (xpath =".//h2")
            private WebElement postTitle;

    @FindBy (xpath = "//*[@class='body-content'][2]//p")
    private WebElement postBody;

    public PostPage(WebDriver webDriver) {
        super(webDriver);
    }

    public PostPage checkIsRedirectToPostPage() {
        //TODO check url
        //TODO some unique elements
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

    public PostPage checkTitleText (String text)
    {
        Assert.assertEquals(text,postTitle.getText());
        return this;
    }

    public PostPage checkBodyText (String text)
    {
        Assert.assertEquals(text,postBody.getText());
        return this;
    }

    public PostPage checkIfPostIsUnique() {
        Assert.assertEquals("Is post unique", "Is this post unique? : yes", isPostUnique.getText());
        return this;
    }

    public PostPage checkIfPostIsVisibleOnlyForOnePerson() {
        Assert.assertEquals("Is post visible only for one person", "One Person", onePerson.getText());
        return this;
    }
}
