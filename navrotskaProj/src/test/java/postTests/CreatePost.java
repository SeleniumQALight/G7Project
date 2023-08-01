package postTests;

import baseTest.BaseTest;
import libs.Util;
import org.junit.Test;

public class CreatePost extends BaseTest {

    private String title = "TC01 - New Post Olesya" + Util.getDateAndTimeFormatted();

    @Test
    public void createNewPost(){
        pageProvider.getHomePage().openHomePage()
                .checkIsRedirectToHomePage()
                .getHeader().clickOnButtonCreatePost()
                .checkIsRedirectToCreatePostPage()
                .enterTextIntoInputTitle(title)
                .enterTextIntoInputBody("Body text Olesya Navrotska")
                .selectTextInDropDown("Приватне повідомлення")
                //.selectValueInDropDown("One Person")
                .clickOnButtonSaveNewPost()
                .checkTextInSuccessMessage("New post successfully created.")
        ;



    }


}
