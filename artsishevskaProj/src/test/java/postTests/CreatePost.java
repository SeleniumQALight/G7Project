package postTests;

import baseTest.BaseTest;
import libs.Util;
import org.junit.After;
import org.junit.Test;

public class CreatePost extends BaseTest {
    private String title = "TC01 - New Post MArt" + Util.getDateAndTimeFormatted();
    private String body = "Body of new Post MArt" + Util.getDateAndTimeFormatted();
    @Test
    public void createNewPost(){
        pageProvider.getHomePage()
                .openHomePage().checkIsRedirectToHomePage()
                .getHeader().clickOnButtonCreatePost()
                .checkIsRedirectToCreatePostPage()
                .enterTextIntoInputTitle(title)
                .enterTextIntoInputBody("Body of new Post MArt")
                .enterTextIntoInputBody(title)
                .enterTextIntoInputBody(body)
                .setCheckBoxUniquePost("check")
                .selectTextInDropDown("Приватне повідомлення")
        //.selectValueDropDown("One Person")
                .clickOnButtonSaveNewPost()
                .checkTextInSuccessMessage("New post successfully created.")

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
                .deletePostsTillPresent(title)

        ;
    }
}
