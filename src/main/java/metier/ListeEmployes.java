package metier;

import base.EmployeDao;
import domaine.Employe;

/**
 *
 * @author fredericlopesmagalhaes     Numéro du poste: HEG-WS-8468
 * @version 1.0
 */
public class ListeEmployes extends ListeObjects {

    public ListeEmployes() {
        liste = EmployeDao.getListeEmployes();
    }

    public Employe getCourant() {
        return (Employe) super.getCourant();
    }

    public Employe get(int k) {
        return (Employe) super.get(k);
    }

}
