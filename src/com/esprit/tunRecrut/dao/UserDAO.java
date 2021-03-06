/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.tunRecrut.dao;

import com.esprit.tunRecrut.entities.User;
import com.esprit.tunRecrut.util.Crud;
import com.esprit.tunRecrut.util.MD5;
import com.esprit.tunRecrut.util.Session;
import static com.esprit.tunRecrut.util.Session.user;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author app4mob
 */
public class UserDAO {

    Crud crud = new Crud();

    public boolean saveUser(User user) {
        System.out.println();
        String sql
                = "INSERT INTO  user (first_name,last_name,raison_social,type,email_address,tel,fax,address,password,region_id) VALUES ('" + user.getFirstName() + "','" + user.getLastName() + "','" + user.getRaisonSocial() + "','" + user.getType() + "','" + user.getEmailAddress() + "','" + user.getTel() + "','" + user.getFax() + "','" + user.getAddress() + "','" + MD5.md5Java(user.getPassword()) + "','" + user.getRegionId().getId() + "')";
        return crud.execute(sql);
    }

    public boolean EditUser(User user) {

        try {
            String sql
                    = "UPDATE  user set first_name='" + user.getFirstName() + "', last_name = '" + user.getLastName() + "',raison_social= '" + user.getRaisonSocial() + "',email_address='" + user.getEmailAddress() + "',tel='" + user.getTel() + "',fax='" + user.getFax() + "',address='" + user.getAddress() + "',region_id='" + user.getRegionId().getId() + "' WHERE id = '" + new Session().getUser().getId() + "'";
            System.out.println(sql);
            return crud.execute(sql);
        } catch (Exception e) {
            Logger.getLogger("Client controller").log(Level.SEVERE, " fail");
            return false;
        }

    }

    public boolean changePasswordAdmin(String new_password) {

        try {
            String sql
                    = "UPDATE  user set password='" + MD5.md5Java(new_password) + "' WHERE is_super_admin=1";
            System.out.println(sql);
            return crud.execute(sql);
        } catch (Exception e) {
            Logger.getLogger("Client controller").log(Level.SEVERE, " fail");
            return false;
        }

    }

    public boolean changePassword(String email, String new_password) {

        try {
            if (this.findUserByEmail(email)) {
                String sql
                        = "UPDATE  user set password='" + MD5.md5Java(new_password) + "' WHERE is_super_admin=1";
                System.out.println(sql);
                return crud.execute(sql);
            } else {
                JOptionPane.showMessageDialog(null, "Votre mail n'existe pas", "Erreur", 0, null);
                return false;
            }
        } catch (Exception e) {
            Logger.getLogger("Client controller").log(Level.SEVERE, " fail");
            return false;
        }

    }

    public User findUserByEmailAndPassword(String email, String password) {

        RegionDAO region_dao = new RegionDAO();
        User user = null;
        try {
            String sql = "SELECT * FROM user WHERE email_address = '" + email + "' AND password = '" + MD5.md5Java(password) + "'";
            ResultSet rs = crud.exeRead(sql);
            while (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setFirstName(rs.getString("first_name"));
                user.setLastName(rs.getString("last_name"));
                user.setType(rs.getInt("type"));
                user.setEmailAddress(rs.getString("email_address"));
                user.setTel(rs.getString("tel"));
                user.setFax(rs.getString("fax"));
                user.setAddress(rs.getString("address"));
                user.setRegionId(region_dao.getRegionById(rs.getString("region_id")));
                user.setRaisonSocial("");
                if (user.getType() == 2) {
                    user.setRaisonSocial(rs.getString("raison_social"));
                }
                user.setSuper_admin(rs.getBoolean("is_super_admin"));

            }
            return user;

        } catch (SQLException ex) {
            Logger.getLogger("Client controller").log(Level.SEVERE, " fail");
            return null;
        }
    }

