
import java.net.*;
import java.io.*;



public class HttpRequest {
    public static void main(String[] args) throws IOException {
        URL url = new URL("https://www.example.com");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.connect();
        System.out.println("Response Code: " + connection.getResponseCode());
}
}