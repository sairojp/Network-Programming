
import java.io.*;
import java.net.*;

public class Server{
    public static void main(String[] args) throws Exception{
        int port = 8000;
        ServerSocket server = new ServerSocket(port);

        while(true){
           Socket clientSocket = server.accept();
           System.out.println("New client Connected: " + clientSocket.getInetAddress());

            // Create input and output streams for the client socket
            InputStream inputStream = clientSocket.getInputStream();
            OutputStream outputStream = clientSocket.getOutputStream();

            // Create readers and writers for client communication
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            PrintWriter writer = new PrintWriter(outputStream, true);

            writer.println("Please Enter a Number");
            // Read from the client and write back
            String clientMessage = reader.readLine();
            if (clientMessage.equalsIgnoreCase("bye")) {
                writer.println("Goodbye");
            }
            else{
                try{
                    int n = Integer.parseInt(clientMessage.trim());
                    // Check Even or Odd
                    if(n % 2 == 0){
                        writer.println(n + "is even number");
                    }
                    else{
                        writer.println(n + " is odd number");
                    }
                } catch(NumberFormatException e){
                    writer.println("Server: Enter a valid Number");
                }
            }
            clientSocket.close();
            System.out.println("Client disconnected.");
        }
    }
}