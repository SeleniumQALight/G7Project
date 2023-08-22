package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreatePostPage extends ParentPageWithHeader {

    public CreatePostPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    protected String getRelativeUrl() {
        return "/create-post";
    }

    @FindBy(id = "post-title") // //input[@id='post-title']
    private WebElement inputTitle;

    @FindBy(name = "body") // //textarea[@id='post-body']
    private WebElement inputBody;

    @FindBy(xpath = "//button[text()='Save New Post']")
    private WebElement buttonSave;

    @FindBy(tagName = "select")
    private WebElement dropDownSelectValue;

    @FindBy(xpath = "//option[text()='Загальнодоступне']")
    private WebElement dropDownSelectValuePublic;

    @FindBy(xpath = "//option[text()='Приватне повідомлення']")
    private WebElement dropDownSelectValuePrivate;

    @FindBy(xpath = "//option[text()='Групове повідомлення']")
    private WebElement dropDownSelectValueGroup;

    @FindBy(xpath = "//input[@type='checkbox']")
    private WebElement checkBoxUniquePost;

    public CreatePostPage checkIsRedirectToCreatePostPage() {
        checkUrl();
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

    public CreatePostPage selectTextDropDownByUI(String option) {
        selectTextDropDownByUI(dropDownSelectValue, option);
        logger.info("Option " + option + " was selected in DropDown");
        return this;
    }

    public CreatePostPage selectCheckBoxUniquePost() {
        selectCheckbox(checkBoxUniquePost);
        return this;
    }

    public CreatePostPage deselectCheckBoxUniquePost() {
        deselectCheckbox(checkBoxUniquePost);
        return this;
    }

    public CreatePostPage markCheckBoxUniquePostYes() {
        markCheckBoxYes(checkBoxUniquePost);
        return this;
    }

    public CreatePostPage markCheckBoxUniquePostNo() {
        markCheckBoxNo(checkBoxUniquePost);
        return this;
    }

    public CreatePostPage markCheckBoxUniquePost(String checkboxState) {
        checkCheckBoxState(checkBoxUniquePost, checkboxState);
        return this;

    }

}
