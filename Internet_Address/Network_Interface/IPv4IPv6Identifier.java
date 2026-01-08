import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class IPv4IPv6Identifier{
    public static void main (String[] args) {
        String hostName = "www.google.com";

    try {
            InetAddress address = InetAddress.getByName(hostName);
            if (address instanceof Inet4Address) {
                System.out.println("The remote server is using IPv4");
            } else if (address instanceof Inet6Address) {
                System.out.println("The remote server is using IPv6");
            } else {
                System.out.println("Unknown Ip version.");
            }
        }
    catch (UnknownHostException e) {
        System.err.println("Unable to resolve the hostname.");
        e.printStackTrace();
    }
    }
}