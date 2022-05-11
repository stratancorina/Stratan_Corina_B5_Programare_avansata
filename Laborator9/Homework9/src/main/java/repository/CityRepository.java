package repository;

import entity.City;
import entity.Country;

import java.util.List;

public class CityRepository extends DataRepository<City, Integer> {

    public City findById(Integer id) {
        return (City) em.createNamedQuery("City.findById")
                .setParameter(1, id)
                .getSingleResult();
    }

    public List<City> findByNamePattern(String name) {
        return em.createNamedQuery("City.findByNamePattern")
                .setParameter("cityName", name)
                .getResultList();
    }

    @Override
    public City findByName(String name) {
        try {
            return (City) em.createNamedQuery("City.findByName")
                    .setParameter("cityName", name)
                    .getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }




    @Override
    public List<City> findAll() {
        return em.createNamedQuery("City.findAll")
                .getResultList();
    }

    @Override
    public void deleteById(Integer id) {
        em.getTransaction().begin();
        em.remove(findById(id));
        em.getTransaction().commit();
    }

    @Override
    public void deleteAll() {
        em.getTransaction().begin();
        em.createQuery("delete from City ").executeUpdate();
        em.getTransaction().commit();
    }
}
