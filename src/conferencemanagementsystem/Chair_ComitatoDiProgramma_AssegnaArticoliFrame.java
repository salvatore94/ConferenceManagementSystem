/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conferencemanagementsystem;

import static conferencemanagementsystem.MainClass.conferenza;
import static conferencemanagementsystem.MainClass.db;
import static conferencemanagementsystem.MainClass.scadutaSottomissione;
import java.sql.*;
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
public class Chair_ComitatoDiProgramma_AssegnaArticoliFrame extends javax.swing.JFrame {

    /**
     * Creates new form Chair_ComitatoDiProgramma_AssegnaArticoliFrame
     */
    public Chair_ComitatoDiProgramma_AssegnaArticoliFrame() {
        initComponents();
        preparaTabellaRecensori();
        preparaTabellaArticoli();
        
        if (scadutaSottomissione == false) {
            assegna.setEnabled(false);
        }
    }
    
    private void preparaTabellaRecensori() {
        Object [] colonne = {"ID Recensore", "Nome", "Cognome", "Email"};        
        Object [] row = new Object[4];
        
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(colonne);
        
        String sql = "SELECT DISTINCT idUtente FROM comitato";
       
       PreparedStatement stat;
       ArrayList<UtenteClass> recensori = new ArrayList<UtenteClass>();
        try {
            stat = db.getDBConnection().prepareStatement(sql);
            
            ResultSet result = stat.executeQuery();

            while(result.next()){
                UtenteClass recensore = new UtenteClass();
                recensore.setId(result.getInt("idUtente"));

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
            row[0] = recensori.get(i).getId();
            row[1] = recensori.get(i).getNome();
            row[2] = recensori.get(i).getCognome();
            row[3] = recensori.get(i).getEmail();
            
            model.addRow(row);
         }
        
       tableRecensori.setModel(model);
    }
    
        private void preparaTabellaArticoli() {
        Object [] colonne = {"ID Articolo", "Titolo", "Tema", "Nome Autore"};        
        Object [] row = new Object[4];
        
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(colonne);
        
       String sql = "SELECT * FROM articoli";
       
       PreparedStatement stat;
       ArrayList<ArticoloClass> articoli = new ArrayList<ArticoloClass>();
        try {
            stat = db.getDBConnection().prepareStatement(sql);
            
            ResultSet result = stat.executeQuery();

            
            while(result.next()){
                ArticoloClass articolo = new ArticoloClass();
                articolo.setIdArticolo(result.getInt("idArticolo"));
                articolo.setIdAutore(result.getInt("idUtente"));
                articolo.setTitolo(result.getString("titolo"));
                articolo.setTema(result.getString("tema"));
                articolo.setFile(result.getString("file"));
                articolo.setFile_rivisto(result.getString("file_rivisto"));
                articolo.setAmmesso(result.getBoolean("ammesso"));

                articoli.add(articolo);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Autore_SottomettiRivistoFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        for (int i=0; i < articoli.size(); i++) {
            sql = "SELECT * FROM utenti WHERE idUtente = ?";
            PreparedStatement stat_utente;
            try {
                stat_utente = db.getDBConnection().prepareStatement(sql);
                stat_utente.setInt(1, articoli.get(i).getIdAutore());
                ResultSet result_utente = stat_utente.executeQuery();
                
                while (result_utente.next()){
                    row[3] = result_utente.getString("nome") + " " + result_utente.getString("cognome");
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(Chair_ListaArticoliFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            row[0] = articoli.get(i).getIdArticolo();
            row[1] = articoli.get(i).getTitolo();
            row[2] = articoli.get(i).getTema();

            
            model.addRow(row);
         }
        
       tableArticoli.setModel(model);

    }
        
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        idRecensoreField = new javax.swing.JTextField();
        idArticoloField = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableRecensori = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableArticoli = new javax.swing.JTable();
        assegna = new javax.swing.JButton();

        jLabel3.setText("ID recensore");

        jLabel4.setText("ID articolo");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(idRecensoreField)
                    .addComponent(idArticoloField, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
                .addGap(161, 161, 161))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(idRecensoreField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(idArticoloField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Lista Recensori");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Lista Articoli");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );

        tableRecensori.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID recensore", "Nome", "Cognome", "Email"
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
        jScrollPane1.setViewportView(tableRecensori);
        if (tableRecensori.getColumnModel().getColumnCount() > 0) {
            tableRecensori.getColumnModel().getColumn(0).setResizable(false);
            tableRecensori.getColumnModel().getColumn(1).setResizable(false);
            tableRecensori.getColumnModel().getColumn(2).setResizable(false);
            tableRecensori.getColumnModel().getColumn(3).setResizable(false);
        }

        tableArticoli.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID articolo", "Titolo", "Tema", "Nome Autore"
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
        jScrollPane2.setViewportView(tableArticoli);
        if (tableArticoli.getColumnModel().getColumnCount() > 0) {
            tableArticoli.getColumnModel().getColumn(0).setResizable(false);
            tableArticoli.getColumnModel().getColumn(1).setResizable(false);
            tableArticoli.getColumnModel().getColumn(2).setResizable(false);
            tableArticoli.getColumnModel().getColumn(3).setResizable(false);
        }

        assegna.setText("Assegna");
        assegna.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assegnaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(68, 68, 68)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(assegna, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(289, 289, 289))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 309, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(assegna, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void assegnaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_assegnaActionPerformed
       
  if (LocalDate.now().isAfter(conferenza.getScadenzaSottomissioneArticoli())) {      
       int row1 = tableRecensori.getSelectedRow();
       int row2 = tableArticoli.getSelectedRow();
       
    if (row1 != -1 && row2 != -1) {     
        int idRecensore = (int) tableRecensori.getValueAt(row1, 0);
        int idArticolo = (int) tableArticoli.getValueAt(row2, 0);
        
        if (recensoreAutore(idRecensore, idArticolo) == true) {
            creaJDialog("Errore", "Articolo scritto dallo stesso recensore");
        }
        else if(haGiaArticoli(idRecensore) == false ) {
                String sql = "UPDATE comitato SET idArticolo = ? WHERE idUtente = ?";
                PreparedStatement stat;
                try {
                    stat = db.getDBConnection().prepareStatement(sql);
                    stat.setInt(1, idArticolo);
                    stat.setInt(2, idRecensore);
                
                    stat.executeUpdate();
                    creaJDialog("Successo", "Articolo Assegnato");
                } catch (SQLException ex) {
                    Logger.getLogger(Chair_ComitatoDiProgramma_AssegnaArticoliFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
        
        
            } else  {
                String sql = "INSERT INTO comitato (idUtente, idArticolo) VALUES (?, ?)";
                PreparedStatement stat;
                try {
                   stat = db.getDBConnection().prepareStatement(sql);
                   stat.setInt(1, idRecensore);
                   stat.setInt(2, idArticolo);
            
                   stat.executeUpdate();
                   creaJDialog("Successo", "Articolo Assegnato");
                } catch (SQLException ex) {
                     Logger.getLogger(Chair_ComitatoDiProgramma_AssegnaArticoliFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        
    } else {
         creaJDialog("Errore", "Selezionare il recensore e l'articolo"); 
    }
    
  } else {
      // dovrebbe ricreare la finestra
  }

    }//GEN-LAST:event_assegnaActionPerformed
    private boolean haGiaArticoli(int idRecensore) {
        boolean test = false;
        String sql = "SELECT * FROM comitato WHERE idUtente = ?";
        PreparedStatement stat1;
           try {
               stat1 = db.getDBConnection().prepareStatement(sql);
               stat1.setInt(1, idRecensore);
               ResultSet result1 = stat1.executeQuery();
               while(result1.next()) {
                   if(result1.getInt("idArticolo") > 0) {
                       //ha già un articolo
                       test = true;
                   }
               }
           } catch (SQLException ex) {
               Logger.getLogger(Chair_ComitatoDiProgramma_AssegnaArticoliFrame.class.getName()).log(Level.SEVERE, null, ex);
           }
           
           return test;
    }
    
    private boolean haGiaLoStessoArticolo(int idRecensore, int idArticolo) {
        boolean test = false;
        String sql = "SELECT * FROM comitato WHERE idUtente = ? AND idArticolo = ?";
        PreparedStatement stat;
           try {
               stat = db.getDBConnection().prepareStatement(sql);
               stat.setInt(1, idRecensore);
               stat.setInt(2, idArticolo);
               ResultSet result = stat.executeQuery();
               while(result.next()) {
                       //ha già un articolo
                       test = true;
               }
           } catch (SQLException ex) {
               Logger.getLogger(Chair_ComitatoDiProgramma_AssegnaArticoliFrame.class.getName()).log(Level.SEVERE, null, ex);
           }
           
           return test;
    }
    
    private boolean recensoreAutore(int idRecensore, int idArticolo) {
        boolean test = false;
        
        String sql = "SELECT * FROM autori WHERE idArticolo = ?";
        PreparedStatement stat;
        try {
            stat = db.getDBConnection().prepareCall(sql);
            stat.setInt(1, idArticolo);
            
            ResultSet result = stat.executeQuery();
            while (result.next()) {
                if(result.getInt("idUtente") == idRecensore) {
                    test = true;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Chair_ComitatoDiProgramma_AssegnaArticoliFrame.class.getName()).log(Level.SEVERE, null, ex);
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
            java.util.logging.Logger.getLogger(Chair_ComitatoDiProgramma_AssegnaArticoliFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Chair_ComitatoDiProgramma_AssegnaArticoliFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Chair_ComitatoDiProgramma_AssegnaArticoliFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Chair_ComitatoDiProgramma_AssegnaArticoliFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Chair_ComitatoDiProgramma_AssegnaArticoliFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton assegna;
    private javax.swing.JTextField idArticoloField;
    private javax.swing.JTextField idRecensoreField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tableArticoli;
    private javax.swing.JTable tableRecensori;
    // End of variables declaration//GEN-END:variables
}
