package postTests;

import baseTest.BaseTest;
import libs.ConfigProvider;
import libs.SpreadsheetData;
import libs.Util;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Collection;

@RunWith(Parameterized.class)
public class CreatePostWithExcel extends BaseTest {

    String title;
    String body;
    String checkBoxState;
    String dropDownText;

    public CreatePostWithExcel(String title, String body, String checkBoxState, String dropDownText) throws SQLException, ClassNotFoundException { // this constructor is needed for @Parameterized
        this.title = title + Util.getDateAndTimeFormatted();
        this.body = body;
        this.checkBoxState = checkBoxState;
        this.dropDownText = dropDownText;

    }

    @Parameterized.Parameters // this annotation is needed for @Parameterized for reading data from Excel
    public static Collection testData() throws IOException {
        InputStream inputStream = new FileInputStream(
                ConfigProvider.configProperties.DATA_FILE_PATH() + "testData.xls");
        return new SpreadsheetData(inputStream, "createPost").getData();
    }

    @Test
    public void createNewPost() throws SQLException, ClassNotFoundException {
        pageProvider.getHomePage().openHomePageDB()
                .checkIsRedirectToHomePage()
                .getHeader().clickOnButtonCreatePost()
                .checkIsRedirectToCreatePostPage()
                .enterTextIntoInputTitle(title)
                .enterTextIntoInputBody(body)
                .selectTextInDropDown(dropDownText)
                .setCheckBoxState(checkBoxState)
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
