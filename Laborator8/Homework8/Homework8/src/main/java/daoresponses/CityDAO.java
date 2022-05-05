package daoresponses;

import models.City;
import services.Database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CityDAO {

    public int numberOfRowsInTable(Connection connection) throws SQLException {
        try (Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery( "select count(*) from cities")) {
            return resultSet.next() ? resultSet.getInt(1) : null;
        }
    }

    public void create(Connection connection, String countryName, String capitalName, boolean isCapital, double capitalLatitude, double capitalLongitude) throws SQLException {
        try (PreparedStatement prepareStatement = connection.prepareStatement("insert into cities (country, name, capital, latitude, longitude) values (?, ?, CAST(? AS bit), ?, ?)")) {
            prepareStatement.setString(1, countryName);
            prepareStatement.setString(2, capitalName);
            prepareStatement.setString(3, isCapital == true ? "1" : "0");
            prepareStatement.setDouble(4, capitalLatitude);
            prepareStatement.setDouble(5, capitalLongitude);
            prepareStatement.executeUpdate();
        }
    }

    public List<City> getAllCities(Connection connection) throws SQLException {
        List<City> citiesList = new ArrayList<>();
        try (Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery( "select * from cities")) {
            while(resultSet.next()) {
                City city = new City(resultSet.getString(2), resultSet.getString(3), resultSet.getString(4).equals("1") ? true : false, resultSet.getDouble(5), resultSet.getDouble(6));
                citiesList.add(city);
            }
            return citiesList;
        }
    }
}
