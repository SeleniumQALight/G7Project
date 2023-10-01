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

public class DBTestSeleniumUsers {
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
        String login = "G7_MArt";

        ArrayList<Map<String,String>> dataFromSeleniumTable =
                mysqlDB.selectTableAsMap("SELECT * FROM seleniumUsers");
        logger.info(dataFromSeleniumTable);
        int numberOfRows = mysqlDB.changeTable("INSERT INTO seleniumTable VALUES('521', '%s', '%s')", login, "123456"); // вставляємо дані в БД
        logger.info("Number of effected rows = " + numberOfRows);

        dataFromSeleniumTable = // робимо селект, перевіряємо чи дані вставились в БД
                mysqlDB.selectTableAsMap(
                        String.format("SELECT * FROM seleniumTable WHERE login = '%s'", login));
        logger.info(dataFromSeleniumTable);

        int deletedRows= mysqlDB.changeTable(String.format("DELETE FROM seleniumTable WHERE login = '%s'", login)); // видаляємо дані з БД
        logger.info("Number of deleted rows = " + deletedRows);

        logger.info("___________________________" );
        DB_Util_seleniumTable db_util_seleniumTable = new DB_Util_seleniumTable();//достаємо пароль за логіном
        logger.info(db_util_seleniumTable.getPassForLogin("G5_taras"));


    }

}
