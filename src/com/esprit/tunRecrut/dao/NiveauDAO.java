/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.esprit.tunRecrut.dao;

import com.esprit.tunRecrut.entities.Niveau;
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
public class NiveauDAO {
    Crud crud = new Crud();

    public List<Niveau> getAllNiveau() {
        try {
            List<Niveau> liste_niveau = new ArrayList<Niveau>();

            String requete = "select * from niveau";
            ResultSet resultat = crud.exeRead(requete);

            while (resultat.next()) {
                Niveau niveau = new Niveau();
                niveau.setId(resultat.getInt(1));
                niveau.setNom(resultat.getString("nom"));

                liste_niveau.add(niveau);
            }
            return liste_niveau;

        } catch (SQLException ex) {
            Logger.getLogger(RegionDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
 public Niveau getNiveauById(String id) {
        try {
            String sql = "SELECT * FROM niveau WHERE id='" + id + "'";
            ResultSet rs = crud.exeRead(sql);
            Niveau region = new Niveau();
            while (rs.next()) {
               region.setId(rs.getInt("id"));
                region.setNom(rs.getString("nom"));
               
            }
            return region;

        } catch (SQLException ex) {
            Logger.getLogger(RegionDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
