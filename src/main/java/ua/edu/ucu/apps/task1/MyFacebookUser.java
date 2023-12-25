package ua.edu.ucu.apps.task1;

import java.time.LocalDateTime;

public class MyFacebookUser implements MyUser {
    private FacebookUser facebookUser;

    public MyFacebookUser(FacebookUser facebookUser) {
        this.facebookUser = facebookUser;
    }

    @Override
    public String getEmail() {
        return facebookUser.getEmail();
    }

    @Override
    public String getCountry() {
        return facebookUser.getCountry();
    }

    @Override
    public LocalDateTime getLastActiveTime() {
        return facebookUser.getUserActiveTime();
    }
    
}
