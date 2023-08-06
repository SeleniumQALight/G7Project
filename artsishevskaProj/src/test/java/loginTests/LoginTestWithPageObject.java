package loginTests;

import data.TestData;
import org.junit.Test;

import static data.TestData.LOGIN_DEFAULT;
import static data.TestData.PASSWORD_DEFAULT;
import org.openqa.selenium.WebElement;

public class LoginTestWithPageObject extends baseTest.BaseTest{
    @Test
    public  void validLogin(){
        pageProvider.getLoginPage().openLoginPage();
        pageProvider.getLoginPage().enterTextIntoInputUserName(LOGIN_DEFAULT);
        pageProvider.getLoginPage().enterTextIntoInputPassword(PASSWORD_DEFAULT);
        pageProvider.getLoginPage().clickOnButtonSignIn();

        pageProvider.getHomePage().getHeader().checkIsButtonSignOutVisible();
    }
    @Test
    public void inValidLogin(){
        pageProvider.getLoginPage().openLoginPage();
        pageProvider.getLoginPage().enterTextIntoInputUserName(LOGIN_DEFAULT);
        pageProvider.getLoginPage().enterTextIntoInputPassword(PASSWORD_DEFAULT);
        pageProvider.getLoginPage().clickOnButtonSignIn();

        pageProvider.getLoginPage().checkIsButtonSignInVisible();
       pageProvider.getHomePage().getHeader().checkIsButtonMyProfileVisible();
    }
    @Test
    public void checkingSignOut(){
        pageProvider.getLoginPage().openLoginPage();
        pageProvider.getLoginPage().enterTextIntoInputUserName(LOGIN_DEFAULT);
        pageProvider.getLoginPage().enterTextIntoInputPassword(PASSWORD_DEFAULT);
        pageProvider.getLoginPage().clickOnButtonSignIn();

        pageProvider.getHomePage().getHeader().checkIsButtonSearchVisible();
        pageProvider.getHomePage().getHeader().checkIsButtonChatVisible();
        pageProvider.getHomePage().getHeader().checkIsButtonMyProfileVisible();
        pageProvider.getHomePage().getHeader().checkIsButtonSignOutVisible();
        pageProvider.getHomePage().getHeader().checkIsButtonCreatePostVisible();

        pageProvider.getLoginPage().checkNotIsButtonSignInVisible();
        pageProvider.getLoginPage().checkNotIsFieldLoginVisible();

        pageProvider.getLoginPage().clickOnButtonSignOut();

        pageProvider.getHomePage().getHeader().checkNotIsButtonSearchVisible();
        pageProvider.getHomePage().getHeader().checkNotIsButtonChatVisible();
        pageProvider.getHomePage().getHeader().checkNotIsButtonMyProfileVisible();
        pageProvider.getHomePage().getHeader().checkNotIsButtonSignOutVisible();

        pageProvider.getLoginPage().checkIsButtonSignInVisible();
        pageProvider.getLoginPage().checkIsFieldLoginVisible();
        pageProvider.getLoginPage().checkIsFieldPasswordVisible();


    }
}
