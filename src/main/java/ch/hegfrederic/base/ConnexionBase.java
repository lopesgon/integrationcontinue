package ch.hegfrederic.base;

import ch.hegfrederic.base.mysql.Outils;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Modélise la connexion à la base
 *
 * @author lopesmagalhaesfrederic
 *
 */
public class ConnexionBase {

  private static final String NOM_BASE = "WhatElse";

  private static Connection con = null;

  private static void connect() {
    try {
      con = Outils.connectMySQL(NOM_BASE);
      // con = Outils.connectH2(NOM_BASE);
    } catch (SQLException e) {
      System.out.println("ConnexionBase: " + e.getMessage());
      throw new RuntimeException(e);
    } catch (ClassNotFoundException e) {
      System.out.println("ConnexionBase: " + e.getMessage());
      throw new RuntimeException(e);
    }
  }

  public static Connection get() {
    if (con == null) {
      connect();
    }
    return con;
  }

  public static void close() {
    if (con == null) {
      return;
    }
    try {
      con.close();
      con = null;
    } catch (SQLException e) {
      System.out.println("ConnexionBase: " + e.getMessage());
      throw new RuntimeException(e);
    }
  }

}
