import java.io.*;
import java.util.Scanner;

/**
 * FileUtility - A Java application for performing basic file operations.
 * This class demonstrates creating, reading, and appending to text files
 * using the java.io package as part of the CODTECH internship Task 1.
 */
public class FileUtility {

    public static void main(String[] args) {
        // Scanner used for taking user input from the console
        Scanner sc = new Scanner(System.in);
        // verbatum reference to data file as required by task context
        String fileName = "task_data.txt";

        // Menu-driven loop to provide continuous interaction
        while (true) {
            System.out.println("\n--- File Handling Utility ---");
            System.out.println("1. Write/Overwrite File");
            System.out.println("2. Read File");
            System.out.println("3. Modify (Append) File");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            // Input validation for integer choices
            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline character left over by nextInt()

            switch (choice) {
                case 1:
                    System.out.print("Enter text to write to file: ");
                    String content = sc.nextLine();
                    writeFile(fileName, content);
                    break;
                case 2:
                    readFile(fileName);
                    break;
                case 3:
                    System.out.print("Enter text to append: ");
                    String appendContent = sc.nextLine();
                    modifyFile(fileName, appendContent);
                    break;
                case 4:
                    System.out.println("Exiting application...");
                    sc.close(); // Closing the scanner resource before exit
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    /**
     * Writes new content to a file. This will overwrite any existing data in the file.
     * 
     * @param fileName The name of the file to be created/overwritten.
     * @param content  The text content to be stored.
     */
    public static void writeFile(String fileName, String content) {
        // Using try-with-resources to ensure FileWriter is closed automatically
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write(content);
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred during writing: " + e.getMessage());
        }
    }

    /**
     * Reads and displays the content of a specified text file line by line.
     * 
     * @param fileName The name of the file to read.
     */
    public static void readFile(String fileName) {
        // BufferedReader is used for efficient reading of characters and lines[cite: 1]
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            System.out.println("\n--- File Content ---");
            // Iterate through the file until the end (null) is reached
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found. Please create it using option 1 first.");
        } catch (IOException e) {
            System.out.println("An error occurred during reading: " + e.getMessage());
        }
    }

    /**
     * Modifies the file by appending new text to the end without deleting old data[cite: 1].
     * 
     * @param fileName The name of the file to modify.
     * @param content  The new text content to add to the existing file.
     */
    public static void modifyFile(String fileName, String content) {
        // Passing 'true' as the second parameter to FileWriter enables 'Append Mode'[cite: 1]
        try (FileWriter writer = new FileWriter(fileName, true)) {
            // Adding a newline before the appended text for better formatting
            writer.write("\n" + content);
            System.out.println("Successfully modified (appended) the file.");
        } catch (IOException e) {
            System.out.println("An error occurred during modification: " + e.getMessage());
        }
    }
}