package com.esprit.tunRecrut.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class MyDBConnection {
    
    /**
     * Déclaration des variables pour la connexion
     */
    private String url = "jdbc:mysql://localhost:3306/tun_recrut";
    private String login = "root";
    private String pwd = "";
    private static MyDBConnection instance;
    public static Connection connection;

    private MyDBConnection() {
        try {
            connection = DriverManager.getConnection(url,login,pwd);
            
        } catch (SQLException ex) {
            Logger.getLogger(MyDBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static Connection getConnection() {
        return connection;
    }

    public static MyDBConnection getInstance() {
        if(instance==null)
            instance = new MyDBConnection();
        return instance;
    }

    
}
