package pages;

import org.openqa.selenium.WebDriver;

public class PageProvider {
    WebDriver webDriver;

    public PageProvider(WebDriver webDriver) {
        this.webDriver = webDriver;
    } // конструктор

    public LoginPage getloginPage() {  // метод для створення об'єкту LoginPage
                return new LoginPage(webDriver);
    }

    public HomePage getHomePage() { // метод для створення об'єкту HomePage
        return new HomePage(webDriver);
    }


    public PostPage getPostPage() { // метод для створення об'єкту PostPage
        return new PostPage(webDriver);
    }

    public CreatePostPage getCreatePostPage() {
        return new CreatePostPage(webDriver); // метод для створення об'єкту CreatePostPage
    }

    public PostEditPage getPostEditPage() {
        return new PostEditPage(webDriver); // метод для створення об'єкту PostEditPage
    }

    public MyProfilePage getMyProfilePage() {
        return new MyProfilePage(webDriver); // метод для створення об'єкту MyProfilePage
    }
}
