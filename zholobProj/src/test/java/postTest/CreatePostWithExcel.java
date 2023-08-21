package postTest;


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

/*
ДЗ#7
написати тест на створення поста (створивши новий класс) у якому :
- залогінитися юзером newqaauto , пароль для якого витягнути з таблиці seleniumUsers (створивши клас для цієї таблиці
(в назву класу додайте назву таблиці), аналогічний DB_Util , і відповідний метод для отримання паролю)
- данні для Title, body, чекбокса і дропдауна витягнути з testData.xls, створивши в ньому відповідний аркуш і додавши
тестові данні (title повинен бути кожного разу унікальним)
 */

@RunWith(Parameterized.class)
// тест буде запускатись кылька раз з різними параметрами що будуть взяті з екселю( один рядок - один запуск тесту)

public class CreatePostWithExcel extends BaseTest { //
    String title;
    String body;
    String dropdownValue;
    String checkBoxValue;

    public CreatePostWithExcel(String title, String body, String dropdownValue, String checkBoxValue) { // конструктор
        this.title = title + Util.getDateAndTimeFormatted();
        this.body = body;
        this.dropdownValue = dropdownValue;
        this.checkBoxValue = checkBoxValue;
    }

    @Parameterized.Parameters
    public static Collection testData1() throws IOException {// метод який повертає колекцію з даними
        FileInputStream inputStream = new FileInputStream( // створюємо конекшен до файлу з даними
                configProperties.DATA_FILE_PATH() + "testDataSuit.xls");//
        return new SpreadsheetData(inputStream, "CreatePostWithExcel").getData(); // створюємо колекцію з даними з екселю, вказуючи на вхід конекшен до файлу і назву листа
    }

    @Before
    public void validLogin() throws SQLException, ClassNotFoundException {//
        pageProvider.getloginPage().openLoginPage();
        pageProvider.getloginPage().enterTextIntoInputUserNane("newqaauto");

        DB_Util_seleniumUsers db_util_seleniumUsers = new DB_Util_seleniumUsers();

        pageProvider.getloginPage().enterTextIntoInputPassword(
             db_util_seleniumUsers.getPassForLogin("newqaauto")); // вводимо пароль з БД

        pageProvider.getloginPage().clickOnButtonSignIn();// клік на кнопку Sign In
        pageProvider.getHomePage().getHeader().checkIsButtonSignOutVisible(); // перевірка чи є кнопка SignOut
    }


    @Test
    public void createNewPostWithExel() {

        pageProvider.getHomePage()
                .getHeader().clickOnButtonCreatePost() // клік на кнопку CreatePost
                .checkIsRedirectToCreatePostPage() //певірка чи ми на сторінці CreatePost
                .enterTextIntoInputTitle(title)// вводимо текст в поле Title
                .enterTextIntoInputBody(body) //
                .selectTextInDropDown2(dropdownValue) // вибираємо значення з дропдауну по тексту
                .selectOnCheckBoxIs(checkBoxValue) // вибираємо чекбокс
                .clickOnButtonSaveNewPost()// клік на кнопку SaveNewPost
                .checkTextInSuccessMessage("New post successfully created."); // перевірка


        // перевіряє повідомлення в профайлі
        pageProvider.getPostPage().getHeader().clickOnMyProfileButton()//
                .checkIsRedirectToMyProfilePage()// перевірка чи ми на сторінці профайлу
                .checkpostWithTitleIsPresent(title); // перевырка  чи є пост з таким заголовкомж

    }

    @After
    public void deletePosts() {
        pageProvider.getHomePage().openHomePageAndLoginifNeeded() //
                .openHomePageAndLoginifNeeded() // перевірка чи ми залогінені
                .getHeader().clickOnMyProfileButton()// клік на кнопку MyProfile
                .checkIsRedirectToMyProfilePage()// перевірка чи ми на сторінці профайлу
                .deletePostsTillPresent(title)// видалення постів з таким заголовком
        ;
    }

}

