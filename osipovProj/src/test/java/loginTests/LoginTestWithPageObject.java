package loginTests;

import org.junit.Test;

import static data.TestData.*;

public class LoginTestWithPageObject extends baseTest.BaseTest{
    @Test
    public void validLogin(){
        pageProvider.getLoginPage().openLoginPage();
        pageProvider.getLoginPage().enterTextIntoInputUserName(LOGIN_DEFAULT);
        pageProvider.getLoginPage().enterTextIntoInputPassword(PASSWORD_DEFAULT);
        pageProvider.getLoginPage().clickOnButtonSignIn();

        pageProvider.getHomePage().getHeader().checkIsButtonSignOutVisible();
    }

    @Test
    public void invalidLogin(){
        pageProvider.getLoginPage().openLoginPage();
        pageProvider.getLoginPage().enterTextIntoInputUserName(LOGIN_INVALID);
        pageProvider.getLoginPage().enterTextIntoInputPassword(PASSWORD_INVALID);
        pageProvider.getLoginPage().clickOnButtonSignIn();

        pageProvider.getLoginPage().checkIsButtonSignInVisible();
        pageProvider.getLoginPage().isInvalidLoginMessageDisplayed();
        pageProvider.getHomePage().getHeader().checkIsButtonSignOutNotVisible();
    }
}
