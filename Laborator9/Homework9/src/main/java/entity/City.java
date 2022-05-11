package entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "cities")
@NamedQueries({
        @NamedQuery(name = "City.findAll",
                query = "select e from City e order by e.name"),
        @NamedQuery(name = "City.findByCountry",
                query = "select e from City e where e.country = ?1"),
        @NamedQuery(name = "City.deleteById",
                query = "delete from City e where e.id = ?1"),
        @NamedQuery(name = "City.findById",
                query = "select e from City e where e.id = ?1"),
        @NamedQuery(name = "City.findByNamePattern",
                query = "select e from City e where e.name LIKE :cityName"),
        @NamedQuery(name = "City.findByName",
                query = "select e from City e where e.name=:cityName")
})
public class City implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "id")
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "latitude")
    private double latitude;
    @Column(name = "longitude")
    private double longitude;
    @Column(name = "capital")
    private boolean isCapital;
    @JoinColumn(name = "country_id")
    @ManyToOne
    private Country country;

    public City(String name, Country country, boolean isCapital, double latitude, double longitude) {
        this.name = name;
        this.country = country;
        this.isCapital = isCapital;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public City() {
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public void setCapital(boolean capital) {
        isCapital = capital;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public boolean isCapital() {
        return isCapital;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", isCapital=" + isCapital +
                '}';
    }
}
