/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.tunRecrut.ui.administrateur;

import com.esprit.tunRecrut.dao.UserDAO;
import com.esprit.tunRecrut.entities.User;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author app4mob
 */
public class Model extends AbstractTableModel {

    String[] colonnes = {"Id", "Etat", "Nom", "Email", "Tel", "Fax", "Adresse", "Region"};
    List<User> ligne = new ArrayList<User>();

    public Model() {
        UserDAO userdao = new UserDAO();
        ligne = userdao.getAllCandidat();
    }

    public Model(String text) {
        UserDAO userdao = new UserDAO();
        ligne = userdao.getAllCandidatByKey(text);
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
        if (ligne.get(rowIndex).getActive() == 1) {
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
                return ligne.get(rowIndex).getFirstName() + " " + ligne.get(rowIndex).getLastName();
            case 3:
                return ligne.get(rowIndex).getEmailAddress();
            case 4:
                return ligne.get(rowIndex).getTel();
            case 5:
                return ligne.get(rowIndex).getFax();
            case 6:
                return ligne.get(rowIndex).getAddress();
            case 7:
                return ligne.get(rowIndex).getRegionId().getName();
            default:
                return null;
        }
    }

}
