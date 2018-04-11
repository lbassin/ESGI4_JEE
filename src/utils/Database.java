package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    static private Connection connection;
    private static final String DB_HOSTNAME = "127.0.0.1";
    private static final String DB_DATABASE = "java";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "root";

    private Database() {
    }

    static private void initConnection() {
        Connection connection = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");

            String connectionString = "jdbc:mysql://" + Database.DB_HOSTNAME + "/" + Database.DB_DATABASE;
            connection = DriverManager.getConnection(connectionString, Database.DB_USERNAME, Database.DB_PASSWORD);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            System.exit(1);
        }

        Database.connection = connection;
    }

    static public Connection getConnection() {
        if (Database.connection == null) {
            Database.initConnection();
        }

        return Database.connection;
    }
}
