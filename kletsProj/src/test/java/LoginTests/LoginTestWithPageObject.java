package LoginTests;

import data.TestData;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static data.TestData.LOGIN_DEFAULT;
import static data.TestData.PASSWORD_DEFAULT;

@RunWith(JUnitParamsRunner.class)

public class LoginTestWithPageObject extends baseTest.BaseTest {

    @Test
    public void validLogin() {
        pageProvider.getLoginPage().openLoginPage();
        pageProvider.getLoginPage().enterTextInputUserName(LOGIN_DEFAULT);
        pageProvider.getLoginPage().enterTextInputPassword(PASSWORD_DEFAULT);
        pageProvider.getLoginPage().clickOnButtonSignIn();

        pageProvider.getHomePage().getHeader().checkIsButtonSignOutVisible();

    }

    @Test
    public void invalidLogin() {
        pageProvider.getLoginPage().openLoginPage();
        pageProvider.getLoginPage().enterTextInputUserName(TestData.LOGIN_INVALID);
        pageProvider.getLoginPage().enterTextInputPassword(TestData.PASSWORD_DEFAULT);
        pageProvider.getLoginPage().clickOnButtonSignIn();

        pageProvider.getLoginPage().checkErrorMessageIsDisplayed();
        pageProvider.getLoginPage().checkButtonSignInDisplayed();

        pageProvider.getHomePage().getHeader().checkIsLinkSearchNotVisible();
        pageProvider.getHomePage().getHeader().checkIsIconChatNotVisible();
        pageProvider.getHomePage().getHeader().checkIsLinkAvatarNotVisible();
        pageProvider.getHomePage().getHeader().checkIsTextUserNameNotVisible();
        pageProvider.getHomePage().getHeader().checkIsLinkCreatePostNotVisible();
        pageProvider.getHomePage().getHeader().checkIsButtonSignOutNotVisible();

    }

    @Test
    @Parameters(method = "parametersForInvalidLogin")
    public void invalidLoginParam(String userName, String password) {
        pageProvider.getLoginPage().openLoginPage();
        pageProvider.getLoginPage().enterTextInputUserName(userName);
        pageProvider.getLoginPage().enterTextInputPassword(password);
        pageProvider.getLoginPage().clickOnButtonSignIn();

        pageProvider.getLoginPage().checkErrorMessageIsDisplayed();
        pageProvider.getLoginPage().checkButtonSignInDisplayed();
        }

        public Object[][] parametersForInvalidLogin() {
            return new Object[][]{
                    {TestData.LOGIN_INVALID, TestData.PASSWORD_DEFAULT},
                    {TestData.LOGIN_DEFAULT, TestData.PASSWORD_INVALID},
                    {TestData.LOGIN_INVALID, TestData.PASSWORD_INVALID},
            };
    }
}
