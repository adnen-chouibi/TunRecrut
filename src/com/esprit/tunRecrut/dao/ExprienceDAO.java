/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.esprit.tunRecrut.dao;

import com.esprit.tunRecrut.entities.Experience;
import com.esprit.tunRecrut.util.Crud;
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
public class ExprienceDAO {
 Crud crud = new Crud();
    public List<Experience> getAllExprience() {
         try {
            List<Experience> liste_exprience = new ArrayList<Experience>();

            String requete = "select * from experience";
            ResultSet resultat = crud.exeRead(requete);

            while (resultat.next()) {
                Experience exprience = new Experience();
                exprience.setId(resultat.getInt(1));
                exprience.setNom(resultat.getString("nom"));

                liste_exprience.add(exprience);
            }
            return liste_exprience;

        } catch (SQLException ex) {
            Logger.getLogger(RegionDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
}
