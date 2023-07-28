package pages;

import org.openqa.selenium.WebDriver;

public class HomePage extends ParentPageWithHeader{
    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    public HomePage openHomePage() {
        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.loginWithValidCreds();
        checkIsRedirectToHomePage();
        return this;
    }

    public HomePage checkIsRedirectToHomePage() {
        //TODO check URL
        //TODO check is avatar present
        getHeader().checkIsButtonSignOutVisible();
        return this;
    }
}
