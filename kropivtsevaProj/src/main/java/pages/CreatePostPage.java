package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreatePostPage extends ParentPageWithHeader {

    @FindBy(id = "post-title")
    private WebElement inputTitle;

    @FindBy(name = "body")
    private WebElement inputBody;

    @FindBy(xpath = ".//button[text()='Save New Post']")
    private WebElement buttonSaveNewPost;

    @FindBy(tagName = "select")
    private WebElement dropDownSelectValue;

    @FindBy(xpath = ".//input[@type='checkbox']")
    private WebElement checkbox;

    public CreatePostPage(WebDriver webDriver) {
        super(webDriver);
    }


    public CreatePostPage checkIsRedirectToCreatePostPage() {
        //TODO check url
        //TODO some unique element
        getHeader().checkIsButtonSignOutVisible();
        return this;
    }

    public CreatePostPage enterTextIntoInputTitle(String title) {
        enterTextIntoInput(inputTitle, title);
        return this;
    }

    public CreatePostPage enterTextIntoInputBody(String bodyText) {
        enterTextIntoInput(inputBody, bodyText);
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

    public CreatePostPage selectTextInDropDownByUI() {
        selectTextInDropDownByUI(dropDownSelectValue, "Приватне повідомлення");
        return this;
    }

    public CreatePostPage workWithCheckBox() {
        clickOnCheckBox(checkbox);
        return this;
    }

    public CreatePostPage unworkWithCheckBox() {
        unclickOnCheckBox(checkbox);
        return this;
    }

    public CreatePostPage checkOrUncheckCheckBoxDependingOnText(String text) {
        checkOrUncheckCheckBoxDependingOnText(checkbox, text);
        return this;
    }

}
