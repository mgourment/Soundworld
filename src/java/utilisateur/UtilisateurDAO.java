package java.utilisateur;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class UtilisateurDAO {
    public List<Utilisateur> findAll(){
        EntityManagerFactory f = Persistence.createEntityManagerFactory("NewPersistenceUnit");
        EntityManager em = f.createEntityManager();
        Query requete = em.createQuery("select p from Utilisateur p");
        return requete.getResultList();

    }
}
