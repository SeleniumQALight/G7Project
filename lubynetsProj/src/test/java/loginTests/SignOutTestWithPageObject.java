package loginTests;

import org.junit.Test;

import static data.TestData.*;

public class SignOutTestWithPageObject extends baseTest.BaseTest {
    @Test // SignOutTestWithPageObject
    public void validSignOut() {
        pageProvider.getloginPage().openLoginPage();
        pageProvider.getloginPage().enterTextIntoInputUserName(LOGIN_DEFAULT);
        pageProvider.getloginPage().enterTextIntoInputPassword(PASSWORD_DEFAULT);
        pageProvider.getloginPage().clickOnButtonSignIn();
        pageProvider.getHomePage().getHeader().checkIsButtonSignOutVisible();
        pageProvider.getHomePage().getHeader().checkIsButtonChatVisible();
        pageProvider.getHomePage().getHeader().checkIsButtonCreatePostVisible();
        pageProvider.getHomePage().getHeader().checkIsButtonLogoVisible();
        pageProvider.getHomePage().getHeader().checkIsButtonSearchVisible();
        pageProvider.getHomePage().getHeader().checkIsButtonProfileVisible();
        pageProvider.getloginPage().checkIsButtonSignInNotVisible();
        pageProvider.getloginPage().checkIsInputUsernameNotVisible();
        pageProvider.getloginPage().checkIsInputPasswordNotVisible();
        pageProvider.getHomePage().getHeader().clickOnButtonSignOut();
        pageProvider.getHomePage().getHeader().checkIsButtonSignOutNotVisible();
        pageProvider.getHomePage().getHeader().checkIsButtonChatNotVisible();
        pageProvider.getHomePage().getHeader().checkIsButtonCreatePostNotVisible();
        pageProvider.getHomePage().getHeader().checkIsButtonSearchNotVisible();
        pageProvider.getHomePage().getHeader().checkIsButtonProfileNotVisible();
        pageProvider.getloginPage().checkIsButtonSignInVisible();
        pageProvider.getloginPage().checkIsInputUsernameVisible();
        pageProvider.getloginPage().checkIsInputPasswordVisible();
    }

}
