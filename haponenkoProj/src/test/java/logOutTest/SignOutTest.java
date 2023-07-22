package logOutTest;

import loginTest.LoginTestWithPageObject;
import org.junit.Test;

public class SignOutTest extends baseTest.BaseTest {

    @Test
    public void signOut() {
        LoginTestWithPageObject loginTest = new LoginTestWithPageObject();
        loginTest.validLogin();
        pageProvider.getHomePage().getHeader().checkIsSearchButtonVisible();
        pageProvider.getHomePage().getHeader().checkIsChatButtonVisible();
        pageProvider.getHomePage().getHeader().checkIsProfileAvatarButtonVisible();
        pageProvider.getHomePage().getHeader().checkIsCreatePostButtonVisible();
        pageProvider.getHomePage().getHeader().checkIsButtonSignInNotVisible();
        pageProvider.getHomePage().getHeader().checkIsInputUserNameNotVisible();
        pageProvider.getHomePage().getHeader().checkIsInputPasswordNotVisible();
        pageProvider.getHomePage().getHeader().clickOnButtonSignOut();

        pageProvider.getLoginPage().checkIsSearchButtonNotVisible();
        pageProvider.getLoginPage().checkIsChatButtonNotVisible();
        pageProvider.getLoginPage().checkIsProfileAvatarButtonNotVisible();
        pageProvider.getLoginPage().checkIsCreatePostButtonNotVisible();
        pageProvider.getLoginPage().checkIsButtonSignOutNotVisible();
        pageProvider.getLoginPage().checkIsInputUserNameVisible();
        pageProvider.getLoginPage().checkIsInputPasswordVisible();
        pageProvider.getLoginPage().checkIsButtonSignInVisible();
    }
}
