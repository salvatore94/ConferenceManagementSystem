/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conferencemanagementsystem.Utils;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author salvatore
 */
public class DataBaseManagement {
    private static final String db_username = "root";
    private static final String db_password = "";
    private static final String db_connection_options = "jdbc:mysql://localhost:3306/cms";
    
    private Connection con = null;
    
    public DataBaseManagement () {
        try {
            con = DriverManager.getConnection(db_connection_options, db_username, db_password);
            System.out.println("Connesso al db");
        } catch (SQLException e) {
            System.err.println(e);
        }
    }
 
    public Connection getDBConnection() {
        return con;
    }
    
    public void creaDB() throws SQLException{
        Statement stat = con.createStatement();
        
        String sql = "CREATE TABLE IF NOT EXISTS articoli " +
                   "(idArticolo INTEGER not NULL AUTO_INCREMENT, " +
                   " idUtente INTEGER NOT NULL, " + 
                   " titolo VARCHAR(255) NOT NULL, " +
                   " tema VARCHAR(255) NOT NULL, " +
                   " file VARCHAR(255) NOT NULL, " + 
                   " file_rivisto VARCHAR(255), " + 
                   " ammesso BOOL DEFAULT false, " +
                   " PRIMARY KEY ( idArticolo ))";
        
        stat.executeUpdate(sql);
        
        sql = "CREATE TABLE IF NOT EXISTS utenti " +
                   "(idUtente INTEGER not NULL AUTO_INCREMENT, " +
                   " email VARCHAR(255) NOT NULL, " + 
                   " nome VARCHAR(255) NOT NULL, " + 
                   " cognome VARCHAR(255) NOT NULL, " +
                   " password VARCHAR(255) NOT NULL, " +
                   " PRIMARY KEY ( idUtente ))";
        
        stat.executeUpdate(sql);
        
        sql = "CREATE TABLE IF NOT EXISTS conferenza " +
                   "(idConferenza INTEGER NOT NULL AUTO_INCREMENT, " +
                   " idChair INTEGER NOT NULL, " +
                   " nome VARCHAR(255) NOT NULL, " + 
                   " tema VARCHAR(255) NOT NULL, " +
                   " luogo VARCHAR(255) NOT NULL, " +
                   " numeroArticoli INT NOT NULL, " +
                   " inizio DATE, " +
                   " fine DATE, " +
                   " scadenzaSottomissione DATE, " +
                   " scadenzaReview DATE, " +
                   " scadenzaSottomissioneRivisti DATE, " +
                   " PRIMARY KEY ( idConferenza ))";
        
        stat.executeUpdate(sql);
        
        sql = "CREATE TABLE IF NOT EXISTS recensioni " +
                   "(idRecensione INTEGER not NULL AUTO_INCREMENT, " +
                   " idArticolo INTEGER NOT NULL, " + 
                   " idRecensore INTEGER NOT NULL, " + 
                   " votazione DOUBLE NOT NULL, " +
                   " commento VARCHAR(255), " +
                   " commentoRiservato VARCHAR(255), " +
                   " PRIMARY KEY ( idRecensione ))";
        
        stat.executeUpdate(sql);
        
        sql = "CREATE TABLE IF NOT EXISTS comitato " +
                   "(id INTEGER not NULL AUTO_INCREMENT, " +
                   " idUtente INTEGER not NULL, " +
                   " idArticolo INTEGER, " + 
                   " idRecensione INTEGER, " + 
                   " PRIMARY KEY ( id ))";
        
        stat.executeUpdate(sql);
        
        sql = "CREATE TABLE IF NOT EXISTS autori " +
                   "(id INTEGER not NULL AUTO_INCREMENT, " +
                   " idUtente INTEGER, " +
                   " idArticolo INTEGER, " +
                   " PRIMARY KEY ( id ))";
        
        stat.executeUpdate(sql);
        
        sql = "CREATE TABLE IF NOT EXISTS notifiche " +
                   "(id INTEGER not NULL AUTO_INCREMENT,  " +
                   " idConferenza INTEGER, " +
                   " idUtente INTEGER, " +
                   " idArticolo INTEGER, " +
                   " descrizione VARCHAR(255), " +
                   " data DATE, " +
                   " PRIMARY KEY ( id ))";
        
        stat.executeUpdate(sql);
    }
   
}
