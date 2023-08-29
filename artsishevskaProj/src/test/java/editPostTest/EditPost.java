package editPostTest;

import baseTest.BaseTest;
import libs.Util;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class EditPost extends BaseTest {
    private String title = "TC01 - New Post MArt" + Util.getDateAndTimeFormatted();
    private String body = "Body of new Post MArt" + Util.getDateAndTimeFormatted() + " edited";
    private String titleEdited = title + " edited";
    @Before
    public void createNewPost(){
        pageProvider.getHomePage()
                .openHomePage().checkIsRedirectToHomePage()
                .getHeader().clickOnButtonCreatePost()
                .checkIsRedirectToCreatePostPage()
                .enterTextIntoInputTitle(title)
                .enterTextIntoInputBody("Body of new Post MArt")
                .setCheckBoxUniquePost("check")
                .selectTextInDropDown("Приватне повідомлення")
                .clickOnButtonSaveNewPost()
                .checkTextInSuccessMessage("New post successfully created.")

        ;

        pageProvider.getPostPage().getHeader().clickOnMyProfileButton()
                .checkIsRedirectToMyProfilePage()
                .checkPostWithTitleIsPresent(title)

        ;
    }

    @Test
    public void editPostTitle() {
        pageProvider.getPostPage()
                .getHeader().clickOnMyProfileButton()
                .checkIsRedirectToMyProfilePage()
                .checkPostWithTitleIsPresent(title)
                .clickOnPostWithTitle(title)
                .checkIsRedirectToPostPage()
                .clickOnEditPostButton();
                pageProvider.getPostEditPage()
                .enterTextIntoInputTitle(titleEdited)
                .clickOnButtonSaveUpdatePost();
                pageProvider.getPostEditPage().checkIsMessageSuccessfullyEditPost();

    }


    @After
    public void deletePosts(){
        pageProvider.getHomePage()
                .openHomePageAndLoginIfNeeded()
                .getHeader().clickOnMyProfileButton()
                .checkIsRedirectToMyProfilePage()
                .deletePostsTillPresent(title)
                .deletePostsTillPresent(title + " edited");
        ;
    }
}