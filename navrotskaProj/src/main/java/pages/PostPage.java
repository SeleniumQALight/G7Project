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

    @FindBy(xpath = "//p[text()='Is this post unique? : yes']")
    private WebElement postIsUnique;

    @FindBy(xpath = "//p[text()='Is this post unique? : no']")
    private WebElement postIsNotUnique;

    @FindBy(xpath = "//div[@class='d-flex justify-content-between']/h2")
    private WebElement titleOnPostPage;

    @FindBy(xpath = "//div[5][@class='body-content']/p")
    private WebElement bodyOnPostPage;

    @FindBy(xpath = "//p/*[text()=' Note: This post was written for ']")
    private WebElement postAccessText;

    public PostPage(WebDriver webDriver) {
        super(webDriver);
    }

    public PostPage checkIsRedirectToPostPage() {
        //TODO check url
        //TODO some unique element
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

    public PostPage checkTitleOnPostPage(String text) {
        Assert.assertEquals("Is created post title matches the typed", text, titleOnPostPage.getText());
        return this;
    }


    public MyProfilePage clickOnDeleteButton() {
        clickOnElement(buttonDelete);
        return new MyProfilePage(webDriver);
    }

    public PostPage checkBodyOnPostPage(String text) {
        Assert.assertEquals("Is created post body matches the typed", text, bodyOnPostPage.getText());
        return this;
    }

    public PostPage checkIsPostAccessTextDisplayed(String text) {
        Assert.assertEquals("Is post access text displayed", text, postAccessText.getText());
        return this;
    }

    public PostPage checkIfPostIsUnique(String text) {
        Assert.assertEquals("Is created post status is unique", text, postIsUnique.getText());
        return this;

    }
}
