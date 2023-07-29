package loginTests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

import java.sql.SQLOutput;
import java.util.concurrent.TimeUnit;

import static data.TestData.*;

public class LoginTestWithPageObject extends baseTest.BaseTest {
    WebDriver webDriver;

    @Test
    public void validLogin() {
        pageProvider.getloginPage().openLoginPage();
        pageProvider.getloginPage().enterTextIntoInputUserName(LOGIN_DEFAULT);
        pageProvider.getloginPage().enterTextIntoInputPassword(PASSWORD_DEFAULT);
        pageProvider.getloginPage().clickOnButtonSignIn();
        pageProvider.getHomePage().getHeader().checkIsButtonSignOutVisible();


// TODO Assert
    }

    @Test
    public void invalidLogin() { // HW3 With PageObject
//        1. Додати тест кейс на невалідний логін (але тепер вже з пейдж обжектом),
//        аналогічні зробити перевірки до тесту, який ви писали без пейдж обжекта (цей кейс додати в наш класс LoginTestWithPageObject)

        pageProvider.getloginPage().openLoginPage();
        pageProvider.getloginPage().enterTextIntoInputUserName(LOGIN_INVALID);
        System.out.println("Username was inputted");

        pageProvider.getloginPage().enterTextIntoInputPassword(PASSWORD_DEFAULT);
        System.out.println("Password was inputted");
        pageProvider.getloginPage().clickOnButtonSignIn();
        System.out.println("Button 'Sign In' was clicked");

//        Assert.assertTrue("Button 'Sign In' is not displayed", LoginTest.isButtonSignInVisible());
//        Assert.assertTrue("Text Invalid username/password is not displayed", LoginTest.textInvalidUserVisible());
//        Assert.assertFalse("Button 'Sign Out' is displayed", LoginTest.isButtonSignOutVisible());

        pageProvider.getloginPage().checkIsButtonSignInVisible();
        pageProvider.getloginPage().checkIsMessageInvalidUsernameAndPasswordVisible();
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
        pageProvider.getloginPage().openLoginPage();
        pageProvider.getloginPage().enterTextIntoInputUserName(LOGIN_DEFAULT);
        pageProvider.getloginPage().enterTextIntoInputPassword(PASSWORD_DEFAULT);
        pageProvider.getloginPage().clickOnButtonSignIn();

        pageProvider.getHomePage().getHeader().checkIsButtonSignOutVisible();
        pageProvider.getHomePage().getHeader().checkIsButtonSearchVisible();
        pageProvider.getHomePage().getHeader().checkIsButtonChatVisible();
        pageProvider.getHomePage().getHeader().checkIsButtonAvatarVisible();
        pageProvider.getHomePage().getHeader().checkIsButtonCreatePostVisible();

        pageProvider.getloginPage().checkIsInputUserNameNotVisible();
        pageProvider.getloginPage().checkIsInputPasswordNotVisible();
        pageProvider.getloginPage().checkIsButtonSignInNotVisible();

        //LogOut
        pageProvider.getHomePage().getHeader().clickOnButtonSignOut();

        pageProvider.getHomePage().getHeader().checkIsButtonSearchNotVisible();
        pageProvider.getHomePage().getHeader().checkIsButtonChatNotVisible();
        pageProvider.getHomePage().getHeader().checkIsButtonAvatarNotVisible();
        pageProvider.getHomePage().getHeader().checkIsButtonCreatePostNotVisible();
        pageProvider.getHomePage().getHeader().checkIsButtonSignOutNotVisible();

        pageProvider.getloginPage().checkIsInputUserNameVisible();
        pageProvider.getloginPage().checkIsInputPasswordVisible();
        pageProvider.getloginPage().checkIsButtonSignInVisible();
    }
}