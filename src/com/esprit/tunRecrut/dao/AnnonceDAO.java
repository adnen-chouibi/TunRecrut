/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.tunRecrut.dao;

import com.esprit.tunRecrut.entities.Annonce;
import com.esprit.tunRecrut.entities.User;
import com.esprit.tunRecrut.util.Crud;
import com.esprit.tunRecrut.util.MD5;
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
public class AnnonceDAO {

    Crud crud = new Crud();

    public boolean saveAnnonce(Annonce annonce) {
        System.out.println();
        String sql
                = "INSERT INTO  annonce (name,type,content,is_active,contrat_id,experience_id,type_emploi_id,niveau_id,region_id,user_id) VALUES"
                + " ('" + annonce.getName() + "',1,'" + annonce.getContent() + "','" + annonce.getIsActive() + "','" + annonce.getContrat_id() + "','" + annonce.getExprience_id() + "','" + annonce.getType_id() + "','" + annonce.getNiveau_id() + "','" + annonce.getRegion_id() + "'," + annonce.getUserId() + ")";
        crud.execute(sql);
        int annonce_id = this.getIdOfLastSavedAnnonce();
        for (int i = 0; i < annonce.getMetier().length; i++) {
            sql = "insert into annonce_has_metier(annonce_id, metier_id) values (" + annonce_id + "," + annonce.getMetier()[i] + ")";
            crud.execute(sql);
        }

        return true;
    }

