import java.util.ArrayList;
import java.util.List;

public class CountryList {
    private String name;
    private List<CountryDAO> countries;

    public CountryList(String name) {
        this.name = name;
        countries = new ArrayList<>();
    }

    public void addCountry( CountryDAO country) {
        countries.add(country);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<CountryDAO> getCountries() {
        return countries;
    }

    public void setCountries(List<CountryDAO> countries) {
        this.countries = countries;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.name + "\n");
        for (CountryDAO c : countries) {
            sb.append(c).append("   ");
        }
        return sb.toString();
    }

}
