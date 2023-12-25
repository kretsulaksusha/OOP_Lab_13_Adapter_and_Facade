package ua.edu.ucu.apps.task1;

import java.time.LocalDateTime;

public class Auth {
    public MyUser login(String email, String country, SocialNetwork socialMedia) {
        switch (socialMedia) {
            case FACEBOOK:
                return new MyFacebookUser(new FacebookUser(email, country, LocalDateTime.now()));
            case TWITTER:
                return new MyTwitterUser(new TwitterUser(email, country, LocalDateTime.now()));
            default:
                return new MyFacebookUser(new FacebookUser(email, country, LocalDateTime.now()));
        }
    }
}
