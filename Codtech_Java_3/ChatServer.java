package Codtech_Java_3;
import java.io.*;
import java.net.*;
import java.util.*;

/**
 * ChatServer - The central hub for the multithreaded chat application.
 * It listens for new connections and manages a list of active clients.
 */
public class ChatServer {
    // Port number where the server will listen
    private static final int PORT = 12345;
    // Set to store all active client writers to broadcast messages[cite: 1]
    private static Set<PrintWriter> clientWriters = new HashSet<>();

    public static void main(String[] args) {
        System.out.println("🚀 Chat Server started on port " + PORT);
        
        // ServerSocket waits for clients to connect over the network[cite: 1]
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            while (true) {
                // Accept a new client connection[cite: 1]
                new ClientHandler(serverSocket.accept()).start();
            }
        } catch (IOException e) {
            System.err.println("Server error: " + e.getMessage());
        }
    }

    /**
     * ClientHandler class - A separate thread for each connected user[cite: 1].
     */
    private static class ClientHandler extends Thread {
        private Socket socket;
        private PrintWriter out;

        public ClientHandler(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            System.out.println("New client connected: " + socket.getInetAddress());
            try (
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true)
            ) {
                // Add this client's output stream to our broadcast list[cite: 1]
                synchronized (clientWriters) {
                    clientWriters.add(out);
                }

                String message;
                // Continuously listen for messages from this specific client[cite: 1]
                while ((message = in.readLine()) != null) {
                    System.out.println("Received: " + message);
                    broadcast(message);
                }
            } catch (IOException e) {
                System.out.println("Client disconnected.");
            } finally {
                // Remove client when they disconnect[cite: 1]
                synchronized (clientWriters) {
                    clientWriters.remove(out);
                }
            }
        }

        // Send a message to every connected client[cite: 1]
        private void broadcast(String message) {
            synchronized (clientWriters) {
                for (PrintWriter writer : clientWriters) {
                    writer.println(message);
                }
            }
        }
    }
}