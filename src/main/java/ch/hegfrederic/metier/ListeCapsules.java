package ch.hegfrederic.metier;

import ch.hegfrederic.base.CapsuleDao;
import ch.hegfrederic.domaine.Capsule;

/**
 *
 * @author fredericlopesmagalhaes
 * 
 */
public class ListeCapsules extends ListeObjects<Capsule> {
  
  private CapsuleDao dao;
  
  ListeCapsules(CapsuleDao dao){
    this.dao = dao;
  }
  
  public ListeCapsules() {    
    this.dao = new CapsuleDao();
  }
  
  public void init(){
    setObjects(dao.getListeCapsules());
  }
}