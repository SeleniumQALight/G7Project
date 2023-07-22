package loginTests;

import org.junit.Test;

import static data.TestData.*;

public class SignOutTest extends baseTest.BaseTest {
    @Test
    public void signOutTest() {
        //step
        pageProvider.getLoginPage().openLoginPage();
        pageProvider.getHomePage().getHeader().enterTextIntoInputUserName(LOGIN_DEFAULT);
        pageProvider.getHomePage().getHeader().enterTextIntoInputPassword(PASSWORD_DEFAULT);
        pageProvider.getHomePage().getHeader().clickOnButtonSignIn();
        //assert
        pageProvider.getHomePage().getHeader().checkIsButtonSignOutVisible();
        pageProvider.getHomePage().getHeader().checkIsChatIconDisplayed();
        pageProvider.getHomePage().getHeader().checkIsSearchIconDisplayed();
        pageProvider.getHomePage().getHeader().checkIsProfileIconDisplayed();
        pageProvider.getHomePage().getHeader().checkIsButtonCreatePostDisplayed();
        //step
        pageProvider.getHomePage().getHeader().clickOnButtonSignOut();
        //assert
        pageProvider.getHomePage().getHeader().checkIsButtonSignOutNotVisible();
        pageProvider.getHomePage().getHeader().checkIsChatIconNotDisplayed();
        pageProvider.getHomePage().getHeader().checkIsSearchIconNotDisplayed();
        pageProvider.getHomePage().getHeader().checkIsProfileIconNotDisplayed();
        pageProvider.getHomePage().getHeader().checkIsButtonCreatePostNotDisplayed();
        pageProvider.getHomePage().getHeader().checkIsButtonSignInVisible();
        pageProvider.getHomePage().getHeader().checkIsUserNameInputDisplayed();
        pageProvider.getHomePage().getHeader().checkIsPasswordInputDisplayed();
    }
}
