package registrationTest;
import libs.ConfigProvider;
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
public class RegistrationTestWithExcel extends baseTest.BaseTest {
    String userName ;
    String email ;
    String Password ;
    String expectedMessages ;

    public RegistrationTestWithExcel(String userName, String email, String password, String expectedMessages) {
        this.userName = userName;
        this.email = email;
        this.Password = password;
        this.expectedMessages = expectedMessages;
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
        pageProvider.getloginPage().enterTextIntoRegistrationUserName(userName);
        pageProvider.getloginPage().enterTextIntoRegistrationEmail(email);
        pageProvider.getloginPage().enterTextIntoRegistrationPassword(Password);
        pageProvider.getloginPage().checkErrorsMessages(expectedMessages);
    }

}