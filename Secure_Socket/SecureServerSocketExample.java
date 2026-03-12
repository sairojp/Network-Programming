



import javax.net.ssl.*;
import java.io.*;

public class SecureServerSocketExample {
    public final static int PORT = 8080;

    public static void main(String[] args) {

        try {
            // Create an SSLServerSocketFactory
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            // Create a secure server socket
            SSLServerSocket serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(PORT);
            System.out.println("Secure server started on port : " + PORT);

            // Wait for incoming connections
            while (true) {
                SSLSocket clientSocket = (SSLSocket) serverSocket.accept();
                System.out.println("Client connected: " + clientSocket.getInetAddress());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}