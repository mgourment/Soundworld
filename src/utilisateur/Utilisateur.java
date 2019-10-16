package utilisateur;

import musique.Musique;
import sun.rmi.log.LogInputStream;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "utilisateur")
public class Utilisateur implements Serializable {
    @Id
    @Column(name = "ID")
    private long id;

    @Basic
    @Column(name = "NOM")
    private String nom;

    @Basic
    @Column(name = "PRENOM")
    private String prenom;

    @Basic
    @Column(name = "LOGIN")
    private String login;

    @Basic
    @Column(name = "MDP")
    private String mdp;

    @OneToMany(mappedBy = "utilisateur")
    private List<Musique> musiqueList;

    public Utilisateur(long id, String nom, String prenom, String login, String mdp){
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.login = login;
        this.mdp = mdp;
    }

    public Utilisateur(String login, String mdp){
        this.login = login;
        this.mdp = mdp;
        this.id = 0;
        this.nom = "inconnu";
        this.prenom = "inconnu";
    }

    public Utilisateur() {
        this.login = "";
        this.mdp = "";
        this.id = 0;
        this.nom = "inconnu";
        this.prenom = "inconnu";
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Utilisateur that = (Utilisateur) o;
        return id == that.id &&
                Objects.equals(nom, that.nom) &&
                Objects.equals(prenom, that.prenom) &&
                Objects.equals(login, that.login) &&
                Objects.equals(mdp, that.mdp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nom, prenom, login, mdp);
    }

    public List<Musique> getMusiqueList() {
        return musiqueList;
    }

//    public  List<Musique> getPublicMusiqueList(){
//        List<Musique> listPublic = new ArrayList<>();
//
//        for (Musique musique :musiqueList) {
//            if (musique.getVisible().equals("Y")) {
//                listPublic.add(musique);
//            }
//        }
//
//        return listPublic;
//    }

    public void setMusiqueList(List<Musique> musiqueList) {
        this.musiqueList = musiqueList;
    }
}
