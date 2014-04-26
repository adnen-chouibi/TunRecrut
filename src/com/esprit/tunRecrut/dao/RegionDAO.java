/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.tunRecrut.dao;

import com.esprit.tunRecrut.util.Crud;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.esprit.tunRecrut.entities.Region;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author app4mob
 */
public class RegionDAO {

    Crud crud = new Crud();

    public List<Region> getAllRegion() {
        try {
            List<Region> liste_region = new ArrayList<Region>();

            String requete = "select * from region";
            ResultSet resultat = crud.exeRead(requete);

            while (resultat.next()) {
                Region region = new Region();
                region.setId(resultat.getInt(1));
                region.setName(resultat.getString(2));

                liste_region.add(region);
            }
            return liste_region;

        } catch (SQLException ex) {
            Logger.getLogger(RegionDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    public Region getRegionById(String id) {
        try {
            String sql = "SELECT * FROM region WHERE id='" + id + "'";
            ResultSet rs = crud.exeRead(sql);
            Region region = new Region();
            while (rs.next()) {
               region.setId(rs.getInt("id"));
                region.setName(rs.getString("name"));
               
            }
            return region;

        } catch (SQLException ex) {
            Logger.getLogger(RegionDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
