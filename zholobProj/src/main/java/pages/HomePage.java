package pages;

import org.openqa.selenium.WebDriver;

public class HomePage extends ParentPageWithHeder { //
    public HomePage(WebDriver webDriver) { // конструктор
        super (webDriver);
    }

    public  HomePage openHomePage() {
        LoginPage loginPage = new LoginPage(webDriver); // створюємо об'єкт класу LoginPage
        loginPage.loginWithValidCreds(); // викликаємо метод loginWithValidCreds() класу LoginPage
        checkIsRedirectToHomePage (); // метод перевірки чи ми на домашній сторінці
        return this; //залишаєьщсь на тій самій пейджі
    }

    public HomePage checkIsRedirectToHomePage() { // перевірка чи ми на домашній сторінці
        //TODO check url
        //TODO some unique element
        getHeader().checkIsButtonSignOutVisible(); // перевірка чи є кнопка SignOut
        return this;
    }

}
