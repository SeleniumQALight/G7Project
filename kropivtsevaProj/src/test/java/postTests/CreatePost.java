package postTests;

import baseTest.BaseTest;
import libs.Util;
import org.junit.After;
import org.junit.Test;

public class CreatePost extends BaseTest {
    private String title = "TC01 - New Post Kropivtseva " + Util.getDateAndTimeFormatted();

    @Test

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
                //.selectTextInDropDown("Приватне повідомлення")
                //.selectValueInDropDown("One Person")
                .selectTextInDropDownByUI()
                .clickOnButtonSaveNewPost()
                .checkIsSuccessMessageDisplayed()
                .checkTextInSuccessMessage("New post successfully created.")
                .checkIsPostBodyDisplayed("Body of new post")
                .checkIsPostTitleDisplayed(title)
                .checkIsPostUnique("Is this post unique? : yes")
                .checkIsPostPrivate("Note: This post was written for One Person")
                .getHeader().clickOnMyProfileButton()
                .checkIsRedirectToMyProfilePage()
                .checkPostWithTitleIsPresent(title);
    }


    @After
    public void deletePost() {
        pageProvider.getHomePage()
                .openHomePageAndLoginIfNeeded()
                .getHeader()
                .clickOnMyProfileButton()
                .checkIsRedirectToMyProfilePage()
                .deletePostsTillPresent(title)
        ;
    }
}
