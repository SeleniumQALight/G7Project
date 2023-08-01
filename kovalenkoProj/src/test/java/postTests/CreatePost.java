package postTests;

import baseTest.BaseTest;
import libs.Util;
import org.junit.Test;

public class CreatePost extends BaseTest {
    private String title = "TC01 - New Post Tetiana" + Util.getDateAndTimeFormatted();
    private String body = "Body of the new Post Tetiana";

    @Test
    public void createNewPost() {
        pageProvider.getHomePage().openHomePage().checkIsRedirectToHomePage().getHeader()
                .clickOnButtonCreatePost().checkIsRedirectToCreatePostPage()
                .enterTextIntoInputTitle(title).enterTextIntoInputBody(body)
                .setCheckBoxUniquePost(true)
                .selectTextInDropDown("Приватне повідомлення")
                //.selectValueInDropDown("One Person")
                .clickOnButtonSaveNewPost()
                .checkTextInSuccessMessage("New post successfully created.")
                .checkIsTitleEquals(title)
                .checkIsBodyEquals(body)
                .checkNoteIsEquals("One Person")
                .checkIsUniqueEquals("Is this post unique? : yes");

    }

}
