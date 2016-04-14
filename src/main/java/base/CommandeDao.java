package base;

import java.util.ArrayList;
import domaine.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author fredericlopesmagalhaes Numéro du poste: HEG-WS-8468
 * @version 1.0 CORRECTIONS : - L'ancien code est en commentaire - Le nouveau
 * code se trouve à la suite de l'ancien mis en commentaire
 */
public class CommandeDao {

  private static final String QUERY_GET
          = "SELECT IdEmploye, IdCapsule, SUM(Nombre) 'Nombre' FROM Commande WHERE IdEmploye = ? GROUP BY IdCapsule",
          QUERY_INSERT
          = //"INSERT INTO Commande VALUES(?,?,?,?)";
          "INSERT INTO Commande VALUES(null,?,?,?,?)";

  private static ArrayList<Capsule> lstCapsules;
  private static ArrayList<Commande> lstCommandes;

  private static Capsule getCapsule(int idCapsule) {
    Capsule capsule = new Capsule(idCapsule, "-1", -1);
    int indCapsule = lstCapsules.indexOf(capsule);
    return lstCapsules.get(indCapsule);
  }

  public static ArrayList<Commande> getListeCommandes(Employe employe) {
    lstCommandes = new ArrayList<>();
    try {
      Connection con = ConnexionBase.get();
      PreparedStatement stmt = con.prepareStatement(QUERY_GET);
      stmt.setInt(1, employe.getId());
      ResultSet rs = stmt.executeQuery();
      //lstCommandes = new ArrayList<>(); // DEPLACE AVANT TRY{ .. }
      lstCapsules = CapsuleDao.getListeCapsules();
      while (rs.next()) {
        Capsule capsule = getCapsule(rs.getInt("IdCapsule"));
        int nombre = rs.getInt("Nombre");
        lstCommandes.add(new Commande(employe, capsule, nombre));
      }
      stmt.close();
      return lstCommandes;
    } catch (SQLException e) {
      System.out.println("base.CommandeDao.getListeCommandes()" + e.getMessage());
      e.printStackTrace();
    } catch (Exception e) {
      System.out.println("base.CommandeDao.getListeCommandes()" + e.getMessage());
      System.out.println("ERREUR NON SQL");
      e.printStackTrace();
    }
    //return null;
    return lstCommandes;
  }

  public static boolean insertCommande(Commande commande) {
    try {
      Connection con = ConnexionBase.get();
      PreparedStatement stmt = con.prepareStatement(QUERY_INSERT);
      stmt.setInt(1, commande.getEmploye().getId());
      stmt.setInt(2, commande.getCapsule().getId());
      stmt.setInt(3, commande.getNombre());
      // Date today = Calendar.getInstance().getTime();
      //stmt.setDate(4, null);
      // ResultSet rs = stmt.executeQuery();
      java.sql.Date today = new java.sql.Date(new java.util.Date().getTime()); // CORRIGE
      stmt.setDate(4, today);
      stmt.executeUpdate(); // CORRIGE
      stmt.close();
      return true;
    } catch (SQLException e) {
      System.out.println("base.CommandeDao.getListeCommandes()" + e.getMessage());
      e.printStackTrace();
      return false;
    }
  }

}