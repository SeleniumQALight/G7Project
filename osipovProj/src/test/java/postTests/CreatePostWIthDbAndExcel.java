package postTests;

import baseTest.BaseTest;
import dbTest.SeleniumUsers;
import libs.ConfigProvider;
import libs.ExcelDriver;
import libs.Util;
import org.junit.After;
import org.junit.Test;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

public class CreatePostWIthDbAndExcel extends BaseTest {
    SeleniumUsers seleniumUsers = new SeleniumUsers();
    String uniqueTitleFromExcel;

    @Test
    public void createPostWIthDbAndExcel() throws SQLException, ClassNotFoundException, IOException {
        Map<String, String> postData = ExcelDriver.getData(ConfigProvider.configProperties.DATA_FILE(), "CreatePost");
        uniqueTitleFromExcel = postData.get("postTitle") + Util.getDateAndTimeFormatted();
        pageProvider.getLoginPage().openLoginPage();
        pageProvider.getLoginPage().enterTextIntoInputUserName("newqaauto");
        pageProvider.getLoginPage().enterTextIntoInputPassword(seleniumUsers.passFromDB("newqaauto"));
        pageProvider.getLoginPage().clickOnButtonSignIn();
        pageProvider.getHomePage().getHeader()
                .clickOnButtonCreatePost()
                .checkIsRedirectToCreatePostPage()
                .enterTextIntoInputTitle(uniqueTitleFromExcel)
                .enterTextIntoInputBody(postData.get("postBody"))
                .workWithCheckBox(postData.get("checkBoxStatus"))
                .selectValueInDropDown(postData.get("DropDownValue"))
                .clickOnButtonSaveNewPost()
                .checkTextInSuccessMessage("New post successfully created.")
                .checkTitleIsMatchingWithCreatePostStep(uniqueTitleFromExcel)
                .checkBodyIsMatchingWithCreatePostStep(postData.get("postBody"))
                .checkPostIsPrivate("Note: This post was written for " + postData.get("DropDownValue"))
                .checkPostIsUnique("Is this post unique? : yes")
        ;
        pageProvider.getPostPage().getHeader().clickOnMyProfileButton()
                .checkIsRedirectToMyProfilePage()
                .checkPostWithTitleIsPresent(uniqueTitleFromExcel);
        ;
    }
    @After
    public void deletePost() {
        pageProvider.getHomePage()
                .openHomePageAndLoginIfNeeded()
                .getHeader().clickOnMyProfileButton()
                .checkIsRedirectToMyProfilePage()
                .deletePostWithTitle(uniqueTitleFromExcel)
        ;
    }
}
