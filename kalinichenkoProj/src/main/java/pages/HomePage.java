package pages;

import org.openqa.selenium.WebDriver;

public class HomePage extends ParentPageWithHeader{
    public HomePage (WebDriver webDriver) {
        super(webDriver);
    }

    public HomePage openHomePage() {
        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.loinWithValidCred();
        checkIsRedirectToHomePage();
        return this;
    }

    public HomePage checkIsRedirectToHomePage() {
        //TODO check url
        //TODO check unique element
        getHeader().checkIsButtonSignOutVisible();
        return this;
    }


}
