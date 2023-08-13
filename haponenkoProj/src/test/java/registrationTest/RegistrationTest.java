package registrationTest;

import baseTest.BaseTest;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class RegistrationTest extends BaseTest {
//    String userName = "test";
//    String email = "trtr";
//    String password = "123456";
//    String expectedErrorMessage = "You must provide a valid email address.;Password must be at least 12 characters.";

    final static String ERROR_USERNAME = "Username must be at least 3 characters.";
    final static String ERROR_EMAIL = "You must provide a valid email address.";
    final static String ERROR_PASSWORD = "Password must be at least 12 characters.";
    final static String ERROR_ALREADY_EXIST = "That username is already taken.";
    final static String SEMICOLON = ";";
    final static String COMMA = ",";
    final static String SHORT_USER_NAME = "tr";
    final static String ERROR_USERNAME_CYRILLIC = "Username can only contain letters and numbers.";
    final static String ERROR_EMAIL_EXIST = "That email is already being used.";
    final static String ERROR_PASSWORD_TOO_LONG = "Password cannot exceed 50 characters.";

    @Test
    @Parameters(method = "parametersForCheckErrorsTest")
    public void checkErrorsTest(String userName, String email, String password, String expectedErrorMessages) {
        pageProvider.getLoginPage().openLoginPage();
        pageProvider.getLoginPage().enterTextIntoRegistrationUserName(userName);
        pageProvider.getLoginPage().enterTextIntoRegistrationEmail(email);
        pageProvider.getLoginPage().enterTextIntoRegistrationPassword(password);
        pageProvider.getLoginPage().checkErrorsMessages(expectedErrorMessages);
    }

    public Object[][] parametersForCheckErrorsTest() {
        return new Object[][]{
                {SHORT_USER_NAME, "trtr", "123456", ERROR_USERNAME + SEMICOLON + ERROR_EMAIL + SEMICOLON + ERROR_PASSWORD},
                {"test", "tr@tr.com", "123", ERROR_PASSWORD},
                {"Ірина", "iryna@qa.auto", " ", ERROR_USERNAME_CYRILLIC + SEMICOLON + ERROR_EMAIL_EXIST + SEMICOLON + ERROR_PASSWORD},
                {"qaauto", " ", "qwerty123456111111111111111111111111111111111111111", ERROR_ALREADY_EXIST + SEMICOLON + ERROR_EMAIL + SEMICOLON + ERROR_PASSWORD_TOO_LONG},
        };
    }
}

