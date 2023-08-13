package testWithBrowser;

import org.junit.Test;
import workWithBrowser.WorkWithBrowser;

import static test_data.TestData.*;


public class LonInTestWithBrowser extends baseTest.BaseTest {
    // how to add new window in browser and switch to it
    @Test

    public void LonInTestWithBrowser() {
        WorkWithBrowser workWithBrowser = new WorkWithBrowser(webDriver);

        pageProvider.getLoginPage().openLoginPage(); // open login page// enter password
        pageProvider.getLoginPage().enterTextIntoInputUserName(LOGIN_DEFAULT);// enter password
        workWithBrowser.switchToNextField(); // switch to next field
        workWithBrowser.enterTextIntoInput(PASSWORD_DEFAULT);// enter password
        workWithBrowser.switchToNextField(); // switch to next field
        workWithBrowser.pressEnter(); // click on button
        pageProvider.getHomePage()
                .getHeader()
                .checkIsButtonSignOutVisible();
        workWithBrowser.addNewWindow(); // add new window
        pageProvider.getLoginPage().openLoginPage();
        pageProvider.getHomePage()
                .getHeader()
                .checkIsButtonSignOutVisible();
        pageProvider.getHomePage().getHeader()
                .clickOnButtonSignOut();
        workWithBrowser.switchToPreviousWindow();
        workWithBrowser.refreshPage();
        pageProvider.getLoginPage()
                .checkButtonSignInVisible();
    }
}
