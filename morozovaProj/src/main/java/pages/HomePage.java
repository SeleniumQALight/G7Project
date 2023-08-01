package pages;

import org.openqa.selenium.WebDriver;

public class HomePage extends ParentPageWithHeder {
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
        // TODO some unigue element
        getHeader().checkIsButtonSignOutVisible();
        return this;
    }

    public HomePage openHomePageAndLoginIfNeeded() {
        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.openLoginPage();

        if (this.getHeader().IsButtonSignOutVisible()) {
            logger.info("User is already logged in");
        } else {
            loginPage.loginWithValidCreds();
            checkIsRedirectToHomePage();
            logger.info("User was  logged in");
        }
        return this;
    }
}
