package pages;

import data.TestData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends ParentPage {
    @FindBy(xpath = ".//input[@placeholder='Username']") // знайти елемент по xpath
    private WebElement inputUserNane;

    @FindBy(xpath = ".//input[@placeholder='Password']")
    private WebElement inputPassword;

    @FindBy(xpath = ".//button[text()='Sign In']")
    private WebElement buttonSignIn;

    @FindBy(xpath = ".//button[text()='Sign Out']") // щоб можна було клікнути кнопку заведи тут змінну
    private WebElement buttonSignOut;

    //ЕЛЕМЕНТИ які я спочатку описала в Header а потім перенесла сюди:

    @FindBy(xpath = "//input[@placeholder='Username']")
    private WebElement fieldLogin;

    @FindBy(xpath = "//input[@placeholder='Password']")
    private WebElement fieldPassword;

// Методи для елементів цієї сторінки:

    public LoginPage(WebDriver webDriver) { // конструктор
        super(webDriver);
    }

    public void openLoginPage() { // метод для відкриття сторінки
        openPage(BASE_URL);
    } // метод для відкриття сторінки

    public void enterTextIntoInputUserNane(String UserNane) { // метод для вводу юзернейм в поле
        enterTextIntoInput(inputUserNane, UserNane);
    } //
    public void enterTextIntoInputPassword(String Password) { // метод для вводу пароля в поле

        enterTextIntoInput(inputPassword,Password);
    }

    public void clickOnButtonSignIn() { // метод для кліку на кнопку Sign In
        clickOnElement(buttonSignIn);
    }

    public void clickOnButtonSignOut() { // метод для кліку на кнопку Sign Out
        clickOnElement(buttonSignOut);

    }

    // Методи які я спочатку описала в Header а потім перенесла сюди:
    // Методи присутності елементів на сторінці :

    public void checkIsButtonSignInVisible() { // метод для перевірки чи кнопка Sign In присутня на сторінці
        checkElementDisplayed(buttonSignIn);
    }

    public void checkIsFieldLoginVisible() { // метод для перевірки чи поле Login присутнє на сторінці
        checkElementDisplayed(fieldLogin);
    }

    public void checkIsFieldPasswordVisible() {  // метод для перевірки чи поле Password присутнє на сторінці
        checkElementDisplayed(fieldPassword);
    }

    // Методи перевірки відсутності елементів на сторінці :

    public void checkNotIsButtonSignInVisible() { // метод для перевірки відсутності кнопки Sign In на сторінці
        checkElementNotDisplayed(buttonSignIn);
    }

    public void checkNotIsFieldLoginVisible() { // метод для перевірки відсутності поля Login на сторінці
        checkElementNotDisplayed(fieldLogin);
    }

    public void checkNotIsFieldPasswordVisible() { // метод для перевірки відсутності поля Password на сторінці
        checkElementNotDisplayed(fieldPassword);
    }

    public void loginWithValidCreds() {
        openLoginPage();
        enterTextIntoInputUserNane(TestData.LOGIN_DEFAULT);
        enterTextIntoInputPassword(TestData.PASSWORD_DEFAULT);
        clickOnButtonSignIn();
    }
}