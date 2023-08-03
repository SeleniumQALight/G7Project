package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PostPage extends ParentPageWithHeader{
    @FindBy(xpath = ".//div[@class='alert alert-success text-center']")
    private WebElement successMessageElement;

    @FindBy(xpath = "//div[@class='d-flex justify-content-between']")
    private WebElement titleOnPostPage;

    @FindBy(xpath = "//*[@class=\"body-content\"][2]//p")
    private WebElement bodyOnPostPage;

    @FindBy(xpath = "//*[@class=\"body-content\"][1]//u")
    private WebElement noteIs;

    @FindBy(xpath = "//*/p[contains(text(),'unique')]")
    private WebElement isUnique;

    @FindBy(xpath = ".//button[@class='delete-post-button text-danger']")
    private WebElement buttonDelete;

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

    public PostPage checkIsTitleEquals(String title) {
        Assert.assertEquals("Title is incorrect", title, titleOnPostPage.getText());
        return this;
    }

    public PostPage checkIsBodyEquals(String body) {
        Assert.assertEquals("Body is incorrect", body, bodyOnPostPage.getText());
        return this;
    }

    public PostPage checkNoteIsEquals(String text) {
        Assert.assertEquals("Note is incorrect", text, noteIs.getText());
        return this;
    }

    public PostPage checkIsUniqueEquals(String text) {
        Assert.assertEquals("Unique is incorrect", text, isUnique.getText());
        return this;
    }

    public MyProfilePage clickOnDeletePostButton() {
        clickOnElement(buttonDelete);
        return new MyProfilePage(webDriver);
    }
}
