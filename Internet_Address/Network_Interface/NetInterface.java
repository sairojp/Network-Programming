
import java.net.*;
import java.util.*;

public class NetInterface {
    public static void main(String[] args) throws SocketException {
        List<NetworkInterface> interfaces = Collections.list(NetworkInterface.getNetworkInterfaces());

        for (NetworkInterface netInterface : interfaces) {
            System.out.println("Interface Name: " + netInterface.getName());
        }
    }
}
