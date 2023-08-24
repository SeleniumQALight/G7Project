package postTests;

import baseTest.BaseTest;
import libs.DB_Util_seleniumUsers;
import libs.SpreadsheetData;
import libs.Util;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;

import static libs.ConfigProvider.configProperties;

/*ДЗ#7
написати тест на створення поста (створивши новий класс) у якому :
- залогінитися юзером newqaauto ,
пароль для якого витягнути з таблиці seleniumUsers
(створивши клас для цієї таблиці(в назву класу додайте назву таблиці),
аналогічний DB_Util , і відповідний метод для отримання паролю)
- данні для Title, body, чекбокса і дропдауна витягнути з testData.xls,
створивши в ньому відповідний аркуш і додавши тестові данні (title повинен бути кожного разу унікальним)
*/
@RunWith(Parameterized.class)//тест буде брати дані з ексель, скільки раз скільки рядків

public class CreatePostWithExcel extends BaseTest {
    //данні для Title, body, чекбокса і дропдауна витягнути з testData.xls,
    String title;
    String body;
    String checkBoxValue;
    String dropdownValue;

    public CreatePostWithExcel(String title, String body, String checkBoxValue, String dropdownValue) { // конструктор
        this.title = title + Util.getDateAndTimeFormatted();//title повинен бути кожного разу унікальним
        this.body = body;
        this.checkBoxValue = checkBoxValue;
        this.dropdownValue = dropdownValue;
    }

    @Parameterized.Parameters
    //створивши в ньому відповідний аркуш і додавши тестові данні
    public static Collection testData() throws IOException {// метод який повертає колекцію з даними
        FileInputStream inputStream = new FileInputStream( // створюємо конекшен до файлу з даними
                configProperties.DATA_FILE_PATH() + "testData.xls");//
        return new SpreadsheetData(inputStream, "CreatePostWithDB").getData(); // створюємо колекцію з даними з екселю, вказуючи на вхід конекшен до файлу і назву листа
    }

    @Before
    public void validLogin() throws SQLException, ClassNotFoundException {//
        pageProvider.getLoginPage().openLoginPage();
        pageProvider.getLoginPage().enterTextIntoInputUserName("newqaauto");//"qaauto"

        DB_Util_seleniumUsers db_util_seleniumUsers = new DB_Util_seleniumUsers();//достаємо пароль за логіном

        pageProvider.getLoginPage().enterTextIntoInputPassword(
                db_util_seleniumUsers.getPassForLogin("newqaauto")); // пароль з БД//"123456qwerty"//PASS

        pageProvider.getLoginPage().clickOnButtonSignIn();// клік на SignIn
        pageProvider.getHomePage().getHeader().checkIsButtonSignOutVisible(); // перевірка чи є SignOut
    }

    @Test
    public void createNewPostWithExel() {
        pageProvider.getHomePage()
                .getHeader().clickOnButtonCreatePost() // клік CreatePost
                .checkIsRedirectToCreatePostPage() //певірка чи ми на CreatePost
                .enterTextIntoInputTitle(title)
                .enterTextIntoInputBody(body)
                //  .selectTextInDropDown("Групове повідомлення")
                .selectTextInDropDown2(dropdownValue)
                //     .selectValueInDropDown("One Person")
                .markCheckboxStateUnique(checkBoxValue) // вибираємо чекбокс
                .clickOnButtonSaveNewPost()
                .checkTextInSuccessMessage("New post successfully created.");
//                        .checkTextInThisPostWasWritten("Note: This post was written for One Person")
//                 .checkTextInThisPostWasWritten("Note: This post was written for Group Message")
//                         .checkIsPostUnique("Is this post unique? : no")
//                .checkIsPostUnique("Is this post unique? : yes");

//перевірка створеного поста в профайлі:
        pageProvider.getPostPage().getHeader().clickOnMyProfileButton()//
                .checkIsRedirectToMyProfilePage().checkPostWithTitleIsPresent(title);

    }

    @After
    public void deletePosts() {
        pageProvider.getHomePage().openHomePageAndLoginIfNeeded().getHeader()
                .clickOnMyProfileButton().checkIsRedirectToMyProfilePage().deletePostsTillPresent(title);
    }
}
