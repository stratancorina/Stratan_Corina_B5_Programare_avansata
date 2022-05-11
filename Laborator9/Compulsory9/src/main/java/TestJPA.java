import entity.Continent;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class TestJPA {
    public void testJPA() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ExamplePU");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        Continent continent = new Continent("Australia");
        em.persist(continent);

        Continent c = (Continent) em.createQuery(
                        "select e from Continent e where e.name='Australia'")
                .getSingleResult();

        c.setName("SAmerica");
        em.getTransaction().commit();

        em.close();
        emf.close();
    }

}
