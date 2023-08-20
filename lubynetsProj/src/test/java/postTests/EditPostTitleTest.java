package postTests;

import libs.Util;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pages.EditPostPage;
import pages.PageProvider;
import pages.PostPage;

public class EditPostTitleTest extends baseTest.BaseTest {

    private String initialTitle;
    private String newTitle;
    private String body;
    private PostPage postPage;
    private EditPostPage EditPostPage;


    @Before
    public void prepareTestData() {
        pageProvider = new PageProvider(webDriver);
        initialTitle = "HW6 - New post Lubynets " + Util.getDateAndTimeFormatted();
        body = "Body text";
        postPage = pageProvider.getPostPage();
        EditPostPage = pageProvider.getEditPostPage();
        pageProvider.getHomePage()
                .openHomePageAndLoginIfNeeded()
                .getHeader().clickOnButtonCreatePost()
                .CheckIsRedirectOnCreatePostPage()
                .enterTextIntoInputTitle(initialTitle)
                .enterTextIntoInputBody(body)
                .selectTextInDropDown("Приватне повідомлення")
                .setCheckboxState("check")
                .clickOnButtonSavePost()
                .checkTextInSuccessMessage("New post successfully created.");
    }

    @Test
    public void editPostTitle() {

        newTitle = "Edited Post Title " + Util.getDateAndTimeFormatted();
        pageProvider.getHomePage()
                .getHeader().clickOnMyProfileButton()
                .checkIsRedirectToMyProfilePage();

        pageProvider.getMyProfilePage().clickOnPostByTitle(initialTitle);
        EditPostPage.clickOnButtonEdit()
                .isButtonViewPostDisplayed();
        postPage.isButtonUpdatePostDisplayed()
                .enterTextIntoInputTitle(newTitle)
                .clickOnButtonSaveUpdatedPost()
                .checkTextInSuccessMessage("Post successfully updated.");


        pageProvider.getPostPage()
                .getHeader().clickOnMyProfileButton()
                .checkIsRedirectToMyProfilePage()
                .checkPostWithTitleIsPresent(newTitle)
                .checkPostWithTitleNotPresent(initialTitle);


    }
    @After
    public void deleteEditedPost() {
        pageProvider.getHomePage()
                .openHomePageAndLoginIfNeeded()
                .getHeader().clickOnMyProfileButton()
                .checkIsRedirectToMyProfilePage()
                .deletePostTillPresent(initialTitle)
                .deletePostTillPresent(newTitle);
    }
}