
import java.io.*;
import java.net.*;
public class EntireHeader {
public static void main(String[] args) throws IOException {
URL url = new URL("https://www.example.com");
URLConnection connection = url.openConnection();
connection.connect();
System.out.println("Headers: " + connection.getHeaderFields());
}
}