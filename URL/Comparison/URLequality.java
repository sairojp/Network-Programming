import java.net.*;

public class URLequality {
    public static void main(String[] args) {
        try {
            // URL u1 = new URL("http://www.example.org/");
            // URL u2 = new URL("http://www.example.org/home.html");
            URL u1 = new URL("http://www.example.com/index.html#p1");
            URL u2 = new URL("http://www.example.com/index.html#q2");
            if (u1.equals(u2)) {
                System.out.println(u1 + " is the same as " + u2);
            } else {
                System.out.println(u1 + " is not the same as " + u2);
            }
        } catch (MalformedURLException ex) {
            System.err.println(ex);
        }
    }
}