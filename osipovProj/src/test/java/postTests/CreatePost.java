package postTests;

import org.junit.Test;

public class CreatePost extends baseTest.BaseTest {
    @Test
    public void createNewPost() {
        pageProvider.getHomePage()
                .openHomePage()
                .checkIsRedirectToHomePage()
                .getHeader()
                .clickOnButtonCreatePost()
                .checkIsRedirectToCreatePostPage()
                .enterTextIntoInputTitle("New Post Ivan")
                .enterTextIntoInputBody("Body Of New Post Ivan")
                .selectTextInDropDown("Приватне повідомлення")
                //.selectValueInDropDown("One Person")
                .clickOnButtonSaveNewPost();
    }
}
