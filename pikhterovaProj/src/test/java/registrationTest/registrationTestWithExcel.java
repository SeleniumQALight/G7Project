package registrationTest;

import baseTest.BaseTest;
import libs.SpreadsheetData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;

import static libs.ConfigProvider.configProperties;

@RunWith(Parameterized.class)
public class registrationTestWithExcel extends BaseTest {

    String userName;
    String email;
    String password;
    String expectedMessage;


    public registrationTestWithExcel(String userName, String email, String password, String expectedMessage) {
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.expectedMessage = expectedMessage;
    }

    @Parameterized.Parameters
    public static Collection testData() throws IOException {
        InputStream inputStream = new FileInputStream(
                configProperties.DATA_FILE_PATH() + "testDataSuit.xls");
        return new SpreadsheetData(inputStream, "registrationErrors").getData();
    }

    @Test

    public void checkErrorsTest() {
        pageProvider.getloginPage().openLoginPage();
        pageProvider.getloginPage().enterTextIntoRegistrationUserNameField(userName);
        pageProvider.getloginPage().enterTextIntoRegistrationEmailField(email);
        pageProvider.getloginPage().enterTextIntoRegistrationPasswordField(password);
        pageProvider.getloginPage().checkErrorsMessages(expectedMessage);

    }


}
