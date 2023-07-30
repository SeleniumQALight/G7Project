package pages;

import org.openqa.selenium.WebDriver;

public class PageProvider {
    WebDriver webDriver;
    public PageProvider(WebDriver webDriver) {
        this.webDriver = webDriver;
    } // конструктор
    public LoginPage getloginPage() {
        return new LoginPage(webDriver);
    } // метод для створення об'єкту LoginPage
    public HomePage getHomePage() { return  new HomePage(webDriver);  } // метод для створення об'єкту HomePage

}