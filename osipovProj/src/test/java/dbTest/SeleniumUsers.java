package dbTest;

import libs.Database;
import libs.MySQL_Database;
import org.apache.log4j.Logger;

import java.sql.SQLException;

public class SeleniumUsers {
    private Database mysqlDB;
    private Logger logger = Logger.getLogger(getClass());

    public String passFromDB(String login) throws SQLException, ClassNotFoundException {
        mysqlDB = MySQL_Database.getDataBase();
        String pass = mysqlDB.selectValue(String.format("SELECT passWord FROM seleniumUsers Where login='%s'", login));
        mysqlDB.quit();
        return pass;
    }
}
