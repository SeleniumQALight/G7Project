package postTests;

import libs.Util;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pages.PageProvider;


public class EditPostTitleTest extends baseTest.BaseTest {

    private String initialTitle;
    private String newTitle;
    private String body;

    @Before
    public void prepareTestData() {
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
        newTitle = "Edited Post Title " + Util.getDateAndTimeFormatted();
        pageProvider.getHomePage()
                .getHeader().clickOnMyProfileButton()
                .checkIsRedirectToMyProfilePage();
        pageProvider.getMyProfilePage().clickOnPostByTitle(initialTitle);
        pageProvider.getPostPage().clickOnButtonEdit();
        pageProvider.getEditPostPage().isButtonViewPostDisplayed();
        pageProvider.getPostPage()
                .enterTextIntoInputTitle(newTitle);
        pageProvider.getEditPostPage().isButtonUpdatePostDisplayed()
                .clickOnButtonSaveUpdatedPost();

        pageProvider.getPostPage().checkTextInSuccessMessage("Post successfully updated.");

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