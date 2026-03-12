







import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
public class SupportedCipherSuitesExample {
    public static void main(String[] args) {
        try {
            // Create SSL socket factory
            SSLSocketFactory sslSocketFactory = (SSLSocketFactory) SSLSocketFactory.getDefault();

            // Create a dummy socket to retrieve the supported cipher suites
            SSLSocket dummySocket = (SSLSocket) sslSocketFactory.createSocket();
            String[] supportedCipherSuites = dummySocket.getSupportedCipherSuites();

            // Print the list of supported cipher suites
            System.out.println("Supported Cipher Suites:");
            for (String cipherSuite : supportedCipherSuites) {
                System.out.println("- " + cipherSuite);
            }

            // Close the dummy socket
            dummySocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}