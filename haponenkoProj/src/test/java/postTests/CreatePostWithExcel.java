package postTests;

import baseTest.BaseTest;
import junitparams.JUnitParamsRunner;
import libs.DB_Util_seleniumUsers;
import libs.SpreadsheetData;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import libs.Util;
import org.junit.runners.Parameterized;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Collection;

import static libs.ConfigProvider.configProperties;

@RunWith(Parameterized.class)
public class CreatePostWithExcel extends BaseTest {
    String postTitle;
    String postBody;
    String checkBoxState;
    String dropDownValue;
    String textInSuccessMessage;
    String postIsUnique;
    private String login;


    public CreatePostWithExcel(String postTitle, String postBody, String checkBoxState, String dropDownValue, String textInSuccessMessage, String postIsUnique, String login) {

        this.postTitle = postTitle + Util.getDateAndTimeFormatted();
        this.postBody = postBody;
        this.checkBoxState = checkBoxState;
        this.dropDownValue = dropDownValue;
        this.textInSuccessMessage = textInSuccessMessage;
        this.postIsUnique = postIsUnique;
        this.login = login;
    }

    @Parameterized.Parameters
    public static Collection testData() throws IOException {
        InputStream inputStream = new FileInputStream(
                configProperties.DATA_FILE_PATH() + "hwTestData.xls");
        return new SpreadsheetData(inputStream, "CreatePostWithExcel").getData();

    }

    @Before
    public void validLogin() throws SQLException, ClassNotFoundException {
        pageProvider.getLoginPage().openLoginPage();
        pageProvider.getLoginPage().enterTextIntoInputUserName(login);

        DB_Util_seleniumUsers db_util_seleniumUsers = new DB_Util_seleniumUsers();

        pageProvider.getLoginPage().enterTextIntoInputPassword(db_util_seleniumUsers.getPassForLogin(login));
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
                .markCheckboxStateUnique(checkBoxState)
                .selectValueInDropDown(dropDownValue)
                .clickOnButtonSaveNewPost()
                .checkTextInSuccessMessage(textInSuccessMessage)
                .checkIsRedirectToPostPage()
                .checkTextPostTitle(postTitle)
                .checkTextPostBody(postBody)
                .checkNote(dropDownValue)
                .checkTextIsPostUnique(postIsUnique);

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
