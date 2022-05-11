package repository;

import jakarta.persistence.EntityManager;

import java.io.Serializable;
import java.util.List;

public abstract class DataRepository
        <D, ID extends Serializable> {
    protected EntityManager em = PersistenceUtil.getEntityManager();

    public void delete(D entity) {
        try {
            em.getTransaction().begin();
            em.remove(entity);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public abstract D findById(ID id);

    public abstract List<D> findByNamePattern(String name);

    public abstract D findByName(String name);

    public abstract List<D> findAll();

    public abstract void deleteById(ID id);

    public abstract void deleteAll();

    public void persist(D entity) {
        try {
            em.getTransaction().begin();
            em.persist(entity);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.err.println(e);
        }
    }

}
