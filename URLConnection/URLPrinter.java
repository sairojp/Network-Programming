

import java.io.*;
import java.net.*;
public class URLPrinter {
    public static void main(String[] args) {
        try {
            URL u = new URL("http://www.example.com/");
            URLConnection uc = u.openConnection();
            System.out.println(uc.getURL());
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }
}





