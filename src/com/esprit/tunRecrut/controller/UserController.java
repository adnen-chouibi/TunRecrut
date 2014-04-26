/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.tunRecrut.controller;

import com.esprit.tunRecrut.dao.UserDAO;
import com.esprit.tunRecrut.entities.User;
import com.esprit.tunRecrut.ui.LoginUI;
import com.esprit.tunRecrut.ui.RegisterUI;
import com.esprit.tunRecrut.ui.TestUI;
import com.esprit.tunRecrut.util.Session;
import javax.swing.JOptionPane;

/**
 *
 * @author app4mob
 */
public class UserController {

    public UserController() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void authentificationAction(User user) {
        UserDAO uDao = new UserDAO();
        user = uDao.findUserByEmailAndPassword(user.getEmailAddress(), user.getPassword());
        if (user != null) {
            System.out.println("user connecté avec success");
            // Interface_User user_interface = new User_Connexion();
            //user_interface.setVisible(true);
            Session session=new Session();
            System.out.println(user.getFirstName());
            session.user= user;
            new TestUI().setVisible(true);
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

    private void LoginUI() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
