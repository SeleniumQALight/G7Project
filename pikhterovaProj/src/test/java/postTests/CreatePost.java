package postTests;

import baseTest.BaseTest;
import libs.Util;
import org.junit.After;
import org.junit.Test;

public class CreatePost extends BaseTest {
    private String title = "TC01 - New Post Pikhterova" + Util.getDateAndTimeFormatted();
    private String body = "New Post Body" + Util.getDateAndTimeFormatted();

    @Test
    public void createNewPost() {
        pageProvider.getHomePage().openHomePage().checkIsRedirectToHomePage()
                .getHeader().clickOnButtonCreatePost()
                .checkIsRedirectToCreatePostPage()
                .enterTextIntoInputTitle(title)
                .enterTextIntoInputBody(body)
                .checkCheckBoxUnique(true)
                //.selectTextInDropDown("Приватне повідомлення")
                //.selectValueInDropDown("One Person")
                .selectTextInDropDownByClick("Приватне повідомлення")
                .clickOnButtonSaveNewPost()
                .checkTextInSuccessMessage("New post successfully created.")
                .checkIfPostIsUnique()
                .checkIfPostIsVisibleOnlyForOnePerson()
                .checkTitleText(title)
                .checkBodyText(body)


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
