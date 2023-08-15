package registrationTest;

import libs.ExcelDriver;
import junitparams.Parameters;
import libs.SpreadsheetData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collection;

import static libs.ConfigProvider.configProperties;

@RunWith(Parameterized.class) // тест буде запускатись кылька раз з різними параметрами

public class RegistrationTestWithExcel extends baseTest.BaseTest {


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
        FileInputStream inputStream = new FileInputStream(
                configProperties.DATA_FILE_PATH() + "testDataSuit.xls");
        return new SpreadsheetData(inputStream, "registrationErrors").getData();
    }


    @Test
       //
    public void checkErrorsTest() {
        pageProvider.getloginPage().openLoginPage(); // відкриття сторінки
        pageProvider.getloginPage().enterTextIntoRegistrationUserNameField(userName); //вводемо значення змінної userName в поле UserName_реєтрація
        pageProvider.getloginPage().enterTextIntoRegistrationEmailField(email); //вводемо значення змінної email в поле Email_реєтрація
        pageProvider.getloginPage().enterTextIntoRegistrationPasswordField(password); //вводемо значення змінної password в поле Password_реєтрація
        pageProvider.getloginPage().checErrorsMessages(expectedMessages); //перевірка на відображення помилок

    }


}

