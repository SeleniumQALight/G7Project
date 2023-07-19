package loginTests;

import org.junit.Test;

public class LoginTestWithPageObject extends baseTest.BaseTest {
    @Test
    public void validLogin() {
            pageProvider.getLoginPage().openLoginPage();
            pageProvider.getLoginPage().enterTextInToInputUserName("yuliiaborodynska");
            pageProvider.getLoginPage().enterTextInToInputPassWord("123qweasd");
            pageProvider.getLoginPage().clickOnButtonSignIn();
        }
    }

