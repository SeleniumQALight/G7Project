package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static java.awt.SystemColor.text;

public class PostPage extends ParentPageWithHeader {

    @FindBy(xpath = ".//div[@class='alert alert-success text-center']")
    private WebElement successMessageElement;

    public PostPage(WebDriver webDriver) {
        super(webDriver);
    }

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
