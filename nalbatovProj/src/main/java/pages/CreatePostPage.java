package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreatePostPage extends ParentPageWithHeader{

    @FindBy(id = "post-title") // //*input[@id='post-title']
    private WebElement inputTitle;

    @FindBy(name = "body")
    private WebElement inputBody;

    @FindBy(xpath = "//button[text()='Save New Post']")
    private WebElement buttonSave;

    @FindBy(tagName = "select")
    private WebElement dropDownSelectValue;


    public CreatePostPage(WebDriver webDriver) {
        super(webDriver);
    }
    @Override
    protected String getRelativeUrl() {
        return "/create-post";
    }

    public CreatePostPage checkisRedirectToCreatePostPage() {
        checkUrl();
        //TODO check unique element
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


}
