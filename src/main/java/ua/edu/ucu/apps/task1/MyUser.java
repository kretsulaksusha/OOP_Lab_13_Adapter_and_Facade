package ua.edu.ucu.apps.task1;

import java.time.LocalDateTime;

public interface MyUser {
    String getEmail();
    String getCountry();
    LocalDateTime getLastActiveTime();
}
