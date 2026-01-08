import java.net.*;

public class SpamChecker {
    
    public static final String BLACKHOLE = "zen.spamhaus.org";

    private static boolean isSpammer(String ip) {
        try {
            InetAddress address = InetAddress.getByName(ip);
            byte[] quad = address.getAddress();
            String query = BLACKHOLE;
            for (byte octet : quad) {
                int unsignedByte = octet < 0 ? octet + 256 : octet;
                query = unsignedByte + "." + query;
            }
            InetAddress.getByName(query);
            return true;
        } catch (UnknownHostException e) {
            return false;
        }
    }

    public static void main(String[] args) throws UnknownHostException {
        System.out.println("SpamCheck");
        System.out.printf(" %-17s | %s\n", "Host","Status");
        System.out.println("-------------------+-----------");
        for (String ip : args) {
            if (isSpammer(ip)) {
                System.out.printf(" %-17s | %s\n", ip,"Spammer");
            } else {
                System.out.printf(" %-17s | %s\n", ip,"Legitimate");
            }
        }
    }
}

