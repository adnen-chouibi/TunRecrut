/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.tunRecrut.controller;

import com.esprit.tunRecrut.dao.UserDAO;
import com.esprit.tunRecrut.entities.User;
import com.esprit.tunRecrut.ui.CandidatUI;
import com.esprit.tunRecrut.ui.LoginUI;
import com.esprit.tunRecrut.util.Session;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

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
                
                CandidatUI candidat_ui = new CandidatUI();
                candidat_ui.setVisible(true);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Votre login et mot de passe sont incorrecte ");
        }
    }

    public void RegisterAction(User user) {
        UserDAO uDao = new UserDAO();
        if (uDao.saveUser(user)) {
            JOptionPane.showMessageDialog(null, "Votre Compte à été crée avec succes");
        } else {
            JOptionPane.showMessageDialog(null, "Une erreur se produit");
        }

    }

}
