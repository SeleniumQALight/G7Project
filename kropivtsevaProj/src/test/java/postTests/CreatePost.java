package postTests;

import baseTest.BaseTest;
import org.junit.Test;

public class CreatePost extends BaseTest {

    @Test

    public void createPost() {
        pageProvider.getHomePage().openHomePage().checkIsRedirectToHomePage().getHeader().clickOnButtonCreatePost().checkIsRedirectToCreatePostPage().enterTextIntoInputTitle("Kropivtseva").enterTextIntoInputBody("Body of new post").selectTextInDropDown("Приватне повідомлення")//.selectValueInDropDown("One Person")
                .clickOnButtonSaveNewPost();
    }

}
