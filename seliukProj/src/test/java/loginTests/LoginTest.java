package loginTests;

import org.junit.Test;

public class LoginTest extends baseTest.BaseTest {
    @Test
    public void validLogin() {
        pageProvider.getLoginPage().openLoginPage();
        pageProvider.getLoginPage().enterPassword("qaauto");
        pageProvider.getLoginPage().enterPassword("123456qwerty");
        pageProvider.getLoginPage().clickOnButtonSignIn();

        //TODO Assert
    }

}
