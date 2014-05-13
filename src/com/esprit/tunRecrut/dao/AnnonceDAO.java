/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.esprit.tunRecrut.dao;

import com.esprit.tunRecrut.entities.Annonce;
import com.esprit.tunRecrut.entities.User;
import com.esprit.tunRecrut.util.Crud;
import com.esprit.tunRecrut.util.MD5;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author app4mob
 */
public class AnnonceDAO {
    Crud crud = new Crud();

    public List<Annonce> afficher() {
        String req = "SELECT a.* FROM Annonce a"
                + "WHERE a.is_active = 1 AND a.type = 1 "
                + "LEFT JOIN exeperience e"
                + "LEFT JOIN niveau n"
                + "ON a.experience_id= e.id;"
                + "ON a.niveau_id = n.id";
        
        List<Annonce> annonces = new ArrayList<Annonce>();
        
        try {
            ResultSet rs;
            rs = crud.exeRead(req);
            while (rs.next()) {
                Annonce p1 = new Annonce();
                
                p1.setId(rs.getInt(1));
                p1.setName(rs.getString(2));
                p1.setType(rs.getInt(3));
                
                p1.setContent(rs.getString(4));
                p1.setCreatedAt(rs.getDate(5));
                //http://www.tutorialspoint.com/javaexamples/jdbc_innerjoin.htm
//                if (rs.getInt("experience_id") > 0) {
//                    p1.setExperienceId(rs.getObject("lexperience"));
//                }
//                
//                if (rs.getInt("")) {
//                    
//                }
                
                annonces.add(p1);

            }
        } catch (SQLException ex) {
            Logger.getLogger(AnnonceDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return annonces;

    }
}
