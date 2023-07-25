package loginTests;

import org.junit.Test;

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

}