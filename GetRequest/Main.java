import java.io.*;
import java.net.*;

public class Main{
    public static void main(String[] args) throws IOException{
        String query = "Lalitpur";
        URL u = new URL("https://www.google.com/search?q=" + query);
        HttpURLConnection connection = (HttpURLConnection) u.openConnection();
        connection.setRequestMethod("GET");
        InputStreamReader reader = new InputStreamReader(connection.getInputStream());
        BufferedReader in = new BufferedReader(reader);
        String inputLine;
        while ((inputLine = in.readLine()) != null){
            System.out.println(inputLine);
        }
        in.close();
    };
}
