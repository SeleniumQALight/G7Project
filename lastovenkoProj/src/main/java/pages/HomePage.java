package pages;

import element.Header;
import org.openqa.selenium.WebDriver;

public class HomePage extends ParentPageWithHeader{
    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }



    public HomePage openHomePage() {
      LoginPage loginPage = new LoginPage(webDriver);
      loginPage.loginWithValidCreds();
      checkIsRedirectOnHomePage();

        return this;
    }

    public HomePage checkIsRedirectOnHomePage() {
        getHeader().checkisButtonSignOutVisible();

        ;
        return this;
    }
}
