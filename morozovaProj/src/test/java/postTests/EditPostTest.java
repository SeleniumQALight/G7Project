package postTests;

import baseTest.BaseTest;
import libs.Util;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class EditPostTest extends BaseTest {
    private String title = "TC01 - New Post Maryna " + Util.getDateAndTimeFormatted();
    private String body = "Body of Post Maryna";
    private String titleEdit = "TC01 - New Post Maryna" + Util.getDateAndTimeFormatted() + " edit1";

    @Before
    public void CreateNewPost() {
        CreatePost createPost = new CreatePost();
        createPost.createNewPost();
    }

    @Test // редагування поста
    public void editPost() {
        pageProvider.getPostPage()
                .getHeader().clickOnMyProfileButton()// перехід на сторінку профайлу
                .checkIsRedirectToMyProfilePage()// перевірка чи ми на сторінці профайлу
                .checkPostWithTitleIsPresent(title) // перевірка чи є пост з таким заголовком(що він 1 елемент)
                .clickOnPostWithTitle(title); // на пост з заголовком
        pageProvider.getPostPage().checkIsRedirectToPostPage() // перевірка чи ми на сторінці поста
                .clickOnEditPostButton(); // на кнопку редагування поста
        pageProvider.getPostEditPage().enterTextIntoInputTitle(titleEdit)// редагуємо Title
                .clickOnButtonSaveUpdates() // на кнопку збереження поста
                .checkIsMessageSuccessEditPost();// перевірка чи успішне редагування
    }

    @After
    public void deletePosts() {

        pageProvider.getHomePage().openHomePageAndLoginIfNeeded().getHeader()
                .clickOnMyProfileButton().checkIsRedirectToMyProfilePage().deletePostsTillPresent(title)
                .deletePostsTillPresent(titleEdit) // видалення постів
        ;
    }
}

