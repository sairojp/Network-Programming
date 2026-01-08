import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpRequestDemo {
    public static void main(String[] args) {
        String url = "https://www.example.com/";

        try {
            // Create a URL object
            URL apiUrl = new URL(url);

            // Open a connection to the URL
            HttpURLConnection connection = (HttpURLConnection) apiUrl.openConnection();

            // Set the request method to HEAD
            connection.setRequestMethod("HEAD");

            // Set request headers (optional)
            connection.setRequestProperty("Host", "www.example.com");
            connection.setRequestProperty("Accept", "text/html, image/gif, image/jpeg, *; q=.2, */*; q=.2");
            connection.setRequestProperty("Connection", "close");

            // Get the response code & message
            int responseCode = connection.getResponseCode();
            String responseMessage = connection.getResponseMessage();

            // Print the response code & message
            System.out.println("Response Code: " + responseCode);
            System.out.println("Response Message: " + responseMessage);

            // Close the connection
            connection.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}