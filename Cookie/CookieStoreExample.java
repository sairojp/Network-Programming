


import java.net.*;
import java.util.*;
public class CookieStoreExample {
    public static void main(String[] args) {
        
        CookieManager cookieManager = new CookieManager();
        CookieStore cookieStore = cookieManager.getCookieStore();

        // creating cookies and URI
        HttpCookie cookieA = new HttpCookie("First", "1");
        HttpCookie cookieB = new HttpCookie("Second", "2");
        URI uri = URI.create("https://www.example.com/");
       
        cookieStore.add(uri, cookieA);
        cookieStore.add(null, cookieB);
        System.out.println("Cookies successfully added\n");


        List cookiesWithURI = cookieStore.get(uri);
        System.out.println("Cookies associated with URI in CookieStore : " + cookiesWithURI + "\n");

        List cookieList = cookieStore.getCookies();
        System.out.println("Cookies in CookieStore : " + cookieList + "\n");

        List uriList = cookieStore.getURIs();
        System.out.println("URIs in CookieStore" + uriList + "\n");

        System.out.println("Removal of Cookie : " + cookieStore.remove(uri, cookieA));
        List remainingCookieList = cookieStore.getCookies();
        System.out.println("Remaining Cookies : " + cookieList + "\n");

        System.out.println("Removal of all Cookies : " + cookieStore.removeAll());
        List EmptyCookieList = cookieStore.getCookies();

        System.out.println("Empty CookieStore : " + cookieList);
    }
}
