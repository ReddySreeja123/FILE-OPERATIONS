package reddy;
import java.io.*;
import java.nio.file.*;
/**
 * A Java program demonstrating file handling operations: writing, reading,
 * and modifying a text file based on user input.
 */
public class FileOperations {
    public static void main(String[] args) {
        String filePath = "example.txt"; // Path to the file to be handled
        // Writing user input to the file
        writeToFile(filePath);
        // Reading and displaying the file contents
        readFromFile(filePath);
        // Modifying specific content in the file based on user input
        modifyFile(filePath); 
        // Reading and displaying the modified file contents
        readFromFile(filePath);
    }
    /**
     * Writes user input to the specified file.
     * @param filePath The path of the file to write to.
     */
    public static void writeToFile(String filePath) {
        try (FileWriter writer = new FileWriter(filePath)) {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter content to write in the file:");
            String content = br.readLine(); // Read user input
            writer.write(content); // Write content to the file
            System.out.println("File written successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing the file.");
            e.printStackTrace();
        }
    }
    /**
     * Reads and displays the content of the specified file.
     * @param filePath The path of the file to read.
     */
    public static void readFromFile(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            System.out.println("Reading file content:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line); // Print each line of the file
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
            e.printStackTrace();
        }
    }
    /**
     * Modifies the content of the specified file by replacing a user-specified word.
     * @param filePath The path of the file to modify.
     */
    public static void modifyFile(String filePath) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter the word to be replaced:");
            String oldWord = br.readLine(); // Read the word to be replaced
            System.out.println("Enter the new word:");
            String newWord = br.readLine(); // Read the replacement word
            Path path = Paths.get(filePath);
            String content = new String(Files.readAllBytes(path)); // Read file content
            content = content.replaceAll(oldWord, newWord); // Replace occurrences of oldWord with newWord
            Files.write(path, content.getBytes()); // Write the modified content back to the file
            System.out.println("File modified successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while modifying the file.");
            e.printStackTrace();
        }
    }
}
