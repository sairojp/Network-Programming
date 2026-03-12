import java.io.*;
import java.net.*;


public class Client {
    public static void main(String[] args) throws Exception{
        Socket client = new Socket("localhost", 8000);

        InputStream in = client.getInputStream();
        OutputStream out = client.getOutputStream();

        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        PrintWriter writer = new PrintWriter(out, true);

        System.out.println("Server: " + reader.readLine());
        writer.println(7);
        System.out.println("Server: " + reader.readLine());
        writer.println("bye");
        client.close();
    }
}