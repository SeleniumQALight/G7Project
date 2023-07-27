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
                .enterTextIntoInputTitle("New Post")
                .enterTextIntoInputBody("New Post Body")
                .selectTextInDropDown("Приватне повідомлення")//.selectValueInDropDownByValue("One Person")
                .clickOnButtonSave();
    }
}
