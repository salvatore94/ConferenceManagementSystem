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
public class ChairFrame extends javax.swing.JFrame {

    /**
     * Creates new form ChairFrame
     */
    public ChairFrame() {
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

        jPanel1 = new javax.swing.JPanel();
        comitatoProgramma = new javax.swing.JButton();
        autoriPaartecipanti = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        listaArticoli = new javax.swing.JButton();
        notificaEsiti = new javax.swing.JButton();
        listaRecensioni = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        comitatoProgramma.setText("Comitato di Programma");
        comitatoProgramma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comitatoProgrammaActionPerformed(evt);
            }
        });

        autoriPaartecipanti.setText("Autori Partecipanti");
        autoriPaartecipanti.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                autoriPaartecipantiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(comitatoProgramma, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(autoriPaartecipanti, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(comitatoProgramma)
                .addGap(18, 18, 18)
                .addComponent(autoriPaartecipanti)
                .addContainerGap())
        );

        listaArticoli.setText("Lista Articoli");
        listaArticoli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listaArticoliActionPerformed(evt);
            }
        });

        notificaEsiti.setText("Notifica Esiti");
        notificaEsiti.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                notificaEsitiActionPerformed(evt);
            }
        });

        listaRecensioni.setText("Lista delle Recensioni");
        listaRecensioni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listaRecensioniActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(listaRecensioni, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(listaArticoli, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 2, Short.MAX_VALUE))
                    .addComponent(notificaEsiti, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(listaArticoli)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(listaRecensioni)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(notificaEsiti)
                .addGap(43, 43, 43))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(35, 35, 35))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void comitatoProgrammaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comitatoProgrammaActionPerformed
        //Mostro la finestra che permette di gestire tutto ciò che riguarda il Comitato di Programma;
       Chair_ComitatoDiProgrammaFrame comitatoF = new Chair_ComitatoDiProgrammaFrame();
       comitatoF.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
       comitatoF.setVisible(true);
    }//GEN-LAST:event_comitatoProgrammaActionPerformed

    private void autoriPaartecipantiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_autoriPaartecipantiActionPerformed
        Chair_AutoriPartecipantiFrame autori = new Chair_AutoriPartecipantiFrame();
        autori.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        autori.setVisible(true);
    }//GEN-LAST:event_autoriPaartecipantiActionPerformed

    private void listaArticoliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listaArticoliActionPerformed
        Chair_ListaArticoliFrame lista = new Chair_ListaArticoliFrame();
        lista.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        lista.setVisible(true);
    }//GEN-LAST:event_listaArticoliActionPerformed

    private void listaRecensioniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listaRecensioniActionPerformed
       Chair_ListaRecensioniFrame listaR = new Chair_ListaRecensioniFrame();
       listaR.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
       listaR.setVisible(true);
    }//GEN-LAST:event_listaRecensioniActionPerformed

    private void notificaEsitiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_notificaEsitiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_notificaEsitiActionPerformed

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
            java.util.logging.Logger.getLogger(ChairFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChairFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChairFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChairFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ChairFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton autoriPaartecipanti;
    private javax.swing.JButton comitatoProgramma;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton listaArticoli;
    private javax.swing.JButton listaRecensioni;
    private javax.swing.JButton notificaEsiti;
    // End of variables declaration//GEN-END:variables
}
