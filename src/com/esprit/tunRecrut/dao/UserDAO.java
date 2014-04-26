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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author app4mob
 */
public class UserDAO {

    Crud crud = new Crud();
    public boolean saveUser(User user) {
        
         String sql =
                "INSERT INTO  user (first_name,last_name,raison_social,type,email_address,tel,fax,address,password,region_id) VALUES ('"+user.getFirstName()+"','"+user.getLastName()+"','"+user.getRaisonSocial()+"','"+user.getType()+"','"+user.getEmailAddress()+"','"+user.getTel()+"','"+user.getFax()+"','"+user.getAddress()+"','"+user.getPassword()+"','"+user.getRegionId().getId()+"')";
        return crud.execute(sql);
    }

    public User findUserByEmailAndPassword(String email, String password) {

        
         User user=null;
        try {
            String sql = "SELECT * FROM user WHERE email_address = '" + email + "' AND password = '" + password + "'";
            ResultSet rs = crud.exeRead(sql);
            while (rs.next()) {
                user = new User(rs.getInt("id"), rs.getInt("type"), rs.getString("email_address"));
            }
            return user;

        } catch (SQLException ex) {
            Logger.getLogger("Client controller").log(Level.SEVERE, " fail");
            return null;
        }
    }
}
