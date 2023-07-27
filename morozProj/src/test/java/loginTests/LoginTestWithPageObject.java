package loginTests;

import org.junit.Test;

public class LoginTestWithPageObject extends baseTest.BaseTest{
    @Test
    public void validLogin(){
        pageProvider.getloginPage().openLoginPage();
        pageProvider.getloginPage().enterTextIntoInputUsername("qaauto");
        pageProvider.getloginPage().enterTextIntoInputPassword("123456qwerty");
        pageProvider.getloginPage().clickOnSignInButton();

        //TODO Assert
    }
}
