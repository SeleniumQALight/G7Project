package postTests;

import baseTest.BaseTest;
import libs.Util;
import org.junit.Test;

public class CreatePost extends BaseTest {

    private String title = "TC01 - Kalinichenko title of post" + Util.getDateAndTimeFormatted();

    @Test
    public void createNewPost() {
        pageProvider.getHomePage()
                .openHomePage()
                .getHeader().clickOnButtonCreatePost()
                .checkIsRedirectToCreatePostPage()
                .enterTextIntoInputTitle(title)
                .enterTextIntoInputBody("Body of Post")
                .selectTextInDropDown("Приватне повідомлення")
                //.selectValueInDropDownByValue("One Person")
                .checkStatusCheckBoxUniquePost("check")
                .clickOnButtonSaveNewPost()
                .checkTextInSuccessMessage("New post successfully created.")
                .checkTextInTitle(title)
                .checkTextInBody("Body of Post")
                .checkTextInThisPostUnique("Is this post unique? : yes")
                .checkTextInThisPostWasWrittenFor("Note: This post was written for One Person")
        ;
    }
}
