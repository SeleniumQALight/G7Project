package loginTests;

import data.TestData;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import libs.ConfigProvider;
import libs.ExcelDriver;
import org.junit.Test;

import static data.TestData.LOGIN_DEFAULT;
import static data.TestData.PASSWORD_DEFAULT;

import org.junit.runner.RunWith;
import org.openqa.selenium.WebElement;


@RunWith(JUnitParamsRunner.class)
public class LoginTestWithPageObject extends baseTest.BaseTest {
    final static String ERROR_LOGIN = "Invalid username / pasword";

import java.io.IOException;
import java.util.Map;

public class LoginTestWithPageObject extends baseTest.BaseTest{
    @Test
    public void validLogin() {
        pageProvider.getLoginPage().openLoginPage();
        pageProvider.getLoginPage().enterTextIntoInputUserName(LOGIN_DEFAULT);
        pageProvider.getLoginPage().enterTextIntoInputPassword(PASSWORD_DEFAULT);
        pageProvider.getLoginPage().clickOnButtonSignIn();

        pageProvider.getHomePage().getHeader().checkIsButtonSignOutVisible();
    }
    @Test
    public  void validLoginWithExcel() throws IOException {
        Map<String,String> dataForValidLogin = ExcelDriver.getData(ConfigProvider.configProperties.DATA_FILE(), "validLogOn");
        pageProvider.getLoginPage().openLoginPage();
        pageProvider.getLoginPage().enterTextIntoInputUserName(dataForValidLogin.get("login"));
        pageProvider.getLoginPage().enterTextIntoInputPassword(dataForValidLogin.get("pass"));
        pageProvider.getLoginPage().clickOnButtonSignIn();

        pageProvider.getHomePage().getHeader().checkIsButtonSignOutVisible();
    }

    @Test
    public void inValidLogin() {
        pageProvider.getLoginPage().openLoginPage();
        pageProvider.getLoginPage().enterTextIntoInputUserName(LOGIN_DEFAULT);
        pageProvider.getLoginPage().enterTextIntoInputPassword(PASSWORD_DEFAULT);
        pageProvider.getLoginPage().clickOnButtonSignIn();

        pageProvider.getLoginPage().checkIsButtonSignInVisible();
        pageProvider.getHomePage().getHeader().checkIsButtonMyProfileVisible();
    }

    @Test
    public void checkingSignOut() {
        pageProvider.getLoginPage().openLoginPage();
        pageProvider.getLoginPage().enterTextIntoInputUserName(LOGIN_DEFAULT);
        pageProvider.getLoginPage().enterTextIntoInputPassword(PASSWORD_DEFAULT);
        pageProvider.getLoginPage().clickOnButtonSignIn();

        pageProvider.getHomePage().getHeader().checkIsButtonSearchVisible();
        pageProvider.getHomePage().getHeader().checkIsButtonChatVisible();
        pageProvider.getHomePage().getHeader().checkIsButtonMyProfileVisible();
        pageProvider.getHomePage().getHeader().checkIsButtonSignOutVisible();
        pageProvider.getHomePage().getHeader().checkIsButtonCreatePostVisible();

        pageProvider.getLoginPage().checkNotIsButtonSignInVisible();
        pageProvider.getLoginPage().checkNotIsFieldLoginVisible();

        pageProvider.getLoginPage().clickOnButtonSignOut();

        pageProvider.getHomePage().getHeader().checkNotIsButtonSearchVisible();
        pageProvider.getHomePage().getHeader().checkNotIsButtonChatVisible();
        pageProvider.getHomePage().getHeader().checkNotIsButtonMyProfileVisible();
        pageProvider.getHomePage().getHeader().checkNotIsButtonSignOutVisible();

        pageProvider.getLoginPage().checkIsButtonSignInVisible();
        pageProvider.getLoginPage().checkIsFieldLoginVisible();
        pageProvider.getLoginPage().checkIsFieldPasswordVisible();


    }

    @Test
    @Parameters(method = "parametersForInvalidLoginErrorsTest")
    public void invalidLoginErrorsTest(String userName, String password, String expectedMessages) {
        pageProvider.getLoginPage().openLoginPage();
        pageProvider.getLoginPage().enterTextIntoInputUserName(userName);
        pageProvider.getLoginPage().enterTextIntoInputPassword(password);
        pageProvider.getLoginPage().clickOnButtonSignIn();
        pageProvider.getLoginPage().checkIsMessageInvalidUserNameOrPasswordVisible();

    }

    public Object[][] parametersForInvalidLoginErrorsTest() {
        return new Object[][]{
                {"", "123456qwerty", ERROR_LOGIN},
                {"quaauto", "123", ERROR_LOGIN},
                {"qaauto", "", ERROR_LOGIN},
                {"", "", ERROR_LOGIN},
        };
    }
}
