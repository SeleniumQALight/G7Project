package pages;

import org.openqa.selenium.WebDriver;

public class PageProvider {
    WebDriver webDriver;

    public PageProvider(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public LoginPage getloginPage() {
        return new LoginPage(webDriver);
    }

    public HomePage getHomePage() {
        return new HomePage(webDriver);
    }

    public PostPage getPostPage() {
        return new PostPage(webDriver);
    }

    public MyProfilePage getMyProfilePage() {
        return new MyProfilePage(webDriver);
    }

    public PrivatBankCurrencyRatesPage getPrivatBankCurrencyRatesPage() {
        return new PrivatBankCurrencyRatesPage(webDriver);
    }

}
