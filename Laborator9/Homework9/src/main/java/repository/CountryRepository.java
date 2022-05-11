package repository;

import entity.Country;

import java.util.List;

public class CountryRepository extends DataRepository<Country, Integer> {
    public Country findById(Integer id) {
        return (Country) em.createNamedQuery("Country.findById")
                .setParameter(1, id)
                .getSingleResult();
    }

    public List<Country> findByNamePattern(String name) {
        return em.createNamedQuery("Country.findByNamePattern")
                .setParameter("countryName", name)
                .getResultList();
    }

    @Override
    public Country findByName(String name) {
        try {
            return (Country) em.createNamedQuery("Country.findByName")
                    .setParameter("countryName", name)
                    .getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Country> findAll() {
        return em.createNamedQuery("Country.findAll")
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
        em.createQuery("delete from Country ").executeUpdate();
        em.getTransaction().commit();
    }
}
