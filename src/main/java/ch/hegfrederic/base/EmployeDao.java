package ch.hegfrederic.base;

import java.util.ArrayList;
import ch.hegfrederic.domaine.Employe;
import ch.hegfrederic.domaine.Commande;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author fredericlopesmagalhaes
 *
 */
public class EmployeDao {

  private static final String QUERY_GETALL
          = "SELECT*FROM Employe ORDER BY Nom, Prenom";

  public List<Employe> getListeEmployes() {
    ArrayList<Employe> liste = new ArrayList<>();
    try {
      Connection con = ConnexionBase.get();
      PreparedStatement stmt = con.prepareStatement(QUERY_GETALL);
      ResultSet rs = stmt.executeQuery();
      while (rs.next()) {
        int id = rs.getInt("Id");
        String nom = rs.getString("Nom");
        String prenom = rs.getString("Prenom");
        Employe employe = new Employe(id, nom, prenom);
        List<Commande> commandes = new CommandeDao().getListeCommandes(employe);
        employe.setCommandes(commandes);
        liste.add(employe);
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    return liste;
  }

}
