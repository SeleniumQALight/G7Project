package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PostEditPage extends ParentPageWithHeader {
    public Object checkIsMessageSuccessfullEditPost;

    public PostEditPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    protected String getRelativeUrl() {
        return "/post/[a-zA-Z0-9]*/edit";

    }
    @FindBy(xpath = "//input[@id='post-title']")
    private WebElement inputTitleOnEditPage;

    @FindBy(xpath = "//button[@class='btn btn-primary']")
    private WebElement buttonSaveUpdates;

    @FindBy(xpath = "//div[@class='alert alert-success text-center']")
    private WebElement successfullyEditPost;

    public PostEditPage enterTextIntoInputTitle(String titleEdited) {
        enterTextIntoInput(inputTitleOnEditPage, titleEdited);
return this;
    }

    public PostEditPage clickOnButtonSaveUpdatePost() {
        clickOnElement(buttonSaveUpdates);
        return this;
    }
    public PostEditPage checkIsMessageSuccessfullyEditPost () {
        Assert.assertTrue("Message is not displayed", isElementDisplayed(successfullyEditPost));
        return this;
    }
}
