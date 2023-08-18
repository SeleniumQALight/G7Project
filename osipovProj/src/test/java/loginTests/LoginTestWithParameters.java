package loginTests;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static data.TestData.*;

@RunWith(JUnitParamsRunner.class)
public class LoginTestWithParameters extends baseTest.BaseTest {
    @Test
    @Parameters(method = "parametersForLogin")
    public void inValidLogin(String userName, String password){
        pageProvider.getLoginPage().openLoginPage();
        pageProvider.getLoginPage().enterTextIntoInputUserName(userName);
        pageProvider.getLoginPage().enterTextIntoInputPassword(password);
        pageProvider.getLoginPage().clickOnButtonSignIn();
        pageProvider.getLoginPage().checkIsInvalidLoginMessageDisplayed();
    }
    public Object[][] parametersForLogin(){
        return new Object[][]{
                {LOGIN_INVALID,PASSWORD_INVALID},
                {LOGIN_DEFAULT,PASSWORD_INVALID},
                {LOGIN_INVALID,PASSWORD_DEFAULT},
//bug           {" qaauto", PASSWORD_DEFAULT},
                {LOGIN_DEFAULT, " 123456qwerty"}
        };
    }
}
