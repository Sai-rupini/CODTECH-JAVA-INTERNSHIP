package Codtech_Java_2;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * Task 2: REST API Client
 * This program demonstrates how to consume a public REST API using Java's HttpClient.
 * It fetches data from a remote server and parses the JSON response for display.
 */
public class RestClient {

    public static void main(String[] args) {
        // The endpoint URL (Free Testing API providing sample To-Do items)
        String apiUrl = "https://jsonplaceholder.typicode.com/todos/1";

        System.out.println("🚀 Connecting to API: " + apiUrl);

        try {
            // 1. Create a HttpClient instance (The engine that sends requests)
            HttpClient client = HttpClient.newHttpClient();

            // 2. Build the HttpRequest (Defining the target URI and the GET method)
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(apiUrl))
                    .GET() // Standard HTTP GET method to retrieve data
                    .build();

            // 3. Send the request and capture the response as a String[cite: 1]
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // 4. Check the HTTP status code (200 OK means the request was successful)[cite: 1]
            if (response.statusCode() == 200) {
                String responseBody = response.body();
                System.out.println("\n✅ Data Received Successfully!");
                
                // Displaying raw data and starting the parsing process[cite: 1]
                displayParsedData(responseBody);
            } else {
                // Handling server-side errors (e.g., 404 Not Found or 500 Internal Error)[cite: 1]
                System.out.println("❌ Error: Received status code " + response.statusCode());
            }

        } catch (Exception e) {
            // Catching network errors, timeouts, or URI issues[cite: 1]
            System.out.println("⚠️ An error occurred while fetching data: " + e.getMessage());
        }
    }

    /**
     * Helper method to parse the JSON string and display specific fields.
     * Uses manual string manipulation to keep the project lightweight without external JARs[cite: 1].
     * 
     * @param json The raw JSON string returned by the API response.
     */
    public static void displayParsedData(String json) {
        System.out.println("\n--- Structured JSON Output ---");
        System.out.println(json);

        // Extracting values by splitting the string around key JSON identifiers[cite: 1]
        System.out.println("\n--- Extracted Details ---");
        
        // Parsing 'id'[cite: 1]
        String id = json.split("\"id\":")[1].split(",")[0].trim();
        
        // Parsing 'title'[cite: 1]
        String title = json.split("\"title\": \"")[1].split("\"")[0].trim();
        
        // Parsing 'completed' boolean status[cite: 1]
        String completed = json.split("\"completed\":")[1].split("}")[0].trim();

        // Formatting the output for better user readability[cite: 1]
        System.out.println("ID        : " + id);
        System.out.println("Title     : " + title);
        System.out.println("Status    : " + (completed.equals("true") ? "✅ Completed" : "⏳ Pending"));
    }
}