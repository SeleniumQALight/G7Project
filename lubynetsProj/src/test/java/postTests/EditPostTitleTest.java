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
        postPage = new PostPage(webDriver);
        EditPostPage = new EditPostPage(webDriver);

        newTitle = "Edited Post Title " + Util.getDateAndTimeFormatted();
        pageProvider.getHomePage()
                .getHeader().clickOnMyProfileButton()
                .checkIsRedirectToMyProfilePage();

        postPage.clickOnPostByTitle(initialTitle);
        EditPostPage.clickOnButtonEdit()
                .isButtonViewPostDisplayed()
                .isButtonUpdatePostDisplayed();
        postPage.enterTextIntoInputTitle(newTitle);
        EditPostPage.clickOnButtonSaveUpdatedPost();
        postPage.checkTextInSuccessMessage("Post successfully updated.");


        pageProvider.getPostPage()
                .getHeader().clickOnMyProfileButton()
                .checkIsRedirectToMyProfilePage();

        pageProvider.getMyProfilePage().checkPostWithTitleIsPresent(newTitle)
                .checkPostWithTitleNotPresent(initialTitle)
                .isOnlyOnePostWithTitlePresent(newTitle);


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