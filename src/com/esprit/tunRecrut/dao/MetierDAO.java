/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.esprit.tunRecrut.dao;

import com.esprit.tunRecrut.entities.Metier;
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
public class MetierDAO {
     Crud crud = new Crud();

    public List<Metier> getAllMetier() {
        try {
            List<Metier> liste_niveau = new ArrayList<Metier>();

            String requete = "select * from metier";
            ResultSet resultat = crud.exeRead(requete);

            while (resultat.next()) {
                Metier niveau = new Metier();
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
}
