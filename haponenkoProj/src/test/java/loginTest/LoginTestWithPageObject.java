package loginTest;

import baseTest.BaseTest;
import categories.SmokeTestFilter;
import io.qameta.allure.*;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import libs.ConfigProvider;
import libs.ExcelDriver;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;

import java.io.IOException;
import java.util.Map;

import static data.TestData.LOGIN_DEFAULT;
import static data.TestData.PASSWORD_DEFAULT;

@RunWith(JUnitParamsRunner.class)

@Epic("Allure examples")
@Feature("Junit 4 support")
public class LoginTestWithPageObject extends BaseTest {

    final static String ERROR_MESSAGE = "Invalid username / pasword";
    @Description("Some detailed test description")
    @Link("https://example.org")
    @Link(name = "allure", type = "mylink")
    @Issue("123")
    @Issue("432")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Base support for bdd annotations")
    @Test
    //@Ignore
    @Category(SmokeTestFilter.class)
    public void validLogin() {
        pageProvider.getLoginPage().openLoginPage();
        pageProvider.getLoginPage().enterTextIntoInputUserName(LOGIN_DEFAULT);
        pageProvider.getLoginPage().enterTextIntoInputPassword(PASSWORD_DEFAULT);
        pageProvider.getLoginPage().clickOnButtonSignIn();

        pageProvider.getHomePage().getHeader().checkIsButtonSignOutVisible();
    }

    @Test
    public void validLoginWithExcel() throws IOException {
        Map<String,String> dataForValidLogin = ExcelDriver.getData(ConfigProvider.configProperties.DATA_FILE(), "validLogOn");
        pageProvider.getLoginPage().openLoginPage();
        pageProvider.getLoginPage().enterTextIntoInputUserName(dataForValidLogin.get("login"));
        pageProvider.getLoginPage().enterTextIntoInputPassword(dataForValidLogin.get("pass"));
        pageProvider.getLoginPage().clickOnButtonSignIn();

        pageProvider.getHomePage().getHeader().checkIsButtonSignOutVisible();
    }

    @Test
    @Parameters(method = "parametersForInvalidLogin")
    public void invalidLogin(String userName, String password) {
        pageProvider.getLoginPage().openLoginPage();
        pageProvider.getLoginPage().enterTextIntoInputUserName(userName);
        pageProvider.getLoginPage().enterTextIntoInputPassword(password);
        pageProvider.getLoginPage().clickOnButtonSignIn();
        pageProvider.getLoginPage().checkIsButtonSignInVisible();
        pageProvider.getHomePage().getHeader().checkIsButtonSignOutNotVisible();
//        pageProvider.getLoginPage().checkIsErrorMessageVisible();

        pageProvider.getLoginPage().checkErrorMessageLogin(ERROR_MESSAGE);
    }

    public Object[][] parametersForInvalidLogin() {
        return new Object[][]{
                {"123", " "}
        };
    }
}
