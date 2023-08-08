package pages;

import org.openqa.selenium.WebDriver;


public class HomePage extends ParentPageWithHeader {
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
        getHeader().checkIsButtonSignOutVisible();
        //TODO check url
        //TODO some unique element on the page
        return this;
    }


    public HomePage openHomePageAndLoginIfNeeded() {
        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.openLoginPage();
        if (this.getHeader().isButtonSignOutVisible()) {
            logger.info("User is already logged in");
        } else {
            loginPage.loginWithValidCreds();
            checkIsRedirectToHomePage();
        }

        return this;
    }
}