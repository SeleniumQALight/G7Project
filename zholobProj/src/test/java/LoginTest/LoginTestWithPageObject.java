package LoginTest;

import categories.SmokeTestFilter;
import io.qameta.allure.*;
import libs.ConfigProvider;
import libs.ExcelDriver;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import java.io.IOException;
import java.util.Map;

import static data.TestData.LOGIN_DEFAULT;
import static data.TestData.PASSWORD_DEFAULT;


@Epic("Allure examples")
@Feature("Junit 4 support")

public class LoginTestWithPageObject extends baseTest.BaseTest {
    @Description("Some detailed test description") //додаткова мета-інформація для
    @Link("https://example.org")
    @Link(name = "allure", type = "mylink")
    @Issue("123")
    @Issue("432")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Base support for bdd annotations") // додаткова мета-інформація для

    @Test
    @Category(SmokeTestFilter.class) // для того щоб запустити тільки тест з цією категорією
    public void validLogin() {
        pageProvider.getloginPage().openLoginPage();
        pageProvider.getloginPage().enterTextIntoInputUserNane(LOGIN_DEFAULT);
        pageProvider.getloginPage().enterTextIntoInputPassword(PASSWORD_DEFAULT);
        pageProvider.getloginPage().clickOnButtonSignIn();

        pageProvider.getHomePage().getHeader().checkIsButtonSignOutVisible(); // перевірка чи є кнопка SignOut
    }

    @Test
    public void validLoginWithExcel() throws IOException { // тест з даними з екселю
        Map<String,String> dataForValidLogin =// створюємо мапу з даними з екселю
                ExcelDriver.getData(ConfigProvider.configProperties.DATA_FILE(),"validLogOn");// шлях до екселю і назва листа
        pageProvider.getloginPage().openLoginPage();//
        pageProvider.getloginPage().enterTextIntoInputUserNane(dataForValidLogin.get("login")); // заповнюємо з мапки значення по ключу логін//замість LOGIN_DEFAULT
        pageProvider.getloginPage().enterTextIntoInputPassword(dataForValidLogin.get("pass")); // заповнюємо з мапки значення по ключу пасс //замість PASSWORD_DEFAULT
        pageProvider.getloginPage().clickOnButtonSignIn(); // клік на кнопку Sign In

        pageProvider.getHomePage().getHeader().checkIsButtonSignOutVisible(); // перевірка чи є кнопка SignOut
    }


    @Test
    public void inValidLogin() {
        pageProvider.getloginPage().openLoginPage();
        pageProvider.getloginPage().enterTextIntoInputUserNane(LOGIN_DEFAULT + "1");
        pageProvider.getloginPage().enterTextIntoInputPassword(PASSWORD_DEFAULT);
        pageProvider.getloginPage().clickOnButtonSignIn();

        pageProvider.getloginPage().checkIsButtonSignInVisible(); // перевірка чи є кнопка SignIn
        pageProvider.getHomePage().getHeader().checkNotIsButtonMyProfileVisible(); // перевірка чи немає кнопки MyProfile
    }

    @Test
    public void checkingSignOut() {
        pageProvider.getloginPage().openLoginPage();
        pageProvider.getloginPage().enterTextIntoInputUserNane(LOGIN_DEFAULT);
        pageProvider.getloginPage().enterTextIntoInputPassword(PASSWORD_DEFAULT);
        pageProvider.getloginPage().clickOnButtonSignIn();

        pageProvider.getHomePage().getHeader().checkIsButtonSearchVisible(); // перевірка чи є кнопка Search
        pageProvider.getHomePage().getHeader().checkIsButtonChatVisible(); // перевірка чи є кнопка Chat
        pageProvider.getHomePage().getHeader().checkIsButtonMyProfileVisible(); // перевірка чи є кнопка MyProfile
        pageProvider.getHomePage().getHeader().checkIsButtonSignOutVisible(); // перевірка чи є кнопка SignOut
        pageProvider.getHomePage().getHeader().checkIsButtonCreatePostVisible(); // перевірка чи є кнопка CreatePost

        pageProvider.getloginPage().checkNotIsFieldLoginVisible(); // перевірка чи відсутнє поле Login
        pageProvider.getloginPage().checkNotIsFieldPasswordVisible(); // перевірка чи відсутнє поле Password

        pageProvider.getloginPage().clickOnButtonSignOut(); // клік на кнопку SignOut

        pageProvider.getHomePage().getHeader().checkNotIsButtonSearchVisible(); // перевірка чи немає кнопки Search
        pageProvider.getHomePage().getHeader().checkNotIsButtonChatVisible(); // перевірка чи немає кнопки Chat
        pageProvider.getHomePage().getHeader().checkNotIsButtonMyProfileVisible(); // перевірка чи немає кнопки MyProfile
        pageProvider.getHomePage().getHeader().checkNotIsButtonCreatePostVisible();  // перевірка чи немає кнопки CreatePost
        pageProvider.getHomePage().getHeader().checkNotIsButtonSignOutVisible(); // перевірка чи немає кнопки SignOut


        pageProvider.getloginPage().checkIsButtonSignInVisible(); // перевірка чи є кнопка SignIn
        pageProvider.getloginPage().checkIsFieldLoginVisible(); // перевірка чи є поле Login
        pageProvider.getloginPage().checkIsFieldPasswordVisible(); // перевірка чи є поле Password

    }
}