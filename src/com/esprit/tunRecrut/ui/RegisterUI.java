/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.tunRecrut.ui;

import com.esprit.tunRecrut.controller.UserController;
import com.esprit.tunRecrut.dao.RegionDAO;
import com.esprit.tunRecrut.entities.Region;
import com.esprit.tunRecrut.entities.User;
import java.awt.Font;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author app4mob
 */
public final class RegisterUI extends javax.swing.JFrame {

    /**
     * Creates new form RegisterUI
     */
    public RegisterUI() {
        initComponents();
        initRegion();
    }

    public void initRegion() {
        RegionDAO regiondao = new RegionDAO();
        List<Region> regions = regiondao.getAllRegion();
        for (Region region : regions) {
            region_id.addItem(region.getName());
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

        type = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        prenom = new javax.swing.JTextField();
        email = new javax.swing.JTextField();
        tel = new javax.swing.JTextField();
        nom = new javax.swing.JTextField();
        fax = new javax.swing.JTextField();
        adresse = new javax.swing.JTextField();
        password = new javax.swing.JTextField();
        employer = new javax.swing.JRadioButton();
        employeur = new javax.swing.JRadioButton();
        raison = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        region_id = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 102));
        jLabel1.setText("Remplir ces champ pour créer un utilisateur");

        jSeparator2.setBackground(new java.awt.Color(51, 51, 51));

        final PlaceholderTextField prenom = new PlaceholderTextField();
        prenom.setPlaceholder("Prenom");
        prenom.setToolTipText("Prénom");
        prenom.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        final PlaceholderTextField email = new PlaceholderTextField();
        email.setPlaceholder("Email");
        email.setToolTipText("Email");
        email.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        final PlaceholderTextField tel = new PlaceholderTextField();
        tel.setPlaceholder("Téléphone");
        tel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        //final PlaceholderTextField nom = new PlaceholderTextField();
        //nom.setPlaceholder("Nom");
        nom.setToolTipText("Nom");
        nom.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        nom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomActionPerformed(evt);
            }
        });
        nom.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                nomFocusGained(evt);
            }
        });

        final PlaceholderTextField fax = new PlaceholderTextField();
        fax.setPlaceholder("Fax");
        fax.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        final PlaceholderTextField adresse = new PlaceholderTextField();
        adresse.setPlaceholder("Adresse");
        adresse.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        final javax.swing.JPasswordField password = new javax.swing.JPasswordField();
        //password.setPlaceholder("Password");
        password.setText(initialPassword);
        password.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                if (password.getText().equals(initialPassword)) {
                    password.selectAll();
                }
            }
        });
        password.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        employer.setBackground(new java.awt.Color(255, 255, 255));
        type.add(employer);
        employer.setText("Employer");
        employer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                employerMouseClicked(evt);
            }
        });
        employer.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                employerStateChanged(evt);
            }
        });
        employer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                employerActionPerformed(evt);
            }
        });

        employeur.setBackground(new java.awt.Color(255, 255, 255));
        type.add(employeur);
        employeur.setText("Employeur");
        employeur.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                employeurStateChanged(evt);
            }
        });

        //final PlaceholderTextField raison = new PlaceholderTextField();
        //raison.setPlaceholder("Raison Social");
        raison.setToolTipText("Raison social");
        raison.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        raison.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                raisonActionPerformed(evt);
            }
        });

        jButton1.setText("S'inscrire");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Se connecter");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        region_id.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "--- Selectionnez une region ---" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tel)
                    .addComponent(fax)
                    .addComponent(adresse)
                    .addComponent(password)
                    .addComponent(raison, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(email)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(nom, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(employer))
                                .addGap(10, 10, 10)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(employeur)
                                    .addComponent(prenom, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(region_id, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(employer)
                    .addComponent(employeur))
                .addGap(33, 33, 33)
                .addComponent(raison, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(prenom, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nom, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(tel, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(fax, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(adresse, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(region_id, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        getContentPane().add(jPanel1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomActionPerformed

    private void nomFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nomFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_nomFocusGained

    private void employerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_employerActionPerformed
//        String type = null;
        if (employer.isSelected()) {
            raison.setVisible(false);
        }
        if (employeur.isSelected()) {
            raison.setVisible(true);
        }        // TODO add your handling code here:
      
        // JOptionPane.showMessageDialog(null, "set to flase");
    }//GEN-LAST:event_employerActionPerformed

    private void employerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_employerStateChanged

    }//GEN-LAST:event_employerStateChanged

    private void raisonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_raisonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_raisonActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        new LoginUI().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        User user = new User();

        if (employer.isSelected()) {
            user.setType("1");
        } else {
            user.setType("2");
            user.setRaisonSocial(raison.getText());
        }
        user.setFirstName(nom.getText());
        user.setLastName(prenom.getText());
        user.setAddress(adresse.getText());
        user.setTel(tel.getText());
        user.setFax(fax.getText());
        user.setEmailAddress(email.getText());
        user.setPassword(password.getText());
        Region region = new Region();
        RegionDAO region_dao = new RegionDAO();
        region= region_dao.getRegionById(String.valueOf(region_id.getSelectedIndex()));
        // if(region_id.getSelectedIndex()){
       // user.setRegionId();
       user.setRegionId(region);

        // }
         System.out.println("emil--:"+email.getText());
        UserController user_controller = new UserController();
        user_controller.RegisterAction(user);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void employerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_employerMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_employerMouseClicked

    private void employeurStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_employeurStateChanged
        // TODO add your handling code here:
        if (employer.isSelected()) {
            raison.setVisible(false);
        }
        if (employeur.isSelected()) {
            raison.setVisible(true);
        }   
    }//GEN-LAST:event_employeurStateChanged

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
            java.util.logging.Logger.getLogger(RegisterUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegisterUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegisterUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegisterUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegisterUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField adresse;
    private javax.swing.JTextField email;
    private javax.swing.JRadioButton employer;
    private javax.swing.JRadioButton employeur;
    private javax.swing.JTextField fax;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField nom;
    private javax.swing.JTextField password;
    private javax.swing.JTextField prenom;
    private javax.swing.JTextField raison;
    private javax.swing.JComboBox region_id;
    private javax.swing.JTextField tel;
    private javax.swing.ButtonGroup type;
    // End of variables declaration//GEN-END:variables
String initialPassword = "Password";
}
