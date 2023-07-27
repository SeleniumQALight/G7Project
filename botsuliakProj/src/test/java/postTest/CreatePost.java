package postTest;

import baseTest.BaseTest;
import org.junit.Test;

public class CreatePost extends BaseTest {
    @Test
    public void createNewPost() {
        pageProvider.getHomePage()
                .openHomePage().checkIsRedirectToHomePage()
                .getHeader().clickOnCreatePostButton()
                .checkIsRedirectToCreatePostPage()
                .enterTextIntoInputTitle("New Post Oleksandra")
                .enterTextIntoInputBody("Post body Oleksandra")
                .selectTextInDropDown("Приватне повідомлення")
                .clickOnButtonSaveNewPost();

    }

}
