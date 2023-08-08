package loginTests;

import data.TestData;
import org.junit.Test;

import static data.TestData.LOGIN_DEFAULT;
import static data.TestData.PASSWORD_DEFAULT;

public class LoginTestWithPageObject extends baseTest.BaseTest {
    @Test
    public void validLogin() {
            pageProvider.getLoginPage().openLoginPage();
            pageProvider.getLoginPage().enterTextInToInputUserName(LOGIN_DEFAULT);
            pageProvider.getLoginPage().enterTextInToInputPassWord(PASSWORD_DEFAULT);
            pageProvider.getLoginPage().clickOnButtonSignIn();

            pageProvider.getHomePage().getHeader().checkIsButtonSignOutVisible();
        }
    }

