package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PostPage extends ParentPageWithHeader{
    @FindBy (xpath = ".//div[@class='alert alert-success text-center']")
    private WebElement successMessageElement;
    @FindBy (xpath = ".//button[@class='delete-post-button text-danger']")
    private WebElement buttonDelete;

    public PostPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    protected String getRelativeUrl() {
        return "/post/[a-z-A-Z0-9]*";
    }

    public PostPage checkIsRedirectToPostPage() {
        checkUrlWithPattern();
        //TODO unique elements
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

    public MyProfilePage clickOnDeleteButton() {
        clickOnElement(buttonDelete);
        return new MyProfilePage(webDriver);
    }
}
