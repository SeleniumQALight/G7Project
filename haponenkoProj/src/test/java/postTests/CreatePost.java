package postTests;

import baseTest.BaseTest;
import org.junit.Test;

public class CreatePost extends BaseTest {
    @Test
    public void createNewPost(){
        pageProvider.getHomePage()
                .openHomePage()
                .checkIsRedirectToHomePage()
                .getHeader()
                .clickOnButtonCreatePost()
                .checkIsRedirectToCreatePostPage()
                .enterTextIntoInputTitle("New Post Iryna value")
                .enterTextIntoInputBody("Body of the New Post Iryna value")
                //.selectTextInDropDown("Приватне повідомлення")
                .selectValueInDropDown("One Person")
                .clickOnButtonSaveNewPost();
    }

}
