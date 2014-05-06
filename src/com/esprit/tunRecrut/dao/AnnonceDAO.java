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
        int annonce_id = crud.executeWithReturnId(sql);
        for (int i = 0; i < annonce.getMetier().length; i++) {
            sql = "insert into annonce_has_metier(annonce_id, metier_id) values (" + annonce_id + "," + annonce.getMetier()[i] + ")";
            crud.execute(sql);
        }

        return true;
    }
}
