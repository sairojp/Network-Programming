import java.net.MalformedURLException;
import java.net.URL;


public class Main{

    public static void main (String[] args){
        try{
            URL u1 = new URL("http://www.mywebsite.org/");
            System.out.println(u1);
        }catch(MalformedURLException e){
            System.err.println(e);
        }

        try{
            URL u2 = new URL("http", "www.mywebsite.org", "/home.html#intro");
            System.out.println(u2);
        }catch(MalformedURLException e){
            System.err.println(e);
        }

        try{
            URL u3 = new URL("http", "www.mywebsite.org", 8000, "/home.html#intro");
            System.out.println(u3);
        }catch(MalformedURLException e){
            System.err.println(e);
        }

        try{
            URL u = new URL("http://www.mywebsite.org/home.html");
            URL u4 = new URL (u, "aboutus.html");
            System.out.println(u4);
        }catch(MalformedURLException e){
            System.err.println(e);
        }


    }
}