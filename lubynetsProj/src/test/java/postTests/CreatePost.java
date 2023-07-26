package postTests;

import org.junit.Test;

public class CreatePost extends baseTest.BaseTest {
    @Test
    public void createNewPost(){
        pageProvider.getHomePage()
                .openHomePage().checkIsRedirectToHomePage()
                .getHeader().clickOnButtonCreatePost()
                .CheckIsRedirectOnCreatePostPage()
                .enterTextIntoInputTitle("Body text")
                .enterTextIntoInputBody("Title text")
                .selectTextInDropDown("Приватне повідомлення")
                .clickOnButtonSavePost()
        ;
    }


}
