package registrationTest;

import baseTest.BaseTest;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;
import junitparams.JUnitParamsRunner;

@RunWith(JUnitParamsRunner.class) // завантажуэмо декілька разів


public class RegistrationTest extends BaseTest {
//    String userName = "test";
//    String email = "trtrt";
//    String password = "123456";
//    String expectedMessages = "You must provide a valid email address.;Password must be at least 12 characters.";

    final static String ERROR_USERNAME = "Username must be at least 3 characters.";
    final static String ERROR_USERNAME1 = "Username can only contain letters and numbers.";
    final static String ERROR_EMAIL = "You must provide a valid email address.";
    final static String ERROR_PASSWORD = "Password must be at least 12 characters.";
    final static String ERROR_PASSWORD_LONG = "Password cannot exceed 50 characters.";
    final static String ERROR_ALREADY_EXIST = "That username is already taken.";
    final static String SEMICOLON = ";";
    final static String COMMA = ",";


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
                {SHORT_USER_NAME, "trtrt", "123456", ERROR_USERNAME + SEMICOLON + ERROR_EMAIL + SEMICOLON + ERROR_PASSWORD},
                {"test", "tr@trt.com", "123", ERROR_PASSWORD},
                {"Мари", "trtrt", "123456", ERROR_USERNAME1 + SEMICOLON + ERROR_EMAIL + SEMICOLON + ERROR_PASSWORD},
                {SHORT_USER_NAME, "tr@trt.com", "123QWERTY1123QWERTY1123QWERTY1123QWERTY1123QWERTY1123QWERTY1123QWERTY1", ERROR_USERNAME + SEMICOLON + ERROR_PASSWORD_LONG}
        };
    }
}