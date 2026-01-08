import java.net.InetAddress;
import java.net.NetworkInterface;
import java.io.IOException;

public class ReachabilityTester {
    public static void main(String[] args) {
        String host = "localhost";
        int timeout = 5000;

        try{
            InetAddress address = InetAddress.getByName(host);
            int hashCode = address.hashCode();
            System.out.println(hashCode);
            System.out.println(address);

            // Test Reachability with default timeout
            boolean isReachableDefault = address.isReachable(timeout);
            System.out.println("Is " + host + " reachable in default timeout " + isReachableDefault);
            
            // Test reachability with specified network interface and time-to-live (TTL)
            NetworkInterface networkInterface = NetworkInterface.getByName("wlp0s20f3"); // Replace with your network interface name
            int ttl = 30; // Maximum number of network hops
            boolean isReachableWithInterface = address.isReachable(networkInterface, ttl, timeout);
            System.out.println("Is " + host + " reachable (with interface and TTL)? " + isReachableWithInterface);
        }
        catch (IOException e){
            System.err.println("Error: " + e.getMessage());
        }
    }
}