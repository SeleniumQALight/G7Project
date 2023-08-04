package registrationTest;

import baseTest.BaseTest;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class registrationTest extends BaseTest {

   // String userName = "test";
  //  String email = "trtr";
  //  String password = "123456";
   // String expectedMessage =  "You must provide a valid email address.;Password must be at least 12 characters.";
   final static String ERROR_USERNAME = "Username must be at least 3 characters.";
    final static String ERROR_EMAIL = "You must provide a valid email address.";
    final static String ERROR_PASSWORD = "Password must be at least 12 characters.";
    final static String ERROR_ALREADY_EXIST = "That username is already taken.";
    final static String SEMICOLON = ";";
    final static String COMMA = ",";
    final static String SHORT_USER_NAME = "tr";

            @Test
            @Parameters(method = "parametersForCheckErrors")
    public void checkErrorsTest(String userName, String email, String password, String expectedMessage) {
        pageProvider.getloginPage().openLoginPage();
                pageProvider.getloginPage().enterTextIntoRegistrationUserNameField(userName);
                pageProvider.getloginPage().enterTextIntoRegistrationEmailField(email);
                pageProvider.getloginPage().enterTextIntoRegistrationPasswordField(password);
pageProvider.getloginPage().checkErrorsMessages(expectedMessage);

            }

            public Object[][] parametersForCheckErrors() {
                return new Object[][]{
                        {SHORT_USER_NAME, "trtr", "123456", ERROR_USERNAME + SEMICOLON + ERROR_EMAIL+ SEMICOLON + ERROR_PASSWORD},
                        {"test", "tr@tr", "1", ERROR_PASSWORD},


                };
            }
}
