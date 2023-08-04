package postTests;

import baseTest.BaseTest;
import libs.Util;
import org.junit.After;
import org.junit.Test;

public class CreatePost extends BaseTest {

    private String title = "TC01 - New Post Olesya" + Util.getDateAndTimeFormatted();

    @Test
    public void createNewPost() {
        pageProvider.getHomePage().openHomePage()
                .checkIsRedirectToHomePage()
                .getHeader().clickOnButtonCreatePost()
                .checkIsRedirectToCreatePostPage()
                .enterTextIntoInputTitle(title)
                .enterTextIntoInputBody("Body text Olesya Navrotska")
                .selectTextInDropDown("Приватне повідомлення")
                //.selectValueInDropDown("One Person")
                .clickOnButtonSaveNewPost()
                .checkTextInSuccessMessage("New post successfully created.")






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
