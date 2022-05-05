import daoresponses.CityDAO;
import models.City;
import services.Database;
import utils.Reader;

import java.sql.SQLException;
import java.util.List;


public class Main {
    private static Database database = Database.getInstance();


    public static void main(String[] args) {
        try {
            loadData();
            displayDistances();
            database.getConnection().close();
        } catch (SQLException e) {
            System.err.println(e);
            database.rollback();
        }

    }

    private static void loadData() throws SQLException {
        CityDAO cities = new CityDAO();
        if(cities.numberOfRowsInTable(database.getConnection()) < 1) {
            Reader reader = new Reader();
            reader.readData("C:\\Users\\Lenovo\\Desktop\\Week8\\concap.csv");
            database.getConnection().commit();
        }
    }

    private static void displayDistances() throws SQLException {
        CityDAO cities = new CityDAO();
        List<City> citiesList = cities.getAllCities(database.getConnection());
        for(int indexFirstCity = 0 ; indexFirstCity < citiesList.size() ; ++indexFirstCity) {
            for (int indexSecondCity = indexFirstCity + 1; indexSecondCity < citiesList.size() ; ++indexSecondCity) {
                System.out.println("From " + citiesList.get(indexFirstCity).getName() + " to " + citiesList.get(indexSecondCity).getName() + " are " + citiesList.get(indexFirstCity).getDistanceTo(citiesList.get(indexSecondCity)) + " km.");
            }
        }


    }

}
