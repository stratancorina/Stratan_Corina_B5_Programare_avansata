package entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "countries")
@NamedQueries({
        @NamedQuery(name = "Country.findAll",
                query = "select e from Country e order by e.name"),
        @NamedQuery(name = "Country.findById",
                query = "select e from Country e where e.id = ?1"),
        @NamedQuery(name = "Country.deleteById",
                query = "delete from Country e where e.id = ?1"),
        @NamedQuery(name = "Country.findByNamePattern",
                query = "select e from Country e where e.name LIKE :countryName"),
        @NamedQuery(name = "Country.findByName",
                query = "select e from Country e where e.name=:countryName")
})
public class Country implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "id")
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "code")
    private String code;

    @JoinColumn(name = "continent_id")
    @ManyToOne
    private Continent continent;

    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "country")
    private Set<City> cities = new HashSet<>();

    public Country(String name, String code, Continent continent) {
        this.name = name;
        this.code = code;
        this.continent = continent;
    }

    public Country() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Continent getContinent() {
        return continent;
    }

    public void setContinent(Continent continent) {
        this.continent = continent;
    }

    @Override
    public String toString() {
        return "Country{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", continent='" + continent + '\'' +
                '}';
    }
}
