import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

class MyAuthenticator extends Authenticator {
    String username = "Admin";
    String password = "Admin@123";
    protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(username, password.toCharArray());
    }
}

public class AuthenticatorClass {
    public static void main(String[] args) {
        MyAuthenticator auth = new MyAuthenticator();
        String line;
        try {
            Authenticator.setDefault(new MyAuthenticator());
            URL url = new URL("https://www.example.com");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            auth.getPasswordAuthentication();
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }
            in.close();
        } catch (MalformedURLException e) {
            System.out.println("Malformed URL : " + e.getMessage());
        } catch (IOException e) {
            System.out.println("I/O Error : " + e.getMessage());
        }
    }
}