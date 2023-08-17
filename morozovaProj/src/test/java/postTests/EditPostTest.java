//ДЗ №6
//        Написати тест на зміну тайтла поста.
//        Тест повинен підготувати собі данні, змінити тайтл поста, перевірити що бачимо зелене повідомлення про зміну, потім перейти в профайл пейдж і в списку постів перевірити що є змінений пост і він один, і в афтері почистити за собою
//
//        Уточнення по домашці:
//        - Готуєм данні в Before - тобто створюємо потрібний пост і впевнюємося в профайл пейджі що він створився.
//        - Відповідно в тесті потім шукаєм пост в списку і натиснувши на ньому потрапляємо на сторінку поста , а потім вже натискаємо кнопку едіт
//        - After - видаляти змінений пост, або якщо тайт не змінився то видаляти не змінений пост (просто двічи викликати метод видалення просто з різними тайтлами)

package postTests;

import baseTest.BaseTest;
import libs.Util;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class EditPostTest extends BaseTest {
    private String title = "TC01 - New Post Maryna " + Util.getDateAndTimeFormatted();
    private String body = "Body of Post Maryna";
    private String titleEdit = "TC01 - New Post Maryna " + Util.getDateAndTimeFormatted() + " edit1";

//    Готуєм данні в Before - тобто створюємо потрібний пост і впевнюємося в профайл пейджі що він створився.
    @Before
    public void CreateNewPost() {
//        CreatePost createPost = new CreatePost();
//        createPost.createNewPost();
        pageProvider.getHomePage().openHomePage().checkIsRedirectToHomePage()
                .getHeader().clickOnButtonCreatePost().checkIsRedirectToCreatePostPage()
                .enterTextIntoInputTitle(title).enterTextIntoInputBody("Body of new Post Maryna")
             //   .selectTextInDropDown("Групове повідомлення")
                .selectTextInDropDown2("Приватне повідомлення")
                //     .selectOnCheckBoxIs("check") // вибираємо чекбокс
                .markCheckboxStateUnique("check")
                //     .selectValueInDropDown("One Person")
                .clickOnButtonSaveNewPost().checkTextInSuccessMessage("New post successfully created.")
                .checkTextInThisPostWasWritten("Note: This post was written for One Person")
                // .checkTextInThisPostWasWritten("Note: This post was written for Group Message")
                //         .checkIsPostUnique("Is this post unique? : no")
                .checkIsPostUnique("Is this post unique? : yes");
//перевірка створеного поста в профайлі:
        pageProvider.getPostPage().getHeader().clickOnMyProfileButton().checkIsRedirectToMyProfilePage().checkPostWithTitleIsPresent(title);
    }

    @Test // редагування поста
    public void editPost() {
        pageProvider.getHomePage().openHomePageAndLoginIfNeeded().getHeader()
                .clickOnMyProfileButton().checkIsRedirectToMyProfilePage().clickOnPostWithTitle(title); // на пост з заголовком
        pageProvider.getPostPage().checkIsRedirectToPostPage() // перевірка чи ми на сторінці поста
                .clickOnEditPostButton(); // на кнопку редагування поста
        pageProvider.getPostEditPage().checkIsRedirectToEditPostPage();//перевірка ура редагування посту
        pageProvider.getPostEditPage().enterTextIntoInputTitle(titleEdit)// редагуємо Title
                        .clickOnButtonSaveUpdates() // на кнопку збереження поста
                .checkIsMessageSuccessEditPost();// перевірка чи успішне редагування
        pageProvider.getHomePage().openHomePageAndLoginIfNeeded().getHeader()
                .clickOnMyProfileButton().checkPostWithTitleIsPresent(titleEdit);//повернулась на myProfile, для перевірки нового тайта
    }
//    After - видаляти змінений пост, або якщо тайт не змінився то видаляти не змінений пост (просто двічи викликати метод видалення просто з різними тайтлами)
    @After
    public void deletePosts() {
        pageProvider.getHomePage().openHomePageAndLoginIfNeeded().getHeader()
                .clickOnMyProfileButton().checkIsRedirectToMyProfilePage().deletePostsTillPresent(title)
                .deletePostsTillPresent(titleEdit) // видалення постів
        ;
    }
}

