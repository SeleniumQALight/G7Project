package pages;

import org.openqa.selenium.WebDriver;

public class HomePage extends ParentPageWithHeder { //
    public HomePage(WebDriver webDriver) { // конструктор
        super (webDriver);
    }

    public  HomePage openHomePage() {
        LoginPage loginPage = new LoginPage(webDriver); // створюємо об'єкт класу LoginPage
        loginPage.loginWithValidCreds();
        checkIsRedirectToHomePage ();
        return this;
    }

    public HomePage checkIsRedirectToHomePage() {
        //TODO check url
        //TODO some unique element
        getHeader().checkIsButtonSignOutVisible(); // перевірка чи є кнопка SignOut
        return this;
    }

    public HomePage openHomePageAndLoginifNeeded() {
        LoginPage loginPage = new LoginPage(webDriver); // створюємо об'єкт класу LoginPage
        loginPage.openLoginPage();
        if(this.getHeader().isButtonSignOutVisible()) { // перевірка чи є кнопка SignOut
           logger.info("User is already logged in");
        } else {
            loginPage.loginWithValidCreds();
            checkIsRedirectToHomePage();
        }
        return this;
    }
}