    public User getSuperUser() {

        RegionDAO region_dao = new RegionDAO();
        User user = null;
        try {
            String sql = "SELECT * FROM user WHERE is_super_admin = 1";
            ResultSet rs = crud.exeRead(sql);
            while (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setFirstName(rs.getString("first_name"));
                user.setLastName(rs.getString("last_name"));
                user.setType(rs.getInt("type"));
                user.setEmailAddress(rs.getString("email_address"));
                user.setTel(rs.getString("tel"));
                user.setFax(rs.getString("fax"));
                user.setAddress(rs.getString("address"));
                user.setRegionId(region_dao.getRegionById(rs.getString("region_id")));
                user.setRaisonSocial("");
                if (user.getType() == 2) {
                    user.setRaisonSocial(rs.getString("raison_social"));
                }
                user.setSuper_admin(rs.getBoolean("is_super_admin"));

            }
            return user;

        } catch (SQLException ex) {
            Logger.getLogger("Client controller").log(Level.SEVERE, " fail");
            return null;
        }
    }

    public boolean findUserByEmail(String email) {

        boolean trouve = false;
        try {
            String sql = "SELECT * FROM user WHERE email_address = '" + email + "'";
            ResultSet rs = crud.exeRead(sql);
            while (rs.next()) {
                trouve = true;
            }
            return trouve;

        } catch (SQLException ex) {
            Logger.getLogger("Client controller").log(Level.SEVERE, " fail");
            return false;
        }
    }

    public User getUserByEmail(String username) {

        RegionDAO region_dao = new RegionDAO();
        User user = null;
        try {
            String sql = "SELECT * FROM user WHERE email_address = '" + username + "@gmail.com'";

            ResultSet rs = crud.exeRead(sql);
            while (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setFirstName(rs.getString("first_name"));
                user.setLastName(rs.getString("last_name"));
                user.setType(rs.getInt("type"));
                user.setEmailAddress(rs.getString("email_address"));
                user.setTel(rs.getString("tel"));
                user.setFax(rs.getString("fax"));
                user.setAddress(rs.getString("address"));
                user.setRegionId(region_dao.getRegionById(rs.getString("region_id")));
                user.setRaisonSocial("");
                if (user.getType() == 2) {
                    user.setRaisonSocial(rs.getString("raison_social"));
                }

            }
            new Session().setUser(user);
            return user;

        } catch (SQLException ex) {
            Logger.getLogger("Client controller").log(Level.SEVERE, " fail");
            return null;
        }
    }

