package LoginTests;

import data.TestData;
import org.junit.Test;

import static data.TestData.LOGIN_DEFAULT;
import static data.TestData.PASSWORD_DEFAULT;

public class LoginTestWithPageObject extends baseTest.BaseTest {

    @Test
    public void validLogin() {
        pageProvider.getLoginPage().openLoginPage();
        pageProvider.getLoginPage().enterTextInputUserName(LOGIN_DEFAULT);
        pageProvider.getLoginPage().enterTextInputPassword(PASSWORD_DEFAULT);
        pageProvider.getLoginPage().clickOnButtonSignIn();

        pageProvider.getHomePage().getHeader().checkIsButtonSignOutVisible();

    }
}
