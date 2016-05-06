package ch.hegfrederic.base;

import ch.hegfrederic.domaine.Capsule;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author fredericlopesmagalhaes
 *
 */
public class CapsuleDao {

  private static List<Capsule> liste;

  private static final String QUERY_GETALL
          = "SELECT*FROM Capsule ORDER BY Nom";

  public List<Capsule> getListeCapsules() {
    if (liste != null && liste.size() > 0) {
      return liste;
    } else {
      liste = new ArrayList<>();
      try {
        Connection con = ConnexionBase.get();
        PreparedStatement stmt = con.prepareStatement(QUERY_GETALL);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
          int id = rs.getInt("Id");
          String nom = rs.getString("Nom");
          Double prix = rs.getDouble("Prix");
          liste.add(new Capsule(id, nom, prix));
        }
      } catch (SQLException e) {
        System.out.println("base.CapsuleDao.getListeCapsules()" + e.getMessage());
        throw new RuntimeException(e);
      }
      return liste;
    }
  }

}