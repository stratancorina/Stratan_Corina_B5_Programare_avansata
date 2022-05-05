package daoresponses;

import services.Database;

import java.sql.*;

public class ContinentDAO {

    public void create(String name) throws SQLException {
        Connection connection = Database.getConnection();
        try (PreparedStatement prepareStatement = connection.prepareStatement("insert into continents (name) values (?)")) {
            prepareStatement.setString(1, name);
            prepareStatement.executeUpdate();
        }
    }

    public Integer findByName(String name) throws SQLException {
        Connection connection = Database.getConnection();
        try (Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery( "select id from continents where name='" + name + "'")) {
            return resultSet.next() ? resultSet.getInt(1) : null;
        }
    }

    public String findById(int id) throws SQLException {
        Connection connection = Database.getConnection();
        try (Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery( "select name from continents where id='" + id + "'")) {
            return resultSet.next() ? resultSet.getString(2) : null;
        }
    }

}
