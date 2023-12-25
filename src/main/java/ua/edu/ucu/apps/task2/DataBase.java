package ua.edu.ucu.apps.task2;

public class DataBase extends БазаДаних {
    public String receiveUserData() {
        return отриматиДаніКористувача();
    }

    public String receiveStaticData() {
        return отриматиСтатистичніДані();
    }
}
