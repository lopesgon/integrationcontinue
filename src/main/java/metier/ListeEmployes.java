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
public class ListeEmployes extends ListeObjects {

    public ListeEmployes() {
        liste = EmployeDao.getListeEmployes();
    }

    public Employe getCourant() {
        return (Employe) super.getCourant();
    }

    public Employe get(int k) {
        return (Employe) super.get(k);
    }
    
    public void addCommande(Commande commande){
      int ind = this.getCourant().addCommande(commande);
      CommandeDao.insertCommande(commande);
      System.out.println("Valeur de l'indice reçu en insertion de commande : " + ind);
    }

}
