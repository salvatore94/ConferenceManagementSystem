/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conferencemanagementsystem.Autore;

import conferencemanagementsystem.Utils.EmailClass;
import conferencemanagementsystem.Utils.NotificaClass;
//import static com.sun.xml.internal.fastinfoset.alphabet.BuiltInRestrictedAlphabets.table;
import static conferencemanagementsystem.MainClass.conferenza;
import static conferencemanagementsystem.MainClass.db;
import static conferencemanagementsystem.MainClass.scadutaIscrizione;
import static conferencemanagementsystem.MainClass.utente;
import java.sql.*;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.table.*;

/**
 *
 * @author salvatore
 */
public class Autore_IscrizioneConferenzaFrame extends javax.swing.JFrame {

    /**
     * Creates new form AutoreForm
     */
    public Autore_IscrizioneConferenzaFrame() {
        initComponents();
        preparaTabella();
        
        if(scadutaIscrizione) {
            partecipa.setEnabled(false);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        partecipa = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Lista delle conferenze attive");

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Nome", "Tema", "Chair", "Data inizio", "Scadenza sottomissione"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(table);
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(0).setResizable(false);
            table.getColumnModel().getColumn(1).setResizable(false);
            table.getColumnModel().getColumn(2).setResizable(false);
            table.getColumnModel().getColumn(3).setResizable(false);
            table.getColumnModel().getColumn(4).setResizable(false);
        }

        partecipa.setText("Partecipa");
        partecipa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                partecipaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 591, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(partecipa, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(partecipa)
                .addGap(10, 10, 10))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void partecipaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_partecipaActionPerformed
        if (LocalDate.now().isAfter(conferenza.getScadenzaSottomissioneArticoli())) {
           creaJDialog("Errore", "Conferenza iniziata");
           
        } else {
        //query al db per aggiungere l'utente alla conferenza
        String sql = "INSERT INTO autori (idUtente) " +
                     " values (?)";
       
        try {
            PreparedStatement stat = db.getDBConnection().prepareStatement(sql);
            stat.setInt(1, utente.getId());
            stat.execute();
        } catch (SQLException ex) {
            Logger.getLogger(Autore_IscrizioneConferenzaFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
      
       String descrizione = "Iscrizione come Autore";
       NotificaClass notifica = new NotificaClass(conferenza.getId(), utente.getId(), descrizione);
        
       sql = "INSERT INTO notifiche (idConferenza, idUtente, descrizione, data) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement stat = db.getDBConnection().prepareStatement(sql);
            stat.setInt(1, notifica.getIdConferenza());
            stat.setInt(2, notifica.getIdUtente());
            stat.setString(3, notifica.getDescrizione());
            stat.setObject(4, notifica.getData());
            
            stat.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Autore_IscrizioneConferenzaFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
       
       // invia email
       String mittente = ""; 
       String oggetto = "Conferenza " + conferenza.getNome();
       String  corpo = "Iscrizone alla conferenza: " + conferenza.getNome() + " Data inizio: " + conferenza.getInizio() + 
                        " Data Fine: " + conferenza.getFine() + " Data scadenza sottomissione articolo: " + conferenza.getScadenzaSottomissioneArticoli() +
                        " Data scadenza recensione articoli: " + conferenza.getScadenzaReview() + 
                        " Data scadenza sottomissione articoli rivisti: " + conferenza.getScadenzaSottomissioneCorretti();
       
       EmailClass email = new EmailClass(mittente, utente.getEmail(),  oggetto, corpo);
       try {
            email.inviaEmail();
        } catch (MessagingException ex) {
            Logger.getLogger(Autore_SottomettiFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
       
       AutoreFrame autoreF = new AutoreFrame();
       autoreF.setDefaultCloseOperation(EXIT_ON_CLOSE);
       autoreF.setVisible(true);
       this.dispose();
        }
    }//GEN-LAST:event_partecipaActionPerformed
    
    private void creaJDialog(String title, String mess) {
        JDialog err = new JDialog(this, title, true);
          err.add(new JLabel(mess));
          
          err.setSize(250, 150);
          err.setVisible(true);
    }
    
    private void preparaTabella() {
        Object [] colonne = {"idChair", "nome", "tema", "inizio", "fine", "scadenzaSottomissione"};        
        Object [] row = new Object[6];
        
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(colonne);
        
        row[0] = conferenza.getIdChair();
        row[1] = conferenza.getNome();
        row[2] = conferenza.getTema();
        row[3] = conferenza.getInizio();
        row[4] = conferenza.getFine();
        row[5] = conferenza.getScadenzaSottomissioneArticoli();
        
        model.addRow(row);
        table.setModel(model);
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
            java.util.logging.Logger.getLogger(Autore_IscrizioneConferenzaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Autore_IscrizioneConferenzaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Autore_IscrizioneConferenzaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Autore_IscrizioneConferenzaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Autore_IscrizioneConferenzaFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton partecipa;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
