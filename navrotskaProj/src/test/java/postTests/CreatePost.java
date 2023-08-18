package postTests;

import baseTest.BaseTest;
import libs.Util;
import org.junit.After;
import org.junit.Test;

public class CreatePost extends BaseTest {

    private String title = "TC01 - New Post Olesya" + Util.getDateAndTimeFormatted();
    private String body = "Body text Olesya Navrotska";

    @Test
    public void createNewPost() {
        pageProvider.getHomePage().openHomePage()
                .checkIsRedirectToHomePage()
                .getHeader().clickOnButtonCreatePost()
                .checkIsRedirectToCreatePostPage()
                .enterTextIntoInputTitle(title)
                .enterTextIntoInputBody(body)
                .selectTextInDropDownByText()
                .setCheckBoxState("check")
                //.selectTextInDropDown("Приватне повідомлення")
                //.selectValueInDropDown("One Person")
                .clickOnButtonSaveNewPost()
                .checkTextInSuccessMessage("New post successfully created.")
                .checkTitleOnPostPage(title)
                .checkBodyOnPostPage(body)
                .checkIsPostAccessTextDisplayed("Note: This post was written for One Person")
                .checkIfPostIsUnique("Is this post unique? : yes")
        ;

        pageProvider.getPostPage().getHeader()
                .clickOnMyProfileButton()
                .checkIsRedirectToMyProfilePage().checkIsPostWasAdded(title)


        ;

    }

    @After
    public void deletePosts() {
        pageProvider.getHomePage()
                .openHomePageAndLoginIfNeed()
                .getHeader().clickOnMyProfileButton()
                .checkIsRedirectToMyProfilePage()
                .deletePostsTillPresent(title)

        ;
    }


}
