package postTests;

import org.junit.Test;

import static data.TestData.*;

public class CreatePost extends baseTest.BaseTest {
    @Test
    public void createNewPost() {
        pageProvider.getHomePage()
                .openHomePage()
                .checkIsRedirectToHomePage()
                .getHeader()
                .clickOnButtonCreatePost()
                .checkIsRedirectToCreatePostPage()
                .enterTextIntoInputTitle(POST_TITLE)
                .enterTextIntoInputBody(POST_BODY)
                .selectTextInDropDownByUI()
                .workWithCheckBox(CHECK_CHECKBOX)
                .clickOnButtonSaveNewPost()
                .checkTextInSuccessMessage("New post successfully created.")
                .checkTitleIsMatchingWithCreatePostStep(POST_TITLE)
                .checkBodyIsMatchingWithCreatePostStep(POST_BODY)
                .checkPostIsPrivate("Note: This post was written for One Person")
                .checkPostIsUnique("Is this post unique? : yes")
        ;
    }
}
