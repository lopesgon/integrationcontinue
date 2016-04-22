package base;

import java.util.ArrayList;
import domaine.Employe;
import domaine.Commande;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author fredericlopesmagalhaes
 * 
 */
public class EmployeDao {
    
    private static final String QUERY_GETALL =
            "SELECT*FROM Employe ORDER BY Nom, Prenom";
    
    public static ArrayList<Employe> getListeEmployes(){
        try {
            Connection con = ConnexionBase.get();
            PreparedStatement stmt = con.prepareStatement(QUERY_GETALL);
            ResultSet rs = stmt.executeQuery();
            ArrayList<Employe> liste = new ArrayList<>();
            while(rs.next()){
                int id = rs.getInt("Id");
                String nom = rs.getString("Nom");
                String prenom = rs.getString("Prenom");
                Employe employe = new Employe(id, nom, prenom);
                ArrayList<Commande> commandes = CommandeDao.getListeCommandes(employe);
                employe.setCommandes(commandes);
                liste.add(employe);
            }
            return liste;
        } catch (SQLException e) {
            System.out.println("base.EmployeDao.getListeEmployes()" + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
    
}