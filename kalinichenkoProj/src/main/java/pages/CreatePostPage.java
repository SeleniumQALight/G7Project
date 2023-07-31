package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreatePostPage extends ParentPageWithHeader {

    @FindBy(id = "post-title") // //*[@id='post-title'] - the same
    private WebElement inputTitle;

    @FindBy(name = "body") // //*[@name='post-body'] - the same
    private WebElement inputBody;

    @FindBy(xpath = "//button[text()='Save New Post']")
    private WebElement buttonSave;

    @FindBy(tagName = "select") // dropdown
    private WebElement dropDownSelectValue;

    @FindBy(xpath = ".//input[@type='checkbox']")
    private WebElement checkBoxUniquePost;


    public CreatePostPage(WebDriver webDriver) {
        super(webDriver);
    }

    public CreatePostPage checkIsRedirectToCreatePostPage() {
        //TODO check url
        //TODO check unique element
        getHeader().checkIsButtonSignOutVisible();
        return this;
    }

    public CreatePostPage enterTextIntoInputTitle(String text) {
        enterTextIntoInput(inputTitle, text);
        return this;
    }

    public CreatePostPage enterTextIntoInputBody(String text) {
        enterTextIntoInput(inputBody, text);
        return this;
    }

    public PostPage clickOnButtonSaveNewPost() {
        clickOnElement(buttonSave);
        return new PostPage(webDriver);
    }

    public CreatePostPage selectTextInDropDown(String text) {
        selectTextInDropDown(dropDownSelectValue, text);
        return this;
    }

    public CreatePostPage checkStatusCheckBoxUniquePost(String status) {
        try {
            if (status.equals("check")) {
                setCheckboxState(checkBoxUniquePost);

            } else if (status.equals("uncheck")) {
                unsetCheckboxState(checkBoxUniquePost);
            } else {
                logger.error("Status should be 'check' or 'uncheck'");
                Assert.fail("Status should be 'check' or 'uncheck'");
            }
        } catch (Exception e) {
            logger.error("Can not work with checkbox");
            Assert.fail("Can not work with checkbox");
        }
        return this;
    }

}
