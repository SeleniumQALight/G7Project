package postTests;

import baseTest.BaseTest;
import libs.Util;
import org.junit.Test;

public class CreatePost extends BaseTest {
    private String title = "TC01 - New Post Dmytro" + Util.getDateAndTimeFormatted();

    @Test
    public void createNewPost(){
        pageProvider.getHomePage()
                .openHomePage().checkIsRedirectToHomePage()
                .getHeader().clickOnButtonCreatePost()
                .checkIsRedirectToCreatePostPage()
                .enterTextIntoInputTitle(title)
                .enterTextIntoInputBody("New Post Body Dmytro")
                .selectTextInDropDown("Приватне повідомлення")
                .selectValueInCheckbox("check")
                //.selectValueInDropDown("One person")
                .clickOnButtonSaveNewPost()
                .checkTextInSuccessMessage("New post successfully created.")
                .checkIsPostTitleCorrect(title).checkIsPostBodyCorrect("New Post Body Dmytro")
                .checkIsPostNoteCorrect("Note: This post was written for One Person").checkIsPostUniqueCorrect("Is this post unique? : yes")
                .checkTextInSuccessMessage("New post successfully created.")
        ;

    }
}
