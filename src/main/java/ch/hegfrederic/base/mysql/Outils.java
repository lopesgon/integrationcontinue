package ch.hegfrederic.base.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author lopesmagalhaesfrederic
 * 
*/
public class Outils {

  public static Connection connect (String nomBase) throws ClassNotFoundException, SQLException {
    Class.forName("com.mysql.jdbc.Driver");
    Properties props = new Properties();
    props.put("user", "root"); props.put("password", "root"); props.put("charSet", "UTF-8");
    return DriverManager.getConnection("jdbc:mysql://localhost:8889/" + nomBase, props);
    //props.put("user", "root"); props.put("password", ""); props.put("charSet", "UTF-8");
    //return DriverManager.getConnection("jdbc:mysql://localhost:3306/" + nomBase, props);
  }

}
