package loginTests;

import data.TestData;
import org.junit.Test;

public class LoginTestWithPageObject extends baseTest.BaseTest{
    @Test
    public void validLogin(){
        pageProvider.getLoginPage().openLoginPage();
        pageProvider.getLoginPage().enterTextIntoInputUserName(TestData.LOGIN_DEFAULT);
        pageProvider.getLoginPage().enterTextIntoInputPassword(TestData.PASSWORD_DEFAULT);
        pageProvider.getLoginPage().clickOnButtonSignIn();
        pageProvider.getHomePage().getHeader().checkIsButtonSignOutVisible();
    }
    @Test
    public void invalidLogin(){
        pageProvider.getLoginPage().openLoginPage();
        pageProvider.getLoginPage().enterTextIntoInputUserName(TestData.INVALID_LOGIN);
        pageProvider.getLoginPage().enterTextIntoInputPassword(TestData.INVALID_PASSWORD);
        pageProvider.getLoginPage().clickOnButtonSignIn();
        pageProvider.getHomePage().getHeader().checkIsButtonSignOutNotVisible();
        pageProvider.getHomePage().getHeader().checkIsButtonSignInVisible();
        pageProvider.getLoginPage().checkIsAlertMessageVisible();
    }
    @Test
    public void Logout(){
        pageProvider.getLoginPage().openLoginPage();
        pageProvider.getLoginPage().enterTextIntoInputUserName(TestData.LOGIN_DEFAULT);
        pageProvider.getLoginPage().enterTextIntoInputPassword(TestData.PASSWORD_DEFAULT);
        pageProvider.getLoginPage().clickOnButtonSignIn();
        pageProvider.getHomePage().getHeader().checkIsSearchVisible();
        pageProvider.getHomePage().getHeader().checkIsChatVisible();
        pageProvider.getHomePage().getHeader().checkIsAvatarVisible();
        pageProvider.getHomePage().getHeader().checkIsCreatePostVisible();
        pageProvider.getHomePage().getHeader().checkIsButtonSignOutVisible();
        pageProvider.getLoginPage().checkIsInputUserNameNotVisible();
        pageProvider.getLoginPage().checkIsInputPasswordNotVisible();
        pageProvider.getHomePage().getHeader().checkIsButtonSignInNotVisible();
        pageProvider.getHomePage().getHeader().clickOnButtonSignOut();
        pageProvider.getHomePage().getHeader().checkIsSearchNotVisible();
        pageProvider.getHomePage().getHeader().checkIsChatNotVisible();
        pageProvider.getHomePage().getHeader().checkIsAvatarNotVisible();
        pageProvider.getHomePage().getHeader().checkIsCreatePostNotVisible();
        pageProvider.getHomePage().getHeader().checkIsButtonSignOutNotVisible();
        pageProvider.getLoginPage().checkIsInputUserNameVisible();
        pageProvider.getLoginPage().checkIsInputPasswordVisible();
        pageProvider.getHomePage().getHeader().checkIsButtonSignInVisible();
    }
}
