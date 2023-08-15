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

@RunWith(Parameterized.class)
public class RegistrationTestWithExcel extends BaseTest {
    String userName;
    String email;
    String password;
    String expectedMessages;

    public RegistrationTestWithExcel(String userName, String email, String password, String expectedMessages) {
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.expectedMessages = expectedMessages;
    }

    @Parameterized.Parameters
    public static Collection testData() throws IOException {
        InputStream inputStream = new FileInputStream(".//src//main//java//data//testDataSuit.xls");
        return new SpreadsheetData(inputStream, "registrationErrors").getData();
    }

    @Test
    public void checkErrorsTest() {
        pageProvider.getLoginPage().openLoginPage();
        pageProvider.getLoginPage().enterTextInroRegistrationUserNameField(userName);
        pageProvider.getLoginPage().enterTextInroRegistrationEmailField(email);
        pageProvider.getLoginPage().enterTextInroRegistrationPasswordField(password);
        pageProvider.getLoginPage().checkErrorsMessages(expectedMessages);
    }

}