/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.esprit.tunRecrut.dao;

import com.esprit.tunRecrut.entities.TypeEmploi;
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
public class TypeDAO {
     Crud crud = new Crud();

    public List<TypeEmploi> getAllType() {
        try {
            List<TypeEmploi> liste_type = new ArrayList<TypeEmploi>();

            String requete = "select * from type_emploi";
            ResultSet resultat = crud.exeRead(requete);

            while (resultat.next()) {
                TypeEmploi type = new TypeEmploi();
                type.setId(resultat.getInt(1));
                type.setNom(resultat.getString("nom"));

                liste_type.add(type);
            }
            return liste_type;

        } catch (SQLException ex) {
            Logger.getLogger(RegionDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
     public TypeEmploi getRegionById(String id) {
        try {
            String sql = "SELECT * FROM type_emploi WHERE id='" + id + "'";
            ResultSet rs = crud.exeRead(sql);
            TypeEmploi region = new TypeEmploi();
            while (rs.next()) {
               region.setId(rs.getInt("id"));
                region.setNom(rs.getString("nom"));
               
            }
            return region;

        } catch (SQLException ex) {
            Logger.getLogger(TypeDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
