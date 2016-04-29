package metier;

import base.CommandeDao;
import base.EmployeDao;
import domaine.Commande;
import domaine.Employe;

/**
 *
 * @author fredericlopesmagalhaes
 *
 */
public class ListeEmployes extends ListeObjects<Employe> {

  public ListeEmployes() {    
    setObjects(EmployeDao.getListeEmployes());
  }

  public void addCommande(Commande commande) {
    int ind = this.getCourant().addCommande(commande);
    CommandeDao.insertCommande(commande);
    System.out.println("Valeur de l'indice reçu en insertion de commande : " + ind);
  }
}
