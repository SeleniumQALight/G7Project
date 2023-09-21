package loginTests;

import data.TestData;
import org.junit.Test;

public class AdditionalLoginTest extends baseTest.BaseTest {
    @Test
    public void checkValidLoginWithTabAndEnter() {
        pageProvider.getLoginPage().openLoginPage();
        pageProvider.getLoginPage().enterTextIntoInputUserName(TestData.LOGIN_DEFAULT);
        pageProvider.getLoginPage().enterTextIntoInputPassword(TestData.PASSWORD_DEFAULT);
        pageProvider.getLoginPage().loginWithTabAndEnter();
        pageProvider.getHomePage().getHeader().checkIsButtonSignOutVisible();

    }
}
