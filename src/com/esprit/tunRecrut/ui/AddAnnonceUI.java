/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.tunRecrut.ui;

import com.esprit.tunRecrut.dao.AnnonceDAO;
import com.esprit.tunRecrut.dao.ContratDAO;
import com.esprit.tunRecrut.dao.ExprienceDAO;
import com.esprit.tunRecrut.dao.MetierDAO;
import com.esprit.tunRecrut.dao.NiveauDAO;
import com.esprit.tunRecrut.dao.RegionDAO;
import com.esprit.tunRecrut.dao.TypeDAO;
import com.esprit.tunRecrut.entities.Annonce;
import com.esprit.tunRecrut.entities.Contrat;
import com.esprit.tunRecrut.entities.Experience;
import com.esprit.tunRecrut.entities.Metier;
import com.esprit.tunRecrut.entities.Niveau;
import com.esprit.tunRecrut.entities.Region;
import com.esprit.tunRecrut.entities.TypeEmploi;
import com.esprit.tunRecrut.util.Session;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author app4mob
 */
public class AddAnnonceUI extends javax.swing.JFrame {

    /**
     * Creates new form AddAnnonceUI
     */
    public AddAnnonceUI() {
        initComponents();
        initRegion();
        initContrat();
        initExprience();
        initType();
        initNiveau();
        initMetier();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        region_id = new javax.swing.JComboBox();
        type = new javax.swing.JComboBox();
        exprience = new javax.swing.JComboBox();
        contrat = new javax.swing.JComboBox();
        niveau = new javax.swing.JComboBox();
        titre = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        description = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        DefaultListModel listModel;
        listModel = new DefaultListModel();
        MetierDAO regiondao = new MetierDAO();
        List<Metier> regions = regiondao.getAllMetier();
        for (Metier region : regions) {
            listModel.addElement(region.getNom());
        }
        metier = new javax.swing.JList(listModel);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Déposer offre d'emploi");

        region_id.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "--- Selectionnez un région ---" }));

        type.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "--- Selctionnez un type d'emploi ---" }));

        exprience.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "---- Selectionnez une exprience ---" }));

        contrat.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "--- Selectionnez type de contrat ---" }));

        niveau.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "--- Selectionnez un niveau d'étude ---" }));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Titre");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Description");

        description.setColumns(20);
        description.setRows(5);
        jScrollPane1.setViewportView(description);

        jButton1.setText("Publier");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jScrollPane2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane2.setMaximumSize(new java.awt.Dimension(200, 32767));

        jScrollPane2.setViewportView(metier);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1)
                            .addComponent(region_id, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(type, 0, 320, Short.MAX_VALUE)
                            .addComponent(titre)))
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(exprience, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(contrat, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(niveau, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(titre, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(region_id, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(type, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(niveau, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(contrat, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(exprience, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Annonce annonce = new Annonce();
        annonce.setName(titre.getText());
        annonce.setContent(description.getText());
        annonce.setRegion_id(region_id.getSelectedIndex());
        annonce.setType_id(type.getSelectedIndex());
        annonce.setExprience_id(exprience.getSelectedIndex());
        annonce.setContrat_id(contrat.getSelectedIndex());
        annonce.setNiveau_id(niveau.getSelectedIndex());
        annonce.setIsActive(0);
        annonce.setUserId(new Session().getUser().getId());
        annonce.setType(new Session().getUser().getType());
        List<Metier> ids = metier.getSelectedValuesList();
        annonce.setMetierCollection((ArrayList<Metier>) ids);
        System.out.println(annonce.getName());
        AnnonceDAO annancedao = new AnnonceDAO();
        annancedao.saveAnnonce(annonce);
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(AddAnnonceUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddAnnonceUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddAnnonceUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddAnnonceUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UIManager.setLookAndFeel(
                            UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(LoginUI.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InstantiationException ex) {
                    Logger.getLogger(LoginUI.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(LoginUI.class.getName()).log(Level.SEVERE, null, ex);
                } catch (UnsupportedLookAndFeelException ex) {
                    Logger.getLogger(LoginUI.class.getName()).log(Level.SEVERE, null, ex);
                }
                new AddAnnonceUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox contrat;
    private javax.swing.JTextArea description;
    private javax.swing.JComboBox exprience;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList metier;
    private javax.swing.JComboBox niveau;
    private javax.swing.JComboBox region_id;
    private javax.swing.JTextField titre;
    private javax.swing.JComboBox type;
    // End of variables declaration//GEN-END:variables

    private void initContrat() {
        ContratDAO contratdao = new ContratDAO();
        List<Contrat> contrats = contratdao.getAllContart();
        for (Contrat contrat_ : contrats) {
            contrat.addItem(contrat_.getNom());
        }
    }

    private void initExprience() {
        ExprienceDAO expriencedao = new ExprienceDAO();
        List<Experience> expriences = expriencedao.getAllExprience();
        for (Experience exprience_ : expriences) {
            exprience.addItem(exprience_.getNom());
        }
    }

    private void initType() {
        TypeDAO typedao = new TypeDAO();
        List<TypeEmploi> types = typedao.getAllType();
        for (TypeEmploi type_ : types) {
            type.addItem(type_.getNom());
        }
    }

    private void initNiveau() {
        NiveauDAO niveaudao = new NiveauDAO();
        List<Niveau> niveaux = niveaudao.getAllNiveau();
        for (Niveau niveau_ : niveaux) {
            niveau.addItem(niveau_.getNom());
        }
    }

    public void initRegion() {
        RegionDAO regiondao = new RegionDAO();
        List<Region> regions = regiondao.getAllRegion();
        for (Region region : regions) {
            region_id.addItem(region.getName());
        }

    }

    public void initMetier() {
        DefaultListModel<Metier> listModel=new DefaultListModel<>();
        MetierDAO regiondao = new MetierDAO();
        List<Metier> regions = regiondao.getAllMetier();
        for (Metier region : regions) {
            listModel.addElement(region);
        }
        metier.setModel(listModel);
    }
}
