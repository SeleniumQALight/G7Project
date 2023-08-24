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
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static libs.ConfigProvider.configProperties;

@RunWith(Parameterized.class)

public class CreatePostWithDB extends baseTest.BaseTest {
    String title;
    String body;
    String checkBoxValue;
    String dropdownValue;

    public CreatePostWithDB(String title, String body, String checkBoxValue, String dropdownValue) {
        this.title = title + Util.getDateAndTimeFormatted();
        this.body = body;
        this.checkBoxValue = checkBoxValue;
        this.dropdownValue = dropdownValue;
    }

    //    @Parameterized.Parameters // это проверка  в которой и прогоняет ключи (4 теста)
//    public static Collection testData() throws IOException {
//        FileInputStream inputStream = new FileInputStream(
//                configProperties.DATA_FILE_PATH() + "testData.xls");//
//        return new SpreadsheetData(inputStream, "DataTest").getData();
//    }
    @Parameterized.Parameters  // это проверка без ключа (3 теста)
    public static Collection testData() throws IOException {
        FileInputStream inputStream = new FileInputStream(
                configProperties.DATA_FILE_PATH() + "testData.xls");//
        Collection<Object[]> data = new SpreadsheetData(inputStream, "DataTest").getData();
        List<Object[]> testData = new ArrayList<>();

        boolean firstRowSkipped = false;
        for (Object[] rowData : data) {
            if (!firstRowSkipped) {
                firstRowSkipped = true;
                continue;
            }

            String title = (String) rowData[0];
            String body = (String) rowData[1];
            String checkBoxValue = (String) rowData[2];
            String dropdownValue = (String) rowData[3];

            Object[] testDataItem = new Object[]{title, body, checkBoxValue, dropdownValue};
            testData.add(testDataItem);
        }

        return testData;
    }


    @Before
    public void validLogin() throws SQLException, ClassNotFoundException {//
        pageProvider.getloginPage().openLoginPage();
        pageProvider.getloginPage().enterTextIntoInputUserName("newqaauto");
        DB_Util_seleniumUsers db_util_seleniumUsers = new DB_Util_seleniumUsers();
        pageProvider.getloginPage().enterTextIntoInputPassword(
                db_util_seleniumUsers.getPasswordForLogin("newqaauto"));
        pageProvider.getloginPage().clickOnButtonSignIn();
        pageProvider.getHomePage().getHeader().checkIsButtonSignOutVisible();
    }

    @Test
    public void createNewPostWithExel() {
        pageProvider.getHomePage()
                .getHeader().clickOnButtonCreatePost()
                .CheckIsRedirectOnCreatePostPage()
                .enterTextIntoInputTitle(title)
                .enterTextIntoInputBody(body)
                .selectTextInDropDown(dropdownValue)
                .setCheckboxState(checkBoxValue)
                .clickOnButtonSavePost()
                .checkTextInSuccessMessage("New post successfully created.");
        pageProvider.getPostPage().getHeader().clickOnMyProfileButton()
                .checkIsRedirectToMyProfilePage().checkPostWithTitleIsPresent(title);

    }

    @After
    public void deletePosts() {
        pageProvider.getHomePage().openHomePageAndLoginIfNeeded().getHeader()
                .clickOnMyProfileButton().checkIsRedirectToMyProfilePage().deletePostTillPresent(title);
    }
}