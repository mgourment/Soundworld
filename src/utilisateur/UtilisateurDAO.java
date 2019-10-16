package utilisateur;

import javax.ejb.Stateless;
import javax.persistence.*;
import java.util.List;

@Stateless
public class UtilisateurDAO {

    @PersistenceContext(unitName = "NewPersistenceUnit")
    private EntityManager em;

    public List<Utilisateur> findAll(){
        Query requete = em.createQuery("select p from Utilisateur p");
        return requete.getResultList();
    }

    public Utilisateur find(Utilisateur u){
        Query requete = em.createQuery("select p from Utilisateur p where p.login ='"+ u.getLogin() +"' and p.mdp = '"+ u.getMdp()+"'");
        return (Utilisateur) requete.getSingleResult();
    }
}
