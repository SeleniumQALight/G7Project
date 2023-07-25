package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreatePostPage  extends ParentPageWithHeader {
    @FindBy(id = "post-title") // //*[@id="post-title"]

    private WebElement inputTitle;
    @FindBy(name = "body") // //*[@id="post-body"];
    private WebElement inputBody;
    @FindBy(xpath = "//button[text()='Save New Post']")
    private WebElement buttonSaveNewPost;

    public CreatePostPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(tagName = "select")
    private WebElement dropDownSelectValue;

    public CreatePostPage checkIsRedirectToCreatePostPage() {
        //super (webDriver);
        //@FindBy(xpath = "//button[text()='Save New Post']")
        //private WebElement buttonSaveNewPost;
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

        clickOnElement(buttonSaveNewPost);
        return new PostPage(webDriver);
    }

    public CreatePostPage selectTextInDropDown(String text) {
        selectTextInDD(dropDownSelectValue, text);
        return this;
    }

    //select by value
    public CreatePostPage selectValueInDropDown(String value) {
        selectValueInDD(dropDownSelectValue, value);
        return this;
    }
}

