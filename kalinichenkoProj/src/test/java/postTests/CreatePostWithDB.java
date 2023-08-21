package postTests;

import baseTest.BaseTest;
import libs.ConfigProvider;
import libs.DB_Util_seleniumUsers;
import libs.ExcelDriver;
import libs.Util;
import org.junit.After;
import org.junit.Test;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;


public class CreatePostWithDB extends BaseTest {
    private String password;
    private String login = "newqaauto";
    String title;
    String body;
    String checkbox;
    String dropDown;


    @Test
    public void createPostWithDB() throws SQLException, ClassNotFoundException, IOException {
        DB_Util_seleniumUsers db_util = new DB_Util_seleniumUsers();
        password = db_util.getPassForLogin(login);
        Map<String, String> dataCreatePost = ExcelDriver.getData(ConfigProvider.configProperties.DATA_FILE(), "CreatePostWithDB");
        title = dataCreatePost.get("title") + Util.getDateAndTimeFormatted();
        body = dataCreatePost.get("body");
        checkbox = dataCreatePost.get("checkbox");
        dropDown = dataCreatePost.get("dropDown");
        pageProvider.getLoginPage().openLoginPage();
        pageProvider.getLoginPage().enterTextIntoInputUserName(login);
        pageProvider.getLoginPage().enterTextIntoInputPassword(password);
        pageProvider.getLoginPage().clickOnButtonSignIn();
        pageProvider.getHomePage().checkIsRedirectToHomePage()
                .getHeader()
                .clickOnButtonCreatePost()
                .checkIsRedirectToCreatePostPage()
                .enterTextIntoInputTitle(title)
                .enterTextIntoInputBody(body)
                .checkStatusCheckBoxUniquePost(checkbox)
                .selectTextInDropDown(dropDown);
        pageProvider.getCreatePostPage().clickOnButtonSaveNewPost()
                .checkTextInTitle(title)
                .checkTextInBody(body)
                .checkTextInThisPostUnique("Is this post unique? : yes")
                .checkTextInSuccessMessage("New post successfully created.")
                .checkTextInThisPostWasWrittenFor("Note: This post was written for One Person")
        ;
        pageProvider.getPostPage()
                .getHeader()
                .clickOnMyProfileButton()
                .checkIsRedirectToMyProfilePage()
                .checkIsPostWithTitlePresent(title)
        ;
    }

    @After
    public void deletePost() {
        pageProvider.getHomePage()
                .openHomePageAndLoginIfNeeded()
                .getHeader()
                .clickOnMyProfileButton()
                .checkIsRedirectToMyProfilePage()
                .deletePostsTillPresent(title);
    }


}
