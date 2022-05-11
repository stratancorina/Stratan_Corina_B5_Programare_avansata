package entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "continents")
@NamedQueries({
        @NamedQuery(name = "Continent.findAll",
                query = "select e from Continent e order by e.name"),
        @NamedQuery(name = "Continent.findById",
                query = "select e from Continent e where e.id = ?1"),
        @NamedQuery(name = "Continent.deleteById",
                query = "delete from Continent e where e.id = ?1"),
        @NamedQuery(name = "Continent.findByNamePattern",
                query = "select e from Continent e where e.name LIKE :continentName"),
        @NamedQuery(name = "Continent.findByName",
                query = "select e from Continent e where e.name=:continentName")
})
public class Continent implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "id")
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "continent")
    private Set<Country> countries = new HashSet<>();

    public Continent(String name) {
        this.name = name;
    }

    public Continent() {
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

    public Set<Country> getCountries() {
        return countries;
    }

    public void setCountries(Set<Country> countries) {
        this.countries = countries;
    }

    @Override
    public String toString() {
        return "Continent{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
