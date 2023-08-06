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

    public MyProfilePage clickOnDeletePostButton() {
       clickOnElement(buttonDelete);
        return new MyProfilePage(webDriver);
    }
}
