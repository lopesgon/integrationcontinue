package metier;

import base.CapsuleDao;
import domaine.Capsule;

/**
 *
 * @author fredericlopesmagalhaes     Numéro du poste: HEG-WS-8468
 * @version 1.0
 */
public class ListeCapsules extends ListeObjects {
    
    public ListeCapsules() {
        liste = CapsuleDao.getListeCapsules();
    }

    public Capsule getCourant() {
        return (Capsule) super.getCourant();
    }

    public Capsule get(int k) {
        return (Capsule) super.get(k);
    }
}