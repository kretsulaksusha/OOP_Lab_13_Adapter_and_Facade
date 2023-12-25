import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import ua.edu.ucu.apps.task1.FacebookUser;
import ua.edu.ucu.apps.task1.MessageSender;
import ua.edu.ucu.apps.task1.MyFacebookUser;
import ua.edu.ucu.apps.task1.MyTwitterUser;
import ua.edu.ucu.apps.task1.MyUser;
import ua.edu.ucu.apps.task1.TwitterUser;
import ua.edu.ucu.apps.task2.Auth;
import ua.edu.ucu.apps.task2.DataBase;
import ua.edu.ucu.apps.task2.ReportBuilder;
import ua.edu.ucu.apps.task3.CompanyData;
import ua.edu.ucu.apps.task3.CompanyExtractInfo;

public class Lab13Tests {

    @Test
    void testTask1() {
		List<MyUser> users = Arrays.asList(
            new MyFacebookUser(new FacebookUser("email1", "USA", LocalDateTime.now())),
            new MyTwitterUser(new TwitterUser("email2", "Canada", LocalDateTime.now())),
            new MyTwitterUser(new TwitterUser("email3", "USA", LocalDateTime.now().minusHours(2))),
            new MyFacebookUser(new FacebookUser("email4", "USA", LocalDateTime.now())),
            new MyFacebookUser(new FacebookUser("email5", "France", LocalDateTime.now()))
        );
        
        MessageSender messageSender = new MessageSender();

        int numberOfSentMessages = messageSender.send("-_-", users, "USA");
        assertEquals(numberOfSentMessages, 2);
    }

    @Test
    void testTask2() {
		DataBase db = new DataBase();
        Auth authClient = new Auth();

        if (authClient.login(db)) {
            ReportBuilder br = new ReportBuilder(db);
            assertTrue(br.getDb() instanceof DataBase);
        }
    }

    @Test
    void testTask3() {
		String url = "https://unsplash.com";
        CompanyData companyData = CompanyExtractInfo.extract(url);

        assertEquals(companyData.getUrl(), url);
        assertEquals(companyData.getName(), "Beautiful Free Images & Pictures | Unsplash");
        assertEquals(companyData.getDescription(), "Beautiful, free images and photos that you can download and use for any project. Better than any royalty free or stock photos.");
        assertEquals(companyData.getLogo(), "https://unsplash.com/apple-touch-icon.png");
    }
}
