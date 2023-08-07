//package loginTests;
//
//import baseTest.BaseTest;
//import org.junit.Test;
//
//import static data.TestData.*;
//
//public class LoginTestWithEnterTab extends BaseTest {
//    @Test
//    public void LoginUsingEnter(){
//        pageProvider.getLoginPage().openLoginPage();
//        pageProvider.getLoginPage().enterTextIntoInputUserName(LOGIN_DEFAULT).tab();
//        pageProvider.getLoginPage().enterTextIntoInputPassword(PASSWORD_DEFAULT).enter();
//
//        pageProvider.getHomePage().getHeader().checkIsButtonSignOutVisible();
//    }
//}
