/*******************************************************/
/* VOUS NE DEVEZ EN PRINCIPE PAS MODIFIER CETTE CLASSE */
/* Si vous le faites, indiquez vos nom et prénom ainsi */
/* que votre numéro de poste dans l'entête ci-dessous. */
/* En l'absence de ces indications, votre modification */
/* sera considérée comme non effectuée.                */
/*******************************************************/
package domaine;

import java.text.DecimalFormat;

/**
 * Module 634.1-Programmation - Contrôle continu du 13.04.2016
 * 
 * Représentation d'une capsule (uniquement les informations qui nous intéressent dans cette application)
 *
 * @author Peter DAEHNE - HEG Genève
 * @version 1.0
 */
public class Capsule {

  private static final DecimalFormat FORMAT = new DecimalFormat("#0.00 CHF");
  
  private int id;      /* Identifiant */
  private String nom;  /* Nom */
  private double prix; /* Prix */

  /** Constructeurs */
  public Capsule (int id, String nom, double prix) {
    this.id = id;
    this.nom = nom; this.prix = prix;
  } // Constructeur

  /** Accesseurs */
  public int getId () {return id;}
  public String getNom () {return nom;}
  public double getPrix () {return prix;}

  @Override
  public boolean equals (Object obj) {return ((Capsule)obj).id == id;}
  
  @Override
  public String toString () {return nom + " [" + FORMAT.format(prix) + "]";}
  
} // Capsule
