package dbTests;

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
    public void setup() throws SQLException, ClassNotFoundException {
        mysqlDB = MySQL_Database.getDataBase();
    }
    @After
    public void tearDown() throws SQLException {
        mysqlDB.quit();
    }
    @Test
    public void testDataFromDB() throws SQLException, ClassNotFoundException {
        String login = "G7_taras_r";
        ArrayList<Map<String,String>>  dataFromSeleniumTable =
                mysqlDB.selectTableAsMap(
                        String.format("SELECT * FROM seleniumTable Where login='%s'", login ));
        logger.info(dataFromSeleniumTable);
       // logger.info(dataFromSeleniumTable.get(0).get("passWord"));
      //  logger.info("Size = " + dataFromSeleniumTable.size());
        int numberOfRows = mysqlDB.changeTable("INSERT INTO seleniumTable VALUES('777','%s','%s')", login,"12345");
        logger.info("Number of effected rows = " + numberOfRows);

        dataFromSeleniumTable =
                mysqlDB.selectTableAsMap(
                        String.format("SELECT * FROM seleniumTable Where login='%s'", login ));
        logger.info(dataFromSeleniumTable);

        int deletedRows = mysqlDB.changeTable(String.format("DELETE FROM seleniumTable Where login='%s'", login ));
        logger.info("Number of deleted rows = " + deletedRows);


        logger.info("---------------");
        DB_Util_seleniumTable dbUtilSeleniumTable = new DB_Util_seleniumTable();
        logger.info(dbUtilSeleniumTable.getPassForLogin("G5_taras"));


    }
}
