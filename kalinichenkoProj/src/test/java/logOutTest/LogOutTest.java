package logOutTest;

import org.junit.Test;
import static test_data.TestData.*;

public class LogOutTest extends baseTest.BaseTest {

    @Test
    public void logOutTest() {
        pageProvider.getLoginPage().openLoginPage();
        pageProvider.getLoginPage().enterTextIntoInputUserName(LOGIN_DEFAULT);
        pageProvider.getLoginPage().enterTextIntoInputPassword(PASSWORD_DEFAULT);
        pageProvider.getLoginPage().clickOnButtonSignIn();
        pageProvider.getLoginPage().isButtonSignInNotVisible();
        pageProvider.getHomePage().getHeader().checkIsButtonSignOutVisible();
        pageProvider.getHomePage().getHeader().checkIsButtonCreatePostVisible();
        pageProvider.getHomePage().getHeader().checkIsProfileNameVisible();
        pageProvider.getHomePage().getHeader().checkIsProfileAvatarVisible();
        pageProvider.getHomePage().getHeader().checkIsButtonChatVisible();
        pageProvider.getHomePage().getHeader().checkIsButtonSearchVisible();
        pageProvider.getHomePage().getHeader().checkIsButtonHomePageVisible();
        pageProvider.getHomePage().getHeader().clickOnButtonSignOut();
        pageProvider.getHomePage().getHeader().checkIsButtonSignOutNotVisible();
        pageProvider.getHomePage().getHeader().checkIsButtonCreatePostNotVisible();
        pageProvider.getHomePage().getHeader().checkIsProfileNameNotVisible();
        pageProvider.getHomePage().getHeader().checkIsProfileAvatarNotVisible();
        pageProvider.getHomePage().getHeader().checkIsButtonChatNotVisible();
        pageProvider.getHomePage().getHeader().checkIsButtonSearchNotVisible();
        pageProvider.getHomePage().getHeader().checkIsButtonHomePageVisible();
        pageProvider.getLoginPage().isButtonSignInVisible();
        pageProvider.getLoginPage().isInputUserNameVisible();
        pageProvider.getLoginPage().isInputPasswordVisible();

    }


}
