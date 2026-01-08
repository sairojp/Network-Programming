import java.net.*;

public class Main {
    public static void main(String[] args) throws UnknownHostException {
        // getLocalHost() method to instance of local hostname and address 
        InetAddress localAddress = InetAddress.getLocalHost();
        System.out.println("InetAddress of Local Host: " + localAddress);

        // getByName() methjod to get instance of hostname and ip of named host
        InetAddress hostAddress = InetAddress.getByName("www.facebook.com");
        System.out.println("InetAddress of Named Host: " + hostAddress);
        
        // getAllByName() method to get all instances of Named host
        InetAddress allAddress[] = InetAddress.getAllByName("www.google.com");
        for (int i=0; i<allAddress.length; i++) {
            System.out.println("All InetAddress of Named Host: " + allAddress[i]);
        }

        // get InetAddresses of Host from raw Ip address
        byte IpAddress[] = {125, 0, 0, 1};
        InetAddress newAddress = InetAddress.getByAddress(IpAddress);
        System.out.println("InetAddress of Host with Ip: " + newAddress);

        InetAddress newAddress2 = InetAddress.getByAddress("NewHost",IpAddress);
        System.out.println("Created instance based on IP and hostname: " + newAddress2);

    }
}