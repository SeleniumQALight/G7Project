package registrationTest;

import baseTest.BaseTest;
import categories.SmokeTestFilter;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
@Category(SmokeTestFilter.class)
public class RegistrationTest extends BaseTest {

    final static String ERROR_USERNAME = "Username must be at least 3 characters.";
    final static String ERROR_EMAIL = "You must provide a valid email address.";
    final static String ERROR_PASSWORD = "Password must be at least 12 characters.";
    final static String ERROR_USERNAME_ALREADY_EXIST = "That username is already taken.";
    final static String ERROR_EMAIL_ALREADY_EXIST = "That email is already being used.";
    final static String ERROR_INVALID_USERNAME_CHARS = "Username can only contain letters and numbers.";
    final static String SEMICOLON = ";";
    final static String COMMA = ",";
    final static String SHORT_USER_NAME = "tr";
    final static String ALREADY_EXIST_USER_NAME = "qaauto";
    final static String INVALID_USERNAME_CHARS = "олеся";
    @Test
    @Parameters(method = "parametersForCheckErrorsTest")
    public void checkErrorsTest(String userName, String email, String password, String expectedMessages) {
        pageProvider.getLoginPage().openLoginPage();
        pageProvider.getLoginPage().enterTextIntoRegistrationUserNameField(userName);
        pageProvider.getLoginPage().enterTextIntoRegistrationEmailField(email);
        pageProvider.getLoginPage().enterTextIntoRegistrationPasswordField(password);
        pageProvider.getLoginPage().checkErrorsMessages(expectedMessages);
    }

    public Object[][] parametersForCheckErrorsTest() {
        return new Object[][]{
                {SHORT_USER_NAME, "trtr", "123456",  ERROR_USERNAME + SEMICOLON + ERROR_EMAIL + SEMICOLON + ERROR_PASSWORD},
                {"test", "tr1@tr.com", "123", ERROR_PASSWORD},
                {INVALID_USERNAME_CHARS, "test@t.com", "123456", ERROR_INVALID_USERNAME_CHARS + SEMICOLON + ERROR_PASSWORD},
                {ALREADY_EXIST_USER_NAME, "tr@tr.com", "qwerasdfzxcv12", ERROR_USERNAME_ALREADY_EXIST + SEMICOLON + ERROR_EMAIL_ALREADY_EXIST},
        };
    }
}
