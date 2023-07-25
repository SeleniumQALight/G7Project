package postTests;

import baseTest.BaseTest;
import org.junit.Test;

public class CreatePost extends BaseTest {
    @Test
    public void createNewPost(){
        pageProvider.getHomePage()
                .openHomePage().checkIsRedirectToHomePage()
                .getHeader().clickOnButtonCreatePost()
                .checkIsRedirectToCreatePostPage()
                .enterTextIntoInputTitle("New Post Taras")
                .enterTextIntoInputBody("Body of new Post Taras")
                .selectTextInDropDown("Приватне повідомлення")
        //.selectValueDropDown("One Person")
                .clickOnButtonSaveNewPost()

        ;
    }
}
