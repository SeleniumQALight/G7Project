package pages;

import org.openqa.selenium.WebDriver;

public class PageProvider {
    WebDriver webDriver;

    public PageProvider(WebDriver webDriver) {
        this.webDriver = webDriver;
        postPage = new PostPage(webDriver);
    }

    public LoginPage getloginPage() {
        return new LoginPage(webDriver);

    }
    private PostPage postPage;

    public HomePage getHomePage() {
        return new HomePage(webDriver);
    }

    public PostPage getPostPage()
    {
        return new PostPage(webDriver);
    }

    public MyProfilePage getMyProfilePage()
    {
        return new MyProfilePage(webDriver);
    }

    public EditPostPage getEditPostPage()
    {
        return new EditPostPage(webDriver);
    }

}
