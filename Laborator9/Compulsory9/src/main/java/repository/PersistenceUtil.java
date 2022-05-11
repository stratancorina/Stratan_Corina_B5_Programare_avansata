package repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class PersistenceUtil {
    private static EntityManagerFactory emf;
    private static EntityManager em;

    public PersistenceUtil() {
    }

    public static EntityManager getEntityManager() {
        if (em == null)
            createEntityManager();
        return em;
    }

    private static void createEntityManager() {
        try {
            emf = Persistence.createEntityManagerFactory("ExamplePU");
            em = emf.createEntityManager();
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public static void closeEntityManager() {
        try {
            em.close();
            emf.close();
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
