package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PostPage extends ParentPageWithHeader{
    @FindBy(xpath = ".//div[@class='alert alert-success text-center']")
    private WebElement successMessageElement;
   @FindBy(xpath = ".//button[@class='delete-post-button text-danger']")
   private WebElement buttonDelete;

    @FindBy(xpath = "//div[@class='d-flex justify-content-between']" )
    private WebElement postTitleOnPage;

    @FindBy(xpath ="//*[@class=\"body-content\"][2]//p")
    private WebElement postBodyOnPage;

    @FindBy(xpath = "//*[@class=\"body-content\"][1]//u")
    private WebElement noteIs;

    @FindBy(xpath ="//*/p[contains(text(),'unique')]")
    private WebElement postIsUnique;


    public PostPage(WebDriver webDriver) {super(webDriver);
    }
    public PostPage checkIsRedirectToPostPage() {

        //TODO check URL
        //TODO some unique element
        getHeader().checkIsButtonSignOutVisible();
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
        Assert.assertEquals("Title in post", title, postTitleOnPage.getText());
        return this;
    }
    public PostPage checkIsBodyEquals(String body) {
        Assert.assertEquals("Body in incorrect", body, postBodyOnPage.getText());
        return this;
    }
    public PostPage checkNoteIsEquals(String text){
        Assert.assertEquals("Note in incorrect", text, noteIs.getText());
        return this;
    }
    public PostPage checkIsUniqueEquals(String text){
        Assert.assertEquals("Unique is incorrect",text,postIsUnique.getText());
        return this;

    }

    public MyProfilePage clickOnDeletePostButton() {
       clickOnElement(buttonDelete);
        return new MyProfilePage(webDriver);
    }
}