    public List<User> getAllCandidat() {
        RegionDAO region_dao = new RegionDAO();
        String req = "select * from user";
        List<User> users = new ArrayList<User>();
        User user;
        try {
            ResultSet rs = crud.exeRead(req);
            while (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setFirstName(rs.getString("first_name"));
                user.setLastName(rs.getString("last_name"));
                user.setType(rs.getInt("type"));
                user.setEmailAddress(rs.getString("email_address"));
                user.setTel(rs.getString("tel"));
                user.setFax(rs.getString("fax"));
                user.setAddress(rs.getString("address"));
                user.setRegionId(region_dao.getRegionById(rs.getString("region_id")));
                user.setRaisonSocial("");
                user.setActive(rs.getInt("active"));

                if (user.getType() == 2) {
                    user.setRaisonSocial(rs.getString("raison_social"));
                }

                users.add(user);

            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return users;
    }

    public List<User> getAllCandidatByKey(String text) {
        RegionDAO region_dao = new RegionDAO();
        String req = "select * from user where (first_name LIKE '%" + text + "%' or last_name LIKE '%" + text + "%' or address LIKE '%" + text + "%') and type = 1";
        List<User> users = new ArrayList<User>();
        User user;
        try {
            ResultSet rs = crud.exeRead(req);
            while (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setFirstName(rs.getString("first_name"));
                user.setLastName(rs.getString("last_name"));
                user.setType(rs.getInt("type"));
                user.setEmailAddress(rs.getString("email_address"));
                user.setTel(rs.getString("tel"));
                user.setFax(rs.getString("fax"));
                user.setAddress(rs.getString("address"));
                user.setRegionId(region_dao.getRegionById(rs.getString("region_id")));
                user.setRaisonSocial("");
                user.setActive(rs.getInt("active"));

                users.add(user);

            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return users;
    }

    public boolean ActivateUser(int id) {
        try {
            String sql
                    = "UPDATE  user set active=1 where id=" + id;
            return crud.execute(sql);
        } catch (Exception e) {
            Logger.getLogger("Client controller").log(Level.SEVERE, " fail");
            return false;
        }
    }

    public boolean DeactivateUser(int id) {
        try {
            String sql
                    = "UPDATE  user set active=0 where id=" + id;
            return crud.execute(sql);
        } catch (Exception e) {
            Logger.getLogger("Client controller").log(Level.SEVERE, " fail");
            return false;
        }
    }

    public boolean DeleteUser(int id) {
        try {
            String sql
                    = "DELETE FROM user WHERE id=" + id;
            return crud.execute(sql);
        } catch (Exception e) {
            Logger.getLogger("Client controller").log(Level.SEVERE, " fail");
            return false;
        }
    }

    public List<User> getAllEntrepriseByKey(String text) {
        RegionDAO region_dao = new RegionDAO();
        String req = "select * from user where (first_name LIKE '%" + text + "%' or last_name LIKE '%" + text + "%' or address LIKE '%" + text + "%') and type = 2";
        List<User> users = new ArrayList<User>();
        User user;
        try {
            ResultSet rs = crud.exeRead(req);
            while (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setFirstName(rs.getString("first_name"));
                user.setLastName(rs.getString("last_name"));
                user.setType(rs.getInt("type"));
                user.setEmailAddress(rs.getString("email_address"));
                user.setTel(rs.getString("tel"));
                user.setFax(rs.getString("fax"));
                user.setAddress(rs.getString("address"));
                user.setRegionId(region_dao.getRegionById(rs.getString("region_id")));
                user.setRaisonSocial("");
                user.setActive(rs.getInt("active"));

                user.setRaisonSocial(rs.getString("raison_social"));

                users.add(user);

            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return users;
    }

    public List<User> getAllUser() {
        RegionDAO region_dao = new RegionDAO();
        String req = "select region_id, count(*) nb from user group by region_id";
        List<User> users = new ArrayList<User>();
        User user;
        try {
            ResultSet rs = crud.exeRead(req);
            while (rs.next()) {
                user = new User();

                user.setRegionId(region_dao.getRegionById(rs.getString("region_id")));
                user.setNbUserByRegion(rs.getInt("nb"));
                System.out.println(rs.getInt("nb"));

                users.add(user);

            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return users;
    }

    public boolean isInUserCandidatures(int annonce_id) {

        return false;
    }

    public boolean findUserByEmail(String email, Integer id) {
        // connect
        boolean trouve = false;
        try {
            String sql = "SELECT * FROM user WHERE email_address = '" + email + "' AND id != " + id + "";
            ResultSet rs = crud.exeRead(sql);
            while (rs.next()) {
                trouve = true;
            }
            return trouve;

        } catch (SQLException ex) {
            Logger.getLogger("Client controller").log(Level.SEVERE, " fail");
            return false;
        }
    }

    public boolean addToBookmarks(int annonce_id, int user_id) {
        try {
            String sql;
            sql = "INSERT INTO user_has_favori (annonce_id, user_id) VALUES ('" + annonce_id + "', '" + user_id + "')";

            return crud.execute(sql);

        } catch (Exception e) {
            Logger.getLogger("Client controller").log(Level.SEVERE, " fail");
            return false;
        }
    }

    public Boolean hasFav(int annonce_id, Integer user_id) {
        try {
            String sql;
            sql = "SELECT COUNT(*) AS nbr FROM user_has_favori WHERE annonce_id = '" + annonce_id + "' AND user_id = '" + user_id + "'";
            System.out.println(sql);
            ResultSet rs = crud.exeRead(sql);
            Boolean bool = false;
            while (rs.next()) {
                if (rs.getInt("nbr") > 0)
                    bool = true;
            }
            return bool;

        } catch (Exception e) {
            Logger.getLogger("Client controller").log(Level.SEVERE, " fail");
            return true;
        }
    }
}
