package signOutTest;

import org.junit.Test;

import static test_data.TestData.*;


public class SignInTest extends baseTest.BaseTest {
    @Test
    public void signOutTest() {
        pageProvider.getLoginPage().openLoginPage();
        pageProvider.getLoginPage().enterTextIntoInputUserName(LOGIN_DEFAULT);
        pageProvider.getLoginPage().enterTextIntoInputPassword(PASSWORD_DEFAULT);
        pageProvider.getLoginPage().clickOnButtonSignIn();
        pageProvider.getLoginPage().checkInputUserNameNotVisible();
        pageProvider.getLoginPage().checkInputPasswordNotVisible();
        pageProvider.getLoginPage().checkButtonSignInNotVisible();
        pageProvider.getHomePage().getHeader().checkIsButtonSignOutVisible();
        pageProvider.getHomePage().getHeader().checkAddNewPostButtonVisible();
        pageProvider.getHomePage().getHeader().checkChatIconVisible();
        pageProvider.getHomePage().getHeader().checkUserIconVisible();
        pageProvider.getHomePage().getHeader().checkUserNameVisible();
        pageProvider.getHomePage().getHeader().checkSearchIconVisible();
        pageProvider.getHomePage().getHeader().checkHomePageButtonVisible();
        pageProvider.getHomePage().getHeader().clickOnButtonSignOut();
        pageProvider.getHomePage().getHeader().checkIsButtonSignOutNotVisible();
        pageProvider.getHomePage().getHeader().checkAddNewPostButtonNotVisible();
        pageProvider.getHomePage().getHeader().checkChatIconNotVisible();
        pageProvider.getHomePage().getHeader().checkUserIconNotVisible();
        pageProvider.getHomePage().getHeader().checkUserNameNotVisible();
        pageProvider.getHomePage().getHeader().checkSearchIconNotVisible();
        pageProvider.getHomePage().getHeader().checkHomePageButtonVisible();
        pageProvider.getLoginPage().checkInputUserNameVisible();
        pageProvider.getLoginPage().checkInputPasswordVisible();
        pageProvider.getLoginPage().checkButtonSignInVisible();

    }
}
