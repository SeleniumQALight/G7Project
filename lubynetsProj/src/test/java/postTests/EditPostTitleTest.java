package postTests;

import libs.Util;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pages.PageProvider;
import pages.PostPage;

public class EditPostTitleTest extends baseTest.BaseTest {

    private String initialTitle;
    private String newTitle;
    private String body;
    private PostPage postPage;


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

        newTitle = "Edited Post Title " + Util.getDateAndTimeFormatted();
        pageProvider.getHomePage()
                .getHeader().clickOnMyProfileButton()
                .checkIsRedirectToMyProfilePage();

        postPage.findAndClickOnPostByTitle(initialTitle)
                .clickOnButtonEdit()
                .isButtonViewPostDisplayed()
                .isButtonUpdatePostDisplayed()
                .enterTextIntoInputTitle(newTitle)
                .clickOnButtonSaveUpdatedPost()
                .checkTextInSuccessMessage("Post successfully updated.");


        pageProvider.getPostPage()
                .getHeader().clickOnMyProfileButton()
                .checkIsRedirectToMyProfilePage();

        postPage.assertPostWithTitleIsPresent(newTitle)
                .assertOnlyOnePostWithTitlePresent(newTitle)
                .assertPostWithTitlesIsNotPresent(initialTitle);

    }
    @After
    public void deleteEditedPost() {
        pageProvider.getHomePage()
                .openHomePageAndLoginIfNeeded()
                .getHeader().clickOnMyProfileButton()
                .checkIsRedirectToMyProfilePage();
        postPage.deletePostByTitle(newTitle);
        postPage.deletePostByTitle(initialTitle);
    }
}