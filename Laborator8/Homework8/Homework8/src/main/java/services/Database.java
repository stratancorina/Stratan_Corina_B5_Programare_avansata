package services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static final String URL = "jdbc:postgresql://localhost:5432/homework8";
    private static final String USER = "postgres";
    private static final String PASSWORD = "admin";
    private static Connection connection = null;
    private static Database databaseInstance = null;

    private Database() {

    }

    public static Database getInstance() {
        if(databaseInstance == null) {
            databaseInstance = new Database();
            createConnection();
        }
        return databaseInstance;
    }

    public static Connection getConnection() {
        return connection;
    }

    private static void createConnection() {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            connection.setAutoCommit(false);
        } catch (SQLException exception) {
            System.out.println(exception);
        }
    }

    public static void closeConnection() {
        try {
            connection.close();
        } catch (SQLException exception) {
            System.out.println(exception);
        }
    }

    public static void rollback() {
        try {
            connection.rollback();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }
}
