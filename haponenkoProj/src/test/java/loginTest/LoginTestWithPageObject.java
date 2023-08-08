package loginTest;

import baseTest.BaseTest;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static data.TestData.LOGIN_DEFAULT;
import static data.TestData.PASSWORD_DEFAULT;

@RunWith(JUnitParamsRunner.class)
public class LoginTestWithPageObject extends BaseTest {

    final static String ERROR_MESSAGE = "Invalid username / pasword";
    @Test
    public void validLogin() {
        pageProvider.getLoginPage().openLoginPage();
        pageProvider.getLoginPage().enterTextIntoInputUserName(LOGIN_DEFAULT);
        pageProvider.getLoginPage().enterTextIntoInputPassword(PASSWORD_DEFAULT);
        pageProvider.getLoginPage().clickOnButtonSignIn();

        pageProvider.getHomePage().getHeader().checkIsButtonSignOutVisible();
    }

    @Test
    @Parameters(method = "parametersForInvalidLogin")
    public void invalidLogin(String userName, String password) {
        pageProvider.getLoginPage().openLoginPage();
        pageProvider.getLoginPage().enterTextIntoInputUserName(userName);
        pageProvider.getLoginPage().enterTextIntoInputPassword(password);
        pageProvider.getLoginPage().clickOnButtonSignIn();
        pageProvider.getLoginPage().checkIsButtonSignInVisible();
        pageProvider.getHomePage().getHeader().checkIsButtonSignOutNotVisible();
//        pageProvider.getLoginPage().checkIsErrorMessageVisible();

        pageProvider.getLoginPage().checkErrorMessageLogin(ERROR_MESSAGE);
    }

    public Object[][] parametersForInvalidLogin() {
        return new Object[][]{
                {"123", " "}
        };
    }
}
