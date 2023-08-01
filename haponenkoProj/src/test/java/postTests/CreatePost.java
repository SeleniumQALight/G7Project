package postTests;

import baseTest.BaseTest;
import libs.Util;
import org.junit.Test;

public class CreatePost extends BaseTest {
    private String title = "TC01 - New Post Iryna one person" + Util.getDateAndTimeFormatted();

    private String checkboxState = "check";

    @Test
    public void createNewPost(){
        pageProvider.getHomePage()
                .openHomePage()
                .checkIsRedirectToHomePage()
                .getHeader()
                .clickOnButtonCreatePost()
                .checkIsRedirectToCreatePostPage()
                .enterTextIntoInputTitle(title)
                .enterTextIntoInputBody("Body of the New Post Iryna one person unique")
                //.selectTextInDropDown("Приватне повідомлення")
                //.selectTextInDropDownByUI("Загальнодоступне")
                .selectValueInDropDown("One Person")
//                .markCheckboxUniqueYes()
//                .markCheckboxUniqueNo()
                .markCheckboxStateUnique(checkboxState)
                .clickOnButtonSaveNewPost()
                .checkTextInSuccessMessage("New post successfully created.")
                .checkIsRedirectToPostPage()
                .checkTextIsPostUnique("Is this post unique? : yes")
                .checkTextPostTitle(title)
                .checkTextPostBody("Body of the New Post Iryna one person unique")
                .checkNote("One Person");
    }

}
