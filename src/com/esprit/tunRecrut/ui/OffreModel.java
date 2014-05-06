/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.esprit.tunRecrut.ui;

import com.esprit.tunRecrut.dao.AnnonceDAO;
import com.esprit.tunRecrut.entities.Annonce;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Haithem
 */
public class OffreModel extends AbstractTableModel {

    private String[] columnNames = { "Id", "Name", "Date de Mise à jour", "Contrat", "Experience", "Type Emploi", "Niveau", "Région"};

    private List<Annonce> data = new ArrayList<Annonce>();

    public OffreModel() {
        AnnonceDAO pdao = new AnnonceDAO();
        data = pdao.afficher();
    }
    
    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }       

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0 : return data.get(rowIndex).getId();
            case 1 : return data.get(rowIndex).getName();
            case 2 : return data.get(rowIndex).getUpdatedAt();          
            default: return null;
        }
    }
    
}
