package net.salesianos.activities.two;

import net.salesianos.utils.FileManager;

public class AppTwo {

    public static void main(String[] args) {
        final String FILE_PATH = "./files/two.txt";

        // Read and display each character with its ASCII value
        System.out.println("ASCII value: " + FileManager.readTextWithAscii(FILE_PATH));
    }
}