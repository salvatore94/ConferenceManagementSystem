/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conferencemanagementsystem;

import java.sql.Connection;
import java.sql.SQLException;


/**
 *
 * @author salvatore
 */
public class MainClass {
    static public UtenteClass utente = new UtenteClass();
   
    
    public static void main(String[] args)  {
      /*
        DataBaseManagement db = new DataBaseManagement();
       String query;
        query = "CREATE TABLE IF NOT EXISTS utenti (id INT NOT NULL PRIMARY KEY)";
       db.inviaQuery(query);
      */ 
       //All'apertura viene caricato lo StartFrame
       StartFrame startF = new StartFrame(new javax.swing.JFrame(), true);
       startF.setVisible(true);
       
       
       
    }

    
}
