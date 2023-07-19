package LoginTests;

import org.junit.Test;

public class LoginTestWithPageObject extends baseTest.BaseTest {

    @Test
    public void validLogin() {
        pageProvider.getLoginPage().openLoginPage();
        pageProvider.getLoginPage().enterTextInputUserName("qaauto");
        pageProvider.getLoginPage().enterTextInputPassword("123456qwerty");

    }
}
