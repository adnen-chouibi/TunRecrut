package com.esprit.tunRecrut.util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Crud {
    
    MyDBConnection mc = MyDBConnection.getInstance();

    public boolean execute(String sql){
        try {
            Statement statement = mc.getConnection().createStatement();
           statement.executeUpdate(sql);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Crud.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public ResultSet exeRead(String sql){
        try {
            Statement statement = mc.getConnection().createStatement();
            ResultSet rs;
            rs = statement.executeQuery(sql);
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(Crud.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }
    
     public int executeWithReturnId(String sql){
        try {
            Statement statement = mc.getConnection().createStatement();
    return  statement.executeUpdate(sql, statement.RETURN_GENERATED_KEYS);
        } catch (SQLException ex) {
            Logger.getLogger(Crud.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }


    
}
