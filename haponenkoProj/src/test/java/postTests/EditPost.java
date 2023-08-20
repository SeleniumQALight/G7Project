package postTests;

import baseTest.BaseTest;
import libs.Util;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class EditPost extends BaseTest {
    private String title = "New Iryna Post for edit " + Util.getDateAndTimeFormatted();
    private String editedTitle = "Edited Iryna Post for edit " + Util.getDateAndTimeFormatted();
    @Before
    public void createNewPost() {
        pageProvider.getHomePage()
                .openHomePage()
                .checkIsRedirectToHomePage()
                .getHeader()
                .clickOnButtonCreatePost()
                .checkIsRedirectToCreatePostPage()
                .enterTextIntoInputTitle(title)
                .enterTextIntoInputBody("Body of the New Post Iryna one person unique")
                .selectValueInDropDown("One Person")
                .markCheckboxUniqueYes()
                .clickOnButtonSaveNewPost()
                .checkTextInSuccessMessage("New post successfully created.")
                .checkIsRedirectToPostPage();
        pageProvider.getPostPage().getHeader().clickOnMyProfileButton()
                .checkIsRedirectToMyProfilePage()
                .checkPostWithTitleIsPresent(title);
    }

    @Test
            public void editPost(){
            pageProvider.getMyProfilePage()
                    .selectPostByTitle(title)
                    .checkIsRedirectToPostPage()
                    .clickOnEditPostButton()
                    .checkIsRedirectToEditPostPage()
                    .checkIsBackButtonDisplayed()
                    .enterTextIntoInputTitle(editedTitle)
                    .clickOnButtonSaveEditedPost()
                    .checkIsRedirectToEditPostPage()
                    .checkTextInSuccessMessage("Post successfully updated.")
                    .getHeader().clickOnMyProfileButton()
                    .checkIsRedirectToMyProfilePage()
                    .checkPostWithTitleIsPresent(editedTitle)
                    ;
    }

    @After
    public void deletePosts(){
        pageProvider.getHomePage()
                .openHomePageAndLoginIfNeeded()
                .getHeader().clickOnMyProfileButton()
                .checkIsRedirectToMyProfilePage()
                .deletePostsTillPresent(editedTitle)
        ;
    }
}
