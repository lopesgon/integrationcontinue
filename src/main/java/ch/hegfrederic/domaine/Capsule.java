package ch.hegfrederic.domaine;

import java.text.DecimalFormat;

/**
 * Représentation d'une capsule (uniquement les informations qui nous intéressent dans cette application)
 *
 * @author lopesmagalhaesfrederic
 * 
 */
public class Capsule {

  private static final DecimalFormat FORMAT = new DecimalFormat("#0.00 CHF");
  
  private int id;
  private String nom;
  private double prix; 

  public Capsule (int id, String nom, double prix) {
    this.id = id;
    this.nom = nom; this.prix = prix;
  }

  public int getId () {return id;}
  public String getNom () {return nom;}
  public double getPrix () {return prix;}

  @Override
  public boolean equals (Object obj) {return ((Capsule)obj).id == id;}
  
  @Override
  public String toString () {return nom + " [" + FORMAT.format(prix) + "]";}
  
}