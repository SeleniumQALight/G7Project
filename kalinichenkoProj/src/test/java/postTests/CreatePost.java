package postTests;

import baseTest.BaseTest;
import org.junit.Test;

public class CreatePost extends BaseTest {

    @Test
    public void createNewPost() {
        pageProvider.getHomePage()
                .openHomePage()
                .getHeader().clickOnButtonCreatePost()
                .checkIsRedirectToCreatePostPage()
                .enterTextIntoInputTitle("kalinichenko title of post")
                .enterTextIntoInputBody("Body of Post")
                .selectTextInDropDown("Приватне повідомлення")
              //.selectValueInDropDownByValue("One Person")
                .clickOnButtonSaveNewPost()
                ;
    }

}
