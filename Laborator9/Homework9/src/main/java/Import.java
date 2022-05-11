import entity.City;
import entity.Continent;
import entity.Country;
import repository.CityRepository;
import repository.ContinentRepository;
import repository.CountryRepository;
import repository.DataRepository;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Import {
    public Import(String absolutePath) {

        
        DataRepository continents = new ContinentRepository();
        DataRepository countries = new CountryRepository();
        DataRepository cities = new CityRepository();

        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(absolutePath));
            String row;

            while ((row = reader.readLine()) != null) {


                String[] vector = row.split(",");

                String countryName = vector[0];
                String capitalName = vector[1];
                double capitalLatitude = Double.parseDouble(vector[2]);
                double capitalLongitude = Double.parseDouble(vector[3]);
                String countryCode = vector[4];
                String continentName = vector[5];


                Continent continent = (Continent) continents.findByName(continentName);

                if (continent == null) {
                    continent = new Continent(continentName);
                }

                continents.persist(continent);

                Country country = (Country) countries.findByName(countryName);

                if (country == null) {
                    country = new Country(countryName, countryCode, continent);
                }

                countries.persist(country);

                City city = (City) cities.findByName(capitalName);

                if (city == null || !city.getCountry().equals(country)) {
                    city = new City(capitalName, country, true, capitalLatitude, capitalLongitude);
                }

                cities.persist(city);
            }
            System.out.println(continents.findByName("Africa"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
