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
        getHeader().checkSearchButtonVisible();
        getHeader().checkChatButtonVisible();
        getHeader().checkProfileButtonVisible();
        getHeader().checkButtonCreatePostVisible();
        getHeader().checkIsSignOutButtonVisible();
        return this;
    }
}
