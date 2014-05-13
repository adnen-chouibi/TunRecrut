/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.esprit.tunRecrut.dao;

import com.esprit.tunRecrut.entities.Contrat;
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
public class ContratDAO {
    Crud crud = new Crud();
    public List<Contrat> getAllContart() {
         try {
            List<Contrat> liste_exprience = new ArrayList<Contrat>();

            String requete = "select * from contrat";
            ResultSet resultat = crud.exeRead(requete);

            while (resultat.next()) {
                Contrat contrat = new Contrat();
                contrat.setId(resultat.getInt(1));
                contrat.setNom(resultat.getString("nom"));

                liste_exprience.add(contrat);
            }
            return liste_exprience;

        } catch (SQLException ex) {
            Logger.getLogger(RegionDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
