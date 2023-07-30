package loginTests;

import baseTest.BaseTest;
import data.TestData;
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
}
