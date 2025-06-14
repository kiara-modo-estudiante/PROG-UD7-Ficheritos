package net.salesianos.activities.one;

import java.util.Scanner;

import net.salesianos.utils.FileManager;

public class AppOne {

    public static void main(String[] args) {
        // a) Create a file to use on this activity
        final String FILE_PATH = "./files/one.txt";
        final int MIN_LENGTH = 30;

        Scanner scanner = new Scanner(System.in);
        String userInput;

        // b) Ask the user for input until it's at least 30 characters long
        do {
            System.out.println("Please enter a text with at least " + MIN_LENGTH + " characters:");
            userInput = scanner.nextLine();

            if (userInput.length() < MIN_LENGTH) {
                int missing = MIN_LENGTH - userInput.length();
                System.out.println("You need " + missing + " more characters");
            }

        } while (userInput.length() < MIN_LENGTH);

        // c) Format the text: uppercase and replace spaces with underscores
        String formattedText = userInput.toUpperCase().replace(" ", "_");

        // d) Save to file
        FileManager.saveText(FILE_PATH, formattedText);

        System.out.println("Text saved to " + FILE_PATH);

        scanner.close();
    }
}
