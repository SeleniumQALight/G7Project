package postTests;

import libs.Util;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class EditPost extends baseTest.BaseTest {
    private String postTitle = "TC 000 Klets new post for edit" + Util.getDateAndTimeFormatted();
    private String body = "New Post Body Klets for edit";
    private String option = "All Users";
    private String TextInSuccessMessage = "New post successfully created.";
    private String TextInSuccessMessageEditPost = "Post successfully updated.";

    private String editPostTitle = "TC 000 Klets new edited title" + Util.getDateAndTimeFormatted();

    @Before
    public void createNewPost() {
        pageProvider.getHomePage().openHomePage().checkIsRedirectToHomePage()
                .getHeader().clickOnButtonCreatePost()
                .checkIsRedirectToCreatePostPage()
                .enterTextIntoInputTitle(postTitle)
                .enterTextIntoInputBody(body)
                .markCheckBoxUniquePost("check")
                .selectTextDropDownByUI("Загальнодоступне")
                .clickOnButtonSaveNewPost()
                .checkTextInSuccessMessage(TextInSuccessMessage)
                .checkIsRedirectToPostPage()
                .checkTextInTitle(postTitle)
                .checkTextInBody(body)
                .checkTextInPrivate(option)
                .checkTextInUnique("Is this post unique? : yes")
        ;

        pageProvider.getPostPage().getHeader().clickOnMyProfileButton()
                .checkIsRedirectToMyProfilePage()
                .checkPostWithTitleIsPresent(postTitle);
    }

    @Test
    public void editPost() {
        pageProvider.getPostPage().getHeader().clickOnMyProfileButton()
                .checkIsRedirectToMyProfilePage()
                .checkPostWithTitleIsPresent(postTitle)
                .selectPostByTitle(postTitle)
                .clickOnEditPostButton()
                .checkIsRedirectToEditPostPage()
                .checkIsBackButtonDisplayed()
                .enterTextInToInputTitle(editPostTitle)
                .clickOnButtonSaveUpdates()
                .checkTextInSuccessMessageEditPost(TextInSuccessMessageEditPost)
                .getHeader()
                .clickOnMyProfileButton()
                .checkIsRedirectToMyProfilePage()
                .checkPostWithTitleIsPresent(editPostTitle)
        ;
    }

    @After
    public void deletePosts() {
        pageProvider.getHomePage()
                .openHomePageAndLoginIfNeeded()
                .getHeader().clickOnMyProfileButton()
                .checkIsRedirectToMyProfilePage()
                .deletePostsTillPresent(editPostTitle)
        ;
    }

}
