package libs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;


/*
 *  Database class provides methods for working with database.
 */
public class Database {
    private Connection connection;
    static Logger log = Logger.getLogger(Database.class);
    private final int MAX_LENGTH_OF_QUERY_FOR_OUTPUT = 150;

    /*
     *  Constructor opens connection to database using connection string from config.properties file.
     *  Note in config.properties, please, that username and password for access to the database should be named as
     *  relevant connection string including "_USER"  and "_PASSWORD"
     */
    public Database(String dbDriver, String bdUrl, String user_name, String user_pass)
            throws ClassNotFoundException, SQLException { // конструктор, задаємо параметри для підключення до БД

        // Load driver for JDBC class
        Class.forName(dbDriver); // "com.mysql.cj.jdbc.Driver" завантажує драйвер під час виконання програми

        // Create a connection to the database
        connection = DriverManager.getConnection(bdUrl, user_name, user_pass); //створюємо з'єднання з БД

    }

    /*
     *  That method gets SQL [Select COLUMN_NAME from TABLE_NAME where ...] query as parameter and returns result as
     * String
     */
    public String selectValue(String query) throws SQLException { // коли скрипт повертає тільки одне значення
        // Create statement for connection, execute query and save outcome in ResultSet
        Statement stm = connection.createStatement();
        ResultSet rSet = stm.executeQuery(query);
        ResultSetMetaData meta = rSet.getMetaData();

        // Retrieve value from ResultSet
        String value = "";

        if (rSet.next()) {
            if (rSet.getObject(1) != null) {
                value = rSet.getObject(1).toString();

                if (meta.getColumnType(1) == 93) {
                    value = value.substring(0, value.length() - 2);
                }
            }
        }

        stm.close();
        printQuery(query);
        value = value.trim();
        return value;
    }

    /*
     *  That method gets SQL [Select COLUMN_NAME from TABLE_NAME where ...] query as parameter and returns result set
     *  as List of Strings
     */
    public List selectResultSet(String query) throws SQLException { // коли скрипт повертає тільки один рядочок
        // Create statement for connection, execute query and save outcome in ResultSet
        Statement stm = connection.createStatement();
        ResultSet rSet = stm.executeQuery(query);

        // Get ResultSet's meta data
        ResultSetMetaData meta = rSet.getMetaData();

        List<String> resultSet = new ArrayList<>();

        while (rSet.next()) {
            String value = "";

            if (rSet.getObject(1) != null) {
                value = rSet.getObject(1).toString();

                if (meta.getColumnType(1) == 93) {
                    value = value.substring(0, value.length() - 2);
                }
            }

            value = value.trim();
            resultSet.add(value);
        }

        // Close the statement
        stm.close();
        printQuery(query);
        return resultSet;
    }

    // login | pass
    // taras | 123
    // taras1 | 325
    /*
     *  That method gets SQL [Select COLUMN_NAME_1,COLUMN_NAME_2 from TABLE_NAME where ...] query as parameter and
     * returns result set as List of Strings
     */
    public ArrayList<ArrayList<String>> selectTable(String query) throws SQLException { // коли скрипт повертає багато рядочків
        // Create statement for connection, execute query and save outcome in ResultSet //універсальний метод
        Statement stm = connection.createStatement();
        //System.out.println(query);
        ResultSet rSet = stm.executeQuery(query);

        // Get ResultSet's meta data
        ResultSetMetaData meta = rSet.getMetaData();
        int columnNumber = meta.getColumnCount();

        ArrayList<ArrayList<String>> resultTable = new ArrayList<>();

        // Add column_name's values in the result table header
        ArrayList<String> columnNameSet = new ArrayList<>();
        columnNameSet.add("");
        for (int i = 0; i < columnNumber; i++) {
            columnNameSet.add(meta.getColumnName(i + 1));
        }
        resultTable.add(columnNameSet);

        // Add result rows in the result table
        int resultSize = 0;

        while (rSet.next()) {
            ArrayList<String> resultSet = new ArrayList<>();
            resultSize++;
            resultSet.add(String.valueOf(resultSize));

            for (int k = 1; k < (columnNumber + 1); k++) {
                String value = "";

                if (rSet.getObject(k) != null) {
                    value = rSet.getObject(k).toString();

                    if (meta.getColumnType(k) == 93) {
                        value = value.substring(0, value.length() - 2);
                    }
                }

                value = value.trim();
                resultSet.add(value);
            }

            resultTable.add(resultSet);
        }

        // Close the statement
        stm.close();
        printQuery(query);
        return resultTable;
    }

