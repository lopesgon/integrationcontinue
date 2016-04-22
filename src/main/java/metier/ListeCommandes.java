package metier;

import base.CommandeDao;
import domaine.Commande;
import domaine.Employe;

/**
 *
 * @author fredericlopesmagalhaes
 * 
 */
public class ListeCommandes extends ListeObjects {

  private Employe employe;

  public ListeCommandes(Employe employe) {
    this.employe = employe;
    liste = CommandeDao.getListeCommandes(this.employe);
  }

  public Commande getCourant() {
    return (Commande) super.getCourant();
  }

  public Commande get(int k) {
    return (Commande) super.get(k);
  }

  public int addCommande(Commande commande) {
    int ind = liste.indexOf(commande);
    if (ind != -1) {
      Commande commandeExist = this.get(ind);
      commandeExist.addNombre(commande.getNombre());
      setPos(ind);
    } else {
      liste.add(commande);
      setPos(super.size() - 1);
    }
    CommandeDao.insertCommande(commande);
    return getPos();
  }
  
  public double getTotal() {
    double total = 0;
    for (int i = 0, n = size(); i < n; i++) {
      total += get(i).getPrix();
    }
    return total;
  }

}