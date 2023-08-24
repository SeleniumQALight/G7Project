package LoginTests;

import baseTest.BaseTest;
import categories.SmokeTestFilter;
import data.TestData;
import junitparams.JUnitParamsRunner;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)

public class SignOutTest extends BaseTest {

    @Test
    @Category(SmokeTestFilter.class)
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

        pageProvider.getLoginPage().checkIsInputUsernameLoginNotVisible();
        pageProvider.getLoginPage().checkIsInputPasswordLoginNotVisible();
        pageProvider.getLoginPage().checkIsButtonSignInNotVisible();

        pageProvider.getHomePage().getHeader().clickOnButtonSignOut();

        pageProvider.getLoginPage().checkIsInputUsernameLoginVisible();
        pageProvider.getLoginPage().checkIsInputPasswordLoginVisible();
        pageProvider.getLoginPage().checkIsButtonSignInVisible();

        pageProvider.getHomePage().getHeader().checkIsLinkSearchNotVisible();
        pageProvider.getHomePage().getHeader().checkIsIconChatNotVisible();
        pageProvider.getHomePage().getHeader().checkIsLinkAvatarNotVisible();
        pageProvider.getHomePage().getHeader().checkIsTextUserNameNotVisible();
        pageProvider.getHomePage().getHeader().checkIsLinkCreatePostNotVisible();
        pageProvider.getHomePage().getHeader().checkIsButtonSignOutNotVisible();

    }
}
