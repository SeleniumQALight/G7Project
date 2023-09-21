package logOutTest;

import org.junit.Test;

public class SignOutTest extends baseTest.BaseTest {

    @Test
    public void signOut() {
        pageProvider.getHomePage().openHomePage();

        pageProvider.getHomePage().getHeader().checkIsButtonSignOutVisible();
        pageProvider.getHomePage().getHeader().checkIsSearchButtonVisible();
        pageProvider.getHomePage().getHeader().checkIsChatButtonVisible();
        pageProvider.getHomePage().getHeader().checkIsButtonProfileAvatarVisible();
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
