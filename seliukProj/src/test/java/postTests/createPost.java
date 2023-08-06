package postTests;

import baseTest.BaseTest;
import libs.Util;
import org.junit.After;
import org.junit.Test;

public class createPost extends BaseTest {
    private String title = "JTSK-001 Tars Wonderfull Post " + Util.getDateAndTimeFormatted();

    @Test
    public void newPost() {
        pageProvider.getHomePage()
                .openHomePage().checkIsRedirectOnHomePage()
                .getHeader().clickOnButtonCreatePost()
                .checkIsRedirectOnCreatePostPage()
                .enterTitle(title)
                .enterBody("Tar's Wonderfull Body")
                .selectTextInDropDown("Приватне повідомлення")
                //.selectValueInDropDown("One Person")
                .clickOnButtonSaveNewPost()
                .checkIsSuccessMessageDisplayed("New post successfully created.")
        ;

        pageProvider.getPostPage().getHeader().clickOnMyProfileButton()
                .checkIsRedirectOnMyProfilePage()
                .checkPostWithTitleIsDisplayed(title)
        ;

    }

    @After
    public void deletePost() {
        pageProvider.getHomePage().openHomePageIfNeed()
                .getHeader().clickOnMyProfileButton()
                .checkIsRedirectOnMyProfilePage()
                .deletePostTillPresent(title)
        ;
    }
}
