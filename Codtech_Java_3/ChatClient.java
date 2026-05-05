package Codtech_Java_3;
import java.io.*;
import java.net.*;
import java.util.Scanner;

/**
 * ChatClient - Connects to the ChatServer to send and receive messages[cite: 1].
 */
public class ChatClient {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 12345)) {
            System.out.println("✅ Connected to the chat server!");

            // Thread to listen for incoming messages from the server[cite: 1]
            new Thread(() -> {
                try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
                    String serverMsg;
                    while ((serverMsg = in.readLine()) != null) {
                        System.out.println("\n[Global]: " + serverMsg);
                    }
                } catch (IOException e) {
                    System.out.println("Disconnected from server.");
                }
            }).start();

            // Main thread for sending messages to the server[cite: 1]
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            try (Scanner scanner = new Scanner(System.in)) {
                System.out.print("Enter your name to join: ");
                String name = scanner.nextLine();
                
                while (true) {
                    String msg = scanner.nextLine();
                    if (msg.equalsIgnoreCase("exit")) break;
                    out.println(name + ": " + msg);
                }
            }
        } catch (IOException e) {
            System.err.println("Client error: " + e.getMessage());
        }
    }
}