package registrationTest;

import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;
import junitparams.JUnitParamsRunner;

@RunWith(JUnitParamsRunner.class) // тест буде запускатись кылька раз з різними параметрами

public class RegistrationTest extends baseTest.BaseTest {

    final static String ERROR_USERNAME = "Username must be at least 3 characters.";
    final static String ERROR_EMAIL = "You must provide a valid email address.";
    final static String ERROR_PASSWORD = "Password must be at least 12 characters.";
    final static String ERROR_ALREADY_EXIST = "That username is already taken.";
    final static String SEMICOLON = ";";
    final static String COMMA = ",";
    final static String SHORT_USER_NAME = "tr";
    final static String LONG_USER_NAME = "qaautodsfsdfsdfsfsfsfsdfsdfdsgfdsgfdsg"; // більше 30
    final static String LONG_PASSWORD = "kdghkdhgdkhgdghdkgdkhgkdhgjhdkdhgkdhgkdhgkdhgkdhg123456"; // більше 50 символів
    final static String ERROR_USERNAME1 = "Username can only contain letters and numbers."; // наприклад кирилиця
    final static String ERROR_USERNAME2 = "That username is already taken."; // коли вже існує такий користувач
    final static String ERROR_USERNAME3 = "Username cannot exceed 30 characters."; // логін більше 30 символів
    final static String ERROR_PASSWORD1 = "Password cannot exceed 50 characters."; // коли пароль більше 50 символів


//    String userName = "test";
//    String email = "tartar";
//   String password = "123456" ;
//   String expectedMessages = "You must provide a valid email address.;Password must be at least 12 characters.";

    @Test
    @Parameters(method = "parametersForCheckErrorsTest")
    //
    public void checkErrorsTest(String userName, String email, String password, String expectedMessages) {
        pageProvider.getloginPage().openLoginPage(); // відкриття сторінки
        pageProvider.getloginPage().enterTextIntoRegistrationUserNameField(userName); //вводемо значення змінної userName в поле UserName_реєтрація
        pageProvider.getloginPage().enterTextIntoRegistrationEmailField(email); //вводемо значення змінної email в поле Email_реєтрація
        pageProvider.getloginPage().enterTextIntoRegistrationPasswordField(password); //вводемо значення змінної password в поле Password_реєтрація
        pageProvider.getloginPage().checErrorsMessages(expectedMessages); //перевірка на відображення помилок

    }

    public Object[][] parametersForCheckErrorsTest() {
        return new Object[][]{
                {SHORT_USER_NAME, "trtrt", "123456", ERROR_USERNAME + SEMICOLON + ERROR_PASSWORD + SEMICOLON + ERROR_EMAIL},
                {"test", "tr@trt.com", "123", ERROR_PASSWORD},
                {"вася", "trt", "123456", ERROR_USERNAME1 + SEMICOLON + ERROR_EMAIL + SEMICOLON + ERROR_PASSWORD},
                {"qaauto", "tr@trt.com", LONG_PASSWORD, ERROR_USERNAME2 + SEMICOLON + ERROR_PASSWORD1},


        };
    }

    @Test // тест на перевірку валідації поля UserName_реєстрація
    @Parameters(method = "parametersForCheckErrorsTestLogin")
    //
    public void checkErrorsTestLogin(String userName, String expectedMessages) {
        pageProvider.getloginPage().openLoginPage(); // відкриття сторінки
        pageProvider.getloginPage().enterTextIntoRegistrationUserNameField(userName); //вводемо значення змінної userName в поле UserName_реєтрація
        pageProvider.getloginPage().checErrorsMessages(expectedMessages);

    }

    public Object[][] parametersForCheckErrorsTestLogin() {
        return new Object[][]{
                {SHORT_USER_NAME, ERROR_USERNAME},
                {"тест", ERROR_USERNAME1},
                {"qaauto", ERROR_USERNAME2},
                {LONG_USER_NAME, ERROR_USERNAME3},

        };
    }
}

