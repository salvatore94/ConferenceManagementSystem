/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conferencemanagementsystem.Chair;

import conferencemanagementsystem.Autore.Autore_SottomettiRivistoFrame;
import conferencemanagementsystem.Utils.UtenteClass;
import static conferencemanagementsystem.MainClass.db;
import static conferencemanagementsystem.MainClass.scadutaReview;
import static conferencemanagementsystem.MainClass.scadutaSottomissione;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author salvatore
 */
public class Chair_ComitatoDiProgrammaFrame extends javax.swing.JFrame {

    /**
     * Creates new form Chair_ComitatoDiProgrammaFrame
     */
    public Chair_ComitatoDiProgrammaFrame() {
        initComponents();
        preparaTabella();
        if (scadutaReview == true) {
            invita.setEnabled(false);
            rimuovi.setEnabled(false);
            assegna.setEnabled(false);
        }
        if (scadutaSottomissione == false) {
            assegna.setEnabled(false);
        }
    }
    
     private void preparaTabella() {
        Object [] colonne = { "Nome", "Cognome", "Email", "ID Articolo"};        
        Object [] row = new Object[4];
        
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(colonne);
        
       String sql = "SELECT * FROM comitato";
       
       PreparedStatement stat;
       ArrayList<UtenteClass> recensori = new ArrayList<UtenteClass>();
        try {
            stat = db.getDBConnection().prepareStatement(sql);
            
            ResultSet result = stat.executeQuery();

            while(result.next()){
                UtenteClass recensore = new UtenteClass();
                recensore.setId(result.getInt("idUtente"));
                if (result.getInt("idArticolo") > 0) {
                    row[3]= result.getInt("idArticolo");
                }
                recensori.add(recensore);

            }
        } catch (SQLException ex) {
            Logger.getLogger(Autore_SottomettiRivistoFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        for (int i=0; i < recensori.size(); i++) {
            sql = "SELECT * FROM utenti WHERE idUtente = ?";
            PreparedStatement stat_utente;
            try {
                stat_utente = db.getDBConnection().prepareStatement(sql);
                stat_utente.setInt(1, recensori.get(i).getId());
                ResultSet result_utente = stat_utente.executeQuery();
                
                while (result_utente.next()){
                    recensori.get(i).setNome(result_utente.getString("nome"));
                    recensori.get(i).setCognome(result_utente.getString("cognome"));
                    recensori.get(i).setEmail(result_utente.getString("email"));
                }
            } catch (SQLException ex) {
                Logger.getLogger(Chair_ListaArticoliFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            row[0] = recensori.get(i).getNome();
            row[1] = recensori.get(i).getCognome();
            row[2] = recensori.get(i).getEmail();
            
            model.addRow(row);
         }
        
       table.setModel(model);

    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        invita = new javax.swing.JButton();
        rimuovi = new javax.swing.JButton();
        assegna = new javax.swing.JButton();
        inviaEmail = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        invita.setText("Invita");
        invita.setActionCommand("Invita Membro");
        invita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                invitaActionPerformed(evt);
            }
        });

        rimuovi.setText("Rimuovi");
        rimuovi.setToolTipText("");
        rimuovi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rimuoviActionPerformed(evt);
            }
        });

        assegna.setText("Assegna Articoli");
        assegna.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assegnaActionPerformed(evt);
            }
        });

        inviaEmail.setText("Invia Email");
        inviaEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inviaEmailActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(assegna, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                    .addComponent(rimuovi, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(invita, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(inviaEmail, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(invita)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rimuovi)
                .addGap(18, 18, 18)
                .addComponent(assegna)
                .addGap(123, 123, 123)
                .addComponent(inviaEmail))
        );

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nome", "Cognome", "Email", "ID Articolo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
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
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void invitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_invitaActionPerformed
     //Mostro la finestra che mi permette di invitare un utente al comitato
       this.dispose();
       Chair_ComitatoDiProgramma_InvitaMembroFrame invitaF = new Chair_ComitatoDiProgramma_InvitaMembroFrame();
       invitaF.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
       invitaF.setVisible(true);
    }//GEN-LAST:event_invitaActionPerformed

    private void assegnaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_assegnaActionPerformed
     // TODO add your handling code here:
       
       Chair_ComitatoDiProgramma_AssegnaArticoliFrame assegnaF = new Chair_ComitatoDiProgramma_AssegnaArticoliFrame();
       assegnaF.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
       assegnaF.setVisible(true);

    }//GEN-LAST:event_assegnaActionPerformed

    private void rimuoviActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rimuoviActionPerformed

       int row = table.getSelectedRow();
       if (row != -1) {
           String email = (String) table.getValueAt(row, 2);
           String sql = "SELECT * FROM utenti WHERE email = ?";
           PreparedStatement stat;
           
           try {
               stat = db.getDBConnection().prepareStatement(sql);
               stat.setString(1, email);
               
               ResultSet result = stat.executeQuery();
               
               while (result.next()) {
                   int idRecensore = result.getInt("idUtente");
                   
                   sql = "DELETE FROM comitato WHERE idUtente = ?";
                   PreparedStatement stat_del = db.getDBConnection().prepareStatement(sql);
                   stat_del.setInt(1, idRecensore);
                   stat_del.executeUpdate();
               }
           } catch (SQLException ex) {
               Logger.getLogger(Chair_ComitatoDiProgrammaFrame.class.getName()).log(Level.SEVERE, null, ex);
           }
         preparaTabella();
         creaJDialog("Successo", "Utente rimosso dal Comitato di Programma");
       } else {
         creaJDialog("Errore", "Seleziona la riga corrispondente all'utente");
       }
    }//GEN-LAST:event_rimuoviActionPerformed

    private void inviaEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inviaEmailActionPerformed
       int row = table.getSelectedRow();
       if (row != -1) {
           String emailDestinatario = (String) table.getValueAt(row, 2);
           
           Chair_ComitatoDiProgramma_InviaEmailFrame inviaF = new Chair_ComitatoDiProgramma_InviaEmailFrame();
           inviaF.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
           inviaF.setDestinatario(emailDestinatario);
           inviaF.setDestinatarioLabel(emailDestinatario);
           inviaF.setVisible(true);
         
       } else {
         creaJDialog("Errore", "Seleziona la riga corrispondente all'utente");
       }
        
    }//GEN-LAST:event_inviaEmailActionPerformed
    
    private void creaJDialog(String title, String mess) {
        JDialog err = new JDialog(this, title, true);
          err.add(new JLabel(mess));
          
          err.setSize(250, 150);
          err.setVisible(true);
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
            java.util.logging.Logger.getLogger(Chair_ComitatoDiProgrammaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Chair_ComitatoDiProgrammaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Chair_ComitatoDiProgrammaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Chair_ComitatoDiProgrammaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Chair_ComitatoDiProgrammaFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton assegna;
    private javax.swing.JButton inviaEmail;
    private javax.swing.JButton invita;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton rimuovi;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
