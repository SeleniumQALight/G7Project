package postTests;

import baseTest.BaseTest;
import libs.Util;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class EditPost extends BaseTest {

    private String title = "TC01 - New Post Olesya" + Util.getDateAndTimeFormatted();
    private String body = "Body text Olesya Navrotska";
    private String editedTitle = "Edited TC01 - New Post Olesya" + Util.getDateAndTimeFormatted();

    @Test
    public void editPostTitle() {
        pageProvider.getMyProfilePage().clickOnPostWithTitle(title);

        pageProvider.getPostPage().checkIsRedirectToPostPage()
                .clickOnEditButton()
                .enterTextIntoInputTitle(editedTitle)
                .clickOnButtonSaveNewPost()
                .checkTextInSuccessMessage("Post successfully updated.").getHeader()
                .clickOnMyProfileButton()
                .checkIsRedirectToMyProfilePage().checkTitleOnMyProfilePage(editedTitle);

    }


    @Before
    public void createPost() {
        pageProvider.getHomePage().openHomePage()
                .checkIsRedirectToHomePage()
                .getHeader().clickOnButtonCreatePost()
                .checkIsRedirectToCreatePostPage()
                .enterTextIntoInputTitle(title)
                .enterTextIntoInputBody(body)
                .clickOnButtonSaveNewPost()

                .checkTextInSuccessMessage("New post successfully created.")
                .checkTitleOnPostPage(title)
                .checkBodyOnPostPage(body)
        ;

        pageProvider.getPostPage().getHeader()
                .clickOnMyProfileButton()
                .checkIsRedirectToMyProfilePage().checkIsPostWasAdded(title)
        ;
    }

    @After
    public void deletePosts() {
        pageProvider.getHomePage()
                .openHomePageAndLoginIfNeed()
                .getHeader().clickOnMyProfileButton()
                .checkIsRedirectToMyProfilePage()
                .deletePostsTillPresent(editedTitle)

        ;
    }
}