package postTest;


import baseTest.BaseTest;
import libs.Util;
import org.junit.After;
import org.junit.Test;

public class CreatePost extends BaseTest {
    private String title = "TC01 - New Post Inna" + Util.getDateAndTimeFormatted();
    @Test
    public void createNewPost() {

        pageProvider.getHomePage().openHomePage().
                checkIsRedirectToHomePage().getHeader().clickOnButtonCreatePost()
                .checkIsRedirectToCreatePostPage()
        .enterTextIntoInputTitle(title)
                .enterTextIntoInputBody("Test Inna body")
                .selectTextInDropDown("Приватне повідомлення")
                //.selectValueInDropDown("One Person")
                .clickOnButtonSaveNewPost()
                .checkTextInSuccessMessage ("New post successfully created.");












// перевіряє повідомлення в профайлі
        pageProvider.getPostPage().getHeader().clickOnMyProfileButton()
                .checkIsRedirectToMyProfilePage()
                .checkpostWithTitleIsPresent(title)
                ;
    }

    @After
    public void deletePosts() {
        pageProvider.getHomePage().openHomePageAndLoginifNeeded()
                .openHomePageAndLoginifNeeded()
                .getHeader().clickOnMyProfileButton()
                .checkIsRedirectToMyProfilePage()
                .deletePostsTillPresent(title)
                ;
    }


}

