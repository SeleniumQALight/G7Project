package loginTests;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;
import static test_data.TestData.*;

@RunWith(JUnitParamsRunner.class)
public class InvalidLogInTestWithParameters extends baseTest.BaseTest {

    @Test
    @Parameters(method = "invalidLoginData")

    public void invalidLoginWthParameters(String login, String password) {
        pageProvider.getLoginPage().openLoginPage();
        pageProvider.getLoginPage().enterTextIntoInputUserName(login);
        pageProvider.getLoginPage().enterTextIntoInputPassword(password);
        pageProvider.getLoginPage().clickOnButtonSignIn();
        pageProvider.getLoginPage().checkAlertMessageWrongLoginOrPasswordVisible();
        pageProvider.getLoginPage().checkButtonSignInVisible();
        pageProvider.getHomePage().getHeader().checkIsButtonSignOutNotVisible();
    }

    public Object[][] invalidLoginData() {
        return new Object[][]{
                {LOGIN_INVALID, PASSWORD_INVALID},
                {LOGIN_INVALID, PASSWORD_DEFAULT},
                {LOGIN_DEFAULT, PASSWORD_INVALID}
        };
    }
}
