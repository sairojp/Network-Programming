

import java.io.*;
import java.net.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimpleHttpServer {
    private static final int PORT = 8080;
    private static final String ROOT_DIRECTORY = "www"; // Change this to your web content directory

    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(10); // Adjust the number of threads as needed

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server started. Listening on port " + PORT);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("New client connected: " + clientSocket.getInetAddress());

                // Create a worker thread to handle the client request
                Runnable worker = new ClientHandler(clientSocket);
                pool.execute(worker);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class ClientHandler implements Runnable {
        private final Socket clientSocket;

        ClientHandler(Socket socket) {
            this.clientSocket = socket;
        }

        @Override
        public void run() {
            try (InputStream inputStream = clientSocket.getInputStream();
                 OutputStream outputStream = clientSocket.getOutputStream();
                 BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                 PrintWriter writer = new PrintWriter(outputStream, true)) {

                String request = reader.readLine();
                if (request != null) {
                    System.out.println("Received request: " + request);

                    // Extract the requested file path from the request
                    String[] requestParts = request.split(" ");
                    if (requestParts.length >= 2 && requestParts[0].equalsIgnoreCase("GET")) {
                        String filePath = requestParts[1];

                        // Handle the request by serving static files
                        serveStaticFile(filePath, writer);
                    } else {
                        // Handle other HTTP methods (e.g., POST) or invalid requests here
                        writer.println("HTTP/1.1 501 Not Implemented");
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    clientSocket.close();
                    System.out.println("Client disconnected.");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        private void serveStaticFile(String filePath, PrintWriter writer) {
            try {
                File file = new File(ROOT_DIRECTORY, filePath);

                if (file.exists() && file.isFile()) {
                    writer.println("HTTP/1.1 200 OK");
                    writer.println("Content-Type: " + getContentType(file.getName()));
                    writer.println("Content-Length: " + file.length());
                    writer.println();
                    writer.flush();

                    try (FileInputStream fileInputStream = new FileInputStream(file)) {
                        byte[] buffer = new byte[1024];
                        int bytesRead;
                        OutputStream outputStream = clientSocket.getOutputStream();
                        while ((bytesRead = fileInputStream.read(buffer)) != -1) {
                            outputStream.write(buffer, 0, bytesRead);
                        }
                    }
                } else {
                    // File not found
                    writer.println("HTTP/1.1 404 Not Found");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private String getContentType(String fileName) {
            if (fileName.endsWith(".html") || fileName.endsWith(".htm")) {
                return "text/html";
            } else if (fileName.endsWith(".jpg") || fileName.endsWith(".jpeg")) {
                return "image/jpeg";
            } else if (fileName.endsWith(".gif")) {
                return "image/gif";
            } else if (fileName.endsWith(".png")) {
                return "image/png";
            } else {
                return "application/octet-stream";
            }
        }
    }
}