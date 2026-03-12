import java.io.*;
import java.net.*;

public class ServerThread {

    public static void main(String[] args) throws Exception {
        int port = 8000;
        ServerSocket server = new ServerSocket(port);
        System.out.println("Server started on port " + port);

        while (true) {
            Socket clientSocket = server.accept();
            System.out.println("New client Connected: " + clientSocket.getInetAddress());

            // Handle each client in a new thread by extending Thread
            new ClientThread(clientSocket).start();
        }
    }
}

// Thread class to handle each client
class ClientThread extends Thread {
    private Socket clientSocket;

    public ClientThread(Socket socket) {
        this.clientSocket = socket;
    }

    @Override
    public void run() {
        try {
            // Create input and output streams for the client socket
            BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);

            writer.println("Please Enter a Number");

            String clientMessage = reader.readLine();
            if (clientMessage.equalsIgnoreCase("bye")) {
                writer.println("Goodbye!");
            } else {
                try {
                    int n = Integer.parseInt(clientMessage.trim());
                    if (n % 2 == 0) {
                        writer.println(n + " is even number");
                    } else {
                        writer.println(n + " is odd number");
                    }
                } catch (NumberFormatException e) {
                    writer.println("Server: Enter a valid Number");
                }
            }

            clientSocket.close();
            System.out.println("Client disconnected: " + clientSocket.getInetAddress());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
