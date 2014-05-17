package com.esprit.tunRecrut.util;

import com.esprit.tunRecrut.entities.User;

public class Session {

   public static User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
