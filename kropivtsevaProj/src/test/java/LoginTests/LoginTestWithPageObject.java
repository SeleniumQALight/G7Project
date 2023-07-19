package LoginTests;

import org.junit.Test;

public class LoginTestWithPageObject extends baseTest.BageTest{
    @Test
    public void validLogin(){
        pageProvider.getLoginPage().openLoginPage();
        pageProvider.getLoginPage().enterTextIntoInputUserName("dariak");
        pageProvider.getLoginPage().enterTextIntoInputUserPassword("123456qwerty");
        pageProvider.getLoginPage().clickOnButtonSignIn();

        //todo Assert
    }
}
