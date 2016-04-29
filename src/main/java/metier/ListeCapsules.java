package metier;

import base.CapsuleDao;
import base.EmployeDao;
import domaine.Capsule;

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