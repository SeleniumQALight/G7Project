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
        pageProvider.getLoginPage().isInputUserNameNotVisible();
        pageProvider.getLoginPage().isInputPasswordNotVisible();
        pageProvider.getLoginPage().isButtonSignInNotVisible();
        pageProvider.getHomePage().getHeader().checkIsButtonSignOutVisible();
        pageProvider.getHomePage().getHeader().isAddNewPostButtonVisible();
        pageProvider.getHomePage().getHeader().isChatIconVisible();
        pageProvider.getHomePage().getHeader().isUserIconVisible();
        pageProvider.getHomePage().getHeader().isUserNameVisible();
        pageProvider.getHomePage().getHeader().isSearchIconVisible();
        pageProvider.getHomePage().getHeader().isHomePageButtonVisible();
        pageProvider.getHomePage().getHeader().clickOnButtonSignOut();
        pageProvider.getHomePage().getHeader().checkIsButtonSignOutNotVisible();
        pageProvider.getHomePage().getHeader().isAddNewPostButtonNotVisible();
        pageProvider.getHomePage().getHeader().isChatIconNotVisible();
        pageProvider.getHomePage().getHeader().isUserIconNotVisible();
        pageProvider.getHomePage().getHeader().isUserNameNotVisible();
        pageProvider.getHomePage().getHeader().isSearchIconNotVisible();
        pageProvider.getHomePage().getHeader().isHomePageButtonVisible();
        pageProvider.getLoginPage().isInputUserNameVisible();
        pageProvider.getLoginPage().isInputPasswordVisible();
        pageProvider.getLoginPage().isButtonSignInVisible();

    }
}
