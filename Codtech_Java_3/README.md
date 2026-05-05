# Task 3: Multithreaded Chat Application

## Overview
This project is a real-time, multithreaded chat system using Java Sockets. It enables a central server to handle multiple client connections simultaneously, broadcasting messages to all active participants[cite: 1].

## Key Features
* **Socket Programming**: Uses `ServerSocket` and `Socket` for network communication[cite: 1].
* **Multithreading**: Implements a `ClientHandler` thread for each user to ensure non-blocking communication[cite: 1].
* **Real-time Broadcasting**: Messages sent by one user are instantly delivered to all others[cite: 1].
* **Synchronized Collections**: Uses thread-safe sets to manage active client lists[cite: 1].

## How to Run
1. Start the server: `java Task3_Chat_App.ChatServer`[cite: 1].
2. Open multiple terminals and start clients: `java Task3_Chat_App.ChatClient`[cite: 1].
3. Type messages to see them appear across all client windows![cite: 1].