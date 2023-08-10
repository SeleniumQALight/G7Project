package pages;

import org.openqa.selenium.WebDriver;

public class HomePage extends ParentPageWithHeader {

    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }
    @Override
    protected String getRelativeUrl() {
        return "/";
    }

    public HomePage openHomePage() {
        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.loginWithValidCred();
        checkIsRedirectToHomePage();
        return this;
    }

    public HomePage checkIsRedirectToHomePage() {
        checkUrl();
        getHeader().checkIsButtonSignOutVisible();
        return this;
    }

    public HomePage openHomePageAndLoginIfNeeded() {
        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.openLoginPage();
        if (this.getHeader().isButtonSignOutVisible()) {
            logger.info("User is already logged in");
        } else {
            loginPage.loginWithValidCred();
            checkIsRedirectToHomePage();
            logger.info("User was logged in");
        }
        return this;
    }
}

