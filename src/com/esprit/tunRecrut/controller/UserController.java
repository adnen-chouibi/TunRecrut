/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.tunRecrut.controller;

import com.esprit.tunRecrut.dao.UserDAO;
import com.esprit.tunRecrut.entities.User;
import com.esprit.tunRecrut.ui.CandidatUI;
import com.esprit.tunRecrut.ui.EditProfileUI;
import com.esprit.tunRecrut.ui.LoginUI;
import com.esprit.tunRecrut.ui.administrateur.ListeCondidat;
import com.esprit.tunRecrut.util.Session;
import static javax.management.Query.and;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import static org.eclipse.persistence.expressions.ExpressionOperator.and;

/**
 *
 * @author app4mob
 */
public class UserController {

    public UserController() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void authentificationAction(User user, JFrame login_ui) {
        UserDAO uDao = new UserDAO();
        Session session = new Session();
        user = uDao.findUserByEmailAndPassword(user.getEmailAddress(), user.getPassword());
        if (user != null) {
            System.out.println("user connecté avec success");
            session.setUser(user);
            login_ui.setVisible(false);
            if (user.getType() == 1) {
                CandidatUI candidat_ui = new CandidatUI();
                candidat_ui.setVisible(true);
            } else if (user.getType() == 2) {
                JOptionPane.showMessageDialog(null, "Go to home page enterprise");
               // CandidatUI candidat_ui = new CandidatUI();
               // candidat_ui.setVisible(true);
            }

        } else {
            JOptionPane.showMessageDialog(null, "Votre login et mot de passe sont incorrecte ");
        }
    }
    static int i = 0;

    public void authentificationAdminAction(User user, JFrame login_ui) {

        UserDAO uDao = new UserDAO();
        Session session = new Session();
        user = uDao.findUserByEmailAndPassword(user.getEmailAddress(), user.getPassword());
        if (user != null && user.isSuper_admin()) {

            System.out.println("admin connecté avec success");
            session.setUser(user);
            login_ui.setVisible(false);

            ListeCondidat candidat_ui = new ListeCondidat();
            candidat_ui.setVisible(true);
        } else {
            i++;
            JOptionPane.showMessageDialog(null, "Votre login et mot de passe sont incorrecte ");
            if (i >= 3) {
                login_ui.setVisible(false);
                new LoginUI().setVisible(true);
            }
        }

    }

    public void RegisterAction(User user, JFrame register_ui) {
        UserDAO uDao = new UserDAO();
        Session session = new Session();
        if (uDao.findUserByEmail(user.getEmailAddress())) {
            JOptionPane.showMessageDialog(null, user.getEmailAddress() + " Existe déja");
        } else {
            if (uDao.saveUser(user)) {
                session.setUser(user);
                if (user.getType() == 1) {
                    CandidatUI candidat_ui = new CandidatUI();
                    candidat_ui.setVisible(true);
                } else if (user.getType() == 2) {

                    CandidatUI candidat_ui = new CandidatUI();
                    candidat_ui.setVisible(true);
                }

                register_ui.setVisible(false);
                JOptionPane.showMessageDialog(null, "Votre Compte à été crée avec succes");
            } else {
                JOptionPane.showMessageDialog(null, "Une erreur se produit");
            }
        }
    }

    public void EditProfileAction(User user, JFrame edit_profile_ui) {
        UserDAO uDao = new UserDAO();
        Session connected_user = new Session();
        if (uDao.findUserByEmail(user.getEmailAddress(), user.getId())) {
            JOptionPane.showMessageDialog(null, user.getEmailAddress() + " Existe déja");
        } else {
            if (uDao.EditUser(user)) {
                user.setId(connected_user.getUser().getId());
                user.setType(connected_user.getUser().getType());
                user.setRaisonSocial(connected_user.getUser().getRaisonSocial());
                connected_user.setUser(user);
                edit_profile_ui.setVisible(false);
                JOptionPane.showMessageDialog(null, "Votre Compte à été modifier avec succes");
            } else {
                JOptionPane.showMessageDialog(null, "Une erreur se produit");
            }
        }

    }

}
