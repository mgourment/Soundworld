package musique;


import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@SessionScoped
@Named
public class MusiqueControler implements Serializable {
    @EJB
    MusiqueDAO dao;
    private Musique musique = new Musique();

    public List<Musique> tous(){
        return dao.findAll();
    }
}
