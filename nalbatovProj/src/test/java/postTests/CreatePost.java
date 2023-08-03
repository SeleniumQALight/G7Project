package postTests;

import baseTest.BaseTest;
import libs.Util;
import org.junit.Test;
import org.junit.After;

public class CreatePost extends BaseTest {

    private String title = "TC01-New Post Oleg" + Util.getDateAndTimeFormatted();
    @Test
    public void createNewPost(){
        pageProvider.getHomePage().openHomePage().checkIsRedirectToHomePage().getHeader().clickOnButtonCreatePost()
                .checkisRedirectToCreatePostPage().enterTextIntoInputTitle(title)
                .enterTextIntoInputBody("Body Oleg").selectTextInDropDown("Приватне повідомлення")
                //.selectValueInDropDown("2")
                .clickOnButtonSaveNewPost().checkIsSuccessMessageDisplayed("New post successfully created.");
        ;

        pageProvider.getPostPage().getHeader().clickOnMyProfileButton()
                .checkIsRedirectToMyProfilePage()
                .checkPostWithTitleIsPresent(title)
        ;

    }

    @After
    public void deletePosts(){
        pageProvider.getHomePage()
                .openHomePageAndLoginIfNeeded()
                .getHeader().clickOnMyProfileButton()
                .checkIsRedirectToMyProfilePage()
                .deletePostsTillPresent(title);



    }
}
