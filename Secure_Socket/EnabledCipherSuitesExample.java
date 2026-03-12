


import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.io.IOException;
public class EnabledCipherSuitesExample {
    public final static String HOST = "www.example.com";
    public final static int PORT = 443;

    public static void main(String[] args) {
        try {
            // Create SSL socket factory
            SSLSocketFactory sslSocketFactory = (SSLSocketFactory) SSLSocketFactory.getDefault();
            // Create SSL socket
            SSLSocket sslSocket = (SSLSocket) sslSocketFactory.createSocket(HOST, PORT);
            // Set the list of enabled cipher suites
            String[] cipherSuites = {
                    "TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA256",
                    "TLS_RSA_WITH_AES_128_CBC_SHA",
                    "TLS_RSA_WITH_AES_256_CBC_SHA"
            };
            sslSocket.setEnabledCipherSuites(cipherSuites);
            // Get the list of enabled cipher suites
            String[] enabledCipherSuites = sslSocket.getEnabledCipherSuites();
            // Print the list of enabled cipher suites
            System.out.println("Enabled Cipher Suites:");
            for (String cipherSuite : enabledCipherSuites) {
                System.out.println("- " + cipherSuite);
            }
            // Close the socket
            sslSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}