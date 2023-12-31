package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreatePostPage extends ParentPageWithHeder {
    @FindBy(id = "post-title") // //* [@id = 'post-title']
    private WebElement inputTitle;

    @FindBy(name = "body") // //* [@name = 'body']
    private WebElement inputBody;

    @FindBy(xpath = "//button[text()='Save New Post']")
    private WebElement buttonSave;

    @FindBy(tagName = "select")
    private WebElement dropDownSelectValue;

    @FindBy(xpath = "//input[@type = 'checkbox']")
    private WebElement checkboxUniquePost;

    public CreatePostPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    protected String getRelativeUrl() {
        return "/create-post";
    }

    public CreatePostPage checkIsRedirectToCreatePostPage() {
        checkUrl();
        // TODO some unique element
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
    public CreatePostPage selectTextInDropDown(String text){
        selectTextInDropDown(dropDownSelectValue, text);
        return this;
    }
    // select by value
    public CreatePostPage selectValueInDropDown(String value){
        selectTextInDropDown(dropDownSelectValue, value);
        return this;
    }
    public CreatePostPage selectTextInDropDown2(String text) { // домашній метод для вибору значення з дропдауну по тексту
        selectTextInDropDownByUI(dropDownSelectValue, text);
        return this;
    }
    public CreatePostPage markCheckboxStateUnique(String checkboxState) {
        checkCheckboxState(checkboxUniquePost, checkboxState);
        return this;
    }
}
