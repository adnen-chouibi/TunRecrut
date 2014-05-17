/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.tunRecrut.test;

import com.esprit.tunRecrut.dao.AnnonceDAO;
import com.esprit.tunRecrut.entities.User;
import com.esprit.tunRecrut.dao.UserDAO;
import com.esprit.tunRecrut.entities.Annonce;
import java.util.ArrayList;
/**
 *
 * @author app4mob
 */
public class TestUser {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
//        User user = new User();
//        user.setFirstName("adnen");
//        user.setLastName("chouibi");
//        user.setRaisonSocial("aden tools");
//        user.setType("1");
//        user.setEmailAddress("adnen.chouibi@gmail.com");
//        user.setAddress("29 rue andirghandi cité salem");
//        user.setPassword("aaa");
//        user.setRegionId("1");
//        UserDAO userdao = new UserDAO();
//        userdao.Authentification(user);
//        System.out.println(user.getFax());
       AnnonceDAO a = new AnnonceDAO();
        //int id = 92;
        Annonce an  = a.getAnnonceById(92);
        //System.out.println("name" + an.getName());
        
        //ArrayList<String> metiersByAnnonId = a.getMetiersByAnnonId(92);
        
    }

}
