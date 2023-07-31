package postTests;

import baseTest.BaseTest;
import libs.Util;
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
                .setCheckBoxUniquePost(true)
                .selectTextInDropDown("Приватне повідомлення")
        //.selectValueDropDown("One Person")
                .clickOnButtonSaveNewPost()
                .checkTextInSuccessMessage("New post successfully created.")
                .checkIsTitleEquals(title)
                .checkIsBodyEquals(body)
                .checkNoteIsEquals("One Person")
                .checkIsUniqueEquals("Is this post unique? : yes")


        ;
    }
}
