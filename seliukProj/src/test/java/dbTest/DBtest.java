package dbTest;

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

public class DBtest {
    private Database mysqlDB;
    private Logger logger = Logger.getLogger(getClass());

    @Before
    public void setUp() throws SQLException, ClassNotFoundException {
        mysqlDB = MySQL_Database.getDataBase();

    }

    @After
    public void tearDown() throws Exception {
        mysqlDB.quit();

    }

    @Test
    public void testDataFromDB() throws SQLException, ClassNotFoundException {
        String login = "G7_taras_s";
        ArrayList<Map<String, String>> dataFromSeleniumTable =
                mysqlDB.selectTableAsMap(
                        String.format("select * from seleniumTable where login='%s'", login));
        logger.info(dataFromSeleniumTable);
        //logger.info(dataFromSeleniumTable.get(0).get("passWord"));
        //logger.info("Size = " + dataFromSeleniumTable.size());
        int numberOfRows = mysqlDB.changeTable(String.format("insert into seleniumTable values ('654', '%s', '%s')", login, "12345"));
        dataFromSeleniumTable = mysqlDB.selectTableAsMap(
                String.format("select * from seleniumTable where login='%s'", login));
        logger.info(dataFromSeleniumTable);

        int deletedRows = mysqlDB.changeTable(String.format("delete from seleniumTable where login = '%s'", login));
        logger.info("Number of deleted rows = " + deletedRows);


        logger.info("_____________________________");

        DB_Util_seleniumTable dbUtilSeleniumTable = new DB_Util_seleniumTable();
        logger.info(dbUtilSeleniumTable.getPassForLogin("G5_Taras"));


    }

}
