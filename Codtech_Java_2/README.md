# Task 2: REST API Client

## 📌 Project Overview
This project is a Java application designed to interact with a RESTful web service. It demonstrates the ability to connect to a remote server, execute HTTP requests, and process JSON data returned from the internet[cite: 1].

## 🚀 Features
* **HttpClient Implementation**: Utilizes the modern Java 11+ `HttpClient` API for non-blocking network requests[cite: 1].
* **Automated GET Requests**: Fetches sample to-do data from the JSONPlaceholder public API[cite: 1].
* **Response Parsing**: Manually parses JSON strings to extract specific fields like ID, Title, and Completion Status[cite: 1].
* **Error Handling**: Includes logic to manage network failures and non-200 HTTP status codes[cite: 1].

## 🛠️ Technical Specifications
* **Language**: Java[cite: 1]
* **API Endpoint**: `https://jsonplaceholder.typicode.com/todos/1`[cite: 1]
* **Key Classes**: `HttpClient`, `HttpRequest`, `HttpResponse`, `URI`[cite: 1]

## 📖 How to Run
1. Ensure you have the Java Development Kit (JDK) 11 or higher installed.
2. Open your terminal in the parent directory of the project.
3. Compile the code:
   ```bash
   javac Codtech_Java_2/RestClient.java
4. Run the application:
   ```bash
   java Codtech_Java_2.RestClient
## 📊 Sample Output
The program displays the raw JSON received from the server followed by a formatted summary of the extracted data, identifying whether a task is "Completed" or "Pending" based on the boolean response[cite: 1].