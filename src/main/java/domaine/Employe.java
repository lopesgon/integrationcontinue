/*******************************************************/
/* VOUS NE DEVEZ EN PRINCIPE PAS MODIFIER CETTE CLASSE */
/* Si vous le faites, indiquez vos nom et prénom ainsi */
/* que votre numéro de poste dans l'entête ci-dessous. */
/* En l'absence de ces indications, votre modification */
/* sera considérée comme non effectuée.                */
/*******************************************************/
package domaine;

/**
 * Module 634.1-Programmation - Contrôle continu du 13.04.2016
 * 
 * Représentation d'un employé
 *
 * @author Peter DAEHNE - HEG Genève
 * @version 1.0
 */
public class Employe {

  private int id;        /* Identifiant */
  private String nom;    /* Nom */
  private String prenom; /* Prénom */

  /** Constructeur */
  public Employe (int id, String nom, String prenom) {
    this.id = id;
    this.nom = nom; this.prenom = prenom;
  } // Constructeur

  /** Accesseurs */
  public int getId () {return id;}
  public String getNom () {return nom;}
  public String getPrenom () {return prenom;}

  @Override
  public boolean equals (Object obj) {return ((Employe)obj).id == id;}
  
  @Override
  public String toString () {return nom + " " + prenom;}
  
} // Employe
