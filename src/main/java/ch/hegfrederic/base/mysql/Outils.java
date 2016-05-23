package ch.hegfrederic.base.mysql;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import org.h2.jdbcx.JdbcDataSource;
import org.h2.tools.RunScript;

/**
 * @author lopesmagalhaesfrederic
 *
 */
public class Outils {

  public static Connection connectMySQL(String nomBase) throws ClassNotFoundException, SQLException {
    Class.forName("com.mysql.jdbc.Driver");
    Properties props = new Properties();
    props.put("user", "root");
    props.put("password", "root");
    props.put("charSet", "UTF-8");
    return DriverManager.getConnection("jdbc:mysql://localhost:8889/" + nomBase, props);
    //props.put("user", "root"); props.put("password", ""); props.put("charSet", "UTF-8");
    //return DriverManager.getConnection("jdbc:mysql://localhost:3306/" + nomBase, props);
  }

  public static Connection connectH2(String nomBase) throws ClassNotFoundException, SQLException {
    Class.forName("org.h2.Driver");
    JdbcDataSource ds = new JdbcDataSource();
    ds.setURL("jdbc:h2:˜/test");
    ds.setUser("sa");
    ds.setPassword("sa");
    Connection conn = ds.getConnection();
    try {
      RunScript.execute(conn, new FileReader("./resources/CreateWhatElse.sql"));
    } catch (Exception e) {
      throw new RuntimeException("Outils.connectH2RunScript, ERREUR RunScript !");
    }
    return conn;
  }

}
