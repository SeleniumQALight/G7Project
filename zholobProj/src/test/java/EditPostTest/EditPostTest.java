package EditPostTest;

import baseTest.BaseTest;
import libs.Util;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class EditPostTest extends BaseTest {
    private String title = "TC01 - New Post Inna" + Util.getDateAndTimeFormatted();
    private String body = "Body of Post Inna";
    private String title_edit = "TC01 - New Post Inna" + Util.getDateAndTimeFormatted() + "edit_22222222222";

    @Before

    public void createNewPost() {

        pageProvider.getHomePage()
                .openHomePage().checkIsRedirectToHomePage() //певірка чи ми на дошній сторінці
                .getHeader().clickOnButtonCreatePost() // клік на кнопку CreatePost
                .checkIsRedirectToCreatePostPage() //певірка чи ми на сторінці CreatePost
                .enterTextIntoInputTitle(title)// вводимо текст в поле Title
                .enterTextIntoInputBody(body)
                .selectTextInDropDown2("Приватне повідомлення") // вибираємо значення з дропдауну по тексту
                .selectOnCheckBoxIs("check") // вибираємо чекбокс
                //.selectValueInDropDown("One Person")//
                .clickOnButtonSaveNewPost()
                .checkTextInSuccessMessage("New post successfully created."); // перевірка чи  повідомлення выдповідає тексту в елементі

    }

    @Test // редагування поста
    public void editPost() {
        pageProvider.getPostPage()
                .getHeader().clickOnMyProfileButton()// перехід на сторінку профайлу
                .checkIsRedirectToMyProfilePage()// перевірка чи ми на сторінці профайлу
                .checkpostWithTitleIsPresent(title) // перевырка  чи є пост з таким заголовком і він один
                .clickOnPostWithTitle(title); // клік на пост з заголовком
        pageProvider.getPostPage().checkIsRedirectToPostPage() // перевірка чи ми на сторінці поста
                .clickOnEditPostButton(); // клік на кнопку редагування поста
        pageProvider.getPostEditPage().checkIsRedirectToPostEditPage();
        pageProvider.getPostEditPage().enterTextIntoInputTitle(title_edit)// вводимо новий текст в поле Title
                .clickOnButtonSaveUpdates() // клік на кнопку збереження поста
                .checkIsMessageSuccessfullyEditPost() // перевірка чи  є повідомлення про успішне редагування

        ;
    }

    @After
    public void deletePosts() {
        pageProvider.getHomePage().openHomePageAndLoginifNeeded()
                .openHomePageAndLoginifNeeded()
                .getHeader().clickOnMyProfileButton()
                .checkIsRedirectToMyProfilePage() // перевірка чи ми на сторінці профайлу
                .deletePostsTillPresent(title) // видалення постів з таким заголовком
                .deletePostsTillPresent(title_edit) // видалення постів з таким заголовком
        ;
    }

}