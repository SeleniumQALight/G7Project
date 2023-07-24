package loginTest;

import org.junit.Test;

import static data.TestData.LOGIN_DEFAULT;
import static data.TestData.PASSWORD_DEFAULT;

public class InvalidLoginTestWithPageObject extends baseTest.BaseTest {
    @Test
    public void invalidLogin() {
        pageProvider.getLoginPage().openLoginPage();
        pageProvider.getLoginPage().enterTextIntoInputUserName(LOGIN_DEFAULT);
        pageProvider.getLoginPage().enterTextIntoInputPassword(PASSWORD_DEFAULT);
        pageProvider.getLoginPage().clickOnButtonSignIn();

        pageProvider.getHomePage().getHeader().checkIsButtonSignOutNotVisible();
        pageProvider.getHomePage().getHeader().checkIsButtonSignInVisible();
        pageProvider.getHomePage().getHeader().checkIsErrorMessageInvalidUsernamePasswordDisplayed();
    }
}