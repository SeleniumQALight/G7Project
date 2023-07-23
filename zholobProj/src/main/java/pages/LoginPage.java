package pages;

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


    public LoginPage(WebDriver webDriver) { // конструктор
        super(webDriver);
    }

    public void openLoginPage() { // метод для відкриття сторінки
        openPage(BASE_URL);
    }

    public void enterTextIntoInputUserNane(String UserNane) { // метод для вводу юзернейм в поле
        enterTextIntoInput(inputUserNane, UserNane);
    }
    public void enterTextIntoInputPassword(String Password) { // метод для вводу пароля в поле
        enterTextIntoInput(inputPassword,Password);
    }

    public void clickOnButtonSignIn() { // метод для кліку на кнопку Sign In
        clickOnElement(buttonSignIn);
    }

    public void clickOnButtonSignOut() { // метод для кліку на кнопку Sign Out
        clickOnElement(buttonSignOut);

    }
}