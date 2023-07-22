package loginTests;

import org.junit.Test;

import static data.TestData.*;

public class LoginTestWithPageObject extends baseTest.BaseTest{
    @Test
    public void validLogin(){
        pageProvider.getLoginPage().openLoginPage();
        pageProvider.getHomePage().getHeader().enterTextIntoInputUserName(LOGIN_DEFAULT);
        pageProvider.getHomePage().getHeader().enterTextIntoInputPassword(PASSWORD_DEFAULT);
        pageProvider.getHomePage().getHeader().clickOnButtonSignIn();

        pageProvider.getHomePage().getHeader().checkIsButtonSignOutVisible();
    }

    @Test
    public void invalidLogin(){
        pageProvider.getLoginPage().openLoginPage();
        pageProvider.getHomePage().getHeader().enterTextIntoInputUserName(LOGIN_INVALID);
        pageProvider.getHomePage().getHeader().enterTextIntoInputPassword(PASSWORD_INVALID);
        pageProvider.getHomePage().getHeader().clickOnButtonSignIn();

        pageProvider.getHomePage().getHeader().checkIsButtonSignInVisible();
        pageProvider.getLoginPage().isInvalidLoginMessageDisplayed();
        pageProvider.getHomePage().getHeader().checkIsButtonSignOutNotVisible();
    }
}
