package registrationTest;

import baseTest.BaseTest;
import categories.SmokeTestFilter;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class) // для запуска декілька разів одного тесту з різними параметрами
@Category(SmokeTestFilter.class)
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
    final static String ERROR_USERNAME_LATIN_LETTERS_NUMBERS = "Username can only contain letters and numbers.";

    @Test
    @Parameters(method = "parametersForCheckErrorsTest") //зв'язок метода з тестом
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
                {"test", "tr56@tr.com", "123", ERROR_PASSWORD},
                {"Тест_Логін", "ТестЕмейл", "ТестПасс", ERROR_USERNAME_LATIN_LETTERS_NUMBERS + SEMICOLON + ERROR_EMAIL + SEMICOLON + ERROR_PASSWORD},
                {"test", "trtr", "123456", ERROR_EMAIL + SEMICOLON + ERROR_PASSWORD},

        };
    }

}