package utilisateur;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class UtilisateurDAO {
    public List<Utilisateur> findAll(){
        EntityManagerFactory f = Persistence.createEntityManagerFactory("NewPersistenceUnit");
        EntityManager em = f.createEntityManager();
        Query requete = em.createQuery("select p from Utilisateur p");
        return requete.getResultList();
    }

    public Utilisateur find(Utilisateur u){
        EntityManagerFactory f = Persistence.createEntityManagerFactory("NewPersistenceUnit");
        EntityManager em = f.createEntityManager();
        Query requete = em.createQuery("select p from Utilisateur p where p.login ='"+ u.getLogin() +"' and p.mdp = '"+ u.getMdp()+"'");
        return (Utilisateur) requete.getSingleResult();
    }
}
