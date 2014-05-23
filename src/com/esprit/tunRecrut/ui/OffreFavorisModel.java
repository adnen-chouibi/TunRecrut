/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.esprit.tunRecrut.ui;

import com.esprit.tunRecrut.dao.AnnonceDAO;
import com.esprit.tunRecrut.dao.UserDAO;
import com.esprit.tunRecrut.entities.Annonce;
import com.esprit.tunRecrut.entities.User;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Haithem
 */
public class OffreFavorisModel extends AbstractTableModel {

    String[] colonnes = {"Id", "Etat","User", "Titre", "Type de contrat", "Experience", "Type", "Niveau", "Region"};
    List<Annonce> ligne = new ArrayList<Annonce>();

    public OffreFavorisModel() {
      //  UserDAO userdao = new UserDAO();
      //  ligne = userdao.getAllCandidat();
    }

    public OffreFavorisModel(int user_id, int type) {
        AnnonceDAO annoncedao = new AnnonceDAO();
       // int type = 1;
        ligne = annoncedao.getAllFavoris(user_id, type);
    }

    @Override
    public int getRowCount() {
        return ligne.size();
    }

    @Override
    public int getColumnCount() {
        return colonnes.length;
    }

    @Override
    public String getColumnName(int column) {
        return colonnes[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        String etat;
        if (ligne.get(rowIndex).getIsActive() == 1) {
            etat = "Active";
        } else {
            etat = "En cours";
        }
        switch (columnIndex) {
            case 0:
                return ligne.get(rowIndex).getId();
            case 1:
                return etat;
            case 2:
                return ligne.get(rowIndex).getUser();
            case 3:
                return ligne.get(rowIndex).getName();
            case 4:
                return ligne.get(rowIndex).getContrat();
            case 5:
                return ligne.get(rowIndex).getExperience();
            case 6:
                return ligne.get(rowIndex).getType_emploi();
            case 7:
                return ligne.get(rowIndex).getNiveau();
            case 8:
                return ligne.get(rowIndex).getRegion();
            default:
                return null;
        }
    }
    
}
