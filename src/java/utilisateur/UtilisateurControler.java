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
        Utilisateur u = new Utilisateur(login, mdp);
        List<Utilisateur> list = dao.find(u);
        if (!list.isEmpty()){
            exist = true;
        }
        return exist;
    }
        
}
