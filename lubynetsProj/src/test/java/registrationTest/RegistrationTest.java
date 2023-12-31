package registrationTest;

import categories.SmokeTestFilter;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import data.TestData;

import static java.time.Duration.ofSeconds;

@Category(SmokeTestFilter.class)
@RunWith(JUnitParamsRunner.class)
public class RegistrationTest extends baseTest.BaseTest {
    //    String userName = "test";
//    String email =  "rtrtr";
//    String Password = "123456";
//
//
//    String expectedMessages = "You must provide a valid email address.;Password must be at least 12 characters.";
    final static String ERROR_USERNAME = "Username must be at least 3 characters.";
    final static String ERROR_EMAIL = "You must provide a valid email address.";
    final static String ERROR_PASSWORD = "Password must be at least 12 characters.";
    final static String ERROR_ALREADY_EXIST = "That username is already taken.";
    final static String SEMICOLON = ";";
    final static String COMMA = ",";
    final static String SHORT_USER_NAME = "tr";
    final static String ERROR_ONLY_LETTERS_AND_NUMBERS = "Username can only contain letters and numbers.";
    final static String ERROR_PASSWORD_ABOVE50 = "Password cannot exceed 50 characters.";


    @Test
    @Parameters(method = "parametersForCheckErrorsTest")
    public void checkErrorsTest(String userName, String email, String Password, String expectedMessages) {
        pageProvider.getLoginPage().openLoginPage();
        pageProvider.getLoginPage().enterTextIntoRegistrationUserName(userName);
        pageProvider.getLoginPage().enterTextIntoRegistrationEmail(email);
        pageProvider.getLoginPage().enterTextIntoRegistrationPassword(Password);
        pageProvider.getLoginPage().checkErrorsMessages(expectedMessages);
    }


    public Object[][] parametersForCheckErrorsTest() {

        return new Object[][]{
                {SHORT_USER_NAME, "trtr", "123456", ERROR_USERNAME + SEMICOLON + ERROR_EMAIL + SEMICOLON + ERROR_PASSWORD},
                {"test", "rtrtr@gmail.com", "123456", ERROR_PASSWORD},
                {"тест", "test@mail.com", "123456", ERROR_ONLY_LETTERS_AND_NUMBERS + SEMICOLON + ERROR_PASSWORD},
                {"test@invalidEmail", "test@mail.com", "12345123451234512345123451234512345123451234512345123451234512345", ERROR_ONLY_LETTERS_AND_NUMBERS + SEMICOLON + ERROR_PASSWORD_ABOVE50},
        };
    }

    // Additional Homework
    @Test
    public void checkErrorMessagesWithTabAndEnter() {
        pageProvider.getLoginPage().openLoginPage()
                .enterTextIntoRegistrationUserName(TestData.SHORT_USER_NAME)
                .pressTabKeyUserName()
                .waitForEmailInputClickable()
                .enterTextIntoRegistrationEmail(TestData.INVALID_EMAIL)
                .pressTabKeyEmail()
                .waitForPasswordInputClickable()
                .pressTabKeyPassword()
                .enterTextIntoRegistrationPassword(TestData.PASSWORD_INVALID_SHORT)
                .pressEnterKeyPassword();

        String expectedMessages = ERROR_USERNAME + SEMICOLON + ERROR_PASSWORD;
        pageProvider.getLoginPage().checkErrorsMessages(expectedMessages);
    }
}