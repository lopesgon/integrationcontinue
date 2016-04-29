package ch.hegfrederic.outils;

/**
 * Outils de validation de nombres
 *
 * @author lopesmagalhaesfrederic
 * 
 */
public class Validation {

  /* Retourne true ssi le String str est un int valide */
  public static boolean isIntValid (String str) {
    try {Integer.parseInt(str);} catch (NumberFormatException e) {return false;}
    return true;
  }

  /* Retourne true ssi le String str est un double valide */
  public static boolean isDoubleValid (String str) {
    try {Double.parseDouble(str);} catch (NumberFormatException e) {return false;}
    return true;
  }

}