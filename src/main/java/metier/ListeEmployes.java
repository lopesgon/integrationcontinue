package metier;

import base.CommandeDao;
import domaine.Commande;
import domaine.Employe;

/**
 *
 * @author fredericlopesmagalhaes
 *
 */
public class ListeEmployes extends ListeObjects<Employe> {
  
  public ListeEmployes(java.util.List<Employe> liste){
    setObjects(liste);
  }

  public void addCommande(Commande commande) {
    int ind = this.getCourant().addCommande(commande);
    }
}