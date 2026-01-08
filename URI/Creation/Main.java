import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;


public class Main{

    public static void main (String[] args){
        try{
            URI voice = new URI("tel:+1-800-9988-9938");
            URI absolute = new URI("http", "//www.example.org" , null);
            URI today= new URI("http", "www.example.org", "/student/index.html", "today");
            URI today2 = new URI("http", "www.student.org", "/student/index.html", "referrer=cnet&date=2014-02-23", "today");
            URI styles = new URI("ftp", "anonymous:prashant@example.org","ftp.example.com", 21, "/data/pdf", null, null);


            System.out.println(voice);
            System.out.println(absolute);
            System.out.println(today);
            System.out.println(today2);
            System.out.println(styles);
        }catch(URISyntaxException e){
            System.err.println(e);
        }
    }
}