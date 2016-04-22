package metier;

import base.CapsuleDao;
import domaine.Capsule;

/**
 *
 * @author fredericlopesmagalhaes
 * 
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