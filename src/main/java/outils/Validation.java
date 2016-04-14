/*****************************************************/
/* VOUS N'AVEZ PAS LE DROIT DE MODIFIER CETTE CLASSE */
/*****************************************************/
package outils;

/**
 * Outils de validation de nombres
 *
 * @author Peter DAEHNE - HEG-Genève
 * @version Version 1.0
*/
public class Validation {

  /* Retourne true ssi le String str est un int valide */
  public static boolean isIntValid (String str) {
    try {Integer.parseInt(str);} catch (NumberFormatException e) {return false;}
    return true;
  } // isIntValid

  /* Retourne true ssi le String str est un double valide */
  public static boolean isDoubleValid (String str) {
    try {Double.parseDouble(str);} catch (NumberFormatException e) {return false;}
    return true;
  } // isDoubleValid

} // Validation