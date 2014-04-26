/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.tunRecrut.dao;

import com.esprit.tunRecrut.entities.User;
import com.esprit.tunRecrut.util.Crud;
import com.esprit.tunRecrut.util.MD5;
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
        System.out.println();
         String sql =
                "INSERT INTO  user (first_name,last_name,raison_social,type,email_address,tel,fax,address,password,region_id) VALUES ('"+user.getFirstName()+"','"+user.getLastName()+"','"+user.getRaisonSocial()+"','"+user.getType()+"','"+user.getEmailAddress()+"','"+user.getTel()+"','"+user.getFax()+"','"+user.getAddress()+"','"+MD5.md5Java(user.getPassword())+"','"+user.getRegionId().getId()+"')";
        return crud.execute(sql);
    }

    public User findUserByEmailAndPassword(String email, String password) {

        RegionDAO region_dao = new RegionDAO();
         User user=null;
        try {
            String sql = "SELECT * FROM user WHERE email_address = '" + email + "' AND password = '" + MD5.md5Java(password) + "'";
            ResultSet rs = crud.exeRead(sql);
            while (rs.next()) {
                user = new User();
                user.setFirstName(rs.getString("first_name"));
                user.setLastName(rs.getString("last_name"));
                user.setType(rs.getInt("type"));
                user.setEmailAddress(rs.getString("email_address"));
                user.setTel(rs.getString("tel"));
                user.setFax(rs.getString("fax"));
                user.setAddress(rs.getString("address"));
                user.setRegionId(region_dao.getRegionById(rs.getString("region_id")));
                if(user.getType()==2)
                    user.setRaisonSocial(rs.getString("raison_social"));
            }
            return user;

        } catch (SQLException ex) {
            Logger.getLogger("Client controller").log(Level.SEVERE, " fail");
            return null;
        }
    }
}
