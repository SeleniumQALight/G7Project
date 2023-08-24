package dbTest;

import libs.DB_Util_seleniumTab;
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
    public void setup() throws SQLException, ClassNotFoundException {
        mysqlDB = MySQL_Database.getDataBase();

    }
    @After
    public void tearDown() throws SQLException {
        mysqlDB.quit();
    }
    @Test
    public void testDataFromDB() throws SQLException, ClassNotFoundException {
        String login = "G7_oleksandra_b";
        ArrayList<Map<String,String>> dataFromSeleniumTable =
                mysqlDB.selectTableAsMap(
                        String.format("SELECT * FROM seleniumTable WHERE login='%s'", login));
        logger.info(dataFromSeleniumTable);
//        logger.info(dataFromSeleniumTable.get(0).get("password"));
//        logger.info("Size = " + dataFromSeleniumTable.size());
        int numberOfRows = mysqlDB.changeTable("INSERT INTO seleniumTable VALUES ('345', '%s', '%s')", login, "12345");
        logger.info("Number of rows = " + numberOfRows);

        dataFromSeleniumTable =
                mysqlDB.selectTableAsMap(
                        String.format("SELECT * FROM seleniumTable WHERE login='%s'", login));
        logger.info(dataFromSeleniumTable);

//        int deletedRows = mysqlDB.changeTable(String.format("DELETE FROM seleniumTable WHERE login='%s'", login));
//        logger.info("Number of deleted rows = " + deletedRows);

        logger.info("---------");
        DB_Util_seleniumTab dbUtilSeleniumTab = new DB_Util_seleniumTab();
        logger.info(dbUtilSeleniumTab.getPassForLogin("G7_oleksandra_b"));
    }
}
