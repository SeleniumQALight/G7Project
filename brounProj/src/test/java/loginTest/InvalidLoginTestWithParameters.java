package loginTest;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)

public class InvalidLoginTestWithParameters extends baseTest.BaseTest{

    final static String ERROR_LOGIN_PASSWORD = "Invalid username / pasword";

    @Test
    @Parameters(method = "parametersForInvalidLoginTest")

    public void invalidLogin(String login, String password, String expectedMessages) {
        pageProvider.getLoginPage().openLoginPage();
        pageProvider.getLoginPage().enterTextIntoInputUserName(login);
        pageProvider.getLoginPage().enterTextIntoInputPassword(password);
        pageProvider.getLoginPage().clickOnButtonSignIn();
        pageProvider.getLoginPage().checkLoginErrors(expectedMessages);

    }

    public Object[][] parametersForInvalidLoginTest() {
        return new Object[][]{
                {"тест", "тест2", ERROR_LOGIN_PASSWORD},
                {"abc", "123456qwerty", ERROR_LOGIN_PASSWORD},
                {"qaauto", "abc", ERROR_LOGIN_PASSWORD }

        };
    }


    }


