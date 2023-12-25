package ua.edu.ucu.apps.task1;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<MyUser> users = Arrays.asList(
            new MyFacebookUser(new FacebookUser("email1", "USA", LocalDateTime.now())),
            new MyTwitterUser(new TwitterUser("email2", "Canada", LocalDateTime.now())),
            new MyTwitterUser(new TwitterUser("email3", "USA", LocalDateTime.now().minusHours(2))),
            new MyFacebookUser(new FacebookUser("email4", "USA", LocalDateTime.now())),
            new MyFacebookUser(new FacebookUser("email5", "France", LocalDateTime.now()))
        );
        
        MessageSender messageSender = new MessageSender();

        messageSender.send("-_-", users, "USA");
    }
}
