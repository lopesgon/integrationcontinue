package domaine;

/**
 * Représentation d'un employé
 *
 * @author lopesmagalhaesfrederic
 * 
 */
// @Entity // ce Framework (Hibern) va permettre de vérifier au
// démarrage de l'application les tables correspondantes aux classes où
// l'on a indiqué @Entity.
public class Employe {

  private int id;
  private String nom;
  private String prenom;

  public Employe (int id, String nom, String prenom) {
    this.id = id;
    this.nom = nom; this.prenom = prenom;
  }

  public int getId () {return id;}
  public String getNom () {return nom;}
  public String getPrenom () {return prenom;}

  @Override
  public boolean equals (Object obj) {return ((Employe)obj).id == id;}
  
  @Override
  public String toString () {return nom + " " + prenom;}
  
}