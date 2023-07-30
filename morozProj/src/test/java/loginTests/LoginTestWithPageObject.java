package loginTests;

import baseTest.BaseTest;
import org.junit.Test;

import static data.TestData.*;

public class LoginTestWithPageObject extends BaseTest {
    @Test
    public void validLogin(){
        pageProvider.getloginPage().openLoginPage();
        pageProvider.getloginPage().enterTextIntoInputUsername(LOGIN_DEFAULT);
        pageProvider.getloginPage().enterTextIntoInputPassword(PASSWORD_DEFAULT);
        pageProvider.getloginPage().clickOnSignInButton();

        pageProvider.getHomePage().getHeader().checkIsSignOutButtonVisible();
    }

    @Test
    public void unvalidLogin(){
        pageProvider.getloginPage().openLoginPage();
        pageProvider.getloginPage().enterTextIntoInputUsername(UNVALID_LOGIN);
        pageProvider.getloginPage().enterTextIntoInputPassword(UNVALID_PASSWORD);
        pageProvider.getloginPage().clickOnSignInButton();

        pageProvider.getloginPage().getHeader().checkIsSignOutButtonNotVisible();
        pageProvider.getloginPage().checkIsSignInButtonVisible();
        pageProvider.getloginPage().checkIsLoginValidationDisplayed();
    }
    @Test
    public void signOutTest(){
        pageProvider.getloginPage().loginWithValidCreds();
        pageProvider.getHomePage().getHeader().checkSearchButtonVisible();
        pageProvider.getHomePage().getHeader().checkChatButtonVisible();
        pageProvider.getHomePage().getHeader().checkProfileButtonVisible();
        pageProvider.getHomePage().getHeader().checkButtonCreatePostVisible();
        pageProvider.getHomePage().getHeader().checkIsSignOutButtonVisible();
        pageProvider.getloginPage().checkIsInputUserNameNotVisible();
        pageProvider.getloginPage().checkIsInputPasswordNotVisible();
        pageProvider.getloginPage().checkisSignInButtonNotVisible();
        pageProvider.getHomePage().getHeader().clickOnSignOutButton();
        pageProvider.getHomePage().getHeader().checkSearchButtonNotVisible();
        pageProvider.getHomePage().getHeader().checkChatButtonNotVisible();
        pageProvider.getHomePage().getHeader().checkProfileButtonNotVisible();
        pageProvider.getHomePage().getHeader().checkButtonCreatePostNotVisible();
        pageProvider.getHomePage().getHeader().checkIsSignOutButtonNotVisible();
        pageProvider.getloginPage().checkIsInputUsernameVisible();
        pageProvider.getloginPage().checkIsInputPasswordVisible();
        pageProvider.getloginPage().checkIsSignInButtonVisible();
    }

    @Test
    public void signOutTestSecondVariant(){
        pageProvider.getloginPage().loginWithValidCreds()
                .checkIsRedirectToHomePage()
                .getHeader().clickOnSignOutButton()
                .checkIsRedirectToLoginPage();
    }


}
