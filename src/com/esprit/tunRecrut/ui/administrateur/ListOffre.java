/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.tunRecrut.ui.administrateur;

import com.esprit.tunRecrut.dao.AnnonceDAO;
import com.esprit.tunRecrut.dao.UserDAO;
import com.esprit.tunRecrut.ui.LoginUI;
import com.esprit.tunRecrut.ui.OffreShowUI;

/**
 *
 * @author app4mob
 */
public class ListOffre extends javax.swing.JFrame {

    /**
     * Creates new form ListOffre
     */
    public ListOffre() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
    private String keyword = "";
    private int contrat_id = 0;
    private int experience_id = 0;
    private int type_id = 0;
    private int niveau_id = 0;
    private int region_id = 0;

    public void setFilter(String keyword, int contrat_id, int experience_id, int type_id, int niveau_id, int region_id) {
        jTable1.setModel(new ListeOffreTable(keyword, contrat_id, experience_id, type_id, niveau_id, region_id, type.getSelectedIndex()));
        jScrollPane1.setViewportView(jTable1);
        this.keyword = keyword;
        this.contrat_id = contrat_id;
        this.experience_id = experience_id;
        this.niveau_id = niveau_id;
        this.region_id = region_id;
        this.type_id = type_id;
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
        activer = new javax.swing.JButton();
        supprimer = new javax.swing.JButton();
        desactiver = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        type = new javax.swing.JComboBox();
        jPanel2 = new javax.swing.JPanel();
        goToNewsLettre = new javax.swing.JButton();
        Logout = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        gotToCandidat = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        goToCharte = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        goToEntreprise = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        goToOffre = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Liste des annonces");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Liste des Annonces"));

        activer.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        activer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/esprit/tunRecrut/assets/activer-user.png"))); // NOI18N
        activer.setText("Activer");
        activer.setEnabled(false);
        activer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                activerActionPerformed(evt);
            }
        });

        supprimer.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        supprimer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/esprit/tunRecrut/assets/delete-user.png"))); // NOI18N
        supprimer.setText("Supprimer");
        supprimer.setEnabled(false);
        supprimer.setName(""); // NOI18N
        supprimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supprimerActionPerformed(evt);
            }
        });

        desactiver.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        desactiver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/esprit/tunRecrut/assets/desactiver-user.png"))); // NOI18N
        desactiver.setText("Désactiver");
        desactiver.setEnabled(false);
        desactiver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                desactiverActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/esprit/tunRecrut/assets/filter-user.png"))); // NOI18N

        jTable1.setFont(new java.awt.Font("Calibri", 0, 11)); // NOI18N
        jTable1.setModel(new com.esprit.tunRecrut.ui.administrateur.ListeOffreTable("",0,0,0,0,0,1));
        jTable1.setRowHeight(28);
        jTable1.setShowVerticalLines(false);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("Filter");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        type.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "--- Type d'offre ---", "Demande", "Offre" }));
        type.setSelectedIndex(1);
        type.setToolTipText("");
        type.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                typeItemStateChanged(evt);
            }
        });
        type.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                typePropertyChange(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(type, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 343, Short.MAX_VALUE)
                        .addComponent(supprimer, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(desactiver)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(activer, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(type, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(activer)
                            .addComponent(desactiver, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(supprimer, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 478, Short.MAX_VALUE)
                .addContainerGap())
        );

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

        jLabel3.setText("Générer des statistique");

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

        jLabel4.setText("Liste des entreprises");

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

        jLabel6.setText("Déconnexion");

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

        jLabel2.setText("Liste des condidat");

        jLabel5.setText("Envoyer des news lettre");

        goToOffre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/esprit/tunRecrut/assets/jobs.png"))); // NOI18N
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

        jLabel7.setText("Liste des offres");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(goToCharte, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(Logout, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(goToNewsLettre, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(gotToCandidat, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4)
                                    .addComponent(goToEntreprise, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(goToOffre, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(jLabel7)))
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
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
                .addComponent(jLabel4)
                .addGap(30, 30, 30)
                .addComponent(goToOffre, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(goToNewsLettre, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addGap(16, 16, 16)
                .addComponent(Logout, javax.swing.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void activerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_activerActionPerformed
        int row = jTable1.getSelectedRow();
        Object annonce_id = jTable1.getValueAt(row, 0);
        AnnonceDAO andao;
        andao = new AnnonceDAO();
        andao.ActivateOffre(annonce_id.hashCode());
        jTable1.setModel(new ListeOffreTable(keyword, contrat_id, experience_id, type_id, niveau_id, region_id, type.getSelectedIndex()));
        jScrollPane1.setViewportView(jTable1);
    }//GEN-LAST:event_activerActionPerformed

    private void supprimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supprimerActionPerformed
        int row = jTable1.getSelectedRow();
        Object annonce_id = jTable1.getValueAt(row, 0);
        AnnonceDAO andao;
        andao = new AnnonceDAO();
        andao.DeleteOffre(annonce_id.hashCode());
        jTable1.setModel(new ListeOffreTable(keyword, contrat_id, experience_id, type_id, niveau_id, region_id, type.getSelectedIndex()));
        jScrollPane1.setViewportView(jTable1);
        supprimer.setEnabled(false);
    }//GEN-LAST:event_supprimerActionPerformed

    private void desactiverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_desactiverActionPerformed
        int row = jTable1.getSelectedRow();
        Object offre_id = jTable1.getValueAt(row, 0);
        AnnonceDAO andao = new AnnonceDAO();

        andao.DeactivateOffre(offre_id.hashCode());
        jTable1.setModel(new ListeOffreTable(keyword, contrat_id, experience_id, type_id, niveau_id, region_id, type.getSelectedIndex()));
        jScrollPane1.setViewportView(jTable1);

    }//GEN-LAST:event_desactiverActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int row = jTable1.getSelectedRow();
        if (evt.getClickCount() == 2) {
            Object offre_id = jTable1.getValueAt(row, 0);
            new OffreShowUI(offre_id.hashCode()).setVisible(true);
        } else {
            Object candidat_id = jTable1.getValueAt(row, 1);
            supprimer.setEnabled(true);
            if (candidat_id.toString() == "En cours") {
                desactiver.setEnabled(false);
                activer.setEnabled(true);
            }
            if (candidat_id.toString() == "Active") {
                activer.setEnabled(false);
                desactiver.setEnabled(true);
            }
        }

    }//GEN-LAST:event_jTable1MouseClicked

    private void goToNewsLettreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goToNewsLettreActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new NewsLettreUI().setVisible(true);
    }//GEN-LAST:event_goToNewsLettreActionPerformed

    private void LogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogoutActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new LoginUI().setVisible(true);
    }//GEN-LAST:event_LogoutActionPerformed

    private void gotToCandidatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gotToCandidatActionPerformed
        // TODO add your handling code here:
        new ListeCondidat().setVisible(true);
        this.setVisible(false);

    }//GEN-LAST:event_gotToCandidatActionPerformed

    private void goToCharteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goToCharteActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new StatistiqueUI().setVisible(true);
    }//GEN-LAST:event_goToCharteActionPerformed

    private void goToEntrepriseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goToEntrepriseActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new ListeEntreprise().setVisible(true);
    }//GEN-LAST:event_goToEntrepriseActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        new FilterOffreUI(this).setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void typePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_typePropertyChange
        // TODO add your handling code here:

    }//GEN-LAST:event_typePropertyChange

    private void typeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_typeItemStateChanged
        // TODO add your handling code here:
        jTable1.setModel(new ListeOffreTable(keyword, contrat_id, experience_id, type_id, niveau_id, region_id, type.getSelectedIndex()));
        jScrollPane1.setViewportView(jTable1);

    }//GEN-LAST:event_typeItemStateChanged

    private void goToOffreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goToOffreActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new ListOffre().setVisible(true);
    }//GEN-LAST:event_goToOffreActionPerformed

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
                java.util.logging.Logger.getLogger(ListOffre.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (InstantiationException ex) {
                java.util.logging.Logger.getLogger(ListOffre.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                java.util.logging.Logger.getLogger(ListOffre.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                java.util.logging.Logger.getLogger(ListOffre.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
        //</editor-fold>

            /* Create and display the form */
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new ListOffre().setVisible(true);
                }
            });
        }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Logout;
    private javax.swing.JButton activer;
    private javax.swing.JButton desactiver;
    private javax.swing.JButton goToCharte;
    private javax.swing.JButton goToEntreprise;
    private javax.swing.JButton goToNewsLettre;
    private javax.swing.JButton goToOffre;
    private javax.swing.JButton gotToCandidat;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton supprimer;
    private javax.swing.JComboBox type;
    // End of variables declaration//GEN-END:variables
}
