

//Program to serve a single HTML file to the client
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class SingleFileServer {
    public final static int PORT = 8080;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Single-File Server listening on port : " + PORT);
            while (true) {
                Socket clientSocket = serverSocket.accept();

                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

                // Read the request from the client (we ignore it for this example)
                String requestLine = in.readLine();
                System.out.println("Received request: " + requestLine);

                // Send the HTTP response with the contents of the file
                out.println("HTTP/1.1 200 OK");
                out.println("Content-Type: text/html");
                out.println();
                out.println("<html><body>");
                out.println("<h1>Hello from Single-File Server!</h1>");
                out.println("</body></html>");

                // Close the streams and the socket
                in.close();
                out.close();
                clientSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
