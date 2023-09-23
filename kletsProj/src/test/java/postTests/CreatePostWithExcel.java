package postTests;

import libs.DB_Util_seleniumUsers;
import libs.SpreadsheetData;
import libs.Util;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;

import static libs.ConfigProvider.configProperties;

@RunWith(Parameterized.class)

public class CreatePostWithExcel extends baseTest.BaseTest {
    String postTitle;
    String postBody;
    String option;
    String checkBoxState;
    String TextInSuccessMessage;
    String TextInUnique;

    public CreatePostWithExcel(String postTitle, String postBody, String option, String checkBoxState, String TextInSuccessMessage, String TextInUnique) {
        this.postTitle = postTitle + Util.getDateAndTimeFormatted();
        this.postBody = postBody;
        this.option = option;
        this.checkBoxState = checkBoxState;
        this.TextInSuccessMessage = TextInSuccessMessage;
        this.TextInUnique = TextInUnique;
    }

    @Parameterized.Parameters
    public static Collection testData() throws IOException {
        FileInputStream inputStream = new FileInputStream(
                configProperties.DATA_FILE_PATH() + "testDataSuit.xls");
        return new SpreadsheetData(inputStream, "createPostWithExcel").getData();
    }

    @Before
    public void validLogin() throws SQLException, ClassNotFoundException {
        pageProvider.getLoginPage().openLoginPage();
        pageProvider.getLoginPage().enterTextIntoInputUserName("newqaauto");

        DB_Util_seleniumUsers db_util_seleniumUsers = new DB_Util_seleniumUsers();

        pageProvider.getLoginPage().enterTextIntoInputPassword(db_util_seleniumUsers.getPassForLogin("newqaauto"));
        pageProvider.getLoginPage().clickOnButtonSignIn();
        pageProvider.getHomePage().getHeader().checkIsButtonSignOutVisible();
    }

    @Test
    public void createPost() {
        pageProvider.getHomePage()
                .getHeader().clickOnButtonCreatePost()
                .checkIsRedirectToCreatePostPage()
                .enterTextIntoInputTitle(postTitle)
                .enterTextIntoInputBody(postBody)
                .markCheckBoxUniquePost(checkBoxState)
                .selectValueInDropDown(option)
                .clickOnButtonSaveNewPost()
                .checkTextInSuccessMessage(TextInSuccessMessage)
                .checkIsRedirectToPostPage()
                .checkTextInTitle(postTitle)
                .checkTextInBody(postBody)
                .checkTextInPrivate(option)
                .checkTextInUnique("Is this post unique? : " + TextInUnique);

        pageProvider.getPostPage().getHeader().clickOnMyProfileButton()
                .checkIsRedirectToMyProfilePage()
                .checkPostWithTitleIsPresent(postTitle);
    }

    @After
    public void deletePosts() {
        pageProvider.getHomePage()
                .openHomePageAndLoginIfNeeded()
                .getHeader().clickOnMyProfileButton()
                .checkIsRedirectToMyProfilePage()
                .deletePostsTillPresent(postTitle);
    }

}
