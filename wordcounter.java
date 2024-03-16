import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class wordcounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter 'file' to read from a file or 'text' to enter text: ");
        String inputType = scanner.nextLine();

        String input;
        if (inputType.equalsIgnoreCase("file")) {
            System.out.println("Enter the file path: ");
            String filePath = scanner.nextLine();
            try {
                input = new String(Files.readAllBytes(Paths.get(filePath)));
            } catch (IOException e) {
                System.out.println("Error in reading the file: " + e.getMessage());
                return;
            }
        } else {
            System.out.println("Enter the text: ");
            input = scanner.nextLine();
        }

        System.out.println("Counting words. Please wait...");
        Map<String, Integer> wordCount = countWords(input);

        System.out.println("Total words: " + wordCount.size());
        System.out.println("Unique words: " + wordCount.keySet().size());

        System.out.println("Word frequencies: ");
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    private static Map<String, Integer> countWords(String input) {
        Map<String, Integer> wordCount = new HashMap<>();
        String[] words = input.split("\\s+|(?=[.,;!?])");

        for (String word : words) {
            if (word.isEmpty()) {
                continue;
            }
            wordCount.put(word.toLowerCase(), wordCount.getOrDefault(word.toLowerCase(), 0) + 1);
        } 
    return wordCount;
    }  
}       