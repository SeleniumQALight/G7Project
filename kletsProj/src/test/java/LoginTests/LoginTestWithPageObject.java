package LoginTests;

import data.TestData;
import io.qameta.allure.*;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import libs.ConfigProvider;
import libs.ExcelDriver;
import org.junit.Test;
import org.junit.runner.RunWith;


import java.io.IOException;
import java.util.Map;

import static data.TestData.LOGIN_DEFAULT;
import static data.TestData.PASSWORD_DEFAULT;

@RunWith(JUnitParamsRunner.class)
@Epic("Allure examples")
@Feature("Junit 4 support")

public class LoginTestWithPageObject extends baseTest.BaseTest {
    @Description("Login with valid credentials")
    @Link("https://qa-complexapp.onrender.com")
    @Link(name = "Base URL", type = "myLink")
    @Issue("Issue-1")
    @Issue("Issue-2")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Base support for bdd annotations")

    @Test
    public void validLogin() {
        pageProvider.getLoginPage().openLoginPage();
        pageProvider.getLoginPage().enterTextIntoInputUserName(LOGIN_DEFAULT);
        pageProvider.getLoginPage().enterTextIntoInputPassword(PASSWORD_DEFAULT);
        pageProvider.getLoginPage().clickOnButtonSignIn();

        pageProvider.getHomePage().getHeader().checkIsButtonSignOutVisible();

    }

    @Test
    public void validLoginWithExel() throws IOException {
        Map<String, String> dataForValidLogin =
                ExcelDriver.getData(ConfigProvider.configProperties.DATA_FILE(), "validLogOn");
        pageProvider.getLoginPage().openLoginPage();
        pageProvider.getLoginPage().enterTextIntoInputUserName(dataForValidLogin.get("login"));
        pageProvider.getLoginPage().enterTextIntoInputPassword(dataForValidLogin.get("pass"));
        pageProvider.getLoginPage().clickOnButtonSignIn();

        pageProvider.getHomePage().getHeader().checkIsButtonSignOutVisible();

    }

    @Test
    public void invalidLogin() {
        pageProvider.getLoginPage().openLoginPage();
        pageProvider.getLoginPage().enterTextIntoInputUserName(TestData.LOGIN_INVALID);
        pageProvider.getLoginPage().enterTextIntoInputPassword(TestData.PASSWORD_DEFAULT);
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
        pageProvider.getLoginPage().enterTextIntoInputUserName(userName);
        pageProvider.getLoginPage().enterTextIntoInputPassword(password);
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
