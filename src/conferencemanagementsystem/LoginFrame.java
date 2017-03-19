/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conferencemanagementsystem;

import conferencemanagementsystem.MainClass;
import static conferencemanagementsystem.MainClass.conferenza;
import static conferencemanagementsystem.MainClass.db;
import static conferencemanagementsystem.MainClass.utente;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.*;
import java.time.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JLabel;

/**
 *
 * @author salvatore
 */
public class LoginFrame extends javax.swing.JFrame {

    /**
     * Creates new form LoginFrame
     */
    public LoginFrame() {
        initComponents();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        loginLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        emailField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        passwordField = new javax.swing.JPasswordField();
        loginButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        loginLabel.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        loginLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        loginLabel.setText("Login");
        loginLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel1.setText("Email");

        jLabel2.setText("Password");

        loginButton.setText("Login");
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(loginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(loginLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(emailField)
                                .addComponent(passwordField, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)))))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(loginLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addComponent(loginButton)
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed
        String email = emailField.getText().trim();
        char[] passwordArray = passwordField.getPassword();
        
        String password = new String (passwordArray);
        
                
        if (email.isEmpty() || password.isEmpty()) {
            creaJDialog("Errore", "Riempire tutti i campi");
        } else {
        //Controllo se i dati inseriti esistono nel db
        //MainClass.db.inviaQuery("");
        
        String sql = "SELECT * FROM utenti WHERE email = ? AND password = ?";
            try {
                PreparedStatement stat = db.getDBConnection().prepareStatement(sql);
                stat.setString(1, email);
                stat.setString(2, password);
                
                ResultSet result = stat.executeQuery();
                if (result.next()) {
                    utente.setId(result.getInt("idUtente"));
                    utente.setNome(result.getString("nome"));
                    utente.setCognome(result.getString("cognome"));
                    utente.setEmail(result.getString("email"));
                    if (esisteConferenza()) {
                        switch (controllaIdentita(utente.getId())) {
                            case 0:
                                //utente non iscritto alla conferenza
                                Autore_IscrizioneConferenzaFrame n = new Autore_IscrizioneConferenzaFrame();
                                n.setDefaultCloseOperation(EXIT_ON_CLOSE);
                                n.setVisible(true);
                                break;
                            case 1:
                                //chair
                                ChairFrame chair = new ChairFrame();
                                chair.setDefaultCloseOperation(EXIT_ON_CLOSE);
                                chair.setVisible(true);
                                break;
                            case 2:
                                //membro del comitato
                                RecensoreFrame recensore = new RecensoreFrame();
                                recensore.setDefaultCloseOperation(EXIT_ON_CLOSE);
                                recensore.setVisible(true);
                                break;
                            case 3:
                                //autore
                                AutoreFrame autore = new AutoreFrame();
                                autore.setDefaultCloseOperation(EXIT_ON_CLOSE);
                                autore.setVisible(true);
                                break;
                        }
                    } else {
                        //non esiste una conferenza
                        CreaConferenzaFrame conferenza = new CreaConferenzaFrame();
                        conferenza.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                        conferenza.setVisible(true);
                    }
                  this.dispose();                
                } else {
                    creaJDialog("Errore", "I dati non corrispondono");
                }
            } catch (SQLException ex) {
                Logger.getLogger(LoginFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
        }

        
    }//GEN-LAST:event_loginButtonActionPerformed

    private void creaJDialog(String title, String mess) {
        JDialog err = new JDialog(this, title, true);
          err.add(new JLabel(mess));
          err.addWindowListener(new WindowAdapter () {
            @Override
              public void windowClosing (WindowEvent e) {
                pulisciField();
            }
            });
          err.setSize(250, 150);
          err.setVisible(true);
    }
    
    public int controllaIdentita(int id){
        int ruolo = 0;  //0 è un utente, 1 è il chair, 2 è un membro del comitato, 3 è un autore
        String sql;
        PreparedStatement stat;
        
        
        sql = "SELECT * FROM conferenza WHERE idChair = ?";
        try {
            stat = db.getDBConnection().prepareStatement(sql);
            stat.setInt(1, id);
            ResultSet result = stat.executeQuery();
            
            if (result.next()) {
                    //è il chair
                   ruolo = 1;                  
                }
            
        } catch (SQLException ex) {
            Logger.getLogger(LoginFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        sql = "SELECT * FROM autori WHERE idUtente = ?";
        try {
            stat = db.getDBConnection().prepareStatement(sql);
            stat.setInt(1, id);
            ResultSet result = stat.executeQuery();
            
            if (result.next()) {
                    //è un autore 
                   ruolo = 3;                  
                }
            
        } catch (SQLException ex) {
            Logger.getLogger(LoginFrame.class.getName()).log(Level.SEVERE, null, ex);
        }             
        
        sql = "SELECT * FROM comitato WHERE idUtente = ?";
        try {
            stat = db.getDBConnection().prepareStatement(sql);
            stat.setInt(1, id);
            ResultSet result = stat.executeQuery();
            
            if (result.next()) {
                    //è un membro del comitato
                   ruolo = 2;                  
                }
            
        } catch (SQLException ex) {
            Logger.getLogger(LoginFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // è un utente semplice
        return ruolo;
    }
    
    public boolean esisteConferenza() {
        String sql = "SELECT * FROM conferenza";
        Statement stat;
        try {
            stat = db.getDBConnection().createStatement();
            ResultSet result = stat.executeQuery(sql);
            
            if (result.next()) {
            conferenza.setIdChair(result.getInt("idChair"));
            conferenza.setNome(result.getString("nome"));
            conferenza.setTema(result.getString("tema"));
            conferenza.setNumeroArticoli(result.getInt("numeroArticoli"));
            conferenza.setInizo(result.getObject("inizio", LocalDate.class));
            conferenza.setFine(result.getObject("fine", LocalDate.class));
            conferenza.setScadenzaSottomissioneArticoli(result.getObject("scadenzaSottomissione", LocalDate.class));
            conferenza.setScadenzaReview(result.getObject("scadenzaReview", LocalDate.class));
            conferenza.setScadenzaSottomissioneCorretti(result.getObject("scadenzaSottomissioneRivisti", LocalDate.class));
            
            return true;
        }
        } catch (SQLException ex) {
            Logger.getLogger(LoginFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
    
    private void pulisciField() {
        emailField.setText("");
        passwordField.setText("");
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField emailField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton loginButton;
    private javax.swing.JLabel loginLabel;
    private javax.swing.JPasswordField passwordField;
    // End of variables declaration//GEN-END:variables
}
