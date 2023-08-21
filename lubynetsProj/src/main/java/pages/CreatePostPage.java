package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreatePostPage extends ParentPageWithHeader {

    @FindBy(id = "post-title") // // *[ @ id = 'post-title']
    private WebElement inputTitle;

    @FindBy(name = "body") // // *[ @ name = 'body']
    private WebElement inputBody;
    @FindBy(tagName = "select")
    private WebElement dropDownSelectValue;
    @FindBy(xpath = "//button[text()='Save New Post']")
    private WebElement buttonSave;
    @FindBy(xpath = "//input[@type='checkbox' and @name='uniquePost']")
    private WebElement checkBoxUniquePost;
    private ActionWithElements actionWithElements;

    public CreatePostPage(WebDriver webDriver) {
        super(webDriver);
        actionWithElements = new ActionWithElements(webDriver);


    }

    @Override
    protected String getRelativeUrl() {
        return "/create-post";
    }


    public CreatePostPage CheckIsRedirectOnCreatePostPage() {
        checkUrl();
        // TODO SOME UNIQUE ELEMENT
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


    public CreatePostPage selectTextInDropDown(String text) {
        selectTextInDropDown(dropDownSelectValue, text);
        return this;
    }

    public CreatePostPage selectTextInDropDownByUI(String text) {
        actionWithElements.selectTextInDropDownByUI(dropDownSelectValue, text);
        return this;

        // select by value
    }

    public CreatePostPage selectValueInDropDown(String value) {
        selectValueInDropDown(dropDownSelectValue, value);
        return this;
    }

    public CreatePostPage checkCheckbox() {
        actionWithElements.checkCheckbox(checkBoxUniquePost);
        return this;
    }

    public CreatePostPage uncheckCheckbox() {
        actionWithElements.uncheckCheckbox(checkBoxUniquePost);
        return this;
    }

    public CreatePostPage setCheckboxState(String state) {
        actionWithElements.setCheckboxState(checkBoxUniquePost, state);
        return this;
    }

    public PostPage clickOnButtonSavePost() {
        actionWithElements.clickOnElement(buttonSave);
        return new PostPage(webDriver);
    }
}