    public int getIdOfLastSavedAnnonce() {
        try {
            String sql = "SELECT * FROM annonce order by id  DESC";
            ResultSet rs = crud.exeRead(sql);
            while (rs.next()) {
                return (rs.getInt("id"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(RegionDAO.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
        return 0;
    }

    public List<Annonce> getAllOffre(String text, int contrat_id, int experience_id, int type_id, int niveau_id, int region_id, int type) {
        RegionDAO region_dao = new RegionDAO();
        String req = "select * from annonce a "
                + " left join contrat c on a.contrat_id = c.id"
                + " left join experience e on a.experience_id = e.id"
                + " left join niveau n on a.niveau_id = n.id"
                + " left join region r on a.region_id = r.id"
                + " left join type_emploi t on a.type_emploi_id = t.id"
                + " left join user u on a.user_id = u.id"
                + " where a.type = " + type;

        System.out.println("text = " + text);

        if (!text.equals("")) {
            req = req + " and (a.name LIKE '%" + text + "%' or a.content LIKE '%" + text + "%')";
        }
        if (contrat_id != 0) {
            req = req + " and a.contrat_id = " + contrat_id;
        }
        if (experience_id != 0) {
            req = req + " and a.experience_id = " + experience_id;
        }
        if (type_id != 0) {
            req = req + " and a.type_emploi_id = " + type_id;
        }
        if (niveau_id != 0) {
            req = req + " and a.niveau_id = " + niveau_id;
        }
        if (region_id != 0) {
            req = req + " and a.region_id = " + region_id;
        }
        System.out.println(req);
        List<Annonce> annonces = new ArrayList<Annonce>();
        Annonce annonce;
        try {
            ResultSet rs = crud.exeRead(req);
            while (rs.next()) {
                annonce = new Annonce();
                annonce.setId(rs.getInt("id"));
                annonce.setName(rs.getString("name"));
                annonce.setType(type);
                annonce.setContent(rs.getString("content"));
                annonce.setIsActive(rs.getInt("is_active"));
                annonce.setContrat(rs.getString("c.nom"));
                annonce.setExperience(rs.getString("e.nom"));
                annonce.setNiveau(rs.getString("n.nom"));
                annonce.setRegion(rs.getString("r.name"));
                annonce.setType_emploi(rs.getString("t.nom"));
                if (type == 1) {
                    annonce.setUser(rs.getString("u.first_name") + " " + rs.getString("u.last_name"));
                }
                if (type == 2) {
                    annonce.setUser(rs.getString("u.raison_social"));
                }

                annonces.add(annonce);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return annonces;
    }

    public boolean DeactivateOffre(int id) {
        try {
            String sql
                    = "UPDATE  annonce set is_active=0 where id=" + id;
            return crud.execute(sql);
        } catch (Exception e) {
            Logger.getLogger("Client controller").log(Level.SEVERE, " fail");
            return false;
        }
    }

    public boolean ActivateOffre(int id) {
        try {
            String sql
                    = "UPDATE  annonce set is_active=1 where id=" + id;
            return crud.execute(sql);
        } catch (Exception e) {
            Logger.getLogger("Client controller").log(Level.SEVERE, " fail");
            return false;
        }
    }

    public boolean DeleteOffre(int id) {
        try {
            String sql
                    = "DELETE FROM annonce WHERE id=" + id;
            return crud.execute(sql);
        } catch (Exception e) {
            Logger.getLogger("Client controller").log(Level.SEVERE, " fail");
            return false;
        }
    }

    public List<Annonce> getAllOffre() {

        String req = "select e.nom, a.experience_id, count(*) nb from annonce a left join experience e on a.experience_id = e.id  where a.type=1 group by a.experience_id ";
        List<Annonce> annonces = new ArrayList<Annonce>();
        Annonce annonce;
        try {
            ResultSet rs = crud.exeRead(req);
            while (rs.next()) {
                annonce = new Annonce();

                annonce.setExperience(rs.getString("e.nom"));

                annonce.setNbAnnonceByExperience(rs.getInt("nb"));

                annonces.add(annonce);

            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return annonces;
    }

    public Annonce getAnnonceById(int id) {

        Annonce annonce = null;
        try {

            String sql = "select * from annonce a "
                    + " left join contrat c on a.contrat_id = c.id"
                    + " left join experience e on a.experience_id = e.id"
                    + " left join niveau n on a.niveau_id = n.id"
                    + " left join region r on a.region_id = r.id"
                    + " left join type_emploi t on a.type_emploi_id = t.id"
                    + " left join user u on a.user_id = u.id"
                    + " WHERE a.id = " + id;

            ResultSet rs = crud.exeRead(sql);
            while (rs.next()) {
                annonce = new Annonce();
                annonce.setName(rs.getString("name"));
                annonce.setContent(rs.getString("content"));
                annonce.setContrat(rs.getString("c.nom"));
                annonce.setExperience(rs.getString("e.nom"));
                annonce.setNiveau(rs.getString("n.nom"));
                annonce.setRegion(rs.getString("r.name"));
                annonce.setType_emploi(rs.getString("t.nom"));
                User user = new User(rs.getInt("u.id"), rs.getInt("u.type"), rs.getString("u.email_address"), rs.getString("u.raison_social"), rs.getString("u.tel"), rs.getString("u.fax"), rs.getString("u.address"));
                annonce.setUserObject(user);
                
                //get annonce metiers
                ArrayList<String> metiersByAnnonId = this.getMetiersByAnnonId(id);                
                annonce.setMetierCollection(metiersByAnnonId);
                
            }

        } catch (SQLException ex) {
            Logger.getLogger("annonce controller").log(Level.SEVERE, " fail");
            return null;
        }

        return annonce;
    }

    public ArrayList<String> getMetiersByAnnonId(int id) {

        try {

            String sql = "select * from annonce_has_metier ahm "
                    + " left join metier m on m.id = ahm.metier_id"
                    + " WHERE ahm.annonce_id = " + id;

            ResultSet rs2 = crud.exeRead(sql);

            ArrayList<String> stringList = new ArrayList<String>();

            while (rs2.next()) {
                stringList.add(rs2.getString("nom"));
                System.out.println(rs2.getString("nom"));
            }

            return stringList;

        } catch (SQLException ex) {
            Logger.getLogger("annonce controller").log(Level.SEVERE, " fail");
            return null;
        }

    }

}
