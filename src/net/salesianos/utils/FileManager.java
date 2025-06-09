package net.salesianos.utils;

import java.io.FileWriter;
import java.io.IOException;

public class FileManager {

    /**
     * Save text on chosen file.
     * Create if it does not exist.
     *
     * @param route File's route.
     * @param text  Text to save.
     * @throws IOException If an I/O error occurs while saving the text.
     */
    public static void saveText(String route, String text) {
        try (FileWriter writer = new FileWriter(route, true)) {
            writer.write(text + "\n");
        } catch (IOException e) {
            System.err.println("Error saving text: " + e.getMessage());
        }
    }
}
