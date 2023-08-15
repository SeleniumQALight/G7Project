package loginTests;

import libs.ExcelDriver;
import org.assertj.core.configuration.ConfigurationProvider;
import org.junit.Test;

import javax.security.auth.login.Configuration;
import java.io.IOException;
import java.util.Map;

import static data.TestData.LOGIN_DEFAULT;
import static data.TestData.PASSWORD_DEFAULT;

public class LoginTest extends baseTest.BaseTest {

    @Test
    public void validLogin() {
        pageProvider.getLoginPage().openLoginPage();
        pageProvider.getLoginPage().enterUserName(LOGIN_DEFAULT);
        pageProvider.getLoginPage().enterPassword(PASSWORD_DEFAULT);
        pageProvider.getLoginPage().clickOnButtonSignIn();
        pageProvider.getHomePage().getHeader().checkIsButtonSignOutVisible();
    }

    @Test
    /**
     * Додати тест кейс на недвалідний логін (але тепер вже з пейдж обжектом),
     * аналогічні зробити перевірки до тесту, який ви писали без пейдж обжекта
     * (цей цейс додати в наш класс LoginTestWithPageObject)
     *      1.  кнопки log Out немає
     *      2.  кнопка Lig In показується
     *      3.  є месседж с тесктом «Invalid username/password.»
     */
    public void invalidLogin() {
        //actions
        pageProvider.getLoginPage().openLoginPage();
        pageProvider.getLoginPage().enterUserName(LOGIN_DEFAULT);
        pageProvider.getLoginPage().enterPassword("invalidLogin");
        pageProvider.getLoginPage().clickOnButtonSignIn();
        //checks
        pageProvider.getHomePage().getHeader().checkIsButtonSignOutNotVisible();
        pageProvider.getLoginPage().checkIsInputUserNameVisible();
        pageProvider.getLoginPage().checkIsMessageInvalidUsernameAndPasswordVisible();
    }

    @Test
    public void validLoginWithExcel() throws IOException {
        Map<String, String> dataForValidLogin = ExcelDriver.getData(".//src//main//java//data//testData.xls", "validLogOn");
        pageProvider.getLoginPage().openLoginPage();
        pageProvider.getLoginPage().enterUserName(dataForValidLogin.get("login"));
        pageProvider.getLoginPage().enterPassword(dataForValidLogin.get("pass"));
        pageProvider.getLoginPage().clickOnButtonSignIn();
        pageProvider.getHomePage().getHeader().checkIsButtonSignOutVisible();
    }

}