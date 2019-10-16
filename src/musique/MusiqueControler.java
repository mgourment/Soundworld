package musique;


import utilisateur.Utilisateur;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.swing.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@SessionScoped
@Named
public class MusiqueControler implements Serializable {
    @EJB
    MusiqueDAO dao;

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
}
