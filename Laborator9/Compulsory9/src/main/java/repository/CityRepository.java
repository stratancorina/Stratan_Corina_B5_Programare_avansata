package repository;

import entity.City;
import entity.Country;
import jakarta.persistence.EntityManager;

import java.util.List;

public class CityRepository {
    private EntityManager em = PersistenceUtil.getEntityManager(); //create it somehow

    public void create(City city) {
        em.persist(city);
    }

    public List<City> findByCountry(Country country) {
        return em.createNamedQuery("City.findByCountry")
                .setParameter("country", country)
                .getResultList();
    }

    public City findById(int id) {
        return (City) em.createNamedQuery("City.findById")
                .setParameter("id", id)
                .getSingleResult();
    }

    public List<City> findByName(String name) {
        return em.createNamedQuery("City.findByName")
                .setParameter("cityName", name)
                .getResultList();
    }
}
