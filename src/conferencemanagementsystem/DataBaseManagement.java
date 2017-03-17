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
public class DataBaseManagement {
    private static final String db_username = "root";
    private static final String db_password = "";
    private static final String db_connection_options = "jdbc:mysql://localhost:3306/cms";
    
    private Connection con = null;
    
    DataBaseManagement () {
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
    
    public boolean inviaQuery (String query)  {
        
        if (con != null) {
            try {
                Statement stat = con.createStatement();
                stat.execute(query);
                return true;
            } catch (SQLException ex) {
                Logger.getLogger(DataBaseManagement.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }
            
        } else {
            return false;
        }
    }
}