    // login | pass
    // taras | 123

    // login | pass
    // taras1 | 325
    /*
     *  That method gets SQL [Select COLUMN_NAME_1,COLUMN_NAME_2 from TABLE_NAME where ...] query as parameter and
     * returns result set as List<Map>
     */
    public ArrayList<Map<String, String>> selectTableAsMap(String query) throws SQLException { // повертає динамічний список
        // Create statement for connection, execute query and save outcome in ResultSet
        Statement stm = connection.createStatement(); // створюємо зв'язок з БД
        //System.out.println(query);
        ResultSet rSet = stm.executeQuery(query);// виконуємо запит, результат зберігаємо в ResultSet

        // Get ResultSet's meta data
        ResultSetMetaData meta = rSet.getMetaData(); // отримуємо метадані
        int columnNumber = meta.getColumnCount();// дізнаємось кількість колонок

        ArrayList<Map<String, String>> resultTable = new ArrayList<>(); // створюємо список мапок

        while (rSet.next()) { // поки є наступний рядок
            HashMap<String, String> resultSet = new HashMap<>();

            for (int k = 1; k < (columnNumber + 1); k++) {
                String value = "";

                if (rSet.getObject(k) != null) { // якщо значення не нульове
                    value = rSet.getObject(k).toString(); // отримуємо значення переводимо в стрінгу

                    if (meta.getColumnType(k) == 93) { // якщо тип колонки дата
                        value = value.substring(0, value.length() - 2); // видаляємо з кінця два службові символи
                    }
                }

                value = value.trim(); // видаляємо пробіли
                resultSet.put(meta.getColumnName(k), value); // додаємо в мапу значення, назву колонки
            }

            resultTable.add(resultSet); // додаємо мапу в список
        }

        // Close the statement
        stm.close();
        printQuery(query);
        return resultTable;
    }

    /**
     * метод для UPDATE, DELETE, INSERT
     * @param query
     * @return
     * @throws SQLException
     */
    // підставляємо параметри в скрипт через %s, тобто скільки параметрів стільки %s, будуть  вставлені в срипт попорядку
    public int changeTable(String query, String... params) throws SQLException { // для UPDATE, DELETE, INSERT повертає кількість змінених рядків
        Statement statement = connection.createStatement();// створюємо зв'язок з БД
        int effectedRows = statement.executeUpdate(String.format(query,params)); // змінна для кількості змінених рядків
        printQuery(query); // виводимо скрипт в консоль
        statement.close();// закриваємо зв'язок з БД
        return effectedRows;//
    }


    /*
     *  Close connection to the database
     */
    public void quit() throws SQLException {
        connection.close();
    }

    private void printQuery(String query) { // виводить скрип в консоль
        String queryForOutput = query.length() < MAX_LENGTH_OF_QUERY_FOR_OUTPUT ? query : // якщо довжина скрипта менша за 100 символів, то виводимо скрипт
                (query.substring(0, MAX_LENGTH_OF_QUERY_FOR_OUTPUT) + "..."); // якщо довжина скрипта більша за 100 символів, то виводимо перші 100 символів
        log.info("Query for execute: \"" + queryForOutput +"\"\n"); // виводимо скрипт в консоль
    }
// ? - замість if
}
