package pages;

import org.openqa.selenium.WebDriver;

public class HomePage extends ParentPageWithHeader{
    public HomePage (WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    protected String getRelativeUrl() {
        return "/";
    }

    public HomePage openHomePage() {
        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.loinWithValidCred();
        checkIsRedirectToHomePage();
        return this;
    }

    public HomePage checkIsRedirectToHomePage() {
        checkUrl();
        //TODO check unique element
        getHeader().checkIsButtonSignOutVisible();
        return this;
    }


    public HomePage openHomePageAndLoginIfNeeded() {
        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.openLoginPage();
        if (this.getHeader().isButtonSignOutVisible()) {
            logger.info("User is already logged in");
        } else {
            loginPage.loinWithValidCred();
            checkIsRedirectToHomePage();
            logger.info("User was logged in");
        }
        return this;
    }
}
