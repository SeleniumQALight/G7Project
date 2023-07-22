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
}
