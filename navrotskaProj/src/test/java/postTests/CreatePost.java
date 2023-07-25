package postTests;

import baseTest.BaseTest;
import org.junit.Test;

public class CreatePost extends BaseTest {

    @Test
    public void createNewPost(){
        pageProvider.getHomePage().openHomePage()
                .checkIsRedirectToHomePage()
                .getHeader().clickOnButtonCreatePost()
                .checkIsRedirectToCreatePostPage()
                .enterTextIntoInputTitle("New Post Olesya")
                .enterTextIntoInputBody("Body text Olesya Navrotska")
                .selectTextInDropDown("Приватне повідомлення")
                //.selectValueInDropDown("One Person")
                .clickOnButtonSaveNewPost()
        ;



    }


}
