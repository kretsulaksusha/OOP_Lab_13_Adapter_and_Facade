package ua.edu.ucu.apps.task1;

import java.time.LocalDateTime;
import java.util.List;

public class MessageSender {

    // Method that allows, regardless of the authentication method,
    // to send text messages to users from a certain country who were active in the last hour.
    public int send(String text, List<MyUser> users, String country) {
        int numberOfSentMessages = 0;
        LocalDateTime lastHour = LocalDateTime.now().minusHours(1);

        for (MyUser myUser : users) {
            if (myUser.getCountry().equals(country) && myUser.getLastActiveTime().isAfter(lastHour)) {
                if (myUser instanceof MyFacebookUser) {
                    // Sending message via Facebook
                    System.out.println("Sending message to My Facebook User with email: " +
                                       myUser.getEmail() +
                                       ", and last active time: " +
                                       myUser.getLastActiveTime().toString());
                } else if (myUser instanceof MyTwitterUser) {
                    // Sending message via Twitter
                    System.out.println("Sending message to My Twitter User with email " +
                                       myUser.getEmail() +
                                       ", and last active time: " +
                                       myUser.getLastActiveTime().toString());
                }
                ++numberOfSentMessages;
            }
        }
        return numberOfSentMessages;
    }

}
