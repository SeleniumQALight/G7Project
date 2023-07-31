package postTests;

import baseTest.BaseTest;
import libs.Util;
import org.junit.Test;

public class CreatePost extends BaseTest {
    private String title = "TC01 - New Post Kropivtseva " + Util.getDateAndTimeFormatted();

    @Test

    public void createPost() {
        pageProvider.getHomePage()
                .openHomePage()
                .checkIsRedirectToHomePage()
                .getHeader()
                .clickOnButtonCreatePost()
                .checkIsRedirectToCreatePostPage()
                .enterTextIntoInputTitle(title)
                .enterTextIntoInputBody("Body of new post")
                .workWithCheckBox("check")
                .selectTextInDropDown("Приватне повідомлення")
                //.selectValueInDropDown("One Person")
                .clickOnButtonSaveNewPost()
                .checkIsSuccessMessageDisplayed()
                .checkTextInSuccessMessage("New post successfully created.")
                .checkIsPostBodyDisplayed("Body of new post")
                .checkIsPostTitleDisplayed(title)
                .checkIsPostUnique("Is this post unique? : yes")
        ;
    }
}
