package loginTests;

import org.junit.Test;

import static data.TestData.LOGIN_DEFAULT;
import static data.TestData.PASSWORD_DEFAULT;

public class SignOutTest extends baseTest.BaseTest {
    @Test
    /**
     * Написати тест на Sign Out
     * + Залогінитися.
     * + Після логіну перевірити наявність елементів в Хедері:
     *      + кнопки пошуку,
     *      + кнопки виклику чатику,
     *      + аватарки,
     *      + кнопки CreatePost ,
     *      + кнопки signOut,
     *      а також відсутності:
     *      + поля для вводу логіна,
     *      + поля для вводу пароля,
     *      + кнопки sign In.
     *      (Для перевірки відсутності елементів додати відповідний метод в ActionsWithElements)
     * + Зробити log Out і перевірити відсутність  елементів в Хедері:
     *      + кнопки пошуку,
     *      + кнопки виклику чатику,
     *      + аватарки,
     *      + кнопки CreatePost,
     *      + кнопки signOut,
     *      а також наявність:
     *      + поля для вводу логіна,
     *      + поля для вводу пароля,
     *      + кнопки sign In.
     */
    public void validSignOut() {
        //SigningIn
        pageProvider.getLoginPage().openLoginPage();
        pageProvider.getLoginPage().enterUserName(LOGIN_DEFAULT);
        pageProvider.getLoginPage().enterPassword(PASSWORD_DEFAULT);
        pageProvider.getLoginPage().clickOnButtonSignIn();

        //Checking the availability of elements in Header (after signing in)
        pageProvider.getHomePage().getHeader().checkIsButtonSearchVisible();
        pageProvider.getHomePage().getHeader().checkIsButtonChatVisible();
        pageProvider.getHomePage().getHeader().checkIsButtonAvatarVisible();
        pageProvider.getHomePage().getHeader().checkIsButtonCreatePostVisible();
        pageProvider.getHomePage().getHeader().checkIsButtonSignOutVisible();

        //Checking for missing elements in Header (after signing in)
        pageProvider.getLoginPage().checkIsInputUserNameNotVisible();
        pageProvider.getLoginPage().checkIsInputPasswordNotVisible();
        pageProvider.getLoginPage().checkIsButtonSignInNotVisible();

        //LoggingOut
        pageProvider.getHomePage().getHeader().clickOnButtonSignOut();

        //Checking for missing elements in Header (after signing out)
        pageProvider.getHomePage().getHeader().checkIsButtonSearchNotVisible();
        pageProvider.getHomePage().getHeader().checkIsButtonChatNotVisible();
        pageProvider.getHomePage().getHeader().checkIsButtonAvatarNotVisible();
        pageProvider.getHomePage().getHeader().checkIsButtonCreatePostNotVisible();
        pageProvider.getHomePage().getHeader().checkIsButtonSignOutNotVisible();

        //Checking the availability of elements in Header (after signing out)
        pageProvider.getLoginPage().checkIsInputUserNameVisible();
        pageProvider.getLoginPage().checkIsInputPasswordVisible();
        pageProvider.getLoginPage().checkIsButtonSignInVisible();

    }

}
