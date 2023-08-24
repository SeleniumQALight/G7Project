package loginTests;

//import io.github.bonigarcia.wdm.WebDriverManager;
//import org.junit.Assert;

import categories.SmokeTestFilter;
import io.qameta.allure.*;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import libs.ConfigProvider;
import libs.ExcelDriver;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;

import java.io.IOException;
import java.util.Map;

import static data.TestData.*;
@Epic("Allure examples")
@Feature("Junit 4 support")


@RunWith(JUnitParamsRunner.class) //позволяет использовать параметризацию
@Category(SmokeTestFilter.class)

public class LoginTestWithPageObject extends baseTest.BaseTest {
    final static String ERROR_USERNAME_OR_PASSWORD = "Invalid username / pasword";
    @Description("Some detailed test description")
    @Link("https://example.org")
    @Link(name = "allure", type = "mylink")
    @Issue("123")
    @Issue("432")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Base support for bdd annotations")

    @Test //проверка входа с невалидными данными
    //@Ignore
    @Category(SmokeTestFilter.class)
    @Parameters(method = "parametersForCheckInvalidLoginPassword") //параметризация
    public void checkInvalidLoginPassword(String userName, String password, String expectedMessages) {//перевірка невалідного логіну
        pageProvider.getLoginPage().openLoginPage();
        pageProvider.getLoginPage().enterTextIntoInputUserName(userName);
        pageProvider.getLoginPage().enterTextIntoInputPassword(password);
        pageProvider.getLoginPage().clickOnButtonSignIn();
        pageProvider.getLoginPage().checkIsButtonSignInVisible();//проверка, что кнопка Sign In видна
        pageProvider.getHomePage().getHeader().checkIsButtonSignOutNotVisible();//проверка, что кнопка Sign Out не видна

        pageProvider.getLoginPage().checkErrorMessageLogin(expectedMessages);//проверка, что появилось сообщение об ошибке
    }

    public Object[][] parametersForCheckInvalidLoginPassword() {
        return new Object[][]{//повертає параметри для тесту
                {SHORT_USER_NAME, "123456", ERROR_USERNAME_OR_PASSWORD},
                {"test", "123", ERROR_USERNAME_OR_PASSWORD}
        };
    }
    @Test
    @Category(SmokeTestFilter.class)
    public void validLogin() throws IOException {//getData- немає обробки ексепшина
        Map<String,String> dataForValidLogin =
                ExcelDriver.getData(ConfigProvider.configProperties.DATA_FILE(), "validLogOn");
        pageProvider.getLoginPage().openLoginPage();
        pageProvider.getLoginPage().enterTextIntoInputUserName(dataForValidLogin.get("login"));//LOGIN_DEFAULT);
        pageProvider.getLoginPage().enterTextIntoInputPassword(dataForValidLogin.get("pass"));//PASSWORD_DEFAULT);
        pageProvider.getLoginPage().clickOnButtonSignIn();
        pageProvider.getHomePage().getHeader().checkIsButtonSignOutVisible();

// TODO Assert
    }

    @Test
    public void invalidLogin() { // HW3 With PageObject
//        1. Додати тест кейс на невалідний логін (але тепер вже з пейдж обжектом),
//        аналогічні зробити перевірки до тесту, який ви писали без пейдж обжекта (цей кейс додати в наш класс LoginTestWithPageObject)

        pageProvider.getLoginPage().openLoginPage();
        pageProvider.getLoginPage().enterTextIntoInputUserName(LOGIN_INVALID);
        System.out.println("Username was inputted");

        pageProvider.getLoginPage().enterTextIntoInputPassword(PASSWORD_DEFAULT);
        System.out.println("Password was inputted");
        pageProvider.getLoginPage().clickOnButtonSignIn();
        System.out.println("Button 'Sign In' was clicked");

//        Assert.assertTrue("Button 'Sign In' is not displayed", LoginTest.isButtonSignInVisible());
//        Assert.assertTrue("Text Invalid username/password is not displayed", LoginTest.textInvalidUserVisible());
//        Assert.assertFalse("Button 'Sign Out' is displayed", LoginTest.isButtonSignOutVisible());

        pageProvider.getLoginPage().checkIsButtonSignInVisible();
        pageProvider.getLoginPage().checkIsMessageInvalidUsernameAndPasswordVisible();
        pageProvider.getHomePage().getHeader().checkIsButtonSignOutNotVisible();
    }

    @Test
    public void validLoginSignOut() {// HW3 p2
//        2. Написати тест на Sign Out
//        Залогінитися.
//        Після логіну перевірити наявність елементів в Хедері - кнопки пошуку, кнопки виклику чатику, аватарки,
//        кнопки CreatePost , кнопки signOut, а також відсутності поля для вводу логіна, пароля, та кнопки sign In.
//        (Для перевірки відсутності елементів додати відповідний метод в ActionsWithElements)
//
//        Зробити log Out і перевірити відсутність  елементів в Хедері - кнопки пошуку, кнопки виклику чатику,
//        аватарки,  кнопки CreatePost , кнопки signOut, а також наявність  поля для вводу логіна, пароля, та кнопки sign In.
        //LogIn
        pageProvider.getLoginPage().openLoginPage();
        pageProvider.getLoginPage().enterTextIntoInputUserName(LOGIN_DEFAULT);
        pageProvider.getLoginPage().enterTextIntoInputPassword(PASSWORD_DEFAULT);
        pageProvider.getLoginPage().clickOnButtonSignIn();

        pageProvider.getHomePage().getHeader().checkIsButtonSignOutVisible();
        pageProvider.getHomePage().getHeader().checkIsButtonSearchVisible();
        pageProvider.getHomePage().getHeader().checkIsButtonChatVisible();
        pageProvider.getHomePage().getHeader().checkIsButtonAvatarVisible();
        pageProvider.getHomePage().getHeader().checkIsButtonCreatePostVisible();

        pageProvider.getLoginPage().checkIsInputUserNameNotVisible();
        pageProvider.getLoginPage().checkIsInputPasswordNotVisible();
        pageProvider.getLoginPage().checkIsButtonSignInNotVisible();

        //LogOut
        pageProvider.getHomePage().getHeader().clickOnButtonSignOut();

        pageProvider.getHomePage().getHeader().checkIsButtonSearchNotVisible();
        pageProvider.getHomePage().getHeader().checkIsButtonChatNotVisible();
        pageProvider.getHomePage().getHeader().checkIsButtonAvatarNotVisible();
        pageProvider.getHomePage().getHeader().checkIsButtonCreatePostNotVisible();
        pageProvider.getHomePage().getHeader().checkIsButtonSignOutNotVisible();

        pageProvider.getLoginPage().checkIsInputUserNameVisible();
        pageProvider.getLoginPage().checkIsInputPasswordVisible();
        pageProvider.getLoginPage().checkIsButtonSignInVisible();
    }
}