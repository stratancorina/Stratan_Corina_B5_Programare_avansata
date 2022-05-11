package repository;

import entity.Continent;

import java.util.List;

public class ContinentRepository extends DataRepository<Continent, Integer> {

    public Continent findById(Integer id) {
        return (Continent) em.find(Continent.class, id);
    }

    public List<Continent> findByNamePattern(String name) {
        return em.createNamedQuery("Continent.findByNamePattern")
                .setParameter("continentName", name)
                .getResultList();
    }

    @Override
    public Continent findByName(String name) {
        try {
            return (Continent) em.createNamedQuery("Continent.findByName")
                    .setParameter("continentName", name)
                    .getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Continent> findAll() {
        return em.createNamedQuery("Continent.findAll")
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
        em.createQuery("delete from Continent ").executeUpdate();
        em.getTransaction().commit();
    }
}
