package registrationTest;

import baseTest.BaseTest;
import libs.SpreadsheetData;
import org.junit.runners.Parameterized;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;

import static libs.ConfigProvider.configProperties;

@RunWith(Parameterized.class)
public class RegistrationTestWithExcel extends BaseTest {
    String userName;
    String email;
    String password;
    String expectedErrorMessages;

    public RegistrationTestWithExcel(String userName, String email, String password, String expectedErrorMessages) {
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.expectedErrorMessages = expectedErrorMessages;
    }

    @Parameterized.Parameters
    public static Collection testData() throws IOException {
        InputStream inputStream = new FileInputStream(
                configProperties.DATA_FILE_PATH() + "testDataSuit.xls");
        return new SpreadsheetData(inputStream, "registrationErrors").getData();
    }

    @Test
    public void checkErrorsTest() {
        pageProvider.getLoginPage().openLoginPage();
        pageProvider.getLoginPage().enterTextIntoRegistrationUserName(userName);
        pageProvider.getLoginPage().enterTextIntoRegistrationEmail(email);
        pageProvider.getLoginPage().enterTextIntoRegistrationPassword(password);
        pageProvider.getLoginPage().checkErrorsMessages(expectedErrorMessages);
    }

}

