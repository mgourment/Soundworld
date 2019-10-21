package musique;

import utilisateur.Utilisateur;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@SessionScoped
@Named
public class MusiqueControler implements Serializable {
    @EJB
    MusiqueDAO dao;
    private Musique musique = new Musique();
    private Utilisateur utilisateurconsulte = new Utilisateur();

    public List<Musique> tous(){
        return dao.findAll();
    }

    public List<Musique> musiquePublic(){
        List<Musique> list = dao.findAll();

        List<Musique> listPublic = new ArrayList<>();

        for (Musique musique :list) {
            if (musique.getVisible().equals("Y")) {
                listPublic.add(musique);
            }
        }
        return listPublic;
    }

    public Utilisateur getUtilisateurconsulte(){
        return utilisateurconsulte;
    }

    public void setUtilisateur(Utilisateur u){
        this.utilisateurconsulte = u;
    }

    public String pageUtilisateur(Utilisateur u){
        utilisateurconsulte = u;
        return "pageUtilisateur";
    }

    public void ajout(Musique musique){
        dao.addMusique(musique);
    }

    public void remove(Musique musique){
        dao.removeMusique(musique);
    }

    public void modify(Musique musique){
        dao.modifyMusique(musique);
    }

}
