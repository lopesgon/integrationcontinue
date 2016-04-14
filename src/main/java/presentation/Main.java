/*****************************************************/
/* VOUS N'AVEZ PAS LE DROIT DE MODIFIER CETTE CLASSE */
/*****************************************************/
package presentation;

/**
 * Module 634.1-Programmation - Contrôle continu du 13.04.2016
 * 
 * Classe principale de l'application
 *
 * @author Peter DAEHNE - HEG Genève
 * @version 1.0
 */
public class Main {

  public static void main (String args[]) {
    java.awt.EventQueue.invokeLater(new Runnable() {public void run() {new FrmMain().setVisible(true);}});
  } // main

} // Main
