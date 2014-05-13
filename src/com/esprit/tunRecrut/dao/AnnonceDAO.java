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
    
    
    public boolean saveAnnonce(Annonce annonce) {
        System.out.println();
        String sql
                = "INSERT INTO  annonce (name,type,content,is_active,contrat_id,experience_id,type_emploi_id,niveau_id,region_id,user_id) VALUES"
                + " ('" + annonce.getName() + "',1,'" + annonce.getContent() + "','" + annonce.getIsActive() + "','" + annonce.getContrat_id() + "','" + annonce.getExprience_id() + "','" + annonce.getType_id() + "','" + annonce.getNiveau_id() + "','" + annonce.getRegion_id() + "'," + annonce.getUserId() + ")";
        int annonce_id = crud.executeWithReturnId(sql);
        for (int i = 0; i < annonce.getMetier().length; i++) {
            sql = "insert into annonce_has_metier(annonce_id, metier_id) values (" + annonce_id + "," + annonce.getMetier()[i] + ")";
            crud.execute(sql);
        }

        return true;
    }

    public List<Annonce> afficher() {
        String req = "SELECT a.* FROM Annonce a"
                + "WHERE a.is_active = 1 AND a.type = 1 "
                + "LEFT JOIN exeperience e"
                + "LEFT JOIN niveau n"
                + "LEFT JOIN cantrat c"
                + " ON a.experience_id = e.id"
                + " ON a.niveau_id = n.id"
                + " ON a.contact_id = c.id"
                + " ON a.region_id = r.id"
                ;
        
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
