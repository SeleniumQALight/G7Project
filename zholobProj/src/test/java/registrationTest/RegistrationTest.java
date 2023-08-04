package registrationTest;

import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;
import junitparams.JUnitParamsRunner;

@RunWith(JUnitParamsRunner.class)

public class RegistrationTest extends baseTest.BaseTest{
    final static String ERROR_USERNAME = "Username must be at least 3 characters.";
    final static String ERROR_EMAIL = "You must provide a valid email address.";
    final static String ERROR_PASSWORD = "Password must be at least 12 characters.";
    final static String ERROR_ALREADY_EXIST = "That username is already taken.";
    final static String SEMICOLON = ";";
    final static String COMMA = ",";
    final static String SHORT_USER_NAME = "tr";


    String userName = "test";
    String email = "tartar";
    String password = "123456" ;

    String expectedMessages = "You must provide a valid email address.;Password must be at least 12 characters.";

    @Test
    @Parameters(method = "parametersForCheckErrorsTest")
    public void checkErrorsTest(String userName, String email, String password, String expectedMessages) {
        pageProvider.getloginPage().openLoginPage();
        pageProvider.getloginPage().enterTextIntoRegistrationUserNameField(userName);
        pageProvider.getloginPage().enterTextIntoRegistrationEmailField(email);
        pageProvider.getloginPage().enterTextIntoRegistrationPasswordField(password);
        pageProvider.getloginPage().checErrorsMessages(expectedMessages);

}
    public Object[][] parametersForCheckErrorsTest() {
        return new Object[][]{
                {SHORT_USER_NAME, "trtrt", "123456", ERROR_USERNAME + SEMICOLON + ERROR_PASSWORD + SEMICOLON + ERROR_EMAIL },
                {"test", "tr@trt.com", "123", ERROR_PASSWORD},

        };
    }
}





