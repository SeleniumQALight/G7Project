package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreatePostPage extends ParentPageWithHeader{

    @FindBy(id = "post-title") // //*[@id='post-title'] - the same
    private WebElement inputTitle;

    @FindBy(name = "body") // //*[@name='post-body'] - the same
    private WebElement inputBody;

    @FindBy(xpath = "//button[text()='Save New Post']")
    private WebElement buttonSave;

    @FindBy(tagName = "select") // dropdown
    private WebElement dropDownSelectValue;

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
    // select by value
    public CreatePostPage selectValueInDropDownByValue(String value) {
        selectValueInDropDown(dropDownSelectValue, value);
        return this;
    }
}
