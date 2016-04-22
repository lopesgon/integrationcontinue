package base;

import base.mysql.Outils;
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

  private static void connect () {
    try {con = Outils.connect(NOM_BASE);}
    catch (SQLException e) {System.out.println("ConnexionBase: " + e.getMessage()); e.printStackTrace();}
    catch (ClassNotFoundException e) {System.out.println("ConnexionBase: " + e.getMessage()); e.printStackTrace();}
  }

  public static Connection get () {
    if (con == null) {connect();}
    return con;
  } // get

  public static void close () {
    if (con == null) {return;}
    try {con.close(); con = null;}
    catch (SQLException e) {System.out.println("ConnexionBase: " + e.getMessage()); e.printStackTrace();}
  }

}