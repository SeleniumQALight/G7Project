package pages.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.ActionsWithElements;
import pages.CreatePostPage;
import pages.MyProfilePage;

public class Header extends ActionsWithElements { // клас для роботи з елементами хедера
    @FindBy(xpath = "//button[text() = 'Sign Out']")
    private WebElement buttonSignOut;




    @FindBy(xpath = "//a[@ class='text-white mr-2 header-search-icon']//*[@data-icon ='search']")
    private WebElement buttonSearch;

    @FindBy(xpath = "//a[@class='btn btn-sm btn-success mr-2']")
    private WebElement buttonCreatePost;

    @FindBy(xpath = "//img") // локатор для кнопки My Profile
    private WebElement buttonMyProfile;

    @FindBy(xpath = " //*[@class='svg-inline--fa fa-comment fa-w-16']//*[@fill='currentColor']")
    private WebElement buttonChat;




    public Header(WebDriver webDriver) {
        super(webDriver);
    } // конструктор

    // Методи роботи з елементами хедера :

    // Методи перевірки присутності елементів на сторінці :

    public void checkIsButtonSignOutVisible() { // метод для перевірки чи кнопка Sign Out присутня на сторінці
        checkElementDisplayed(buttonSignOut);
    }

    public void checkIsButtonSearchVisible() { // метод для перевірки чи кнопка Search присутня на сторінці
        checkElementDisplayed(buttonSearch);
    }

    public void checkIsButtonCreatePostVisible() { // метод для перевірки чи кнопка Create Post присутня на сторінці
        checkElementDisplayed(buttonCreatePost);
    }

    public void checkIsButtonMyProfileVisible() { // метод для перевірки чи кнопка My Profile присутня на сторінці
        checkElementDisplayed(buttonMyProfile);
    }

    public void checkIsButtonChatVisible() { checkElementDisplayed(buttonChat);}



    //Методи перевірки відсутності елементів на сторінці :

    public void checkNotIsButtonSignOutVisible() { // метод для перевірки відсутності кнопки Sign Out на сторінці
        checkElementNotDisplayed(buttonSignOut);
    }

    public void checkNotIsButtonSearchVisible() { // метод для перевірки відсутності кнопки Search на сторінці
        checkElementNotDisplayed(buttonSearch);
    }

    public void checkNotIsButtonCreatePostVisible() { // метод для перевірки відсутності кнопки Create Post  на сторінці
        checkElementNotDisplayed(buttonCreatePost);
    }

    public void checkNotIsButtonMyProfileVisible() { // метод для перевірки відсутності кнопки My Profile на сторінці
        checkElementNotDisplayed(buttonMyProfile);
    }

    public void checkNotIsButtonChatVisible() { // метод для перевірки відсутності кнопки Chat на сторінці
        checkElementNotDisplayed(buttonChat);
    }

    public CreatePostPage clickOnButtonCreatePost(){ // метод для кліку по кнопці Create Post
        clickOnElement(buttonCreatePost);
        return new CreatePostPage(webDriver);//в результаті відкривається НОВА сторінка Create Post
    }

    public MyProfilePage clickOnMyProfileButton() {
        clickOnElement(buttonMyProfile);
        return new MyProfilePage(webDriver);

    }

    public boolean isButtonSignOutVisible() {
        return isElementDisplayed(buttonSignOut);
    }
}