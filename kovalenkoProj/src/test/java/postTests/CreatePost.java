package postTests;

import baseTest.BaseTest;
import libs.Util;
import org.junit.Test;

public class CreatePost extends BaseTest {
    private String title = "TC01 - New Post Tetiana" + Util.getDateAndTimeFormatted();

    @Test
    public void createNewPost() {
        pageProvider.getHomePage().openHomePage().checkIsRedirectToHomePage().getHeader()
                .clickOnButtonCreatePost().checkIsRedirectToCreatePostPage()
                .enterTextIntoInputTitle(title).enterTextIntoInputBody("Body of the new Post Tetiana")
                .selectTextInDropDown("Приватне повідомлення")
                //.selectValueInDropDown("One Person")
                .clickOnButtonSaveNewPost()
                .checkTextInSuccessMessage("New post successfully created.");

    }

}