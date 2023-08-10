package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreatePostPage extends ParentPageWithHeader {
    @Override
    protected String getRelativeUrl() {
        return "/create-post";
    }
    @FindBy(id = "post-title")
    private WebElement inputTitle;
    @FindBy(name = "body")
    private WebElement inputBody;
    @FindBy(xpath = "//button[text()='Save New Post']")
    private WebElement buttonSaveNewPost;
    @FindBy(tagName = "select")
    private WebElement dropDownSelectValue;
    @FindBy(xpath = "//option[text()='Приватне повідомлення']")
    private WebElement dropDownOnePersonVariant;
    @FindBy(xpath = "//input[@type='checkbox']")
    private WebElement checkbox;

    public CreatePostPage(WebDriver webDriver) {
        super(webDriver);
    }

    public CreatePostPage checkIsRedirectToCreatePostPage() {
        checkUrl();
        getHeader().checkIsButtonSignOutVisible();
        return this;
    }

    public CreatePostPage enterTextIntoInputTitle(String title) {
        enterTextIntoInput(inputTitle, title);
        return this;
    }

    public CreatePostPage enterTextIntoInputBody(String body) {
        enterTextIntoInput(inputBody, body);
        return this;
    }

    public PostPage clickOnButtonSaveNewPost() {
        clickOnElement(buttonSaveNewPost);
        return new PostPage(webDriver);
    }

    public CreatePostPage selectTextInDropDown(String text) {
        selectTextInDropDown(dropDownSelectValue, text);
        return this;
    }

    public CreatePostPage selectValueInDropDown(String value) {
        selectValueInDropDown(dropDownSelectValue, value);
        return this;
    }

    public CreatePostPage workWithCheckBox(String text) {
        checkOrUncheckCheckBoxDependingOnText(checkbox, text);
        return this;
    }

    public CreatePostPage selectTextInDropDownByUI() {
        selectTextInDropDownByUI(dropDownSelectValue, dropDownOnePersonVariant);
        return this;
    }
}
