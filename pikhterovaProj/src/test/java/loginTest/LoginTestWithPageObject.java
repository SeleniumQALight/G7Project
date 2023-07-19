package loginTest;

import org.junit.Test;

public class LoginTestWithPageObject extends baseTest.BaseTest {
    @Test
    public void validLogin() {
        pageProvider.getloginPage().openLoginPage();
        pageProvider.getloginPage().enterTextIntoInputUserName("qaauto");
        pageProvider.getloginPage().enterTextIntoInputPassword("123456qwerty");
        pageProvider.getloginPage().clickOnButtonSignIn();

        //TODO Assert
    }
}
