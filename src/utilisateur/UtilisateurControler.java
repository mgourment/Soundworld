package utilisateur;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class UtilisateurControler implements Serializable{
    @EJB
    UtilisateurDAO dao;
    private Utilisateur utilisateur = new Utilisateur();

    public List<Utilisateur> tous(){
        return dao.findAll();
    }
    
    public String isExist(){
        if(utilisateur.getLogin().length() != 0 && utilisateur.getMdp().length() != 0) {
            boolean exist = false;
            Utilisateur U= dao.find(utilisateur);
            if (U != null) {
                exist = true;
            }

            if (exist) {
                utilisateur = U;
            }
            return "home";
        }
        return "index";
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }
}
