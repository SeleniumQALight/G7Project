package pages;

import org.openqa.selenium.WebDriver;

import java.sql.SQLException;

public class HomePage extends ParentPageWithHeader{
    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    protected String getRelativeUrl() {
        return "/";
    }

    public HomePage openHomePage() {
        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.loginWithValidCreds();
        checkIsRedirectToHomePage();

        return this;
    }
    public HomePage openHomePageDB () throws SQLException, ClassNotFoundException {
        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.loginWithValidCredsFromDB();
        checkIsRedirectToHomePage();
        return this;

    }

    public HomePage checkIsRedirectToHomePage() {
        checkUrl();
        //TODO check URL
        //TODO some unique element
        getHeader().checkIsButtonSignOutVisible();
        return this;

    }

    public HomePage openHomePageAndLoginIfNeeded() {
        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.openLoginPage();
        if(this.getHeader().isButtonSignOutVisible()){
            logger.info("User is already logged in");
        }else{
            loginPage.loginWithValidCreds();
            checkIsRedirectToHomePage();
            logger.info("User was not logged in. Login with valid creds");
        }
        return this;
    }
    public HomePage openHomePageAndLoginifNeeded() {//
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
