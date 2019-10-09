package java.musique;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Musique {
    private long idM;
    private String titre;
    private String artiste;
    private Long duree;

    @Id
    @Column(name = "ID_M")
    public long getIdM() {
        return idM;
    }

    public void setIdM(long idM) {
        this.idM = idM;
    }

    @Basic
    @Column(name = "TITRE")
    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    @Basic
    @Column(name = "ARTISTE")
    public String getArtiste() {
        return artiste;
    }

    public void setArtiste(String artiste) {
        this.artiste = artiste;
    }

    @Basic
    @Column(name = "DUREE")
    public Long getDuree() {
        return duree;
    }

    public void setDuree(Long duree) {
        this.duree = duree;
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
