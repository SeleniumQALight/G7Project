package postTests;

import baseTest.BaseTest;
import libs.Util;
import org.junit.After;
import org.junit.Test;

public class CreatePost extends BaseTest {

    private String title = "TC01 - Kalinichenko title of post" + Util.getDateAndTimeFormatted();

    @Test
    public void createNewPost() {
        pageProvider.getHomePage()
                .openHomePage()
                .getHeader().clickOnButtonCreatePost()
                .checkIsRedirectToCreatePostPage()
                .enterTextIntoInputTitle(title);
        pageProvider.getCreatePostPage().enterTextIntoInputBody("Body of Post");
        pageProvider.getCreatePostPage().selectTextInDropDown("Приватне повідомлення");
        //pageProvider.getCreatePostPage().selectValueInDropDownByValue("One Person"); b
        pageProvider.getCreatePostPage().checkStatusCheckBoxUniquePost("check");
        pageProvider.getCreatePostPage().clickOnButtonSaveNewPost()
                .checkTextInSuccessMessage("New post successfully created.")
                .checkTextInTitle(title)
                .checkTextInBody("Body of Post")
                .checkTextInThisPostUnique("Is this post unique? : yes")
                .checkTextInThisPostWasWrittenFor("Note: This post was written for One Person")
        ;

        pageProvider.getPostPage()
                .getHeader()
                .clickOnMyProfileButton()
                .checkIsRedirectToMyProfilePage()
                .checkIsPostWithTitlePresent(title)
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
        ;
    }
}
