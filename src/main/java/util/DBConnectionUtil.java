package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 * Returns the connection object that can be used to connect to database
 * <p>
 * Class.forName(DRIVER) - dynamically load the driver class into memory, after which it is automatically registered
 */
public class DBConnectionUtil {
    private static final String USERNAME = "root";
    private static final String PASSWORD = "1234";
    private static final String URL = "jdbc:mysql://localhost:3306/iatest?useSSL=false";
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final Connection connection = null;

    public static Connection openConnection() {
        if (connection != null)
            return connection;
        else {
            try {
                Class.forName(DRIVER);
                return DriverManager.getConnection(URL, USERNAME, PASSWORD);
            } catch (ClassNotFoundException | SQLException e) {
                throw new RuntimeException(e);
            }
        }

    }
}


