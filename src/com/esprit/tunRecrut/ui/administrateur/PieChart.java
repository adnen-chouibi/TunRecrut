package com.esprit.tunRecrut.ui.administrateur;

import com.esprit.tunRecrut.dao.UserDAO;
import com.esprit.tunRecrut.entities.User;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

public class PieChart extends JFrame {

    DefaultPieDataset dataset;//Dataset qui va contenir les Données
    JFreeChart graphe;        //Graphe
    ChartPanel cp;            //Panel

    public PieChart() {
        dataset = new DefaultPieDataset();
//Statique
         List<User> users = new ArrayList<User>();
        UserDAO userdao = new UserDAO();
       users =  userdao.getAllUser();
        for (User user : users) {
            System.out.println(user.getRegionId().getName()+" "+user.getNbUserByRegion());
             dataset.setValue(user.getRegionId().getName(), user.getNbUserByRegion());
        }
//        dataset.setValue("Java", new Double(20.0));
//        dataset.setValue("BD", new Double(20.0));
//        dataset.setValue("Maths", new Double(20.0));
//        dataset.setValue("Info", new Double(20.0));
//        dataset.setValue("Mecanique", new Double(20.0));
        graphe = ChartFactory.createPieChart3D("Exemple Camemberg", dataset, true, true, false);
        cp = new ChartPanel(graphe);
        this.add(cp);
    }

    public void showStatestique() {
        PieChart pchart = new PieChart();
        pchart.setSize(500,400);
        pchart.setVisible(true);

    }

    public static void main(String args[]) {
        PieChart pchart = new PieChart();
        pchart.setSize(500,400);
        pchart.setVisible(true);
    }
}
