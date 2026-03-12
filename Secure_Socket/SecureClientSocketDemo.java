




import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class SecureClientSocketDemo {
    public final static String HOST = "www.example.com";
    public final static int PORT = 443;

    public static void main(String[] args) {
        try {

            // Create SSL socket factory
            SSLSocketFactory sslSocketFactory =(SSLSocketFactory) SSLSocketFactory.getDefault();

            // Create SSL socket
            SSLSocket sslSocket = (SSLSocket) sslSocketFactory.createSocket(HOST, PORT);

            // Get input and output streams
            PrintWriter out = new PrintWriter(sslSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(sslSocket.getInputStream()));

            // Send an HTTP GET request
            out.println("GET / HTTP/1.1");
            out.println("Host: " + HOST);
            out.println("Connection: close");
            out.println();

            // Read and print the response
            String line;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }

            // Close the socket
            sslSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
