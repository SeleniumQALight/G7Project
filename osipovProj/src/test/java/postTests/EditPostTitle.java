package postTests;

import baseTest.BaseTest;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class EditPostTitle extends BaseTest {
    String postTitle;

    @Before
    public void createAndCheckPost() {
        postTitle = pageProvider.getLoginPage().createValidPostAndCheckIfExist();
    }

    @Test
    public void searchAndEditTitle() {
        pageProvider.getHomePage()
                .getHeader()
                .clickOnMyProfileButton()
                .checkIsRedirectToMyProfilePage()
                .clickOnPostFromTheList(postTitle)
                .checkIsRedirectToPostPage()
                .clickOnEditButton()
                .checkIsRedirectToEditPostPage()
                .editPostTitle(postTitle + "test")
                .saveEditPostChanges()
                .getHeader()
                .clickOnMyProfileButton()
                .checkIsRedirectToMyProfilePage()
                .checkPostWithTitleIsPresent(postTitle + "test");
    }

    @After
    public void deletePost() {
        pageProvider.getHomePage()
                .openHomePageAndLoginIfNeeded()
                .getHeader().clickOnMyProfileButton()
                .checkIsRedirectToMyProfilePage()
                .deletePostWithTitle(postTitle).deletePostWithTitle(postTitle + "test");
    }
}
