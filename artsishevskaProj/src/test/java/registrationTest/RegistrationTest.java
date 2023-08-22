package registrationTest;

import baseTest.BaseTest;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)

public class RegistrationTest extends BaseTest {
   // String userName = "test";
    //String email = "trtr";
   // String password = "123456";
    //String expectedMessages = "You must provide a valid email address.;Password must be at least 12 characters.";
   final static String ERROR_USERNAME = "Username must be at least 3 characters.";
    final static String ERROR_EMAIL = "You must provide a valid email address.";
    final static String ERROR_PASSWORD = "Password must be at least 12 characters.";
    final static String ERROR_ALREADY_EXIST = "That username is already taken.";
    final static String SEMICOLON = ";";
    final static String COMMA = ",";
    final static String SHORT_USER_NAME = "tr";
    final static String LONG_USER_NAME = "qaautoqaautoqaautoqaautoqaautoo";
    final static String LONG_PASSWORD = "qwerty123456qwerty123456qwerty123456qwerty123456qwerty123456qwerty123456";
    final static String ERROR_USERNAME_TYPE = "Username can only contain letters and numbers.";
    final static String ERROR_USERNAME_EXISTING = "That username is already taken.";
    final static String ERROR_USERNAME_MAX_LENGTH = "Username cannot exceed 30 characters.";
    final static String ERROR_PASSWORD_MAX_LENGTH = "Password cannot exceed 50 characters.";

    @Test
    @Parameters(method = "parametersForCheckErrorsTest")//зв'язок методу з тестом
    public void checkErrorsTest(String userName, String email, String password, String expectedMessages){
        pageProvider.getLoginPage().openLoginPage();
        pageProvider.getLoginPage().enterTextIntoRegistrationUserNameField(userName);
        pageProvider.getLoginPage().enterTextIntoRegistrationEmailField(email);
        pageProvider.getLoginPage().enterTextIntoRegistrationPasswordField(password);
        pageProvider.getLoginPage().checkErrorsMessages(expectedMessages);
    }
    public Object[][] parametersForCheckErrorsTest(){
        return new Object[][]{
                {SHORT_USER_NAME, "trtr","123456",ERROR_USERNAME + SEMICOLON + ERROR_EMAIL + SEMICOLON +ERROR_PASSWORD},

                {"test","tr@tr.com","123",ERROR_PASSWORD},
                {"тест","trt", "123456", ERROR_USERNAME_TYPE + SEMICOLON + ERROR_EMAIL + SEMICOLON + ERROR_PASSWORD},
                {"qaauto","tr@tr.com",LONG_PASSWORD, ERROR_USERNAME_EXISTING + SEMICOLON + ERROR_PASSWORD_MAX_LENGTH},

        };
    }
    @Test
    @Parameters(method = "parametersForCheckErrorsTestLogin")
    public void checkErrorsTestLogin(String userName, String expectedMessages){
        pageProvider.getLoginPage().openLoginPage();
        pageProvider.getLoginPage().enterTextIntoRegistrationUserNameField(userName);
        pageProvider.getLoginPage().checkErrorsMessages(expectedMessages);
    }
    public Object[][] parametersForCheckErrorsTestLogin(){
        return new Object[][]{
                {SHORT_USER_NAME, ERROR_USERNAME},
                {"тест", ERROR_USERNAME_TYPE},
                {"qaauto", ERROR_USERNAME_EXISTING},
                {LONG_USER_NAME, ERROR_USERNAME_MAX_LENGTH},
        };
    }

}
