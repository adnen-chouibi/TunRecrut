/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.tunRecrut.ui.administrateur;

import com.esprit.tunRecrut.dao.AnnonceDAO;
import com.esprit.tunRecrut.dao.UserDAO;
import com.esprit.tunRecrut.entities.Annonce;
import com.esprit.tunRecrut.entities.User;
import java.util.ArrayList;
import java.util.List;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author app4mob
 */
public class StatistiqueUI extends javax.swing.JFrame {

    DefaultPieDataset dataset;//Dataset qui va contenir les Données
    JFreeChart graphe;        //Graphe
    ChartPanel cp;            //Panel

    /**
     * Creates new form StatistiqueUI
     */
    public StatistiqueUI() {
        initComponents();
        dataset = new DefaultPieDataset();
        List<Annonce> annonces = new ArrayList<Annonce>();
        AnnonceDAO userdao = new AnnonceDAO();
        annonces = userdao.getAllOffre();
        for (Annonce annonce : annonces) {
            dataset.setValue(annonce.getExperience(), annonce.getNbAnnonceByExperience());
        }

        graphe = ChartFactory.createPieChart3D("Statstique des Demmande d'emploi par experience", dataset, true, true, false);

        ChartPanel jPanel1 = new ChartPanel(graphe);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 647, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 596, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addGap(174, 174, 174)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
        );
        pack();
        //  this.add(cp);
        this.setSize(1000, 650);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        gotToCandidat = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        goToEntreprise = new javax.swing.JButton();
        goToCharte = new javax.swing.JButton();
        goToOffre = new javax.swing.JButton();
        goToNewsLettre = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        Logout = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        gotToCandidat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/esprit/tunRecrut/assets/liste-candidat.png"))); // NOI18N
        gotToCandidat.setBorder(null);
        gotToCandidat.setBorderPainted(false);
        gotToCandidat.setContentAreaFilled(false);
        gotToCandidat.setDefaultCapable(false);
        gotToCandidat.setFocusPainted(false);
        gotToCandidat.setFocusable(false);
        gotToCandidat.setRolloverEnabled(false);
        gotToCandidat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gotToCandidatActionPerformed(evt);
            }
        });

        jLabel12.setText("Déconnexion");

        jLabel7.setText("Liste des entreprises");

        goToEntreprise.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/esprit/tunRecrut/assets/liste-etreprise.png"))); // NOI18N
        goToEntreprise.setBorder(null);
        goToEntreprise.setBorderPainted(false);
        goToEntreprise.setContentAreaFilled(false);
        goToEntreprise.setFocusPainted(false);
        goToEntreprise.setRequestFocusEnabled(false);
        goToEntreprise.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goToEntrepriseActionPerformed(evt);
            }
        });

        goToCharte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/esprit/tunRecrut/assets/charte.png"))); // NOI18N
        goToCharte.setBorder(null);
        goToCharte.setBorderPainted(false);
        goToCharte.setContentAreaFilled(false);
        goToCharte.setDefaultCapable(false);
        goToCharte.setFocusPainted(false);
        goToCharte.setFocusable(false);
        goToCharte.setRolloverEnabled(false);
        goToCharte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goToCharteActionPerformed(evt);
            }
        });

        goToOffre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/esprit/tunRecrut/assets/liste-etreprise.png"))); // NOI18N
        goToOffre.setBorder(null);
        goToOffre.setBorderPainted(false);
        goToOffre.setContentAreaFilled(false);
        goToOffre.setFocusPainted(false);
        goToOffre.setRequestFocusEnabled(false);
        goToOffre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goToOffreActionPerformed(evt);
            }
        });

        goToNewsLettre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/esprit/tunRecrut/assets/news-lettre.png"))); // NOI18N
        goToNewsLettre.setBorder(null);
        goToNewsLettre.setBorderPainted(false);
        goToNewsLettre.setContentAreaFilled(false);
        goToNewsLettre.setFocusPainted(false);
        goToNewsLettre.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/com/esprit/tunRecrut/assets/desactiver-user.png"))); // NOI18N
        goToNewsLettre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goToNewsLettreActionPerformed(evt);
            }
        });

        jLabel3.setText("Générer des statistique");

        jLabel2.setText("Liste des condidat");

        jLabel13.setText("Envoyer des news lettre");

        Logout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/esprit/tunRecrut/assets/logout.png"))); // NOI18N
        Logout.setBorder(null);
        Logout.setBorderPainted(false);
        Logout.setContentAreaFilled(false);
        Logout.setFocusPainted(false);
        Logout.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/com/esprit/tunRecrut/assets/desactiver-user.png"))); // NOI18N
        Logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogoutActionPerformed(evt);
            }
        });

        jLabel14.setText("Liste des offres");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(goToCharte, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(Logout, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(gotToCandidat, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7)
                                    .addComponent(goToEntreprise, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(goToOffre, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(jLabel14))
                                    .addComponent(goToNewsLettre, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(616, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(goToCharte, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(gotToCandidat, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(21, 21, 21)
                .addComponent(goToEntreprise, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addGap(30, 30, 30)
                .addComponent(goToOffre, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel14)
                .addGap(18, 18, 18)
                .addComponent(goToNewsLettre, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13)
                .addGap(16, 16, 16)
                .addComponent(Logout, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void gotToCandidatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gotToCandidatActionPerformed
        // TODO add your handling code here:
        new ListeCondidat().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_gotToCandidatActionPerformed

    private void goToEntrepriseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goToEntrepriseActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new ListeEntreprise().setVisible(true);
    }//GEN-LAST:event_goToEntrepriseActionPerformed

    private void goToCharteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goToCharteActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new StatistiqueUI().setVisible(true);
    }//GEN-LAST:event_goToCharteActionPerformed

    private void goToOffreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goToOffreActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new ListOffre().setVisible(true);
    }//GEN-LAST:event_goToOffreActionPerformed

    private void goToNewsLettreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goToNewsLettreActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new NewsLettreUI().setVisible(true);
    }//GEN-LAST:event_goToNewsLettreActionPerformed

    private void LogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogoutActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LogoutActionPerformed

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
            java.util.logging.Logger.getLogger(StatistiqueUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StatistiqueUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StatistiqueUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StatistiqueUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StatistiqueUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Logout;
    private javax.swing.JButton goToCharte;
    private javax.swing.JButton goToEntreprise;
    private javax.swing.JButton goToNewsLettre;
    private javax.swing.JButton goToOffre;
    private javax.swing.JButton gotToCandidat;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    // End of variables declaration//GEN-END:variables
}
