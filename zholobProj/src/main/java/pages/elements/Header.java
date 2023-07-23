package pages.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.ActionsWithElements;

public class Header extends ActionsWithElements { // клас для роботи з елементами хедера
    @FindBy(xpath = "//button[text() = 'Sign Out']")
    private WebElement buttonSignOut;

    @FindBy(xpath = "//button[text() = 'Sign In']")
    private WebElement buttonSignIn;

    @FindBy(xpath = "//a[@ class='text-white mr-2 header-search-icon']//*[@data-icon ='search']")
    private WebElement buttonSearch;

    @FindBy(xpath = "//a[@class='btn btn-sm btn-success mr-2']")
    private WebElement buttonCreatePost;

    @FindBy(xpath = "//img") //
    private WebElement buttonMyProfile;

    @FindBy(xpath = " //*[@class='svg-inline--fa fa-comment fa-w-16']//*[@fill='currentColor']")
    private WebElement buttonChat;

    @FindBy(xpath = "//input[@placeholder='Username']")
    private WebElement fieldLogin;

    @FindBy(xpath = "//input[@placeholder='Password']") //?
    private WebElement fieldPassword;


    public Header(WebDriver webDriver) {
        super(webDriver);
    } // конструктор

    // Методи присутності елементів на сторінці :

    public void checkIsButtonSignOutVisible() { // метод для перевірки чи кнопка Sign Out присутня на сторінці
        checkElementDisplayed(buttonSignOut);
    }

    public void checkIsButtonSignInVisible() { // метод для перевірки чи кнопка Sign In присутня на сторінці
        checkElementDisplayed(buttonSignIn);
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

    public void checkIsFieldLoginVisible() { checkElementDisplayed(fieldLogin);}

    public void checkIsFieldPasswordVisible() { checkElementDisplayed(fieldPassword);}




    //Методи перевірки відсутності елементів на сторінці :

    public void checkNotIsButtonSignOutVisible() { // метод для перевірки відсутності кнопки Sign Out на сторінці
        checkElementNotDisplayed(buttonSignOut);
    }
    public void checkNotIsButtonSignInVisible() { // метод для перевірки відсутності кнопки Sign In на сторінці
        checkElementNotDisplayed(buttonSignIn);
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

    public void checkNotIsFieldLoginVisible() { // метод для перевірки відсутності поля Login на сторінці
        checkElementNotDisplayed(fieldLogin);
    }

    public void checkNotIsFieldPasswordVisible() { // метод для перевірки відсутності поля Password на сторінці
        checkElementNotDisplayed(fieldPassword);
    }

}