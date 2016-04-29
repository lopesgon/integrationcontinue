package ch.hegfrederic.metier;

import ch.hegfrederic.base.CommandeDao;
import ch.hegfrederic.domaine.Commande;
import ch.hegfrederic.domaine.Employe;

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