package loginTests;

import org.junit.Test;

import static data.TestData.*;

public class SignOutTest extends baseTest.BaseTest {
    @Test
    public void signOutTest() {
        //step
        pageProvider.getLoginPage().openLoginPage();
        pageProvider.getLoginPage().enterTextIntoInputUserName(LOGIN_DEFAULT);
        pageProvider.getLoginPage().enterTextIntoInputPassword(PASSWORD_DEFAULT);
        pageProvider.getLoginPage().clickOnButtonSignIn();
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
        pageProvider.getLoginPage().checkIsButtonSignInVisible();
        pageProvider.getLoginPage().checkIsUserNameInputDisplayed();
        pageProvider.getLoginPage().checkIsPasswordInputDisplayed();
    }
}
