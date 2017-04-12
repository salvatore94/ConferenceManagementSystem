/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conferencemanagementsystem.Chair;

import conferencemanagementsystem.Autore.Autore_SottomettiRivistoFrame;
import conferencemanagementsystem.Utils.RecensioneClass;
import static conferencemanagementsystem.MainClass.conferenza;
import static conferencemanagementsystem.MainClass.db;
import static conferencemanagementsystem.MainClass.scadutaSottomissioneRivisto;
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
public class Chair_ListaRecensioniFrame extends javax.swing.JFrame {
    
    ArrayList<RecensioneClass> recensioni;
    /**
     * Creates new form Chair_ListaRecensioniFrame
     */
    public Chair_ListaRecensioniFrame() {
        initComponents();
        recensioni = preparaTabella();
    }
    
    
    private ArrayList<RecensioneClass>  preparaTabella() {
        Object [] colonne = {"#", "Recensore", "Titolo Articolo", "ID Articolo", "Votazione", "Commento", "Commento Riservato"};        
        Object [] row = new Object[7];
        
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(colonne);
        
       String sql = "SELECT * FROM recensioni ORDER by votazione DESC";
       
       PreparedStatement stat;
       ArrayList<RecensioneClass> recensioni = new ArrayList<RecensioneClass>();
        try {
            stat = db.getDBConnection().prepareStatement(sql);
            
            ResultSet result = stat.executeQuery();

            while(result.next()){
                RecensioneClass recensione = new RecensioneClass();
                recensione.setIdRecensione(result.getInt("idRecensione"));
                recensione.setIdArticolo(result.getInt("idArticolo"));
                recensione.setIdRecensore(result.getInt("idRecensore"));
                recensione.setVotazione(result.getDouble("Votazione"));
                recensione.setCommento(result.getString("commento"));
                recensione.setCommentoRiservato(result.getString("commentoRiservato"));
                
                recensioni.add(recensione);

            }
        } catch (SQLException ex) {
            Logger.getLogger(Autore_SottomettiRivistoFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        for (int i=0; i < recensioni.size(); i++) {
            sql = "SELECT * FROM articoli WHERE idArticolo = ?";
            PreparedStatement stat_articolo;
            try {
                stat_articolo = db.getDBConnection().prepareStatement(sql);
                stat_articolo.setInt(1, recensioni.get(i).getIdArticolo());
                ResultSet result_articolo = stat_articolo.executeQuery();
                
                while (result_articolo.next()){
                    row[2] = result_articolo.getString("titolo");
                }
            sql = "SELECT * FROM utenti WHERE idUtente = ?";  
            PreparedStatement stat_recensore;
            stat_recensore = db.getDBConnection().prepareStatement(sql);
            stat_recensore.setInt(1, recensioni.get(i).getIdRecensore());
            
            ResultSet result_recensore = stat_recensore.executeQuery();
            while(result_recensore.next()) {
                row[1] = result_recensore.getString("nome") + " " + result_recensore.getString("cognome");
            }
            } catch (SQLException ex) {
                Logger.getLogger(Chair_ListaArticoliFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            row[0] = i + 1;
            
            row[3] = recensioni.get(i).getIdArticolo();
            row[4] = recensioni.get(i).getVotazione();
            row[5] = recensioni.get(i).getCommento();
            row[6] = recensioni.get(i).getCommentoRiservato();
            
            model.addRow(row);
         }
        
       table.setModel(model);
       
       return recensioni;

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
        graduatoria = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Lista delle Recensioni");

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "#", "Recensore", "Titolo Articolo", "ID Articolo", "Votazione", "Commento", "Commento Riservato"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Double.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
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
            table.getColumnModel().getColumn(5).setResizable(false);
            table.getColumnModel().getColumn(6).setResizable(false);
        }

        graduatoria.setText("Graduatoria");
        graduatoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                graduatoriaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(10, 10, 10))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 770, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(graduatoria, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 525, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(graduatoria, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void graduatoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_graduatoriaActionPerformed
        Chair_ListaRecensioni_GraduatoriaFrame graduatoriaF = new Chair_ListaRecensioni_GraduatoriaFrame();
        graduatoriaF.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        graduatoriaF.setVisible(true);
        
        this.dispose();

    }//GEN-LAST:event_graduatoriaActionPerformed
    
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
            java.util.logging.Logger.getLogger(Chair_ListaRecensioniFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Chair_ListaRecensioniFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Chair_ListaRecensioniFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Chair_ListaRecensioniFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Chair_ListaRecensioniFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton graduatoria;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
