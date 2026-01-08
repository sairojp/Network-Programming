

import java.net.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Supported Protocols: ");

        String pkgs = System.getProperty("java.protocol.handler.pkgs");

        if (pkgs != null) {
            for (String protocol : pkgs.split("\\|")) {
                System.out.println(protocol);
            }
        } else {
            System.out.println("No custom protocol handlers found.");
        }
    }
}
