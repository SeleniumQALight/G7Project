package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditPostPage extends ParentPageWithHeader {

    @FindBy(xpath = "//a[@class='small font-weight-bold' and contains(@href, '/post/')]")
    private WebElement buttonViewPost;

    public EditPostPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    protected String getRelativeUrl() {
        return "/edit-post";
    }

    public EditPostPage isButtonViewPostDisplayed() {
        Assert.assertTrue("Button View Post is not displayed", isElementDisplayed(buttonViewPost));
        return this;
    }


}
