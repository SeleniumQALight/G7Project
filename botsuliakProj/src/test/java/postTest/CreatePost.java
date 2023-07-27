package postTest;

import baseTest.BaseTest;
import libs.Util;
import org.junit.Test;

public class CreatePost extends BaseTest {
    private String title = "TC01 - New Post Oleksandra" + Util.getDateAndTimeFormatted();
    @Test
    public void createNewPost() {
        pageProvider.getHomePage()
                .openHomePage().checkIsRedirectToHomePage()
                .getHeader().clickOnCreatePostButton()
                .checkIsRedirectToCreatePostPage()
                .enterTextIntoInputTitle("New Post Oleksandra")
                .enterTextIntoInputBody("Post body Oleksandra")
                .selectTextInDropDown("Приватне повідомлення")
                .clickOnButtonSaveNewPost()
                .checkTextInSuccessMessage("New post successfully created.");
    }

}
