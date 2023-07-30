package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreatePostPage extends ParentPageWithHeader {
    public CreatePostPage(WebDriver webDriver) {
        super(webDriver);
    }

    //elements
    @FindBy(id = "post-title")
    private WebElement inputTitle;

    @FindBy(name = "body")
    private WebElement inputBody;

    @FindBy(xpath = "//button[text()='Save New Post']")
    private WebElement buttonSaveNewPost;

    @FindBy(tagName = "select")
    private WebElement dropDownSelectValue;

    //actions
    public CreatePostPage enterTitle(String title) {
        enterTextIntoInput(inputTitle, title);
        return this;
    }

    public CreatePostPage enterBody(String body) {
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

    //checks
    public CreatePostPage checkIsRedirectOnCreatePostPage() {
        //TODO: check url
        //TODO: check some unique element
        getHeader().checkIsButtonSignOutVisible();
        return this;
    }

}
