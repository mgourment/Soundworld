package utilisateur;

import javax.ejb.EJB;
import javax.inject.Named;
import java.util.List;

@Named
public class UtilisateurControler {
    @EJB
    private UtilisateurDAO dao;
    private Utilisateur utilisateur;

    public List<Utilisateur> tous(){
        return dao.findAll();
    }
    
    public String isExist(String login, String mdp){
        if(login != null || mdp != null) {
            boolean exist = false;
            Utilisateur u = new Utilisateur(login, mdp);
            List<Utilisateur> list = dao.find(u);
            if (!list.isEmpty()) {
                exist = true;
            }

            if (exist) {
                utilisateur = list.get(0);
                return utilisateur.getNom();
            }
        }
        return "index";
    }
        
}
