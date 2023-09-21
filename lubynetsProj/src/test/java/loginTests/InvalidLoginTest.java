package loginTests;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class InvalidLoginTest extends baseTest.BaseTest {
    final static String SHORT_USER_NAME = "tr";
    final static String SHORT_PASSWORD = "trtr";
    final static String EMPTY_USER_NAME = "";
    final static String EMPTY_PASSWORD = "";
    final static String CIRILIC_USER_NAME = "логин";
    final static String CIRILIC_PASSWORD = "пароль";
    final static String LONG_LETTERS_LENGTH_50 = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
    final static String LONG_NUMBERS_LENGTH_50 = "12345123451234512345123451234512345123451234512345";
    final static String LONG_LETTERS_NUMBERS_LENGTH_50 = "1234512345123451234512345AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";

    @Test
    @Parameters(method = "parametersForCheckErrorsTest")
    public void checkErrorsTest(String userName, String password) {
        pageProvider.getLoginPage().openLoginPage();
        pageProvider.getLoginPage().enterTextIntoInputUserName(userName);
        pageProvider.getLoginPage().enterTextIntoInputPassword(password);
        pageProvider.getLoginPage().clickOnButtonSignIn();
        pageProvider.getHomePage().getHeader().checkIsButtonSignOutNotVisible();
        pageProvider.getHomePage().getHeader().checkIsMassageInvalidDisplayed();
        pageProvider.getLoginPage().checkIsButtonSignInVisible();
    }

    public Object[][] parametersForCheckErrorsTest() {
        return new Object[][]{
                {SHORT_USER_NAME, SHORT_PASSWORD},
                {EMPTY_USER_NAME, EMPTY_PASSWORD},
                {LONG_NUMBERS_LENGTH_50, LONG_NUMBERS_LENGTH_50},
                {LONG_LETTERS_LENGTH_50, LONG_LETTERS_LENGTH_50},
                {LONG_LETTERS_NUMBERS_LENGTH_50, LONG_LETTERS_NUMBERS_LENGTH_50},
                {CIRILIC_USER_NAME, CIRILIC_PASSWORD},
        };
    }
}