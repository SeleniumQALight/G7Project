package postTests;

import baseTest.BaseTest;
import libs.Util;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class UpdatePost extends BaseTest {
    private String title = "TC01 - New Post Kropivtseva " + Util.getDateAndTimeFormatted();
    private String update = "update" + Util.getDateAndTimeFormatted();

    @Before
    public void createPost() {
        pageProvider.getHomePage()
                .openHomePage()
                .checkIsRedirectToHomePage()
                .getHeader()
                .clickOnButtonCreatePost()
                .checkIsRedirectToCreatePostPage()
                .enterTextIntoInputTitle(title)
                .enterTextIntoInputBody("Body of new post")
                .workWithCheckBox()
                .checkOrUncheckCheckBoxDependingOnText("check")
                .selectTextInDropDownByUI()
                .clickOnButtonSaveNewPost()
                .checkIsSuccessMessageDisplayed()
                .checkTextInSuccessMessage("New post successfully created.")
                .checkIsPostBodyDisplayed("Body of new post")
                .checkIsPostTitleDisplayed(title)
                .checkIsPostUnique("Is this post unique? : yes")
                .checkIsPostPrivate("Note: This post was written for One Person");

    }

    @Test
    public void updatePost() {
        pageProvider.getHomePage()
                .getHeader().clickOnMyProfileButton()
                .checkIsRedirectToMyProfilePage()
                .clickOnPostWithTitle(title)
                .checkIsRedirectToPostPage()
                .clickOnButtonEditPost()
                .checkIsRedirectToUpdatePostPage()
                .enterTextIntoInputTitle(title + update)
                .enterTextIntoInputBody("Body of updated post")
                .clickOnButtonSaveUpdates()
                .checkIsSuccessMessageDisplayed("Post successfully updated.")
                .getHeader().clickOnMyProfileButton()
                .checkIsRedirectToMyProfilePage()
                .clickOnPostWithTitle(title + update)
                .checkIsPostTitleDisplayed(title + update)
                .checkIsPostBodyDisplayed("Body of updated post")
        ;


    }


    @After
    public void deletePost() {
        pageProvider.getHomePage()
                .openHomePageAndLoginIfNeeded()
                .getHeader()
                .clickOnMyProfileButton()
                .checkIsRedirectToMyProfilePage()
                .deletePostsTillPresent(title + update)
        ;
    }
}

