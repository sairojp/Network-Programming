
import java.net.*;
import java.io.*;
import java.util.*;

public class Main2 {
    public static void main(String[] args) throws Exception {

        CookieManager cookieManager = new CookieManager();
        cookieManager.setCookiePolicy(new CookiePolicy() {
            public boolean shouldAccept(URI uri, HttpCookie cookie) {
                return !uri.getHost().endsWith(".gov");
            }
        });

        // IMPORTANT: register it
        CookieHandler.setDefault(cookieManager);

        // Make a request
        URL url = new URL("http://www.google.com");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.getResponseCode(); // forces the request

        // Print accepted cookies
        System.out.println("Stored cookies:");
        for (HttpCookie cookie : cookieManager.getCookieStore().getCookies()) {
            System.out.println(cookie);
        }
    }
}
