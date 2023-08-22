package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreatePostPage extends ParentPageWithHeder {

    //Шукаємо елементи на сторінці Create Post:
    @FindBy(id = "post-title") // знайти елемент по id
    private WebElement inputTitle;

    @FindBy(name = "body") // знайти елемент по name
    private WebElement inputBody;

    @FindBy(xpath = ".//button[text()='Save New Post']") // знайти елемент по xpath
    private WebElement buttonSave;

    @FindBy(tagName = "select") // закритий дробаун
    private WebElement dropDownSelectValue;


    @FindBy(xpath = "//input[@type='checkbox']")// чекбокс
    private WebElement checkBox;


    public CreatePostPage(WebDriver webDriver) { // конструктор
        super(webDriver);
    }

    @Override
    protected String getRelativeUrl() {
            return "/create-post";
    }

    public CreatePostPage checkIsRedirectToCreatePostPage() { // перевірка чи ми на сторінці Create Post
checkUrl();//TODO check URL
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
        return new PostPage(webDriver); // повертає нову сторінку об'єкт класу PostPage
    }

    public CreatePostPage selectTextInDropDown(String text) { // метод для вибору значення з дропдауну по тексту
        selectTextInDropDown(dropDownSelectValue, text);
        return this;
    }

    public CreatePostPage selectValueInDropDown(String value) { // метод для вибору значення за value з дропдауну
        selectValueInDropDown(dropDownSelectValue, value);
        return this;
    }

    public CreatePostPage selectTextInDropDown2(String text) { // ще метод для вибору значення з дропдауну по тексту
        selectTextInDropDownByUI(dropDownSelectValue, text);   // цей метод вставила в кейс - працює
        return this;
    }

    public CreatePostPage selectOnCheckBoxIs(String text) { // метод для вибору check or uncheck значення  на чекбокс
        toMarkAndToUnMarkCheckBoxByUI(checkBox, text);
        return this;
    }


}