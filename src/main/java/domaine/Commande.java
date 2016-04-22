package domaine;

import java.text.DecimalFormat;

/**
 * Représentation d'une commande (les commandes d'une même capsule sont regroupées: donc pas d'attribut id, ni d'attribut date).
 *
 * @author lopesmagalhaesfrederic
 * 
 */
public class Commande {
  
  private static final DecimalFormat FORMAT = new DecimalFormat("#0.00 CHF");

  private int id;
  private Employe employe;
  private Capsule capsule; 
  private int nombre;     
    
  public Commande (Employe employe, Capsule capsule, int nombre) {
    this.employe = employe; this.capsule = capsule; this.nombre = nombre;
  }

  public Capsule getCapsule () {return capsule;}
  public Employe getEmploye(){return employe;}
  public int getNombre () {return nombre;}
  public void addNombre(int nombre){this.nombre += nombre;}

  public double getPrix () {return nombre * capsule.getPrix();}

  @Override
  public boolean equals (Object obj) {return ((Commande)obj).employe.equals(employe) && ((Commande)obj).capsule.equals(capsule);}
  
  @Override
  public String toString () {return nombre + " x " + capsule.getNom() + " à " + FORMAT.format(capsule.getPrix());}
  
} 