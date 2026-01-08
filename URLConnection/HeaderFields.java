
import java.io.*;
import java.net.*;
import java.util.List;
import java.util.Map;
public class HeaderFields {
    public static void main(String[] args) throws IOException {
        URL url = new URL("https://www.example.com");
        URLConnection connection = url.openConnection();
        Map<String, List<String>> headers = connection.getHeaderFields();
        for (Map.Entry<String, List<String>> entry : headers.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}