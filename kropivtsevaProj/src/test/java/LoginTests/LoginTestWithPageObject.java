package LoginTests;

import categories.SmokeTestFilters;
import data.TestData;
import io.qameta.allure.*;
import libs.ExcelDriver;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;

import java.io.IOException;
import java.util.Map;

import static data.TestData.*;
import static libs.ConfigProvider.configProperties;

@Epic("Allure examples")
@Feature("Junit 4 support")

public class LoginTestWithPageObject extends baseTest.BaseTest {
    @Description("Some detailed test description")
    @Link("https://example.org")
    @Link(name = "allure", type = "mylink")
    @Issue("123")
    @Issue("432")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Base support for bdd annotations")
    @Test
    @Category(SmokeTestFilters.class)
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

    @Test
    @Parameters(method = "parametersForLogin")
    public void checkErrorsTest(String userName, String password) {
        pageProvider.getLoginPage().openLoginPage();
        pageProvider.getLoginPage().enterTextIntoInputUserName(userName);
        pageProvider.getLoginPage().enterTextIntoInputUserPassword(password);
        pageProvider.getLoginPage().clickOnButtonSignIn();
        pageProvider.getLoginPage().checkMessageInvalidUsernamePasswordIsDisplayed();

    }

    public Object[][] parametersForLogin() {
        return new Object[][]{
                {LOGIN_DEFOULT, PASSWORD_invalid},
                {LOGIN_invalid, PASSWORD_DEFOULT},
                {LOGIN_invalid, PASSWORD_invalid}
        };
    }

    @Test

    public void validSignOut() {
        pageProvider.getLoginPage().openLoginPage();
        pageProvider.getLoginPage().enterTextIntoInputUserName(LOGIN_DEFOULT);
        pageProvider.getLoginPage().enterTextIntoInputUserPassword(PASSWORD_DEFOULT);
        pageProvider.getLoginPage().clickOnButtonSignIn();
        pageProvider.getHomePage().getHeader().checkIsButtonSignOutVisible();
        pageProvider.getHomePage().getHeader().checkIsButtonSearchVisible();
        pageProvider.getHomePage().getHeader().checkIsButtonChatVisible();
        pageProvider.getHomePage().getHeader().checkIsButtonProfileVisible();
        pageProvider.getHomePage().getHeader().checkIsButtonCreatePostVisible();
        pageProvider.getLoginPage().checkIsButtonSignInNotVisible();
        pageProvider.getLoginPage().checkIsInputUserNameNotVisible();
        pageProvider.getLoginPage().checkIsInputUserPasswordNotVisible();
        pageProvider.getHomePage().getHeader().clickOnButtonSignOut();
        pageProvider.getLoginPage().checkIsButtonSignInVisible();
        pageProvider.getLoginPage().checkIsInputUserNameVisible();
        pageProvider.getLoginPage().checkIsInputUserPasswordVisible();
        pageProvider.getHomePage().getHeader().checkIsButtonSignOutNotVisible();
        pageProvider.getHomePage().getHeader().checkIsButtonSearchNotVisible();
        pageProvider.getHomePage().getHeader().checkIsButtonChatNotVisible();
        pageProvider.getHomePage().getHeader().checkIsButtonProfileNotVisible();
        pageProvider.getHomePage().getHeader().checkIsButtonCreatePostNotVisible();
    }

    @Test
    public void validLoginWithExcel() throws IOException {
        Map<String, String> dataForValidLogin = ExcelDriver.getData(configProperties.DATA_FILE(), "validLogOn");
        pageProvider.getLoginPage().openLoginPage();
        pageProvider.getLoginPage().enterTextIntoInputUserName(dataForValidLogin.get("login"));
        pageProvider.getLoginPage().enterTextIntoInputUserPassword(dataForValidLogin.get("pass"));
        pageProvider.getLoginPage().clickOnButtonSignIn();
        pageProvider.getHomePage().getHeader().checkIsButtonSignOutVisible();
    }

}
