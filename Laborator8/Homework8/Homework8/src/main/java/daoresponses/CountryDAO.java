package daoresponses;

import services.Database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CountryDAO {

    public void create(String countryName) throws SQLException {
        Connection connection = Database.getConnection();
        try (PreparedStatement prepareStatement = connection.prepareStatement("insert into countries (name) values (?)")) {
            prepareStatement.setString(1, countryName);
            prepareStatement.executeUpdate();
        }
    }
    public void create(String countryName, String continentName) throws SQLException {
        Connection connection = Database.getConnection();
        try (PreparedStatement prepareStatement = connection.prepareStatement("insert into countries (name, continent) values (?, ?)")) {
            prepareStatement.setString(1, countryName);
            prepareStatement.setString(2, continentName);
            prepareStatement.executeUpdate();
        }
    }

    public Integer findByName(String name) throws SQLException {
        Connection connection = Database.getConnection();
        try (Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery( "select id from countries where name='" + name + "'")) {
            return resultSet.next() ? resultSet.getInt(1) : null;
        }
    }

    public String findById(int id) throws SQLException {
        Connection connection = Database.getConnection();
        try (Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery( "select name from countries where id='" + id + "'")) {
            return resultSet.next() ? resultSet.getString(1) : null;
        }
    }

    /**
     * Returns countries from a continent.
     *
     * @param continent
     * @return
     * @throws SQLException
     */
    public List<String> findByContinent(String continent) throws SQLException {
        List<String> stringList = new ArrayList<>();
        Connection connection = Database.getConnection();
        try (Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery( "select name from countries where continent='" + continent + "'")) {
            while(resultSet.next()) {
                stringList.add(resultSet.getString(1));
            }
            return stringList;
        }
    }
}
