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
//
//    String expectedMessages = "You must provide a valid email address.;Password must be at least 12 characters.";

    final static String ERROR_USERNAME = "Username must be at least 3 characters.";
    final static String ERROR_EMAIL = "You must provide a valid email address.";
    final static String ERROR_PASSWORD = "Password must be at least 12 characters.";
    final static String ERROR_ALREADY_EXIST = "That username is already taken.";
    final static String SEMICOLON = ";";
    final static String COMMA = ",";
    final static String SHORT_USER_NAME = "tr";

    final static String USER_NAME_REGISTER_INVALID = "qaauto";
    final static String ERROR_MESSAGE_USER_NAME_REGISTER = "That username is already taken.";
    final static String USER_NAME_REGISTER_INVALID1 = "qaautotesttesttetesttesttetesttesttetesttesttetesttesttet";
    final static String ERROR_MESSAGE_USER_NAME_REGISTER1 = "Username cannot exceed 30 characters.";
    final static String PASSWORD_REGISTER_INVALID = "testtesttetesttesttetesttesttetesttesttetesttesttet";
    final static String ERROR_MESSAGE_PASSWORD_REGISTER = "Password cannot exceed 50 characters.";

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
                {SHORT_USER_NAME, "trtr", "123456", ERROR_USERNAME + SEMICOLON + ERROR_EMAIL + SEMICOLON + ERROR_PASSWORD},
                {"test", "tr@tr.com", "123456", ERROR_PASSWORD},
        };
    }

    @Test
    @Parameters(method = "parametersForCheckErrorsTest1")
    public void checkErrorsTest1(String userName, String email, String password, String expectedMessages) {
        pageProvider.getLoginPage().openLoginPage();
        pageProvider.getLoginPage().enterTextIntoRegistrationUserNameField(userName);
        pageProvider.getLoginPage().enterTextIntoRegistrationEmailField(email);
        pageProvider.getLoginPage().enterTextIntoRegistrationPasswordField(password);
        pageProvider.getLoginPage().checkErrorsMessages(expectedMessages);
    }

    public Object[][] parametersForCheckErrorsTest1() {
        return new Object[][]{
                {USER_NAME_REGISTER_INVALID, "test@test.com", PASSWORD_REGISTER_INVALID,
                        ERROR_MESSAGE_USER_NAME_REGISTER + SEMICOLON + ERROR_MESSAGE_PASSWORD_REGISTER},
                {USER_NAME_REGISTER_INVALID1, "test@test.com", "1234567891011",
                        ERROR_MESSAGE_USER_NAME_REGISTER1},
        };
    }
}
