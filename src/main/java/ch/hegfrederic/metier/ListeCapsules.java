package ch.hegfrederic.metier;

import ch.hegfrederic.base.CapsuleDao;
import ch.hegfrederic.domaine.Capsule;

/**
 *
 * @author fredericlopesmagalhaes
 * 
 */
public class ListeCapsules extends ListeObjects<Capsule> {
  
  public ListeCapsules() {    
    setObjects(CapsuleDao.getListeCapsules());
  }
}