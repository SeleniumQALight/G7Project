package postTest;


import baseTest.BaseTest;
import org.junit.Test;

public class CreatePost extends BaseTest {
    @Test
    public void createNewPost() {
        pageProvider.getHomePage().openHomePage().
                checkIsRedirectToHomePage().getHeader().clickOnButtonCreatePost()
                .checkIsRedirectToCreatePostPage()
        .enterTextIntoInputTitle("New Post Taras")
                .enterTextIntoInputBody("Test Inna body")
                .selectTextInDropDown("Приватне повідомлення")
                //.selectValueInDropDown("One Person")
                .clickOnButtonSaveNewPost();

    }


}

