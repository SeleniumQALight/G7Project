package LoginTest;

import org.junit.Test;

public class LoginTestWithPageObject extends baseTest.BaseTest {

    @Test
    public void validLogin() {
        pageProvider.getloginPage().openLoginPage();
        pageProvider.getloginPage().enterTextIntoInputUserNane("qaauto");
        pageProvider.getloginPage().enterTextIntoInputPassword("123456qwerty");
        pageProvider.getloginPage().clickOnButtonSignIn();

// TODO Assert
    }
}