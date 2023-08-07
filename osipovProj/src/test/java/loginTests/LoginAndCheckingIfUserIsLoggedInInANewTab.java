package loginTests;

import baseTest.BaseTest;
import org.junit.Test;

public class LoginAndCheckingIfUserIsLoggedInInANewTab extends BaseTest {
    @Test
    public void LoginAndCheckingIfUserIsLoggedInInANewTab() {
        pageProvider.getLoginPage().loginWithValidCred();
        openNewTab();
        pageProvider.getLoginPage().openLoginPage();

        pageProvider.getHomePage().getHeader().checkIsButtonSignOutVisible();

        pageProvider.getHomePage().getHeader().clickOnButtonSignOut();
        pageProvider.getLoginPage().checkIsButtonSignInVisible();
        refreshPage();
        pageProvider.getLoginPage().checkIsButtonSignInVisible();
    }
}
