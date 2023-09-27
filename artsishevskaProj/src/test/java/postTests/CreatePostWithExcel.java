package postTests;


import baseTest.BaseTest;
import libs.DB_Until_seleniumUsers;
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


public class CreatePostWithExcel extends BaseTest { //
    String title;
    String body;
    String dropdownValue;
    String checkBoxValue;

    public CreatePostWithExcel(String title, String body, String dropdownValue, String checkBoxValue) {
        this.title = title + Util.getDateAndTimeFormatted();
        this.body = body;
        this.dropdownValue = dropdownValue;
        this.checkBoxValue = checkBoxValue;
    }

    @Parameterized.Parameters
    public static Collection testData1() throws IOException {
        FileInputStream inputStream = new FileInputStream(
                configProperties.DATA_FILE_PATH() + "testDataSuit.xls");
        return new SpreadsheetData(inputStream, "CreatePostWithExcel").getData();
    }

    @Before
    public void validLogin() throws SQLException, ClassNotFoundException {
        pageProvider.getLoginPage().openLoginPage();
        pageProvider.getLoginPage().enterTextIntoInputUserName("newqaauto");

        DB_Until_seleniumUsers db_util_seleniumUsers = new DB_Until_seleniumUsers();

        pageProvider.getLoginPage().enterTextIntoInputPassword(
                db_util_seleniumUsers.getPassForLogin("newqaauto"));

        pageProvider.getLoginPage().clickOnButtonSignIn();
        pageProvider.getHomePage().getHeader().checkIsButtonSignOutVisible();
    }


    @Test
    public void createNewPostWithExel() {

        pageProvider.getHomePage()
                .getHeader().clickOnButtonCreatePost()
                .checkIsRedirectToCreatePostPage()
                .enterTextIntoInputTitle(title)
                .enterTextIntoInputBody(body)
                .selectValueInDropDown(dropdownValue)
                .setCheckBoxUniquePost(checkBoxValue)
                .clickOnButtonSaveNewPost()
                .checkTextInSuccessMessage("New post successfully created.");



        pageProvider.getPostPage().getHeader().clickOnMyProfileButton()
                .checkIsRedirectToMyProfilePage()
                .checkIsPostWasAdded(title);

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

