package ua.edu.ucu.apps.task2;

public class Main {
    public static void main(String[] args) {
        DataBase db = new DataBase();
        Auth authClient = new Auth();

        if (authClient.login(db)) {
            ReportBuilder br = new ReportBuilder(db);
            System.out.println(br.getDb() instanceof DataBase);
        }
    }
}
