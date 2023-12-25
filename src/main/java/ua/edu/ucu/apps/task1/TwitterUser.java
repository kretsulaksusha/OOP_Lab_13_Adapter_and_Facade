package ua.edu.ucu.apps.task1;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data @ToString @AllArgsConstructor
public class TwitterUser {
    private String email;
    private String country;
    private LocalDateTime lastActiveTime;
}
