package pages;

import org.openqa.selenium.WebDriver;

public class HomePage extends ParentPageWithHeader {
    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    //actions
    public HomePage openHomePage() {
        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.openLoginPage();
        loginPage.loginWithValidCredentials();
        checkIsRedirectOnHomePage();
        return this;
    }

    //checks
    public HomePage checkIsRedirectOnHomePage() {
        //TODO: check url
        //TODO: check some unique element
        getHeader().checkIsButtonSignOutVisible();
        return this;
    }

    public HomePage openHomePageIfNeed() {
        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.openLoginPage();
        if (this.getHeader().isButtonSignOutVisible()) {
            logger.info("User was already logged in");
        } else {
            loginPage.loginWithValidCredentials();
            checkIsRedirectOnHomePage();
        }
        return this;
    }
}
