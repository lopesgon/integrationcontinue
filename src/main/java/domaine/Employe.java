package domaine;

import java.util.ArrayList;
import java.util.List;

/**
 * Représentation d'un employé
 *
 * @author lopesmagalhaesfrederic
 * 
 */
/* @Entity // Le Framework (Hibern) va permettre de vérifier au démarrage de l'application les tables correspondantes aux classes où l'on a indiqué @Entity. */
public class Employe {

  private int id;
  private String nom;
  private String prenom;
  private List<Commande> commandes;

  // TEMPORAIREMENT JUSQU'A FIN DES MODIFICATIONS
  public Employe (int id, String nom, String prenom) {
    this(id,nom,prenom,null);
  }
  
  public Employe(int id, String nom, String prenom, ArrayList<Commande> commandes){
    this.id = id;
    this.nom = nom; this.prenom = prenom;
    this.commandes = commandes;
  }

  public int getId () {return id;}
  public String getNom () {return nom;}
  public String getPrenom () {return prenom;}
  public int getNbCommandes(){return commandes.size();}
  public List<Commande> getCommandes(){return commandes;}
  public Commande getCommande(int ind){return commandes.get(ind);}
  
  public void setCommandes(List<Commande> commandes){this.commandes = commandes;}

  public double getTotalCommandes(){
    double total = 0;
    for(Commande commande : commandes){
      total += commande.getPrix();
    }
    return total;
  }
  
  /*  Retourne l'indice où la commande reçu a été insérée OU additionnée.
      On peut ainsi savoir s'il s'agit d'une nouvelle commande (return -1) 
      ou si l'article commandé l'avait déjà été auparavant. */
  public int addCommande(Commande commande){
    int ind = commandes.indexOf(commande);
    if (ind != -1) {
      Commande commandeExist = commandes.get(ind);
      commandeExist.addNombre(commande.getNombre());
    } else {
      commandes.add(commande);
    }
    return ind;
  }
  
  @Override
  public boolean equals (Object obj) {return ((Employe)obj).id == id;}
  
  @Override
  public String toString () {return nom + " " + prenom;}
  
}