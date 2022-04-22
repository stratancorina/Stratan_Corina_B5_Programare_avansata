import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String args[])  {
        try {
            var continents = new ContinentDAO();
            continents.create("Europe");
            Database.getConnection().commit();
            var countries = new CountryDAO();
            int europeId = continents.findByName("Europe");
            countries.create("Romania", europeId);
            countries.create("Ukraine", europeId);
            Database.getConnection().commit();
            //TODO: print all the countries in Europe

            List <CountryList> countriesList = getCountryList();
            for(CountryList countriesL: countriesList) {
                System.out.println(countriesL);
            }


            Database.getConnection().close();
        } catch (SQLException | ClassNotFoundException e) {
            System.err.println(e);
            Database.rollback();
        }
    }

    private static List<CountryList> getCountryList() {
    }
}