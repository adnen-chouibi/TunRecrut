package com.esprit.tunRecrut.util;

import com.esprit.tunRecrut.dao.UserDAO;
import com.esprit.tunRecrut.ui.RegisterUI;
import static java.lang.String.format;
import static java.lang.System.currentTimeMillis;
import static java.lang.System.out;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.restfb.Connection;
import com.restfb.DefaultFacebookClient;
import com.restfb.DefaultJsonMapper;
import com.restfb.Facebook;
import com.restfb.FacebookClient;
import com.restfb.JsonMapper;
import com.restfb.Parameter;
import com.restfb.json.JsonArray;
import com.restfb.json.JsonObject;
import com.restfb.types.FacebookType;
import com.restfb.types.Page;
import com.restfb.types.Post;
import com.restfb.types.Url;
import com.restfb.types.User;

@SuppressWarnings("deprecation")
public class GraphFacebookReader {

    public static String acces_token;
//public static         FacebookClient facebookClient = new DefaultFacebookClient(acces_token);

    public static boolean fetchObject() {
        com.esprit.tunRecrut.entities.User connected_user;
        out.println("* Fetching single objects *");
        out.println(acces_token);
        FacebookClient facebookClient = new DefaultFacebookClient(acces_token);
        User user = facebookClient.fetchObject("me", User.class);
        out.println("Email: " + user.getEmail());
        UserDAO user_dao = new UserDAO();
        connected_user = user_dao.getUserByEmail(user.getUsername());       
        if (connected_user != null) {
            return true;
        } else {
            new RegisterUI(user).setVisible(true);
            return false;
        }
//        out.println("First name: " + user.getFirstName());
//        out.println("Last Name: " + user.getLastName());
//        out.println("Username: " + user.getUsername());
//        out.println("Email: " + user.getEmail());
//        out.println("ID Facebook: " + user.getId());
//        out.println("About: " + user.getAbout());
//        out.println("Birthday: " + user.getBirthday());

    }

}
