/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.tunRecrut.dao;

import com.esprit.tunRecrut.entities.User;
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
public class NewsLettreDAO {

    Crud crud = new Crud();

    

    public ArrayList<String> getAllUser() {
        RegionDAO region_dao = new RegionDAO();
        String req = "select  * from newslettre";
         ArrayList<String> emails = new ArrayList<String>();
        try {
            ResultSet rs = crud.exeRead(req);
            int i=0;
            while (rs.next()) {
               
                emails.add(rs.getString("email"));
               i++;

            }
        } catch (SQLException ex) {
            Logger.getLogger(NewsLettreDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return emails;
    }

}
