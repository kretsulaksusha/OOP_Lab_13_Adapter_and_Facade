package ua.edu.ucu.apps.task1;

import java.time.LocalDateTime;

public class MyTwitterUser implements MyUser {
    private TwitterUser twitterUser;

    public MyTwitterUser(TwitterUser twitterUser) {
        this.twitterUser = twitterUser;
    }

    @Override
    public String getEmail() {
        return twitterUser.getEmail();
    }

    @Override
    public String getCountry() {
        return twitterUser.getCountry();
    }

    @Override
    public LocalDateTime getLastActiveTime() {
        return twitterUser.getLastActiveTime();
    }
    
}
