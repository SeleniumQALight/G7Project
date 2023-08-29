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
//    String userName = "test";
//    String email = "trtr";
//    String password = "123456";
//
//    String expectedMessages = "You must provide a valid email address1.;Password must be at least 12 characters2.";
    final static String ERROR_USERNAME = "Username must be at least 3 characters.";
    final static String ERROR_EMAIL = "You must provide a valid email address.";
    final static String ERROR_PASSWORD = "Password must be at least 12 characters.";
    final static String ERROR_ALREADY_EXIST = "That username is already taken.";
    final static String SEMICOLON = ";";
    final static String COMMA = ",";
    final static String SHORT_USER_NAME = "tr";
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
                {"test", "trtr", "123456",  ERROR_EMAIL + SEMICOLON + ERROR_PASSWORD},
               {"test", "tr@tr.com", "123", ERROR_PASSWORD}
        };
    }
}
