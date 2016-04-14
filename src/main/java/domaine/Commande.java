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
 * Représentation d'une commande (les commandes d'une même capsule sont regroupées: donc pas d'attribut id, ni d'attribut date).
 *
 * @author Peter DAEHNE - HEG Genève
 * Modifications : fredericlopesmagalhaes
 * @version 1.0
 */
public class Commande {
  
  private static final DecimalFormat FORMAT = new DecimalFormat("#0.00 CHF");

  private Employe employe; /* L'employé concernée par la commande */
  private Capsule capsule; /* La capsule concernée par la commande */
  private int nombre;      /* Le nombre de capsules commandées */
  
  /** Constructeurs */
  public Commande (Employe employe, Capsule capsule, int nombre) {
    this.employe = employe; this.capsule = capsule; this.nombre = nombre;
  } // Constructeur

  /** Accesseurs */
  public Capsule getCapsule () {return capsule;}
  public Employe getEmploye(){return employe;}
  public int getNombre () {return nombre;}
  public void addNombre(int nombre){this.nombre += nombre;}

  public double getPrix () {return nombre * capsule.getPrix();}

  @Override
  public boolean equals (Object obj) {return ((Commande)obj).employe.equals(employe) && ((Commande)obj).capsule.equals(capsule);}
  
  @Override
  public String toString () {return nombre + " x " + capsule.getNom() + " à " + FORMAT.format(capsule.getPrix());}
  
} // Commande
