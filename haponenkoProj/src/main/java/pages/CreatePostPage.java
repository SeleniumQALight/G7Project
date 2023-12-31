package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreatePostPage extends ParentPageWithHeader {
    public CreatePostPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(id = "post-title") // xpath = //*[@id='post-title']
    private WebElement inputTitle;

    @FindBy(name = "body") // //*[@id = 'post-body']
    private WebElement inputBody;

    @FindBy(xpath = "//button[text()='Save New Post']")
    private WebElement buttonSave;

    @FindBy(tagName = "select")
    private WebElement dropDownSelectValue;

    @FindBy(xpath = "//input[@type = 'checkbox']")
    private WebElement checkboxUniquePost;

    @Override
    protected String getRelativeUrl() {
        return "/create-post";
    }

    public CreatePostPage checkIsRedirectToCreatePostPage() {
        checkUrl();
        //TODO some unique element
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

    public CreatePostPage selectTextInDropDownByUI (String text) {
        selectTextInDropDownByUI(dropDownSelectValue, text);
        return this;
    }

    public CreatePostPage markCheckboxUniqueYes () {
        markCheckboxYes(checkboxUniquePost);
        return this;
    }

    public CreatePostPage markCheckboxUniqueNo () {
        markCheckboxNo(checkboxUniquePost);
        return this;
    }

    public CreatePostPage markCheckboxStateUnique(String checkboxState) {
        checkCheckboxState(checkboxUniquePost, checkboxState);
        return this;
    }
}
