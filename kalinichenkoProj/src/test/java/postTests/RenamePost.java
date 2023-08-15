package postTests;

import baseTest.BaseTest;
import libs.Util;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RenamePost extends BaseTest {

    private String title = "TC002 - Kalinichenko" + Util.getDateAndTimeFormatted();
    private String newTitle = title + " - RENAMED";


    @Before
    public void createPost() {
        pageProvider.getHomePage()
                .openHomePage()
                .getHeader().clickOnButtonCreatePost()
                .checkIsRedirectToCreatePostPage()
                .enterTextIntoInputTitle(title)
                .enterTextIntoInputBody("Body of Post");
        pageProvider.getCreatePostPage().clickOnButtonSaveNewPost()
                .checkTextInSuccessMessage("New post successfully created.");
        pageProvider.getPostPage()
                .checkIsRedirectToPostPage()
                .checkTextInTitle(title);
        pageProvider.getHomePage()
                .getHeader()
                .clickOnMyProfileButton()
                .checkIsRedirectToMyProfilePage()
                .checkIsPostWithTitlePresent(title);
    }

    @Test
    public void renamePost() {
        pageProvider.getHomePage()
                .getHeader()
                .clickOnMyProfileButton()
                .checkIsRedirectToMyProfilePage()
                .clickOnLocator(title);
        pageProvider.getPostPage()
                .checkIsRedirectToPostPage()
                .clickOnEditPostButton();
        pageProvider.getEditPostPage()
                .checkIsRedirectToEditPostPage()
                .enterTextIntoInputTitle(newTitle);
        pageProvider.getEditPostPage().clickOnButtonSaveUpdates();
        pageProvider.getEditPostPage().isPostUpdatedDisplayed();

        pageProvider.getPostPage()
                .getHeader()
                .clickOnMyProfileButton()
                .checkIsRedirectToMyProfilePage()
                .checkIsPostWithTitlePresent(newTitle)
                .clickOnLocator(newTitle);
        pageProvider.getPostPage()
                .checkIsRedirectToPostPage()
                .checkTextInTitle(newTitle)
                .checkTextInBody("Body of Post")
        ;


    }

    @After
    public void deletePosts() {
        pageProvider.getHomePage()
                .openHomePageAndLoginIfNeeded()
                .getHeader()
                .clickOnMyProfileButton()
                .checkIsRedirectToMyProfilePage()
                .deletePostsTillPresent(title)
                .deletePostsTillPresent(newTitle)
        ;
    }

}
