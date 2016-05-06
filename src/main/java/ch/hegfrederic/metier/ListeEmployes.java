package ch.hegfrederic.metier;

import ch.hegfrederic.base.EmployeDao;
import ch.hegfrederic.domaine.Commande;
import ch.hegfrederic.domaine.Employe;

/**
 *
 * @author fredericlopesmagalhaes
 *
 */
public class ListeEmployes extends ListeObjects<Employe> {

  private final EmployeDao dao;

  // Vue Package
  ListeEmployes(EmployeDao employeDao) {
    this.dao = employeDao;
  }

  public ListeEmployes() {
    this.dao = new EmployeDao();
  }

  public void init() {
    setObjects(dao.getListeEmployes());
  }

  public void addCommande(Commande commande) {
    int ind = this.getCourant().addCommande(commande);
  }
}
