package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreatePostPage extends ParentPageWithHeader {

    public CreatePostPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(id = "post-title") // //input[@id='post-title']
    private WebElement inputTitle;

    @FindBy(name = "body") // //textarea[@id='post-body']
    private WebElement inputBody;

    @FindBy(xpath = "//button[text()='Save New Post']")
    private WebElement buttonSave;

    @FindBy(tagName = "select")
    private WebElement dropDownSelectValue;

    @FindBy //option[text()='Загальнодоступне']
    private WebElement dropDownSelectValuePublic;

    @FindBy //option[text()='Приватне повідомлення']
    private WebElement dropDownSelectValuePrivate;

    @FindBy //option[text()='Групове повідомлення']
    private WebElement dropDownSelectValueGroup;

    public CreatePostPage checkIsRedirectToCreatePostPage() {
        //TODO check URL
        //TODO check some unique element
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
    public CreatePostPage selectTextDropDownBuUI(String text) {
        selectTextDropDownByUI(dropDownSelectValue, text);
        return this;
    }

}
