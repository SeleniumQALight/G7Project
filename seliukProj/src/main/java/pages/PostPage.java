package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static java.awt.SystemColor.text;

public class PostPage extends ParentPageWithHeader {

    //locators
    @FindBy(xpath = ".//div[@class='alert alert-success text-center']")
    private WebElement successMessageElement;

    @FindBy(xpath = ".//button[@class='delete-post-button text-danger']")
    private WebElement buttonDelete;

    public PostPage(WebDriver webDriver) {
        super(webDriver);
    }

    //actions
    public MyProfilePage clickOnDeletePostButton() {
        clickOnElement(buttonDelete);
        return new MyProfilePage(webDriver);
    }

    //checks
    public PostPage checkIsRedirectOnPostPage() {
        //TODO check url
        //TODO unique elements
        return this;
    }

    public PostPage checkIsSuccessMessageDisplayed(String text) {
        Assert.assertEquals("Text in message:", text, successMessageElement.getText());
        return this;
    }

}
