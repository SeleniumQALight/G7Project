package logOutTest;

import loginTest.LoginTestWithPageObject;
import org.junit.Test;

import static data.TestData.LOGIN_DEFAULT;
import static data.TestData.PASSWORD_DEFAULT;

public class SignOutTest extends baseTest.BaseTest {

    @Test
    public void signOut() {
        pageProvider.getHomePage().openHomePage();

        pageProvider.getHomePage().getHeader().checkIsButtonSignOutVisible();
        pageProvider.getHomePage().getHeader().checkIsSearchButtonVisible();
        pageProvider.getHomePage().getHeader().checkIsChatButtonVisible();
        pageProvider.getHomePage().getHeader().checkIsProfileAvatarButtonVisible();
        pageProvider.getHomePage().getHeader().checkIsCreatePostButtonVisible();
        pageProvider.getLoginPage().checkIsButtonSignInNotVisible();
        pageProvider.getLoginPage().checkIsInputUserNameNotVisible();
        pageProvider.getLoginPage().checkIsInputPasswordNotVisible();
        pageProvider.getHomePage().getHeader().clickOnButtonSignOut();

        pageProvider.getHomePage().getHeader().checkIsSearchButtonNotVisible();
        pageProvider.getHomePage().getHeader().checkIsChatButtonNotVisible();
        pageProvider.getHomePage().getHeader().checkIsProfileAvatarButtonNotVisible();
        pageProvider.getHomePage().getHeader().checkIsCreatePostButtonNotVisible();
        pageProvider.getHomePage().getHeader().checkIsButtonSignOutNotVisible();
        pageProvider.getLoginPage().checkIsInputUserNameVisible();
        pageProvider.getLoginPage().checkIsInputPasswordVisible();
        pageProvider.getLoginPage().checkIsButtonSignInVisible();
    }
}
