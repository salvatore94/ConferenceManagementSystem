/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conferencemanagementsystem.Recensore;

import conferencemanagementsystem.Utils.ArticoloClass;
import conferencemanagementsystem.Autore.Autore_SottomettiRivistoFrame;
import conferencemanagementsystem.Autore.Autore_IscrizioneConferenzaFrame;
import conferencemanagementsystem.Chair.Chair_ListaArticoliFrame;
import conferencemanagementsystem.Utils.EmailClass;
import conferencemanagementsystem.Utils.NotificaClass;
import static conferencemanagementsystem.MainClass.conferenza;
import static conferencemanagementsystem.MainClass.db;
import static conferencemanagementsystem.MainClass.utente;
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
public class Recensore_InvitaSottoRecensoreFrame extends javax.swing.JFrame {

    /**
     * Creates new form Recensore_InvitaSottoRecensore
     */
    public Recensore_InvitaSottoRecensoreFrame() {
        initComponents();
        preparaTabella();
    }

    private void preparaTabella() {
        Object [] colonne = {"ID Articolo", "Titolo", "Tema", "File"};        
        Object [] row = new Object[4];
        
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(colonne);
        
       String sql = "SELECT * FROM comitato WHERE idUtente = ?";
       
       PreparedStatement stat;
       ArrayList<ArticoloClass> articoli = new ArrayList<ArticoloClass>();
        try {
            stat = db.getDBConnection().prepareStatement(sql);
            stat.setInt(1, utente.getId());
            ResultSet result = stat.executeQuery();

            
            while(result.next()){
                ArticoloClass articolo = new ArticoloClass();
                articolo.setIdArticolo(result.getInt("idArticolo"));

                articoli.add(articolo);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Autore_SottomettiRivistoFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        for (int i=0; i < articoli.size(); i++) {
            sql = "SELECT * FROM articoli WHERE idArticolo = ?";
            PreparedStatement stat_articolo;
            try {
                stat_articolo = db.getDBConnection().prepareStatement(sql);
                stat_articolo.setInt(1, articoli.get(i).getIdArticolo());
                ResultSet result_articolo = stat_articolo.executeQuery();
                
                while (result_articolo.next()){
                    articoli.get(i).setTitolo(result_articolo.getString("titolo"));
                    articoli.get(i).setTema(result_articolo.getString("tema"));
                    articoli.get(i).setFile(result_articolo.getString("file"));
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(Chair_ListaArticoliFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            if(articoli.get(i).getIdArticolo() > 0) {
                //altrimenti spunta una riga vuota 
                
                row[0] = articoli.get(i).getIdArticolo();
                row[1] = articoli.get(i).getTitolo();
                row[2] = articoli.get(i).getTema();
                row[3] = articoli.get(i).getFile();
            
                model.addRow(row);
            }
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

        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        labl = new javax.swing.JLabel();
        emailTextField = new javax.swing.JTextField();
        invita = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID Articolo", "Titolo", "Tema", "FILE"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
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

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Lista Articoli");

        labl.setText("Email");

        invita.setText("Invita");
        invita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                invitaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(labl, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(emailTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(220, 220, 220)
                        .addComponent(invita, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labl, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(emailTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(invita, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addGap(10, 10, 10))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void invitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_invitaActionPerformed
        String emailDestinatario = emailTextField.getText().toString().trim();
        int row = table.getSelectedRow();
       if (row != -1) {
           int idarticolo = (int) table.getValueAt(row, 0);
           
           //Genera Notifica per il CHAIR
           String descrizione = "Invitato Sottorecensore: " + emailDestinatario ;
           NotificaClass notifica = new NotificaClass(conferenza.getId(), utente.getId(), idarticolo, descrizione);
               
           String sql = "INSERT INTO notifiche (idConferenza, idUtente, descrizione, data) VALUES (?, ?, ?, ?)";
           
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
           
           //Manda email
           String oggetto = "Invito a far parte del Comitato di Programma della conferenza: " + conferenza.getNome();
           String  corpo = "Titolo Articolo da Recensire: ";
           EmailClass email = new EmailClass(utente.getEmail(), emailDestinatario,  oggetto, corpo);
           //email.inviaEmail();
           
           creaJDialog("Successo", "SottoRecensore invitato");
       } else {
           creaJDialog("Errore", "Seleziona la riga corrispondente all'articolo");
       }
    }//GEN-LAST:event_invitaActionPerformed

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
            java.util.logging.Logger.getLogger(Recensore_InvitaSottoRecensoreFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Recensore_InvitaSottoRecensoreFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Recensore_InvitaSottoRecensoreFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Recensore_InvitaSottoRecensoreFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Recensore_InvitaSottoRecensoreFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField emailTextField;
    private javax.swing.JButton invita;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labl;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
