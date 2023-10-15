package pages;

import org.openqa.selenium.WebDriver;
import pages.PrivateBank.PrivateBankPage;

public class PageProvider {
    WebDriver webDriver;

    public PageProvider(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public LoginPage getLoginPage() {
        return new LoginPage(webDriver);
    }

    public HomePage getHomePage() {
        return new HomePage(webDriver);
    }

    public PostPage getPostPage() {
        return new PostPage(webDriver);
    }

    public EditPostPage getEditPostPage() {
        return new EditPostPage(webDriver);
    }

    public MyProfilePage getMyProfilePage() {
        return new MyProfilePage(webDriver);
    }

    public PrivateBankPage getPrivateBankPage() {
        return new PrivateBankPage(webDriver);
    }

}
