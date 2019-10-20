package musique;

import utilisateur.Utilisateur;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Musique {

    @Id
    @Column(name = "ID_M")
    private long idM;

    @Basic
    @Column(name = "TITRE")
    private String titre;

    @Basic
    @Column(name = "ARTISTE")
    private String artiste;

    @Basic
    @Column(name = "DUREE")
    private Long duree;

    @Basic
    @Column(name = "VISIBLE")
    private String visible;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "PROPRIETAIRE")
    private Utilisateur utilisateur;

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public long getIdM() {
        return idM;
    }

    public void setIdM(long idM) {
        this.idM = idM;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getArtiste() {
        return artiste;
    }

    public void setArtiste(String artiste) {
        this.artiste = artiste;
    }

    public Long getDuree() {
        return duree;
    }

    public void setDuree(Long duree) {
        this.duree = duree;
    }

    public String getVisible() {
        return visible;
    }

    public void setVisible(String visible) {
        this.visible = visible;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Musique musique = (Musique) o;
        return idM == musique.idM &&
                Objects.equals(titre, musique.titre) &&
                Objects.equals(artiste, musique.artiste) &&
                Objects.equals(duree, musique.duree);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idM, titre, artiste, duree);
    }
}
