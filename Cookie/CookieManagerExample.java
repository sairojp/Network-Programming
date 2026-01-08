import java.io.IOException;
import java.net.*;
import java.util.List;
public class CookieManagerExample {
    public static void main(String[] args) throws IOException {
        String uri = "https://www.youtube.com/";
        CookieManager cookieManager = new CookieManager();
        CookieHandler.setDefault(cookieManager);
        CookiePolicy cookiePolicy = CookiePolicy.ACCEPT_ORIGINAL_SERVER;
        cookieManager.setCookiePolicy(cookiePolicy);
        URL url = new URL(uri);
        URLConnection connection = url.openConnection();
        connection.getContent();
        CookieStore cookieStore = cookieManager.getCookieStore();
        List<HttpCookie> cookieList = cookieStore.getCookies();
        for (HttpCookie cookie : cookieList) {
            System.out.println("Domain name is: " + cookie.getDomain());
            System.out.println("Cookie name is: " + cookie.getName());
        }
    }
}