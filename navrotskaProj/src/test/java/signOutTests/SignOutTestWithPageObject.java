package signOutTests;

import baseTest.BaseTest;
import org.junit.Test;
import pages.LoginPage;
import pages.elements.Header;

public class SignOutTestWithPageObject extends BaseTest {


    @Test
    public void validSignOut() {
        pageProvider.getLoginPage().loginWithValidCreds();
        pageProvider.getHomePage().getHeader().checkIsButtonSearchVisible();
        pageProvider.getHomePage().getHeader().checkIsButtonChatVisible();
        pageProvider.getHomePage().getHeader().checkIsButtonMyProfileVisible();
        pageProvider.getHomePage().getHeader().checkIsButtonCreatePostVisible();

        pageProvider.getLoginPage().checkIsInputUserNameNotVisible();
        pageProvider.getLoginPage().checkIsInputPasswordNotVisible();
        pageProvider.getLoginPage().checkIsButtonSignInNotVisible();

        pageProvider.getHomePage().getHeader().clickOnButtonSignOut();
        pageProvider.getLoginPage().checkIsInputUserNameVisible();
        pageProvider.getLoginPage().checkIsInputPasswordVisible();
        pageProvider.getLoginPage().checkIsButtonSignInVisible();

        pageProvider.getHomePage().getHeader().checkIsButtonSearchNotVisible();
        pageProvider.getHomePage().getHeader().checkIsButtonChatNotVisible();
        pageProvider.getHomePage().getHeader().checkIsButtonMyProfileNotVisible();
        pageProvider.getHomePage().getHeader().checkIsButtonCreatePostNotVisible();


    }


}
