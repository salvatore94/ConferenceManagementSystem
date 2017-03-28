/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conferencemanagementsystem;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author salvatore
 */
public class MainClass {
    static public UtenteClass utente = new UtenteClass();
    static public DataBaseManagement db = new DataBaseManagement();
    static public ConferenzaClass conferenza = new ConferenzaClass();
    
    static boolean scadutaIscrizione = false;
    static boolean scadutaSottomissione = false;
    static boolean scadutaSottomissioneRivisto = false;
    static boolean scadutaReview = false;
    
    public static void main(String[] args)  {
            
            StartFrame startF = new StartFrame(new javax.swing.JFrame(), true);
            startF.setVisible(true);
        try {
            db.creaDB();
        } catch (SQLException ex) {
            Logger.getLogger(MainClass.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    
}
