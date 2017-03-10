/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conferencemanagementsystem;


/**
 *
 * @author salvatore
 */
public class MainClass {
    static public UtenteClass utente = new UtenteClass();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       DataBaseManagement db = new DataBaseManagement();
      // db.startDBConnection();
       
        //All'apertura viene caricato lo StartFrame
       StartFrame startF = new StartFrame(new javax.swing.JFrame(), true);
       startF.setVisible(true);
       
       
       
    }

    
}
