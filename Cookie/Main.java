





import java.net.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws MalformedURLException {
        CookieManager cookieManager = new CookieManager();
        cookieManager.setCookiePolicy(new CookiePolicy() {
            public boolean shouldAccept(URI uri, HttpCookie cookie) {
                return !uri.getHost().endsWith(".gov");
            }
        });

        CookieHandler.setDefault(cookieManager);

        URL url = new URL("http://www.example.gov");
        
    }
}

