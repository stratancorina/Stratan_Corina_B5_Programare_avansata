package entity;

import jakarta.persistence.*;

@Entity
public class Continent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "id")
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    public Continent() {
    }

    public Continent(String name) {
        this.name = name;
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

    @Override
    public String toString() {
        return "Continent{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
