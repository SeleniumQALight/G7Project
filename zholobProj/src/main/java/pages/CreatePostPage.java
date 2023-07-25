package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreatePostPage extends ParentPageWithHeder{

    @FindBy(id="post-title") // знайти елемент по id
    private WebElement inputTitle;

    @FindBy(name = "body") // знайти елемент по name
    private WebElement inputBody;

    @FindBy(xpath = ".//button[text()='Save New Post']") // знайти елемент по xpath
    private WebElement buttonSave;

    @FindBy(tagName = "select") // знайти елемент по tagName
    private WebElement dropDownSelectValue;


       public CreatePostPage(WebDriver webDriver) { // конструктор
        super(webDriver);
    }

    public CreatePostPage checkIsRedirectToCreatePostPage() {
//TODO check URL
// TODO some unique element
        getHeader().checkIsButtonSignOutVisible();
        return this;
    }

    public CreatePostPage enterTextIntoInputTitle(String title) { // метод для вводу заголовку в поле
        enterTextIntoInput(inputTitle, title);
        return this;
    }

    public CreatePostPage enterTextIntoInputBody(String body) { // метод для вводу тіла поста в поле
        enterTextIntoInput(inputBody, body);
        return this;
    }

    public PostPage clickOnButtonSaveNewPost() { // метод для кліку на кнопку Save New Post
        clickOnElement(buttonSave);
        return new PostPage(webDriver);
    }

    public CreatePostPage selectTextInDropDown(String text) { // метод для вибору значення з дропдауну
        selectTextInDropDown(dropDownSelectValue, text);
        return this;
    }

    public CreatePostPage selectValueInDropDown(String value) { // метод для вибору значення за value з дропдауну
        selectValueInDropDown(dropDownSelectValue, value);
        return this;
    }


}