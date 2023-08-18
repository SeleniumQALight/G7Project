package testWithBrowser;

import org.junit.Test;

import static test_data.TestData.*;


public class LonInTestWithBrowser extends baseTest.BaseTest {
    // how to add new window in browser and switch to it
    @Test

    public void LonInTestWithBrowser() {
        pageProvider.getLoginPage().openLoginPage(); // open login page// enter password
        pageProvider.getLoginPage().switchToNextField()
                .enterTextIntoInput(LOGIN_DEFAULT)// enter password
                .switchToNextField() // switch to next field
                .enterTextIntoInput(PASSWORD_DEFAULT)// enter password
                .switchToNextField() // switch to next field
                .pressEnter(); // click on button
        pageProvider.getHomePage()
                .getHeader()
                .checkIsButtonSignOutVisible();
        pageProvider.getHomePage().addNewWindow(); // add new window
        pageProvider.getLoginPage().openLoginPage();
        pageProvider.getHomePage()
                .getHeader()
                .checkIsButtonSignOutVisible();
        pageProvider.getHomePage().switchToNextField() // switch to next field
                .pressEnter(); // click on button
        pageProvider.getLoginPage()
                .checkButtonSignInVisible();
        pageProvider.getHomePage().switchToPreviousWindow();
        pageProvider.getHomePage().refreshPage();
        pageProvider.getLoginPage()
                .checkButtonSignInVisible();
    }
}
