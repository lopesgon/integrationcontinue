package ch.hegfrederic.presentation;

/**
 * Classe principale de l'application
 *
 * @author lopesmagalhaesfrederic
 * @version 1.0
 */
public class Main {

  public static void main (String args[]) {
    java.awt.EventQueue.invokeLater(new Runnable() {public void run() {new FrmMain().setVisible(true);}});
  }

}
