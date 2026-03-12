import javax.net.ssl.*;
import java.io.*;
import java.security.*;

public class SSLClientServerDemo {

    public static void main(String[] args) {
        int port = 12345;

        // Start the server in a separate thread
        Thread serverThread = new Thread(() -> startServer(port));
        serverThread.start();

        // Allow some time for the server to start
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Start the client
        startClient("localhost", port);
    }

    private static void startServer(int port) {
        try {
            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(null, null, new SecureRandom());

            SSLServerSocketFactory serverSocketFactory = sslContext.getServerSocketFactory();
            SSLServerSocket serverSocket = (SSLServerSocket) serverSocketFactory.createServerSocket(port);

            // Set client authentication mode
            serverSocket.setNeedClientAuth(true);

            System.out.println("Server listening on port " + port);

            while (true) {
                try (SSLSocket clientSocket = (SSLSocket) serverSocket.accept()) {
                    boolean needClientAuth = clientSocket.getNeedClientAuth();
                    System.out.println("Server: Need Client Auth: " + needClientAuth);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void startClient(String host, int port) {
        try {
            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(null, null, new SecureRandom());

            SSLSocketFactory socketFactory = sslContext.getSocketFactory();
            SSLSocket clientSocket = (SSLSocket) socketFactory.createSocket(host, port);

            // Set client mode
            clientSocket.setUseClientMode(true);

            System.out.println("Client connected to " + host + " on port " + port);

            if(clientSocket.getUseClientMode())
            {
                System.out.println("Socket will use authentication in its first handshake.");
            }

            boolean needClientAuth = clientSocket.getNeedClientAuth();
            System.out.println("Client: Need Client Auth: " + needClientAuth);

            clientSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}