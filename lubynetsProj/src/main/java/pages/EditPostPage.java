package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditPostPage extends ParentPageWithHeader {

    @FindBy(xpath = "//a[@class='small font-weight-bold' and contains(@href, '/post/')]")
    private WebElement buttonViewPost;
    @FindBy(xpath = "//button[@class='btn btn-primary']")
    private WebElement buttonSaveUpdatedPost;

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
    public EditPostPage isButtonUpdatePostDisplayed() {
        Assert.assertTrue("Button Update Post is not displayed", isElementDisplayed(buttonSaveUpdatedPost));
        return this;
    }
    public EditPostPage clickOnButtonSaveUpdatedPost() {
        clickOnElement(buttonSaveUpdatedPost);
        return this;
    }


}
