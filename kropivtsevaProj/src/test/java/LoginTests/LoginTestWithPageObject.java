package LoginTests;

import data.TestData;
import org.junit.Test;

import static data.TestData.LOGIN_DEFOULT;
import static data.TestData.PASSWORD_DEFOULT;

public class LoginTestWithPageObject extends baseTest.BageTest {
    @Test
    public void validLogin() {
        pageProvider.getLoginPage().openLoginPage();
        pageProvider.getLoginPage().enterTextIntoInputUserName(LOGIN_DEFOULT);
        pageProvider.getLoginPage().enterTextIntoInputUserPassword(PASSWORD_DEFOULT);
        pageProvider.getLoginPage().clickOnButtonSignIn();
        pageProvider.getHomePage().getHeader().checkIsButtonSignOutVisible();
    }
}
