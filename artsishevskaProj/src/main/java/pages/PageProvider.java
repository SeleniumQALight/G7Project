package pages;

import org.openqa.selenium.WebDriver;



public class PageProvider {
    WebDriver webDriver;
    public PageProvider(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
    public LoginPage getLoginPage(){
        return new LoginPage(webDriver);
    }
    public HomePage getHomePage(){
        return new HomePage(webDriver);
    }

    public PostPage getPostPage() {
        return new PostPage(webDriver);
    }

   public PostEditPage enterTextIntoInputTitle() {
      return new PostEditPage(webDriver);
 }
 public PostEditPage getPostEditPage() {
     return new PostEditPage(webDriver);
 }

    public MyProfilePage getMyProfilePage() {
        return new MyProfilePage(webDriver);
    }
    public CurrencyPagePB getPrivatBankHomePage(){
        return new CurrencyPagePB(webDriver);
    }
}
