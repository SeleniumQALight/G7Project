package LoginTests;

import baseTest.BaseTest;
import data.TestData;
import org.junit.Test;

public class SignOutTest extends BaseTest {

    @Test
    public void signOut() {
        pageProvider.getLoginPage().openLoginPage();
        pageProvider.getLoginPage().enterTextInputUserName(TestData.LOGIN_DEFAULT);
        pageProvider.getLoginPage().enterTextInputPassword(TestData.PASSWORD_DEFAULT);
        pageProvider.getLoginPage().clickOnButtonSignIn();

        pageProvider.getHomePage().getHeader().checkIsLinkSearchVisible();
        pageProvider.getHomePage().getHeader().checkIsIconChatVisible();
        pageProvider.getHomePage().getHeader().checkIsLinkAvatarVisible();
        pageProvider.getHomePage().getHeader().checkIsTextUserNameVisible();
        pageProvider.getHomePage().getHeader().checkIsLinkCreatePostVisible();
        pageProvider.getHomePage().getHeader().checkIsButtonSignOutVisible();

        pageProvider.getHomePage().getHeader().clickOnButtonSignOut();

        pageProvider.getLoginPage().checkIsInputUsernameLoginVisible();
        pageProvider.getLoginPage().checkIsInputPasswordLoginVisible();
        pageProvider.getLoginPage().checkIsButtonSignInVisible();

    }


}
