package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreatePostPage extends ParentPageWithHeader {

    @FindBy(id = "post-title") //(xpath = "//*[@id='post-title']")
    private WebElement inputTitle;

    @FindBy(name="body") //(xpath = "//*[@name='body']")
    private WebElement inputBody;

    @FindBy(xpath = "//button[@class='btn btn-primary']")
    private WebElement buttonSaveNewPost;

    @FindBy(xpath = "//*[@id='select1']")
    private WebElement dropDownPostAccess;

    @FindBy(tagName = "select")
    private WebElement dropDownSelectValue;

    @FindBy(xpath = "//*[text()='Приватне повідомлення']")
    private WebElement dropDownSelectPrivatePostAccess;

    @FindBy (xpath = "//*[@name='uniquePost']")
    private WebElement checkBoxUniquePost;

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

    public CreatePostPage selectTextInDropDownByValue(String value) {
        selectValueInDropDown(dropDownSelectValue, value);
        return this;
    }

    public CreatePostPage selectTextInDropDownByText() {
        selectTextInDropDownByUI(dropDownPostAccess, dropDownSelectPrivatePostAccess);
        return this;
    }

    public CreatePostPage setCheckBoxState(String CheckboxState){
        setCheckboxState(checkBoxUniquePost, CheckboxState);
        return this;
    }


}

