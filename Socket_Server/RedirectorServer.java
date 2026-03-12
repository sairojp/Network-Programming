



import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class RedirectorServer {
    public final static int PORT = 8080;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Redirector Server listening on port : " + PORT);
            while (true) {
                Socket clientSocket = serverSocket.accept();

                // Send the HTTP response with a redirect header
                String response = "HTTP/1.1 301 Moved Permanently\r\nLocation: http://www.example.com\r\n\r\n";
                clientSocket.getOutputStream().write(response.getBytes());

                // Close the socket
                clientSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}