package loginTests;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static data.TestData.*;

@RunWith(JUnitParamsRunner.class)
public class LoginTestWithParameters extends baseTest.BaseTest {

    final static String ERROR_LOGIN = "Invalid username / pasword";
    @Test
    @Parameters(method = "parametersForLogin")
    public void inValidLogin(String userName, String password, String expectedMessage){
        pageProvider.getLoginPage().openLoginPage();
        pageProvider.getLoginPage().enterTextIntoInputUserName(userName);
        pageProvider.getLoginPage().enterTextIntoInputPassword(password);
        pageProvider.getLoginPage().clickOnButtonSignIn();
        pageProvider.getLoginPage().checkIsInvalidLoginMessageDisplayed();
    }
    public Object[][] parametersForLogin(){
        return new Object[][]{
                {LOGIN_INVALID,PASSWORD_INVALID,ERROR_LOGIN},
                {LOGIN_DEFAULT,PASSWORD_INVALID,ERROR_LOGIN},
                {LOGIN_INVALID,PASSWORD_DEFAULT,ERROR_LOGIN},
//bug           {" qaauto", PASSWORD_DEFAULT, ERROR_LOGIN},
                {LOGIN_DEFAULT, " 123456qwerty", ERROR_LOGIN}
        };
    }
}
