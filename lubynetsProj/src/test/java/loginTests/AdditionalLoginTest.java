package loginTests;

import data.TestData;
import org.junit.Test;

public class AdditionalLoginTest extends baseTest.BaseTest {
    @Test
    public void checkValidLoginWithTabAndEnter() {
        pageProvider.getloginPage().openLoginPage();
        pageProvider.getloginPage().enterTextIntoInputUserName(TestData.LOGIN_DEFAULT);
        pageProvider.getloginPage().enterTextIntoInputPassword(TestData.PASSWORD_DEFAULT);
        pageProvider.getloginPage().loginWithTabAndEnter();
        pageProvider.getHomePage().getHeader().checkIsButtonSignOutVisible();

    }
}
