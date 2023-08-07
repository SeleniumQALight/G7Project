package loginTests;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class InvalidLoginTest extends baseTest.BaseTest {
    final static String ERROR_USERNAME = "Invalid username / pasword\n";
    final static String ERROR_PASSWORD = "Invalid username / pasword\n";
    final static String ERROR_USERNAME_PASSWORD = "Invalid username / pasword\n";
    final static String SEMICOLON = ";";
    final static String COMMA = ",";
    final static String SHORT_USER_NAME = "tr";
    final static String SHORT_PASSWORD = "trtr";
    final static String EMPTY_USER_NAME = "";
    final static String EMPTY_PASSWORD = "";
    final static String CIRILIC_USER_NAME = "логин";
    final static String CIRILIC_PASSWORD = "пароль";
    final static String LONG_USER_NAME_SMALL_LETTERS = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
    final static String LONG_PASSWORD_SMALL_LETTERS = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
    final static String LONG_USER_NAME_NUMBERS = "123451234512345123451234512345123451234512345123451234512345";
    final static String LONG_PASSWORD_NUMBERS = "123451234512345123451234512345123451234512345123451234512345";
    final static String LONG_USER_NAME_LETTERS = "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
    final static String LONG_PASSWORD_LETTERS = "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
    final static String LONG_USER_NAME_LETTERS_NUMBERS = "1234512345123451234512345AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
    final static String LONG_PASSWORD_LETTERS_NUMBERS = "1234512345123451234512345AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";


    @Test
    @Parameters(method = "parametersForCheckErrorsTest")
    public void checkErrorsTest(String userName, String Password, String expectedMessages) {
        pageProvider.getloginPage().openLoginPage();
        pageProvider.getloginPage().enterTextIntoInputUserName(userName);
        pageProvider.getloginPage().enterTextIntoInputPassword(Password);
        pageProvider.getloginPage().clickOnButtonSignIn();
        pageProvider.getHomePage().getHeader().checkIsButtonSignOutNotVisible();
        pageProvider.getHomePage().getHeader().checkIsMassageInvalidDisplayed();
        pageProvider.getloginPage().checkIsButtonSignInVisible();
    }

    public Object[][] parametersForCheckErrorsTest() {

        return new Object[][]{
                {SHORT_USER_NAME, SHORT_PASSWORD, ERROR_USERNAME + SEMICOLON + ERROR_PASSWORD},
                {EMPTY_USER_NAME, EMPTY_PASSWORD, SEMICOLON + ERROR_USERNAME_PASSWORD},
                {EMPTY_USER_NAME, EMPTY_PASSWORD, ERROR_USERNAME + SEMICOLON + ERROR_PASSWORD},
                {LONG_USER_NAME_NUMBERS, LONG_PASSWORD_NUMBERS, ERROR_USERNAME + SEMICOLON + ERROR_PASSWORD},
                {LONG_USER_NAME_LETTERS, LONG_PASSWORD_LETTERS, ERROR_USERNAME + SEMICOLON + ERROR_PASSWORD},
                {LONG_USER_NAME_LETTERS_NUMBERS, LONG_PASSWORD_LETTERS_NUMBERS, ERROR_USERNAME + SEMICOLON + ERROR_PASSWORD},
                {CIRILIC_USER_NAME, CIRILIC_PASSWORD, ERROR_USERNAME + SEMICOLON + ERROR_PASSWORD},
                {LONG_USER_NAME_SMALL_LETTERS, LONG_PASSWORD_SMALL_LETTERS, ERROR_USERNAME + SEMICOLON + ERROR_PASSWORD},
        };

    }

}