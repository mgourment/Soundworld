package java.utilisateur;

import javax.ejb.EJB;
import javax.inject.Named;
import java.util.List;

@Named
public class UtilisateurControler {
    @EJB
    private UtilisateurDAO dao;

    public List<Utilisateur> tous(){
        return dao.findAll();
    }
    
    public boolean isExist(String login, String mdp){
        boolean exist = false;
        for (Utilisateur u: tous()){
            if (u.getLogin().equals(login) && u.getMdp().equals(mdp)){
                exist = true;
            }
        }
        return exist;
    }
        
}
