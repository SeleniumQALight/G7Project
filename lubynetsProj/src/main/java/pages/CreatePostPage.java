package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreatePostPage extends ParentPageWithHeader{

@FindBy(id = "post-title") // // *[ @ id = 'post-title']
private WebElement inputTitle;

@FindBy (name = "body") // // *[ @ name = 'body']
private WebElement inputBody;
    @FindBy (tagName = "select")
    private WebElement dropDownSelectValue;
@FindBy (xpath = "//button[text()='Save New Post']")
private WebElement buttonSave;
    public CreatePostPage(WebDriver webDriver) {
        super(webDriver);

    }


    public CreatePostPage CheckIsRedirectOnCreatePostPage() {
        // TODO CHECK URL
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

    public PostPage clickOnButtonSavePost() {
        clickOnElement(buttonSave);
        return new PostPage(webDriver);
    }

    public CreatePostPage selectTextInDropDown(String text) {
        selectTextInDropDown(dropDownSelectValue, text);
        return this;
    }

    // select by value

    public CreatePostPage selectValueInDropDown(String value) {
        selectValueInDropDown(dropDownSelectValue, value);
        return this;
    }
}


