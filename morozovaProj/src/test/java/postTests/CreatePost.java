package postTests;


import baseTest.BaseTest;
import libs.Util;
import org.junit.After;
import org.junit.Test;

public class CreatePost extends BaseTest {
    private String title = "TC01 - New Post Maryna " + Util.getDateAndTimeFormatted();
    private String checkboxState = "check"; // "uncheck";

    @Test
    public void createNewPost() {

        pageProvider.getHomePage().openHomePage().checkIsRedirectToHomePage()
                .getHeader().clickOnButtonCreatePost().checkIsRedirectToCreatePostPage()
                .enterTextIntoInputTitle(title).enterTextIntoInputBody("Body of new Post Maryna")
                .selectTextInDropDown("Групове повідомлення")
                .selectTextInDropDown2("Приватне повідомлення")
                //     .selectOnCheckBoxIs("check") // вибираємо чекбокс
                .markCheckboxStateUnique(checkboxState)
                //     .selectValueInDropDown("One Person")
                .clickOnButtonSaveNewPost().checkTextInSuccessMessage("New post successfully created.")
                .checkTextInThisPostWasWritten("Note: This post was written for One Person")
                // .checkTextInThisPostWasWritten("Note: This post was written for Group Message")

                //         .checkIsPostUnique("Is this post unique? : no")
                .checkIsPostUnique("Is this post unique? : yes");
//перевірка створеного поста в профайлі:
        pageProvider.getPostPage().getHeader().clickOnMyProfileButton().checkIsRedirectToMyProfilePage().checkPostWithTitleIsPresent(title);
    }

    @After
    public void deletePosts() {
        pageProvider.getHomePage().openHomePageAndLoginIfNeeded().getHeader().clickOnMyProfileButton().checkIsRedirectToMyProfilePage().deletePostsTillPresent(title);

    }
}
