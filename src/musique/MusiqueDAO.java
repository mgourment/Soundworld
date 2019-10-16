package musique;

import utilisateur.Utilisateur;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class MusiqueDAO {
    @PersistenceContext(unitName = "NewPersistenceUnit")
    private EntityManager em;

    public List<Musique> findAll(){
        Query requete = em.createQuery("select p from Musique p");
        return requete.getResultList();
    }
}
