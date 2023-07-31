package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreatePostPage extends ParentPageWithHeader {

    @FindBy(id = "post-title") // //*[@id='post-title'] замість повного локатора з ID
    private WebElement inputTitle;

    @FindBy(name = "body") // //*[@name='body'] замість повного локатора
    private WebElement inputBody;

    @FindBy(xpath = "//button[text()='Save New Post']")
    private WebElement buttonSave;

    @FindBy(tagName = "select")
    private WebElement dropDownSelectValue;

    @FindBy(xpath = "//option[text()='Приватне повідомлення']")
    private WebElement dropDownOptionValue;

    @FindBy(xpath = "//input[@type= 'checkbox']")
    private WebElement checkBoxValue;

    public CreatePostPage(WebDriver webDriver) {
        super(webDriver);
    }

    public CreatePostPage checkIsRedirectToCreatePostPage() {
        //TODO check url
        //TODO same unique element
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
        clickOnElement(buttonSave);
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
        selectTextInDropDownByUI(dropDownSelectValue, dropDownOptionValue);
        return this;
    }

    public CreatePostPage selectValueInCheckbox(String value) {
        selectValueInCheckbox(checkBoxValue, value);
        return this;
    }

}
