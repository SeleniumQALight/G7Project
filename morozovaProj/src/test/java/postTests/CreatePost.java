package postTests;


import baseTest.BaseTest;
import org.junit.Test;

public class CreatePost extends BaseTest {
    @Test
    public void createNewPost() {
        pageProvider.getHomePage().openHomePage().
                checkIsRedirectToHomePage().getHeader().clickOnButtonCreatePost()
                .checkIsRedirectToCreatePostPage()
                .enterTextIntoInputTitle("New Post Maryna")
                .enterTextIntoInputBody("Body of  Post Maryna")
                .selectTextInDropDown("Приватне повідомлення")
                //.selectValueInDropDown("One Person")
                .clickOnButtonSaveNewPost();
    }
}
