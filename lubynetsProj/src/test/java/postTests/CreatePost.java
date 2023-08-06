package postTests;

import libs.Util;
import org.junit.After;
import org.junit.Test;

public class CreatePost extends baseTest.BaseTest {
    private String title = "TC01 - New post Lubynets" + Util.getDateAndTimeFormatted();
    @Test
    public void createNewPost(){
        pageProvider.getHomePage()
                .openHomePage().checkIsRedirectToHomePage()
                .getHeader().clickOnButtonCreatePost()
                .CheckIsRedirectOnCreatePostPage()
                .enterTextIntoInputTitle(title)
                .enterTextIntoInputBody("Title text")
                .selectTextInDropDown("Приватне повідомлення")
                .clickOnButtonSavePost()
                .checkTextInSuccessMessage("New post successfully created.")
        ;

        pageProvider.getPostPage().getHeader().clickOnMyProfileButton().checkIsRedirectToMyProfilePage().checkPostWithTitleIsPresent(title)

        ;


    }


    @After
    public void deletePosts(){
        pageProvider.getHomePage()
                    .openHomePageAndLoginIfNeeded()
                .getHeader().clickOnMyProfileButton()
                .checkIsRedirectToMyProfilePage()
                .deletePostTillPresent(title);

    }

}
