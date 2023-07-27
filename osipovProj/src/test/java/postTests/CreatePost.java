package postTests;

import libs.Util;
import org.junit.Test;

public class CreatePost extends baseTest.BaseTest {
    private String title = "TC01 - New Post Ivan" + Util.getDateAndTimeFormatted();
    @Test
    public void createNewPost() {
        pageProvider.getHomePage()
                .openHomePage()
                .checkIsRedirectToHomePage()
                .getHeader()
                .clickOnButtonCreatePost()
                .checkIsRedirectToCreatePostPage()
                .enterTextIntoInputTitle(title)
                .enterTextIntoInputBody("Body Of New Post Ivan")
                .selectTextInDropDown("Приватне повідомлення")
                //.selectValueInDropDown("One Person")
                .clickOnButtonSaveNewPost()
                .checkTextInSuccessMessage("New post successfully created.")
        ;
    }
}
