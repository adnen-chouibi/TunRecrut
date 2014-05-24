package com.esprit.tunRecrut.controller;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

/**
 *
 * @author WIEM
 */
public class GenererPDFAnnonce {

    public void genratePDF(int id) throws IOException {
        Connection connection;
        try {
            // - Connexion à la base
            connection = MySQLConnexion.getInstance();
            // - Chargement et compilation du rapport
            JasperDesign jasperDesign = JRXmlLoader.load("C:\\Users\\\\app4mob\\\\Desktop\\\\test.jrxml");

            JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
            // - Paramètres à envoyer au rapport
            Map parameters = new HashMap();
            //parameters.put("Titre", "Titre");
            System.out.println(id);
            parameters.put("id", id);
            // - Execution du rapport
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, connection);
            // - Création du rapport au format PDF
            JasperExportManager.exportReportToPdfFile(jasperPrint, "C:\\Users\\app4mob\\Desktop\\annonces\\annonce-" + id + ".pdf");
            System.out.println("Succes ");
            try {
                Desktop desktop = Desktop.getDesktop();
                if (desktop.isSupported(Desktop.Action.OPEN)) {
                    desktop.open(new File("C:\\Users\\app4mob\\Desktop\\annonces\\annonce-" + id + ".pdf"));
                } else {
                    System.out.println("Open is not supported");
                }
            } catch (IOException exp) {
                exp.printStackTrace();
            }
        } catch (JRException e) {
            System.out.println("erreur de compilation" + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Connection connection;
        try {
            // - Connexion à la base
            connection = MySQLConnexion.getInstance();
            // - Chargement et compilation du rapport
            JasperDesign jasperDesign = JRXmlLoader.load("C:\\Users\\\\app4mob\\\\Desktop\\\\test.jrxml");

            JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
            // - Paramètres à envoyer au rapport
            Map parameters = new HashMap();
            parameters.put("id", 193);
            // - Execution du rapport
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, connection);
            // - Création du rapport au format PDF
            JasperExportManager.exportReportToPdfFile(jasperPrint, "C:\\Users\\app4mob\\Desktop\\annonce2.pdf");
            System.out.println("Succes ");
        } catch (JRException e) {
            System.out.println("erreur de compilation" + e.getMessage());
        }
    }

}
