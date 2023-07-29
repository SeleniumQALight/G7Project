package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreatePostPage extends ParentPageWithHeader{

    @FindBy(id = "post-title") //*[@id='post-tile']
    private WebElement inputTitle;

    @FindBy(name = "body") //*[@name='body']
    private WebElement inputBody;

    @FindBy(xpath = ".//button[text()='Save New Post']")
    private WebElement buttonSave;

    @FindBy(tagName = "select")
    private WebElement dropDownSelectValue;
    public CreatePostPage(WebDriver webDriver) {
        super(webDriver);
    }

    public CreatePostPage checkIsRedirectToCreatePostPage() {
        //TODO check url
        //TODO check unique element
        getHeader().checkIsSignOutButtonVisible();
        return this;
    }

    public CreatePostPage enterTextIntoInputTitle(String title) {
        enterTextIntoInput(title, inputTitle);
        return this;
    }

    public CreatePostPage enterTextIntoInputBody(String body) {
        enterTextIntoInput(body, inputBody);
        return this;
    }

    public PostPage clickOnButtonSave() {
        clickOnElement(buttonSave);
        return new PostPage(webDriver);
    }

    public CreatePostPage selectTextInDropDown(String text){
        selectTextInDropDown(dropDownSelectValue, text);
        return this;
    }

    public CreatePostPage selectValueInDropDownByValue(String value){
        selectValueInDropDown(dropDownSelectValue, value);
        return this;
    }
}
