package postTests;

import libs.Util;
import org.junit.Test;
import pages.ActionWithElements;
import pages.PostPage;


public class CreatePost extends baseTest.BaseTest {
    private String title;
    private String body;
    private PostPage postPage;
    private ActionWithElements actionWithElements;

    @Test
    public void createNewPost() {
        title = " TC01 - New post Lubynets" + Util.getDateAndTimeFormatted();
        body = "Body text";
        postPage = new PostPage(webDriver);

        pageProvider.getHomePage()
                .openHomePage().checkIsRedirectToHomePage()
                .getHeader().clickOnButtonCreatePost()
                .CheckIsRedirectOnCreatePostPage()
                .enterTextIntoInputTitle(title)
                .enterTextIntoInputBody(body)
                .selectTextInDropDown("Приватне повідомлення")
                .setCheckboxState("check");
        postPage.checkPostTitle(title)
                .checkPostBody(body)
                .clickOnButtonSavePost()
                .checkTextInSuccessMessage("New post successfully created.")
                .checkIsNoteMessageDisplayed("Note: This post was written for ")
                .checkIsPostWrittenFor("One Person")
                .checkIsPostUnique("Is this post unique? : yes", "yes");
    }

    @Test
    public void createNewPostWithDropDown() {
        String dropDownValue = "Приватне повідомлення";
        title = " TC02 - New post Lubynets" + Util.getDateAndTimeFormatted();
        body = "Body text";
        postPage = new PostPage(webDriver);
        pageProvider.getHomePage()
                .openHomePage().checkIsRedirectToHomePage()
                .getHeader().clickOnButtonCreatePost()
                .CheckIsRedirectOnCreatePostPage()
                .enterTextIntoInputTitle(title)
                .enterTextIntoInputBody(body);
        postPage.selectTextInDropDownByUI(postPage.getDropDownSelectValue(), dropDownValue);
        postPage.clickOnButtonSavePost()
                .checkIsNoteMessageDisplayed("Note: This post was written for ")
                .checkIsPostWrittenFor("One Person")
                .checkIsNegativePostUnique("Is this post unique? : no", "no")
                .checkTextInSuccessMessage("New post successfully created.");
    }
}