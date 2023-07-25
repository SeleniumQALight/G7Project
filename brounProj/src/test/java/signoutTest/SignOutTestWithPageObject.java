package signoutTest;

import org.junit.Test;

public class SignOutTestWithPageObject extends baseTest.BaseTest {
    @Test
    public void signOut() {
        pageProvider.getLoginPage().openLoginPage();
        pageProvider.getLoginPage().enterTextIntoInputUserName(data.TestData.LOGIN_DEFAULT);
        pageProvider.getLoginPage().enterTextIntoInputPassword(data.TestData.PASSWORD_DEFAULT);
        pageProvider.getLoginPage().clickOnButtonSignIn();
        pageProvider.getHomePage().getHeader().checkIsButtonSignOutVisible();
        pageProvider.getHomePage().getHeader().checkIsButtonCreatePostVisible();
        pageProvider.getHomePage().getHeader().checkIsButtonChatVisible();
        pageProvider.getHomePage().getHeader().checkIsButtonMyProfileVisible();
        pageProvider.getHomePage().getHeader().checkIsButtonSearchVisible();
        pageProvider.getLoginPage().checkIsButtonSignInNotVisible();
        pageProvider.getLoginPage().checkIsInputUserNameIsNotDisplayed();
        pageProvider.getLoginPage().checkIsInputPasswordIsNotDisplayed();

        pageProvider.getHomePage().getHeader().clickOnButtonSignOut();
        pageProvider.getHomePage().getHeader().checkIsButtonSignOutNotVisible();
        pageProvider.getLoginPage().checkIsButtonSignInVisible();
        pageProvider.getHomePage().getHeader().checkIsButtonSearchNotVisible();
        pageProvider.getHomePage().getHeader().checkIsButtonChatNotVisible();
        pageProvider.getHomePage().getHeader().checkIsButtonMyProfileNotVisible();
        pageProvider.getHomePage().getHeader().checkIsButtonCreatePostNotVisible();
        pageProvider.getLoginPage().checkIsButtonSignInVisible();
        pageProvider.getLoginPage().checkIsInputUserNameDisplayed();
        pageProvider.getLoginPage().checkIsInputPasswordDisplayed();


    }

}
