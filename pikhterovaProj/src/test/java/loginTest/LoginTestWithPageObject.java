package loginTest;

import libs.ConfigProvider;
import libs.ExcelDriver;
import org.junit.Test;


import java.io.IOException;
import java.util.Map;

import static testData.TestData.LOGIN_DEFAULT;
import static testData.TestData.PASSWORD_DEFAULT;

public class LoginTestWithPageObject extends baseTest.BaseTest {
    @Test
    public void validLogin() {
        pageProvider.getloginPage().openLoginPage();
        pageProvider.getloginPage().enterTextIntoInputUserName(LOGIN_DEFAULT);
        pageProvider.getloginPage().enterTextIntoInputPassword(PASSWORD_DEFAULT);
        pageProvider.getloginPage().clickOnButtonSignIn();

        pageProvider.getHomePage().getHeader().checkIsButtonSignOutVisible();
    }

    @Test
    public void validLoginWithExcel() throws IOException {
        Map<String,String> dataForValidLogin =
                ExcelDriver.getData(ConfigProvider.configProperties.DATA_FILE(), "validLogOn");
        pageProvider.getloginPage().openLoginPage();
        pageProvider.getloginPage().enterTextIntoInputUserName(dataForValidLogin.get("login"));
        pageProvider.getloginPage().enterTextIntoInputPassword(dataForValidLogin.get("pass"));
        pageProvider.getloginPage().clickOnButtonSignIn();

        pageProvider.getHomePage().getHeader().checkIsButtonSignOutVisible();
    }
}
