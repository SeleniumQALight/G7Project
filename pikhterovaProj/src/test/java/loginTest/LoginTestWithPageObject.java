package loginTest;

import org.junit.Test;


import static testData.TestData.LOGIN_DEFAULT;
import static testData.TestData.PASSWORD_DEFAULT;

public class LoginTestWithPageObject extends baseTest.BaseTest {
    @Test
    public void validLogin() {
        pageProvider.getloginPage().openLoginPage();
        pageProvider.getloginPage().enterTextIntoInputUserName(LOGIN_DEFAULT);
        pageProvider.getloginPage().enterTextIntoInputPassword(PASSWORD_DEFAULT);
        pageProvider.getloginPage().clickOnButtonSignIn();

        pageProvider.getHomePage().getHeader().checkIsButtonSignOutVisible();
    }
}
