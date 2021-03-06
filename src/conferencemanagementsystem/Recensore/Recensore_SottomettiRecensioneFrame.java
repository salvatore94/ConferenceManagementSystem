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
import conferencemanagementsystem.Utils.NotificaClass;
import conferencemanagementsystem.Utils.RecensioneClass;
import static conferencemanagementsystem.MainClass.conferenza;
import static conferencemanagementsystem.MainClass.db;
import static conferencemanagementsystem.MainClass.scadutaReview;
import static conferencemanagementsystem.MainClass.utente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
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
public class Recensore_SottomettiRecensioneFrame extends javax.swing.JFrame {

    /**
     * Creates new form Recensore_SottomettiRecensioneFrame
     */
    public Recensore_SottomettiRecensioneFrame() {
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
                if(result.getInt("idRecensione") == 0 ) {
                    ArticoloClass articolo = new ArticoloClass();
                    articolo.setIdArticolo(result.getInt("idArticolo"));

                    articoli.add(articolo);
                }
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        criterio1 = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        criterio2 = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        criterio3 = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        commentoPrivatoField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        commentoField = new javax.swing.JTextField();
        sottometti = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        competenza = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Lista Articoli");

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID Articolo", "Titolo", "Tema"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
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
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Voto");

        jLabel3.setText("Esposizione Contenuto");

        criterio1.setMaximumRowCount(5);
        criterio1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5" }));

        jLabel4.setText("Originalità Argomento");

        criterio2.setMaximumRowCount(5);
        criterio2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5" }));

        jLabel5.setText("Qualità ricerca");

        criterio3.setMaximumRowCount(5);
        criterio3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5" }));

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Commento");

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Commento per la Commissione");

        sottometti.setText("Sottometti Recensione");
        sottometti.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sottomettiActionPerformed(evt);
            }
        });

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Competenza sul tema dell'articolo");

        competenza.setMaximumRowCount(5);
        competenza.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(sottometti, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(commentoPrivatoField, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(commentoField)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(criterio3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(competenza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(4, 4, 4)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(criterio1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(criterio2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(0, 3, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(criterio1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(criterio2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(criterio3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(commentoField, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(commentoPrivatoField, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(competenza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(55, 55, 55)
                .addComponent(sottometti, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(10, 10, 10))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void sottomettiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sottomettiActionPerformed
        int row = table.getSelectedRow();
        if (row != -1) {
          if (LocalDate.now().isAfter(conferenza.getScadenzaReview())) {
            creaJDialog("Errore", "Scaduta finestra di Sottomissione Recensione");
            this.dispose();
           
            RecensoreFrame recensore = new RecensoreFrame();
            recensore.setDefaultCloseOperation(EXIT_ON_CLOSE);
            recensore.setVisible(true);
            
            } else {
              
            int idarticolo = (int) table.getValueAt(row, 0);
            int voto1 = criterio1.getSelectedIndex() + 1;
            int voto2 = criterio2.getSelectedIndex() + 1;
            int voto3 = criterio3.getSelectedIndex() + 1;
        
            double voto = (voto1 + voto2 + voto3) / 2 ;
            
            int competenzaRecensore = competenza.getSelectedIndex() + 1;
            
            voto = voto * competenzaRecensore;
        
            String commento = commentoField.getText().trim();
            String commentoPrivato = commentoPrivatoField.getText().trim();
        
            RecensioneClass recensione = new RecensioneClass();
            recensione.setIdArticolo(idarticolo);
            recensione.setIdRecensore(utente.getId());
            recensione.setVotazione(voto);
            recensione.setCommento(commento);
            recensione.setCommentoRiservato(commentoPrivato);
            
            if (esisteRecensione(recensione.getIdRecensore(), recensione.getIdArticolo()) == false) {
           String sql = "INSERT INTO recensioni (idArticolo, idRecensore, votazione, commento, commentoRiservato) VALUES (?, ?, ?, ?, ?)";
           PreparedStatement stat;
            try {
                stat = db.getDBConnection().prepareStatement(sql);
                stat.setInt(1, recensione.getIdArticolo());
                stat.setInt(2, recensione.getIdRecensore());
                stat.setDouble(3, recensione.getVotazione());
                stat.setString(4, recensione.getCommento());
                stat.setString(5, recensione.getCommentoRiservato());
                
                stat.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(Recensore_SottomettiRecensioneFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            sql = "SELECT * FROM recensioni WHERE idArticolo = ? AND idRecensore = ?";
            PreparedStatement stat1;
            try {
                stat1 = db.getDBConnection().prepareStatement(sql);
                stat1.setInt(1, recensione.getIdArticolo());
                stat1.setInt(2, recensione.getIdRecensore());
                
                ResultSet result = stat1.executeQuery();
                while (result.next()) {
                    recensione.setIdRecensione(result.getInt("idRecensione"));
                    
                    sql = "UPDATE comitato SET idRecensione = ? WHERE idUtente = ? AND idArticolo = ?";
                    PreparedStatement stat2;
                    stat2 = db.getDBConnection().prepareStatement(sql);
                    stat2.setInt(1, recensione.getIdRecensione());
                    stat2.setInt(2, recensione.getIdRecensore());
                    stat2.setInt(3, recensione.getIdArticolo());
                    
                    stat2.executeUpdate();
                }
            } catch (SQLException ex) {
                Logger.getLogger(Recensore_SottomettiRecensioneFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
            
          String descrizione = "Recensione articolo sottomessa";
          NotificaClass notifica = new NotificaClass(conferenza.getId(), utente.getId(), idarticolo, descrizione);
               
          sql = "INSERT INTO notifiche (idConferenza, idUtente, idArticolo, descrizione, data) VALUES (?, ?, ?, ?, ?)";
          
          try {
                    stat = db.getDBConnection().prepareStatement(sql);
                    stat.setInt(1, notifica.getIdConferenza());
                    stat.setInt(2, notifica.getIdUtente());
                    stat.setInt(3, recensione.getIdArticolo());
                    stat.setString(4, notifica.getDescrizione());
                    stat.setObject(5, notifica.getData());
            
                    stat.executeUpdate();
                } catch (SQLException ex) {
                    Logger.getLogger(Autore_IscrizioneConferenzaFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
          
          creaJDialog("Successo", "Recensione Sottomessa");
          this.dispose();
            } else {
                // esiste già una recensione
                creaJDialog("Errore", "Recensione già sottomessa");
            }
          }
        } else {
            creaJDialog("Errore", "Seleziona la riga corrispondente all'articolo");
        }
    }//GEN-LAST:event_sottomettiActionPerformed
    
    private boolean esisteRecensione (int idRecensore, int idArticolo) {
        boolean test = false;
        String sql = "SELECT * FROM recensioni WHERE idArticolo = ? AND idRecensore = ?";
        PreparedStatement stat;
        try {
            stat = db.getDBConnection().prepareStatement(sql);
            stat.setInt(1, idArticolo);
            stat.setInt(2, idRecensore);
            
            ResultSet result = stat.executeQuery();
            if (result.next()) {
                test = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Recensore_SottomettiRecensioneFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

        
        return test;
    }
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
            java.util.logging.Logger.getLogger(Recensore_SottomettiRecensioneFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Recensore_SottomettiRecensioneFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Recensore_SottomettiRecensioneFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Recensore_SottomettiRecensioneFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Recensore_SottomettiRecensioneFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField commentoField;
    private javax.swing.JTextField commentoPrivatoField;
    private javax.swing.JComboBox<String> competenza;
    private javax.swing.JComboBox<String> criterio1;
    private javax.swing.JComboBox<String> criterio2;
    private javax.swing.JComboBox<String> criterio3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton sottometti;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
