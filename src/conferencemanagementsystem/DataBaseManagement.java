/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conferencemanagementsystem;

import java.sql.*;

/**
 *
 * @author salvatore
 */
public class DataBaseManagement {
    private static final String db_username = "root";
    private static final String db_password = "";
    private static final String db_connection_options = "jdbc:mysql://localhost:3306/cms";
    
    public void startDBConnection() {
        Connection con = null;
        try {
            con = DriverManager.getConnection(db_connection_options, db_username, db_password);
            System.out.println("Connesso al db");
        } catch (SQLException e) {
            System.err.println(e);
        }
        
    }
}
