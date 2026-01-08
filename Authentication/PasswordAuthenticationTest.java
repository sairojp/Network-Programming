
import java.net.PasswordAuthentication;

public class PasswordAuthenticationTest {
    public static void main(String[] args) {
        String username = "admin";
        char[] password = { 'a','d','m','i','n','1','2','3' };
        PasswordAuthentication adminAuthentication = new PasswordAuthentication(username, password);
        System.out.println("Username: " + adminAuthentication.getUserName());
        System.out.println("Password: " + adminAuthentication.getPassword());
        // You can get the password in normal string
        System.out.println("Password: " + String.copyValueOf(adminAuthentication.getPassword()));
    }
}