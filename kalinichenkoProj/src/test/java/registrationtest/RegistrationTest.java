package registrationtest;

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
//    String expectedMessage = "You must provide a valid email address.;Password must be at least 12 characters.";

    final static String ERROR_USERNAME = "Username must be at least 3 characters.";
    final static String ERROR_EMAIL = "You must provide a valid email address.";
    final static String ERROR_PASSWORD = "Password must be at least 12 characters.";
    final static String ERROR_ALREADY_EXIST = "That username is already taken.";
    final static String ERROR_USERNAME_NOT_EN = "Username can only contain letters and numbers.";
    final static String ERROR_PASSWORD_TOO_LONG = "Password cannot exceed 50 characters.";
    final static String SEMICOLON = ";";
    final static String COMMA = ",";
    final static String SHORT_USER_NAME = "tr";
    @Test
    @Parameters(method = "parametersForCheckErrorsTest")

    public void checkErrorsTest(String userName, String email, String password, String expectedMessage) {
        pageProvider.getLoginPage().openLoginPage();
        pageProvider.getLoginPage().enterTextIntoRegistrationUserNameField(userName);
        pageProvider.getLoginPage().enterTextIntoRegistrationEmailField(email);
        pageProvider.getLoginPage().enterTextIntoRegistrationPasswordField(password);
        pageProvider.getLoginPage().checkErrorsMessage(expectedMessage);
    }

    public Object[][] parametersForCheckErrorsTest() {
        return new Object[][]{
                {SHORT_USER_NAME, "trtr", "123456", ERROR_USERNAME + SEMICOLON + ERROR_EMAIL + SEMICOLON + ERROR_PASSWORD},
                {"test", "tr@tr.com", "123456", ERROR_PASSWORD},
                {"Тест", "trtr", "123456", ERROR_USERNAME_NOT_EN + SEMICOLON + ERROR_EMAIL + SEMICOLON + ERROR_PASSWORD},
                {"test", "trtr", "12345678901234567890123456789012345678901234567890QAZWSXEDCRFVTGB", ERROR_EMAIL + SEMICOLON + ERROR_PASSWORD_TOO_LONG}
        };

}
}
