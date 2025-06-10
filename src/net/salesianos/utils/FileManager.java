package net.salesianos.utils;

import java.io.FileReader;
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

    /**
     * Reads the content of a text file and returns its characters with their ASCII
     * values. Each character is represented in the format
     * "char_ASCII", and multiple characters are separated by a comma and a space.
     *
     * @param filePath The path to the text file to be read.
     * @return A string containing the characters and their ASCII values, or an
     *         error message.
     * @throws IOException If an error occurs while reading the file.
     */
    public static String readTextWithAscii(String filePath) {
        StringBuilder output = new StringBuilder();
        try (FileReader reader = new FileReader(filePath)) {
            int character;

            while ((character = reader.read()) != -1) {
                if (output.length() > 0) {
                    output.append(", ");
                }
                output.append((char) character).append("_").append(character);
            }
        } catch (IOException ioe) {
            return "Error reading file: " + ioe.getMessage();
        }
        return output.toString();
    }

    /**
     * Reads the content of a text file and returns it as a string.
     *
     * @param filePath The path to the text file to be read.
     * @return A string containing the content of the file, or an error message
     * 
     * @throws IOException
     */
    public static String readText(String filePath) {
        StringBuilder content = new StringBuilder();
        try (FileReader reader = new FileReader(filePath)) {
            int character;
            while ((character = reader.read()) != -1) {
                content.append((char) character);
            }
        } catch (IOException ioe) {
            return "Error reading file: " + ioe.getMessage();
        }
        return content.toString();
    }

    /**
     * Merges the content of two source files into a target file.
     * If the target file does not exist, it will be created.
     * 
     * @param targetFilePath    The file where content will be saved.
     * @param sourceFilePathOne The first source file to read.
     * @param sourceFilePathTwo The second source file to read.
     * 
     * @throws IOException
     */
    public static void mergeFilesContent(String targetFilePath, String sourceFilePathOne, String sourceFilePathTwo) {
        FileManager.saveText(targetFilePath, "");
        System.out.println(targetFilePath + " created. ");

        String contentOne = FileManager.readText(sourceFilePathOne);
        String contentTwo = FileManager.readText(sourceFilePathTwo);

        String mergedContent = "- Contenido del Fichero Uno: " + contentOne + "\n" +
                "- Contenido del Fichero Dos: " + contentTwo;

        FileManager.saveText(targetFilePath, mergedContent);
        System.out.println("Content merged and saved to " + targetFilePath);
    }
}
