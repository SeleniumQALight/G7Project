package LoginTests;

import data.TestData;
import org.junit.Test;

import static data.TestData.*;


public class LoginTestWithPageObject extends baseTest.BageTest {
    @Test
    public void validLogin() {
        pageProvider.getLoginPage().openLoginPage();
        pageProvider.getLoginPage().enterTextIntoInputUserName(LOGIN_DEFOULT);
        pageProvider.getLoginPage().enterTextIntoInputUserPassword(PASSWORD_DEFOULT);
        pageProvider.getLoginPage().clickOnButtonSignIn();
        pageProvider.getHomePage().getHeader().checkIsButtonSignOutVisible();
    }

    @Test
    public void invalidLogin() {
        pageProvider.getLoginPage().openLoginPage();
        pageProvider.getLoginPage().enterTextIntoInputUserName(LOGIN_invalid);
        pageProvider.getLoginPage().enterTextIntoInputUserPassword(PASSWORD_invalid);
        pageProvider.getLoginPage().clickOnButtonSignIn();
        pageProvider.getLoginPage().checkMessageInvalidUsernamePasswordIsDisplayed();
        pageProvider.getLoginPage().checkIsButtonSignInVisible();
        pageProvider.getHomePage().getHeader().checkIsButtonSignOutNotVisible();
    }
}
