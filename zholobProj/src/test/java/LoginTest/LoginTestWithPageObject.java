package LoginTest;

import data.TestData;
import org.junit.Test;

import static data.TestData.LOGIN_DEFAULT;
import static data.TestData.PASSWORD_DEFAULT;

public class LoginTestWithPageObject extends baseTest.BaseTest {

    @Test
    public void validLogin() {
        pageProvider.getloginPage().openLoginPage();
        pageProvider.getloginPage().enterTextIntoInputUserNane(LOGIN_DEFAULT);
        pageProvider.getloginPage().enterTextIntoInputPassword(PASSWORD_DEFAULT);
        pageProvider.getloginPage().clickOnButtonSignIn();

        pageProvider.getHomePage().getHeader().checkIsButtonSignOutVisible(); // перевірка чи є кнопка SignOut
    }

    @Test
    public void inValidLogin() {
        pageProvider.getloginPage().openLoginPage();
        pageProvider.getloginPage().enterTextIntoInputUserNane(LOGIN_DEFAULT + "1");
        pageProvider.getloginPage().enterTextIntoInputPassword(PASSWORD_DEFAULT);
        pageProvider.getloginPage().clickOnButtonSignIn();

        pageProvider.getHomePage().getHeader().checkIsButtonSignInVisible(); // перевірка чи є кнопка SignIn
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

        pageProvider.getHomePage().getHeader().checkNotIsFieldLoginVisible(); // перевірка чи відсутнє поле Login
        pageProvider.getHomePage().getHeader().checkNotIsFieldPasswordVisible(); // перевірка чи відсутнє поле Password

        pageProvider.getloginPage().clickOnButtonSignOut(); // клік на кнопку SignOut

        pageProvider.getHomePage().getHeader().checkNotIsButtonSearchVisible(); // перевірка чи немає кнопки Search
        pageProvider.getHomePage().getHeader().checkNotIsButtonChatVisible(); // перевірка чи немає кнопки Chat
        pageProvider.getHomePage().getHeader().checkNotIsButtonMyProfileVisible(); // перевірка чи немає кнопки MyProfile
        pageProvider.getHomePage().getHeader().checkNotIsButtonCreatePostVisible();  // перевірка чи немає кнопки CreatePost
        pageProvider.getHomePage().getHeader().checkNotIsButtonSignOutVisible(); // перевірка чи немає кнопки SignOut


        pageProvider.getHomePage().getHeader().checkIsButtonSignInVisible(); // перевірка чи є кнопка SignIn
        pageProvider.getHomePage().getHeader().checkIsFieldLoginVisible(); // перевірка чи є поле Login
        pageProvider.getHomePage().getHeader().checkIsFieldPasswordVisible(); // перевірка чи є поле Password

    }
}