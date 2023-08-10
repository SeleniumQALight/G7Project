package pages;

import data.TestData;
import libs.Util;
import org.assertj.core.api.SoftAssertions;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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

    @FindBy(id = "username-register") // для реєстрації
    WebElement inputUserNaneRegistration;

    @FindBy(id = "email-register") // для реєстрації
    WebElement inputEmailRegistration;

    @FindBy(id = "password-register") // для реєстрації
    WebElement inputPasswordRegistration;

    //локатор  для списоку червоних повідомлень з помилками при неправильному вводі логіна чи пароля
    final String listErrorsMessagesLocator = ".//*[@class='alert alert-danger small liveValidateMessage liveValidateMessage--visible']";

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

        enterTextIntoInput(inputPassword, Password);
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

    public void loginWithValidCreds() { //4 в одному для логіна з валідними даними
        openLoginPage();
        enterTextIntoInputUserNane(TestData.LOGIN_DEFAULT);
        enterTextIntoInputPassword(TestData.PASSWORD_DEFAULT);
        clickOnButtonSignIn();
    }

    public LoginPage enterTextIntoRegistrationUserNameField(String userName) { // метод для вводу юзернейм в поле реєстрації
        enterTextIntoInput(inputUserNaneRegistration, userName);
        return this;
    }

    public LoginPage enterTextIntoRegistrationEmailField(String email) { // метод для вводу емейлу в поле реєстрації
        enterTextIntoInput(inputEmailRegistration, email);
        return this;
    }

    public LoginPage enterTextIntoRegistrationPasswordField(String password) { // метод для вводу пароля в поле реєстрації
        enterTextIntoInput(inputPasswordRegistration, password);
        return this;
    }

    public LoginPage checErrorsMessages(String expectedMessages) { // метод для перевірки кількості помилок
        // error1;error2--> [error1,error2]
        String[] errors = expectedMessages.split(";"); // розбиваємо стрічку помилок на масив окремих помилок
        // wait util number of  errors  will be expected
        List<WebElement> until = webDriverWait10.until // чекаємо 10с поки кількість помилок буде як в масиві
                (ExpectedConditions.numberOfElementsToBe //
                        (By.xpath(listErrorsMessagesLocator), errors.length));

        Util.waitABit(1); // чекаємо 1 секунду


        Assert.assertEquals("Number of elements", errors.length, //
                getListOfErrors().size());


        ArrayList actualTextFromErrors = new ArrayList(); // створили ліст для зберігання тексту з помилок
        for (WebElement element : getListOfErrors()) { // цикл для перебору елементів
            actualTextFromErrors.add(element.getText()); // додали текст з помилок в масив
        }

        SoftAssertions softAssertions = new SoftAssertions();//
        for (int i = 0; i < errors.length; i++) { // цикл для перевірки помилок
            softAssertions.assertThat(errors[i])
                    .as("Error " + i)
                    .isIn(actualTextFromErrors);
        }


        softAssertions.assertAll(); // для того щоб вивести всі помилки
        return this;
    }

    private List<WebElement> getListOfErrors() { // метод для отримання списку помилок за локаторои
        return webDriver.findElements(By.xpath(listErrorsMessagesLocator));
    }}