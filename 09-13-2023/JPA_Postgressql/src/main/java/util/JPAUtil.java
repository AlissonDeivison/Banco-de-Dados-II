package util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

    //    EntityManagerFactory emf = Persistence.createEntityManagerFactory("loja");
    //    EntityManager em = emf.createEntityManager();
    //    ...
    //    em.getTransaction().begin();

    //Criando viriável estática e utilizando o design pattern factory
    private static final EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("JPA_Postgressql");

    public static EntityManager getEntityManager() {
        return FACTORY.createEntityManager();
    }

}