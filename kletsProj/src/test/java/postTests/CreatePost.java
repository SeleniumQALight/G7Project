package postTests;

import baseTest.BaseTest;
import libs.Util;
import org.junit.After;
import org.junit.Test;

public class CreatePost extends BaseTest {

    private String TextInSuccessMessage = "New post successfully created.";
    private String title = "TC01 - New Post Klets " + Util.getDateAndTimeFormatted();

    private String body = "New Post Body Klets";

    private String checkBoxState = "check";

    private String option = "All Users";


    @Test
    public void createNewPost() {
        pageProvider.getHomePage().openHomePage().checkIsRedirectToHomePage()
                .getHeader().clickOnButtonCreatePost()
                .checkIsRedirectToCreatePostPage()
                .enterTextIntoInputTitle(title)
                .enterTextIntoInputBody(body)
                //.markCheckBoxUniquePostYes()
                //.markCheckBoxUniquePostNo()
                .markCheckBoxUniquePost(checkBoxState)
                //.selectCheckBoxUniquePost()
                //.deselectCheckBoxUniquePost()
                .selectTextDropDownByUI("Загальнодоступне")
                // .selectTextDropDownByUI("Приватне повідомлення")
              //  .selectTextDropDownByUI(option)
                //.selectTextInDropDown("Приватне повідомлення")
                // .selectValueInDropDown("One Person")
                .clickOnButtonSaveNewPost()
                .checkTextInSuccessMessage(TextInSuccessMessage)
                .checkIsRedirectToPostPage()
                .checkTextInTitle(title)
                .checkTextInBody(body)
                .checkTextInPrivate(option)
                .checkTextInUnique("Is this post unique? : yes")



        ;

        pageProvider.getPostPage().getHeader().clickOnMyProfileButton()
                .checkIsRedirectToMyProfilePage()
                .checkPostWithTitleIsPresent(title)


        ;

    }

    @After
    public void deletePosts() {
        pageProvider.getHomePage()
                .openHomePageAndLoginIfNeeded()
                .getHeader().clickOnMyProfileButton()
                .checkIsRedirectToMyProfilePage()
                .deletePostsTillPresent(title)
        ;

    }

}
