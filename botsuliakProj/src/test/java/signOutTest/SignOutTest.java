package signOutTest;

import org.junit.Test;

import static data.TestData.LOGIN_DEFAULT;
import static data.TestData.PASSWORD_DEFAULT;

public class SignOutTest extends baseTest.BaseTest {
    @Test
    public void signOut() {
        pageProvider.getLoginPage().openLoginPage();
        pageProvider.getLoginPage().enterTextIntoInputUserName(LOGIN_DEFAULT);
        pageProvider.getLoginPage().enterTextIntoInputPassword(PASSWORD_DEFAULT);
        pageProvider.getLoginPage().clickOnButtonSingIn();

        pageProvider.getHomePage().checkIsRedirectToHomePage();
        pageProvider.getLoginPage().checkIsNotRedirectToLoginPage();

        pageProvider.getHomePage().getHeader().clickOnButtonSignOut();

        pageProvider.getHomePage().checkIsNotRedirectToHomePage();
        pageProvider.getLoginPage().checkIsRedirectToLoginPage();
    }

}
