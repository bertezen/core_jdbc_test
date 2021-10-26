package core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    private static final String dbURL = "jdbc:h2:mem:test";
    private static final String dbUsername = "sa";
    private static final String dbPassword = "";

    public static Connection getConnection() {
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(dbURL, dbUsername, dbPassword);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return connection;
    }
}















