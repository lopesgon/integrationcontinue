package ch.hegfrederic.base;

import ch.hegfrederic.domaine.Capsule;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author fredericlopesmagalhaes
 * 
 */
public class CapsuleDao {

    private static ArrayList<Capsule> liste;
    
    private static final String QUERY_GETALL =
            "SELECT*FROM Capsule ORDER BY Nom";
    
    public static ArrayList<Capsule> getListeCapsules(){
        if(liste!=null){
            return liste;
        }else{
            try {
                Connection con = ConnexionBase.get();
                PreparedStatement stmt = con.prepareStatement(QUERY_GETALL);
                ResultSet rs = stmt.executeQuery();
                liste = new ArrayList<>();
                while(rs.next()){
                    int id = rs.getInt("Id");
                    String nom = rs.getString("Nom");
                    Double prix = rs.getDouble("Prix");
                    liste.add(new Capsule(id, nom, prix));
                }
                return liste;
            } catch (SQLException e) {
                System.out.println("base.CapsuleDao.getListeCapsules()" + e.getMessage());
                e.printStackTrace();
                return null;
            }
        }
    }
    
}
