package DBTest;

import libs.DB_Util_seleniumTable;
import libs.Database;
import libs.MySQL_Database;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

public class DBTest {

    private Database mysqlDB;
    private Logger logger = Logger.getLogger(getClass());

    @Before
    public void setUp() throws SQLException, ClassNotFoundException { // конекшен до БД/викликається перед кожним тестом
        mysqlDB = MySQL_Database.getDataBase();
    }

    @After
    public void tearnDown() throws SQLException {
        mysqlDB.quit();
    }

    @Test
    public void testDataFromDB() throws SQLException, ClassNotFoundException {
        String login = "G7_inna25";
        ArrayList<Map<String,String>> dataFromSeleniumTable =
                mysqlDB.selectTableAsMap(   // витягуємо дані з БД
        String.format("SELECT * FROM seleniumTable WHERE login = '%s'", login));
        logger.info(dataFromSeleniumTable); // виводимо дані з БД в консоль
     //   logger.info(dataFromSeleniumTable.get(0).get("passWord")); // виводимо дані з БД в консоль
     //   logger.info("Size = " + dataFromSeleniumTable.size()); // виводимо розмір масиву


        int numberOfRows = mysqlDB.changeTable("INSERT INTO seleniumTable VALUES (899, '%s', '%s')", "login", "123456");
        logger.info("Number of effected rows = " + numberOfRows);

        dataFromSeleniumTable =
                mysqlDB.selectTableAsMap(
                        String.format("SELECT * FROM seleniumTable WHERE login = '%s'", login));
        logger.info(dataFromSeleniumTable);

        int deletedRows= mysqlDB.changeTable(String.format("DELETE FROM seleniumTable WHERE login = '%s'", login));
        logger.info("Number of deleted rows = " + deletedRows);

        logger.info("___________________________" );
        DB_Util_seleniumTable db_util_seleniumTable = new DB_Util_seleniumTable();
        logger.info(db_util_seleniumTable.getPassForLogin("G5_taras"));
    }
}
