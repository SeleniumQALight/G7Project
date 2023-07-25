package postTests;

import baseTest.BaseTest;
import org.junit.Test;

public class CreatePost extends BaseTest {
    @Test
    public void createNewPost(){
        pageProvider.getHomePage().openHomePage().checkIsRedirectToHomePage().getHeader().clickOnButtonCreatePost()
                .checkisRedirectToCreatePostPage().enterTextIntoInputTitle("New Post Oleg")
                .enterTextIntoInputBody("Body Oleg").selectTextInDropDown("Приватне повідомлення")
                //.selectValueInDropDown("2")
                .clickOnButtonSaveNewPost();



    }
}
